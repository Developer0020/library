package org.example;

import org.example.controller.AuthController;

public class Main {
    public static void main(String[] args) {
        AuthController authController = new AuthController();
        authController.start();
    }
}