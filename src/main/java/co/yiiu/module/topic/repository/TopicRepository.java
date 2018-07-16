package co.yiiu.module.topic.repository;

import co.yiiu.module.topic.model.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by tomoya.
 * Copyright (c) 2016, All Rights Reserved.
 * https://yiiu.co
 */
@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer>, JpaSpecificationExecutor<Topic> {

  @Query(value = "select t as topic, u as user from Topic t left join User u on t.userId = u.id and t.userId = ?1",
      countQuery = "select count(1) from Topic t left join User u on t.userId = u.id and t.userId = ?1")
  Page<Map> findByUserId(Integer userId, Pageable pageable);

  void deleteByUserId(Integer userId);

  @Query(value = "select t as topic, u as user from Topic t left join User u on t.userId = u.id",
      countQuery = "select count(1) from Topic t left join User u on t.userId = u.id")
  Page<Map> findTopics(Pageable pageable);

  @Query(value = "select t as topic, u as user from Topic t left join User u on t.userId = u.id and t.good = ?1",
      countQuery = "select count(1) from Topic t left join User u on t.userId = u.id and t.good = ?1")
  Page<Map> findByGood(Boolean b, Pageable pageable);

  @Query(value = "select t as topic, u as user from Topic t left join User u on t.userId = u.id and t.commentCount = ?1",
      countQuery = "select count(1) from Topic t left join User u on t.userId = u.id and t.commentCount = ?1")
  Page<Map> findByCommentCount(Integer commentCount, Pageable pageable);

  Topic findByTitle(String title);

  void delete(Topic topic);

  @Query(value = "select t as topic, u as user, c as category from Topic t left join User u on t.userId = u.id left join Category c on t.categoryId = c.id",
      countQuery = "select count(1) from Topic t left join User u on t.userId = u.id")
  Page<Map> findAllForAdmin(Pageable pageable);

  @Query(value = "select t as topic, u as user from Topic t left join User u on t.userId = u.id left join TopicTag tt on t.id = tt.topicId and tt.tagId = ?1",
      countQuery = "select count(1) from Topic t left join User u on t.userId = u.id left join TopicTag tt on t.id = tt.topicId and tt.tagId = ?1")
  Page<Map> findTopicsByTagId(Integer tagId, Pageable pageable);

  @Query(value = "select t as topic from Topic t where  t.categoryId = ?1",
          countQuery = "select count(1) from Topic t where t.categoryId = ?1")
  Page<Map> findByCategory(String category, Pageable pageable);

  @Query(value = "select t as tag,c as category from Topic t,Category c  where t.categoryId = c.id")
    List<Topic> findAllForOa();
}
