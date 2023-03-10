package org.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class Book {
    private Integer id;
    private String title;
    private String author;
    private LocalDate publishYear;
    private String amount;
    private boolean visible = true;
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishYear=" + publishYear +
                ", amount='" + amount + '\'' +
                ", visible=" + visible +
                '}';
    }

}
//id,title,author, publishYear, amount, visible