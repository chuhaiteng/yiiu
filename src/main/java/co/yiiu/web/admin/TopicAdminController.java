package co.yiiu.web.admin;

import co.yiiu.config.SiteConfig;
import co.yiiu.core.base.BaseController;
import co.yiiu.core.bean.Result;
import co.yiiu.core.util.JsonUtil;
import co.yiiu.module.category.model.Category;
import co.yiiu.module.category.service.CategoryService;
import co.yiiu.module.es.service.TopicSearchService;
import co.yiiu.module.log.model.LogEventEnum;
import co.yiiu.module.log.model.LogTargetEnum;
import co.yiiu.module.log.service.LogService;
import co.yiiu.module.tag.model.Tag;
import co.yiiu.module.tag.service.TagService;
import co.yiiu.module.topic.model.Topic;
import co.yiiu.module.topic.service.TopicService;
import co.yiiu.module.topic.service.TopicTagService;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by tomoya.
 * Copyright (c) 2016, All Rights Reserved.
 * https://yiiu.co
 */
@Controller
@RequestMapping("/admin/topic")
public class TopicAdminController extends BaseController {

  @Autowired
  private TopicService topicService;
  @Autowired
  private TopicTagService topicTagService;
  @Autowired
  private TagService tagService;
  @Autowired
  private LogService logService;
  @Autowired
  private TopicSearchService topicSearchService;
  @Autowired
  private SiteConfig siteConfig;
  @Autowired
  private CategoryService categoryService;

  /**
   * topic list
   *
   * @param p
   * @param model
   * @return
   */
  @GetMapping("/list")
  public String list(@RequestParam(defaultValue = "1") Integer p, Model model) {
    model.addAttribute("page", topicService.findAllForAdmin(p, siteConfig.getPageSize()));
    return "admin/topic/list";
  }

  /**
   * 新增话题
   * @return
   */
  @GetMapping("/create")
  public String add(Model model) {
    //找到所有的模块
    List<Category> moduleAll = categoryService.findAll();
    model.addAttribute("moduleAll",moduleAll);
    return "admin/topic/create";
  }

  /**
   * 创建话题
   *
   * @param title
   * @param content
   * @return
   */
  @PostMapping("/create")
  @ResponseBody
  public Result create(String title, String content, String tag, String module) {
    Topic topic = new Topic();
    topic.setTitle(title);
    topic.setContent(content);
    topic.setModifyTime(new Date());
    topic.setInTime(new Date());
    topic.setView(0);
    topic.setUserId(1);
    topic.setCommentCount(0);
    topic.setGood(false);
    topic.setTop(false);
    topic.setUp(0);
    topic.setDown(0);
    topic.setUpIds("");
    topic.setDownIds("");
    topic.setWeight(0.0);
    topic.setCategoryId(module);
    topic.setTag(Jsoup.clean(tag, Whitelist.none()));
    topicService.save(topic);
    // 处理标签
    topicTagService.deleteByTopicId(topic.getId());
    List<Tag> tagList = tagService.save(tag.split(","));
    topicTagService.save(tagList, topic.getId());
    // 日志
    logService.save(LogEventEnum.CREATE_TOPIC, 1, LogTargetEnum.TOPIC.name(), topic.getId(),
            null, JsonUtil.objectToJson(topic), topic);
    // 索引话题
    if(siteConfig.isSearch()) topicSearchService.indexed(topic, "admin");

    return Result.success();
  }

  /**
   * 编辑话题
   *
   * @param id
   * @param model
   * @return
   */
  @GetMapping("/edit")
  public String edit(Integer id, Model model) {
    Topic topic = topicService.findById(id);
    Assert.notNull(topic, "话题不存在");

    model.addAttribute("topic", topic);
    return "admin/topic/edit";
  }

  /**
   * 更新话题
   *
   * @param title
   * @param content
   * @return
   */
  @PostMapping("/edit")
  @ResponseBody
  public Result update(Integer id, String title, String content) {
    Topic topic = topicService.findById(id);
    topic.setTitle(title);
    topic.setContent(content);
    topic.setModifyTime(new Date());
    topicService.save(topic);

    return Result.success();
  }

  /**
   * delete topic
   *
   * @param id
   * @return
   */
  @GetMapping("/delete")
  @ResponseBody
  public Result delete(Integer id) {
    // delete topic
    topicService.deleteById(id, getAdminUser().getId());
    return Result.success();
  }

  /**
   * 加/减精华
   *
   * @param id
   * @return
   */
  @GetMapping("/good")
  @ResponseBody
  public Result good(Integer id) {
    Topic topic = topicService.findById(id);
    topic.setGood(!topic.getGood());
    topicService.save(topic);
    return Result.success();
  }

  /**
   * 置/不置顶
   *
   * @param id
   * @return
   */
  @GetMapping("/top")
  @ResponseBody
  public Result top(Integer id) {
    Topic topic = topicService.findById(id);
    topic.setTop(!topic.getTop());
    topicService.save(topic);
    return Result.success();
  }
}
