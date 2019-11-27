package com.ght.onlineeducation.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class Video {

  private Integer id;
  private String title;
  private String summary;
  private String coverImg;
  private Integer viewNum;
  private Integer price;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale = "zh",timezone = "GMT+8")
  private java.util.Date createTime;
  private Integer online;
  private Double point;

}
