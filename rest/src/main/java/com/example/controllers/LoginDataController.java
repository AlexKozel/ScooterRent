package com.example.controllers;

import com.example.dto.LoginDataDto;
import com.example.dto.PageDTO;
import com.example.service.LoginDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginDataController {

    private Logger logger = LoggerFactory.getLogger(LoginDataController.class);

    private LoginDataService service;

    @Autowired
    public LoginDataController(LoginDataService service) {
        this.service = service;
    }

    @GetMapping("/user/loginData/{id}")
    public ResponseEntity<LoginDataDto> getLoginDataById(@PathVariable int id) {
        logger.info("find a LoginData by id {}", id);
        return new ResponseEntity<>(service.getOne(id), HttpStatus.OK);
    }

    @GetMapping("/admin/loginData")
    public ResponseEntity<PageDTO> getAllLoginDates(@RequestParam (value = "page") int page) {
        logger.info("find all LoginDates");
        return new ResponseEntity<>(service.getAll(page), HttpStatus.OK);
    }

    @PostMapping("/admin/loginData")
    public ResponseEntity<LoginDataDto> saveLoginData(@RequestBody LoginDataDto loginDataDto) {
        logger.info("save LoginData -- {}", loginDataDto);
        return new ResponseEntity<>(service.save(loginDataDto), HttpStatus.CREATED);
    }

    @PutMapping("/admin/loginData")
    public ResponseEntity<LoginDataDto> updateLoginData(@RequestBody LoginDataDto loginDataDto) {
        logger.info("update LoginData -- {}", loginDataDto);
        return new ResponseEntity<>(service.update(loginDataDto), HttpStatus.OK);
    }


    @DeleteMapping("/admin/loginData/{id}")
    public ResponseEntity<String> deleteLoginDataById(@PathVariable int id) {
        logger.info("delete LoginData with id {}", id);
        service.deleteById(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }
}
