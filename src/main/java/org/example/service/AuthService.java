package org.example.service;

import org.example.controller.AdminController;
import org.example.controller.UserController;
import org.example.repository.StudentRepository;
import org.example.util.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private AdminController adminController;
    @Autowired
    private UserController userController;
    public void logIn(String phone) {
        if (studentRepository.getStudentByPhone(phone) == null) {
            System.err.println("Bunday student yo'q!");
        } else if (studentRepository.getStudentByPhone(phone).getPhone().equals("+998936529454")) {
            Component.student = studentRepository.getStudentByPhone(phone);
            adminController.start();
        } else {
            Component.student = studentRepository.getStudentByPhone(phone);
            userController.start();
        }
    }
}
