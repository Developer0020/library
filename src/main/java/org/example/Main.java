package org.example;

import org.example.config.Config;
import org.example.controller.AuthController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        AuthController authController=(AuthController)context.getBean("authController") ;
        authController.start();
    }
}