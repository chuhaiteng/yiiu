package co.yiiu.module.category.service;

import co.yiiu.module.category.model.Category;
import co.yiiu.module.category.respository.CategoryRepository;
import co.yiiu.module.tag.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service
@Transactional
public class CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  public List<Category> findAll() {
    return categoryRepository.findAll();
  }
}
