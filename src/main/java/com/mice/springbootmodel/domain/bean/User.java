package com.mice.springbootmodel.domain.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;

/**
 * @Author: ChenHao
 * @Date: 2018/7/11 16:56
 */
@Data
@AllArgsConstructor
@ToString
public class User {
    @Id
    private Integer id;
    private String name;
    private Integer age;

}