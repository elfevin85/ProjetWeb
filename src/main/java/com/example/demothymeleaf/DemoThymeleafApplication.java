package com.example.demothymeleaf;

import com.example.demothymeleaf.Service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoThymeleafApplication implements CommandLineRunner {

    @Autowired
    private CustomerService customerService;


    public static void main(String[] args) {
        SpringApplication.run(DemoThymeleafApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //System.out.println(customerService.readOneCustomer(1L));
    }
}
