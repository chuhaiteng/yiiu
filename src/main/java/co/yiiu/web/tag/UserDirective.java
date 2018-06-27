package co.yiiu.web.tag;

import co.yiiu.core.base.BaseController;
import co.yiiu.module.user.model.User;
import co.yiiu.module.user.service.UserService;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Map;

/**
 * Created by tomoya.
 * Copyright (c) 2016, All Rights Reserved.
 * https://yiiu.co
 */
@Component
public class UserDirective extends BaseController implements TemplateDirectiveModel {

  @Autowired
  private UserService userService;

  @Override
  public void execute(Environment environment, Map map, TemplateModel[] templateModels,
                      TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
    DefaultObjectWrapperBuilder builder = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);

    User user;
    if (map.containsKey("username") && !StringUtils.isEmpty(map.get("username").toString())) {
      user = userService.findByUsername(map.get("username").toString());
    } else {
      user = getUser();
    }

    environment.setVariable("user", builder.build().wrap(user));
    templateDirectiveBody.render(environment.getOut());
  }
}