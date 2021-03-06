//package co.yiiu.web.tag;
//
//import co.yiiu.config.SiteConfig;
//import co.yiiu.module.category.service.CategoryService;
//import co.yiiu.module.topic.service.TopicService;
//import freemarker.core.Environment;
//import freemarker.template.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//
//import java.io.IOException;
//import java.util.Map;
//
///**
// * Created by tomoya.
// * Copyright (c) 2016, All Rights Reserved.
// * https://yiiu.co
// */
//@Component
//public class CategoryDirective implements TemplateDirectiveModel {
//
//  @Autowired
//  private CategoryService categoryService;
//  @Autowired
//  private SiteConfig siteConfig;
//
//  @Override
//  public void execute(Environment environment, Map map, TemplateModel[] templateModels,
//                      TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
//    DefaultObjectWrapperBuilder builder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
//
//    String category = StringUtils.isEmpty(map.get("category")) ? "default" : map.get("category").toString();
//    if (StringUtils.isEmpty(category)) category = "";
//
//    int p = map.get("p") == null ? 1 : Integer.parseInt(map.get("p").toString());
//    Page<Map> page = categoryService.page(p, siteConfig.getPageSize(), category);
//
//    environment.setVariable("page", builder.build().wrap(page));
//    templateDirectiveBody.render(environment.getOut());
//  }
//}