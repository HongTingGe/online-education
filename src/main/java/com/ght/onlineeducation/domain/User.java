package com.ght.onlineeducation.domain;

import lombok.Data;

@Data
public class User {

  private Integer id;
  private String openid;
  private String name;
  private String headImg;
  private String phone;
  private String sign;
  private Integer sex;
  private String city;
  private java.util.Date createTime;


}
