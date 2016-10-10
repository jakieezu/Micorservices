package com.accenture.microservices.consumer.poc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@RestController
public class Application {

    @Autowired
    ConsumerPort consumerPort;

    @RequestMapping("/foos")
    public List<Foo> foos() {
    	System.out.println("consumerPort.foos(): "+consumerPort.foos());
        return consumerPort.foos();
    }

    @RequestMapping("/")
    public String hello() {
        return "Hello World!";
    };
    

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
