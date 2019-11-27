package com.ght.onlineeducation.domain;

import lombok.Data;

@Data
public class Episode {

  private Integer id;
  private String title;
  private Integer num;
  private String duration;
  private String coverImg;
  private Integer videoId;
  private String summary;
  private java.util.Date createTime;
  private Integer chapterId;

}
