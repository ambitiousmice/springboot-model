package com.mice.springbootmodel.service;

import com.mice.springbootmodel.domain.bean.User;
import org.springframework.stereotype.Repository;

/**
 * @Author: ChenHao
 * @Date: 2018/7/11 17:01
 */
@Repository
public interface UserService {
    void save(User user);

    User findByName(String name);
}
