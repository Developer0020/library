package org.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Student {
    private Integer id;
    private String name;
    private String surname;
    private String phone;
    private LocalDate createdDate;
    private boolean visible;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", createdDate=" + createdDate +
                ", visible=" + visible +
                '}';
    }
}
//id, name, surname,phone, createdDate, visible