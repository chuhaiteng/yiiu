package co.yiiu.web.tag;

import co.yiiu.config.SiteConfig;
import co.yiiu.module.es.model.TopicIndex;
import co.yiiu.module.es.service.TopicSearchService;
import co.yiiu.module.tag.model.Tag;
import co.yiiu.module.tag.service.TagService;
import co.yiiu.module.user.service.UserService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by tomoya.
 * Copyright (c) 2016, All Rights Reserved.
 * https://yiiu.co
 */
@Component
public class ReputationDirective implements TemplateDirectiveModel {

  @Autowired
  private UserService userService;
  @Autowired
  private SiteConfig siteConfig;
  @Autowired
  private TopicSearchService topicSearchService;
  @Autowired
  private TagService tagService;
  @Override
  public void execute(Environment environment, Map map, TemplateModel[] templateModels,
                      TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
    DefaultObjectWrapperBuilder builder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);

    int p = map.get("p") == null ? 1 : Integer.parseInt(map.get("p").toString());
    int limit = map.get("limit") == null ? siteConfig.getPageSize() : Integer.parseInt(map.get("limit").toString());

    //Page<User> page = userService.findByReputation(p, limit);
    List<Tag> tagList = tagService.findByTopicId(Integer.valueOf(map.get("topic").toString()));
    List keywords = new ArrayList();
    for(int i=0;i<tagList.size();i++ ){
      keywords.add(tagList.get(i).getName());
    }
    keywords.add(String.valueOf(map.get("title")));
    Page<TopicIndex> page = topicSearchService.Detialquery(keywords,p,limit,Integer.valueOf(map.get("topic").toString()));
    environment.setVariable("page", builder.build().wrap(page));
    templateDirectiveBody.render(environment.getOut());
  }
}