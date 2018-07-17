package co.yiiu.module.category.respository;

import co.yiiu.module.category.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Map;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "select c as category from Category c ",
            countQuery = "select count(1) from Category c")
    Page<Map> findAllForAdmin(Pageable pageable);
}
