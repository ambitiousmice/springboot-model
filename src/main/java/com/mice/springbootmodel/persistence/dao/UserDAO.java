package com.mice.springbootmodel.persistence.dao;

import com.mice.springbootmodel.domain.bean.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author: ChenHao
 * @Date: 2018/7/11 17:00
 */
public interface UserDAO extends MongoRepository<User, String> {


    User findByName(String name);

}
