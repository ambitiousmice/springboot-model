package com.mice.springbootmodel.service;

import com.mice.springbootmodel.domain.bean.User;
import com.mice.springbootmodel.persistence.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: ChenHao
 * @Date: 2018/7/11 17:01
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userRepository;

    @Override
    public void save(User user) {

        userRepository.save(user);

    }

    @Override
    public User findByName(String name) {
        return this.findByName(name);
    }

}
