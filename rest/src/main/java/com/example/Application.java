package com.example;

import com.example.model.City;
import com.example.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(scanBasePackages = "com.example")
@RestController
public class Application {

    public final DiscountService service;

    public Application(@Autowired DiscountService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home() {
        System.out.println("create a discount");
//        service.save();
        System.out.println("discount added");
//        System.out.println(new City().toString());
        return service.message();

    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}