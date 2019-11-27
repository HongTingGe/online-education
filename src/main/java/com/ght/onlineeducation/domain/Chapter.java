package com.ght.onlineeducation.domain;

import lombok.Data;

@Data
public class Chapter {

  private Integer id;
  private Integer videoId;
  private String title;
  private Integer ordered;
  private java.util.Date createTime;

}
