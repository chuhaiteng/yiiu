package co.yiiu.module.es.service;

import co.yiiu.module.es.model.TopicIndex;
import co.yiiu.module.es.repository.TopicIndexRepository;
import co.yiiu.module.topic.model.Topic;
import co.yiiu.module.topic.repository.TopicRepository;
import co.yiiu.module.user.model.User;
import co.yiiu.module.user.service.UserService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomoya at 2018/4/24
 */
@Service
public class TopicSearchService {

  @Autowired
  private TopicRepository topicRepository;
  @Autowired
  private UserService userService;
  @Autowired
  private TopicIndexRepository topicIndexRepository;

  /**
   * 索引全部话题
   */
  public void indexedAll() {
    List<TopicIndex> topicIndices = new ArrayList<>();
    List<Topic> topics = topicRepository.findAll();
    topics.forEach(topic -> {
      TopicIndex topicIndex = new TopicIndex();
      topicIndex.setId(topic.getId());
      topicIndex.setTitle(topic.getTitle());
      topicIndex.setTag(topic.getTag());
      topicIndex.setContent(topic.getContent());
      topicIndex.setInTime(topic.getInTime());
      if(topic.getUserId()!=null){
        User user = userService.findById(topic.getUserId());
        topicIndex.setUsername(user.getUsername());
      }
      topicIndices.add(topicIndex);
    });
    // 保存前先删除索引
    this.clearAll();
    topicIndexRepository.saveAll(topicIndices);
  }

  /**
   * 索引话题
   * @param topic
   * @param username
   */
  public void indexed(Topic topic, String username) {
    TopicIndex topicIndex = new TopicIndex();
    topicIndex.setId(topic.getId());
    topicIndex.setTitle(topic.getTitle());
    topicIndex.setTag(topic.getTag());
    topicIndex.setContent(topic.getContent());
    topicIndex.setInTime(topic.getInTime());
    topicIndex.setUsername(username);
    topicIndexRepository.save(topicIndex);
  }

  /**
   * 根据id删除索引
   * @param id
   */
  public void deleteById(Integer id) {
    topicIndexRepository.deleteById(id);
  }

  /**
   * 查询索引
   * @param keyword
   * @param pageNo
   * @param pageSize
   * @return
   */
  public Page<TopicIndex> query(String keyword, Integer pageNo, Integer pageSize) {
    Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
    NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder()
        .withQuery(
          QueryBuilders.boolQuery()
                  .should(QueryBuilders.multiMatchQuery(keyword, "title","content","tag").minimumShouldMatch("75%"))
        );
    SearchQuery query = queryBuilder.withPageable(pageable).build();
    return topicIndexRepository.search(query);
  }

  /**
   * 清除所有的索引
   */
  public void clearAll() {
    topicIndexRepository.deleteAll();
  }


  /**
   * 详情页相关内容
   */
  public Page<TopicIndex> Detialquery(List keywords, Integer pageNo, Integer pageSize, Integer topic) {
    Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
    NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
    BoolQueryBuilder boolqueryBuilder = QueryBuilders.boolQuery();
    for(int i=0;i<keywords.size();i++) {
      boolqueryBuilder.should(QueryBuilders.multiMatchQuery(keywords.get(i), "title","content","tag").minimumShouldMatch("75%"));
    }
    boolqueryBuilder.mustNot(QueryBuilders.matchQuery("id",topic));
    queryBuilder.withQuery(boolqueryBuilder);
    SearchQuery query = queryBuilder.withPageable(pageable).build();
    return topicIndexRepository.search(query);
  }
}
