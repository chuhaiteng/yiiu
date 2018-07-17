package co.yiiu.web.admin;

import co.yiiu.config.SiteConfig;
import co.yiiu.core.base.BaseController;
import co.yiiu.core.bean.Result;
import co.yiiu.module.category.model.Category;
import co.yiiu.module.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by tomoya.
 * Copyright (c) 2016, All Rights Reserved.
 * https://yiiu.co
 */
@Controller
@RequestMapping("/admin/category")
public class CategoryAdminController extends BaseController {

  @Autowired
  private SiteConfig siteConfig;
  @Autowired
  private CategoryService categoryService;

  /**
   * module list
   *
   * @param p
   * @param model
   * @return
   */
  @GetMapping("/list")
  public String list(@RequestParam(defaultValue = "1") Integer p, Model model) {
    model.addAttribute("page", categoryService.findAllForAdmin(p,siteConfig.getPageSize()));
    return "admin/category/list";
  }

  /**
   * 新增模块
   * @return
   */
  @GetMapping("/create")
  public String add() {
    return "admin/category/create";
  }

  /**
   * 创建模块
   *
   * @param catename
   * @return
   */
  @PostMapping("/create")
  @ResponseBody
  public Result create(String catename) {
    Category category = new Category();
    category.setName(catename);
    category.setInTime(new Date());
    categoryService.save(category);
    return Result.success();
  }

  /**
   * 修改模块
   *
   * @param id
   * @param model
   * @return
   */
  @GetMapping("/edit")
  public String edit(Integer id, Model model) {
    Category category = categoryService.findById(id);
    Assert.notNull(category, "模块不存在");
    model.addAttribute("category",category);
    return "admin/category/edit";
  }

  /**
   * 更新模块
   *
   * @param id
   * @param catename
   * @return
   */
  @PostMapping("/edit")
  @ResponseBody
  public Result update(Integer id, String catename) {
    Category category = categoryService.findById(id);
    category.setName(catename);
    category.setInTime(new Date());
    categoryService.save(category);
    return Result.success();
  }

  /**
   * delete module
   *
   * @param id
   * @return
   */
  @GetMapping("/delete")
  @ResponseBody
  public Result delete(Integer id) {
    categoryService.deleteById(id);
    return Result.success();
  }

}
