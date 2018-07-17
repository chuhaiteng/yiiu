package co.yiiu.module.category.service;

import co.yiiu.module.category.model.Category;
import co.yiiu.module.category.respository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

  public Page<Map> findAllForAdmin(Integer pageNo, Integer pageSize) {
    Sort sort = new Sort(Sort.Direction.DESC, "id","inTime");
    Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
    return categoryRepository.findAllForAdmin(pageable);
  }

  public Category save(Category category) {
    return categoryRepository.save(category);
  }

  public void deleteById(Integer id) {
    Category category = findById(id);
    if(category!=null){
        categoryRepository.delete(category);
    }
  }

  public Category findById(Integer id) {
    return categoryRepository.findById(id).get();
  }
}
