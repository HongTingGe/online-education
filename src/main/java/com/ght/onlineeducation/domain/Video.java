package com.ght.onlineeducation.domain;

import lombok.Data;

@Data
public class Video {

  private Integer id;
  private String title;
  private String summary;
  private String coverImg;
  private Integer viewNum;
  private Integer price;
  private java.util.Date createTime;
  private Integer online;
  private double point;

}
