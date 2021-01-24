package com.javatechie.actuator.dao;

import com.javatechie.actuator.dto.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class UserDatabase {



    public List<User> getAllUsers() {
        return Stream.of(
                new User(108, "zyx", "xyz@gmail.com", "inActive"),
                new User(101, "john", "john@gmail.com", "active"),
                new User(102, "smith", "smith@gmail.com", "inActive"),
                new User(103, "peter", "peter@gmail.com", "active"),
                new User(104, "kely", "kely@gmail.com", "active"))
                .collect(Collectors.toList());
    }


    public long getUserStatusCountByStatus(String status){
       return getAllUsers().stream().filter(user -> user.getStatus().equals(status)).count();
    }

}
