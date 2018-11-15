package com.carl.study.springboot.v1x.model.model2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Desc 开户实体信息
 * @Author changez
 * @Time 2018/11/13 13:49
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KHInfo {

  private int id;
  private String name;
  private String idno;
}
