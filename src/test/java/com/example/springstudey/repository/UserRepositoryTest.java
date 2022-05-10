package com.example.springstudey.repository;

import com.example.springstudey.SpringStudeyApplicationTests;
import com.example.springstudey.model.entity.Item;
import com.example.springstudey.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.transaction.annotation.Transactional;


import javax.xml.bind.SchemaOutputResolver;
import java.time.LocalDateTime;
import java.util.Optional;


public class UserRepositoryTest extends SpringStudeyApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        User user = new User();
        user.setAccout("TestUser03");
        user.setEmail("TestUser02@gmail.com");
        user.setPhoneNumber("000-1000-3333");
        user.setCreateAt(LocalDateTime.now());
        user.setCreateBy("TestUser03");

        User newUser = userRepository.save(user);
        System.out.println("newUser : " + newUser);
    }
    @Test
    @Transactional
    public void read(){
        Optional<User> user =userRepository.findByAccout("TestUser03");

        user.ifPresent(selectUser ->{
           selectUser.getOrderDetailsList().stream().forEach(detail ->{
               Item item = detail.getItem();
               System.out.println(item);
           });
        });

    }
    @Test
    public void update(){
        Optional<User> user = userRepository.findById(2L);
        user.ifPresent(selectUser ->{
            selectUser.setAccout("updateTestUser02");
            selectUser.setUpdateAt(LocalDateTime.now());
            selectUser.setUpdateBy("update method()");

            userRepository.save(selectUser);
        });
    }
    @Test
    @Transactional
    public void delete(){
        Optional<User> user = userRepository.findById(2L);
        user.ifPresent(selectUser ->{
           userRepository.delete(selectUser);
        });
        Optional<User> deleteUser = userRepository.findById(2L);

    }
}
