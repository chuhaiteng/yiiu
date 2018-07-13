package co.yiiu.web.api;

import co.yiiu.core.base.BaseController;
import co.yiiu.module.collect.service.CollectService;
import co.yiiu.module.tag.model.Tag;
import co.yiiu.module.tag.service.TagService;
import co.yiiu.module.topic.model.Topic;
import co.yiiu.module.topic.service.TopicService;
import co.yiiu.module.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by tomoya.
 * Copyright (c) 2016, All Rights Reserved.
 * https://yiiu.co
 */
@RestController
@RequestMapping("/api/oa")
public class OaApiController extends BaseController {

  @Autowired
  private TopicService topicService;
  @Autowired
  private CollectService collectService;
  @Autowired
  private TagService tagService;
  @Autowired
  private UserService userService;


  @RequestMapping("/getContent")
  @ResponseBody
  public  List<Topic>  getContent() {
      return topicService.findForOa();
  }


  @GetMapping("/topicDetail")
  public String detail(@PathVariable Integer id, Model model) {
    Topic topic = topicService.findById(id);
    Assert.notNull(topic, "话题不存在");
    // 浏览量+1
    topic.setView(topic.getView() + 1);
    topicService.save(topic);// 更新话题数据
    model.addAttribute("topic", topic);
    // 查询是否收藏过
    if (getUser() != null) {
      model.addAttribute("collect", collectService.findByUserIdAndTopicId(getUser().getId(), id));
    } else {
      model.addAttribute("collect", null);
    }
    // 查询这个话题被收藏的个数
    model.addAttribute("collectCount", collectService.countByTopicId(id));
    model.addAttribute("topicUser", userService.findById(topic.getUserId()));
    // 查询话题的标签
    List<Tag> tags = tagService.findByTopicId(id);
    model.addAttribute("tags", tags);
    return "/front/topic/detail";
  }
}
