package org.example.service;

import org.example.dto.Student;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    private StudentRepository studentRepository;

    public void addStudent(Student student) {
        if (student != null) {
            studentRepository.addStudent(student);
        } else {
            System.err.println("Nimadur xato ketdi !!!");
        }
    }

    public void studentList() {
        if (studentRepository.studentList() != null) {
            studentRepository.studentList().stream().forEach(System.out::println);
        } else {
            System.err.println("List bo'sh !!!");
        }
    }

    public Student getStudentById(Integer id) {
        return null;
    }

    public void deleteStudent(Integer id, boolean visible) {
        studentRepository.deleteStudent(id, visible);
    }

}
