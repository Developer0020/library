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
    public void logIn(Integer id, String phone) {
        if (studentRepository.getStudentById(id, phone) == null) {
            System.err.println("Bunday student yo'q!");
        } else if (studentRepository.getStudentById(id, phone).getPhone().equals("+998936529454")) {
            adminController.start();
            Component.student= studentRepository.getStudentById(id, phone);
        } else {
            userController.start();
            Component.student= studentRepository.getStudentById(id, phone);
        }
    }
}
