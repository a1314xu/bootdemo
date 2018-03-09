package com.xpc.bootdemo.web;

import com.xpc.bootdemo.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.xpc.bootdemo.domain.User;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository repo;

    @GetMapping(value = "/api/getUsers")
    public List<User> findUser() {
        return repo.findAll();
    }

    @PostMapping(value = "/api/addUser")
    public User addUser(@RequestBody User user) {
        return repo.saveAndFlush(user);
    }

    @PutMapping( value = "/api/updateUser" )
    public User updateUser(@RequestBody User user) {
        return repo.saveAndFlush(user);
    }

    @DeleteMapping( value = "/api/deleteUser/{id}" )
    public void deleteUser(@PathVariable("id") Long id) {
        repo.deleteById(id);
    }
}
