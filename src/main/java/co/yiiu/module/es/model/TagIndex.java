package co.yiiu.module.es.model;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by tomoya at 4/27/18
 */
@Data
@Document(indexName = "tag_index", type = "tag", refreshInterval = "-1")
public class TagIndex implements Serializable {

  @Id
  private Integer id;
  private String logo;
  @Field(analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
  private String name;
  private String intro;

  private Date inTime;
  private Integer topicCount;

  public TagIndex(Integer id, String logo, String name, String intro, Date inTime, Integer topicCount) {
    this.id = id;
    this.logo = logo;
    this.name = name;
    this.intro = intro;
    this.inTime = inTime;
    this.topicCount = topicCount;
  }
}
