package com.mice.springbootmodel;

import com.mice.springbootmodel.domain.bean.User;
import com.mice.springbootmodel.persistence.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootModelApplication implements CommandLineRunner {
    @Autowired
    private UserDAO repository;
    public static void main(String[] args) {
        SpringApplication.run(SpringbootModelApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();

        repository.save(new User(1,"name1",19));
        repository.save(new User(2,"name2",20));

        System.out.println("User found with findAll():");
        System.out.println("-------------------------------");
        for (User user : repository.findAll()) {
            System.out.println(user);
        }
        System.out.println("------------------------");

        System.out.println("User found with findByName('name1'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByName("name1"));


    }
}
