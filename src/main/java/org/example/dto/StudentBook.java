package org.example.dto;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.Status;

import java.time.LocalDate;

@Getter
@Setter
public class StudentBook {
    private Integer id;
    private Integer student_id;
    private Integer book_id;
    private LocalDate createdDate;
    private Status status;
    private LocalDate returnedDate;
    private String duration; // davomiyliki yani nechi kun unda bo'lishi

}
//id,student_id,book_id,createdDate,status(TAKEN,RETURNED),returnedDate,duration