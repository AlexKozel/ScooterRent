package com.example.controllers;

import com.example.dto.PageDTO;
import com.example.dto.UserDTO;
import com.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/user/users/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable int id) {
        logger.info("find a user by id {}", id);
        return new ResponseEntity<>(service.getOne(id), HttpStatus.OK);
    }

    @GetMapping("/user/users")
    public ResponseEntity<PageDTO> getAllUsers(@RequestParam(value = "page") int page) {
        logger.info("find all users");
        return new ResponseEntity<>(service.getAll(page), HttpStatus.OK);
    }

    @PostMapping("/admin/users")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {
        logger.info("save user -- {}", userDTO);
        return new ResponseEntity<>(service.save(userDTO), HttpStatus.CREATED);
    }

    @PutMapping("/admin/users")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO) {
        logger.info("update user -- {}", userDTO);
        return new ResponseEntity<>(service.update(userDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/users/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable int id) {
        logger.info("delete user with id {}", id);
        service.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }


}
