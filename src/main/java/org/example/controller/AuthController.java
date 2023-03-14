package org.example.controller;

import org.example.service.AuthService;
import org.example.util.Scan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AuthController {
    @Autowired
    private Scan scanner;
    @Autowired
    private AuthService authService;
    public void start() {
        boolean b = true;
        while (b) {
            switch (menu()) {
                case 1 -> logIn();
                case 0 -> b = false;
                default -> System.out.println("Not found this command !!! ");
            }
        }
    }
    public Integer menu() {
        System.out.println("** * * * * *****  MENU  ** * * * * *****");
        System.out.println("1.Login: ");
        System.out.println("0.Exit:");
        System.out.print("Enter action :");
        return scanner.intScan().nextInt();
    }
    public void logIn() {
        System.out.print("Enter phone number :");
        authService.logIn(scanner.stringScan().nextLine());
    }
}
