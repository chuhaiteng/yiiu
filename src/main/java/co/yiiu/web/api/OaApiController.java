package co.yiiu.web.api;

import co.yiiu.core.base.BaseController;
import co.yiiu.module.collect.service.CollectService;
import co.yiiu.module.tag.model.Tag;
import co.yiiu.module.tag.service.TagService;
import co.yiiu.module.topic.model.Topic;
import co.yiiu.module.topic.service.TopicService;
import co.yiiu.module.user.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


  @RequestMapping(value="/getContent",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
  @ResponseBody
  public  String   getContent(@RequestParam("callback") String callback) {
    List<Topic> list = topicService.findForOa();
    Gson gson=new Gson();
    return callback+"("+gson.toJson(list)+")";
  }


  @GetMapping("/topicDetail")
  public void detail(@RequestParam("id") Integer id, HttpServletResponse response) throws Exception{
    response.sendRedirect("/topic/"+id);
  }
}
