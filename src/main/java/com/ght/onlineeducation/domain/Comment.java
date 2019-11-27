package com.ght.onlineeducation.domain;

import lombok.Data;

@Data
public class Comment {

  private Integer id;
  private String content;
  private Integer userId;
  private String headImg;
  private String name;
  private double point;
  private Integer up;
  private java.util.Date createTime;
  private Integer orderId;
  private Integer videoId;


}
