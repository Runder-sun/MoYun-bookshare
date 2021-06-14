package com.example.moyun.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book_info")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer BookID;
    private String BookName;
    private String Author;
    private String Publisher;
    private String ISBN;
    private String Kind;
    private Double Score;
    private String Link;
    private String BookImage;
    private Integer ReadTimes;
    private String UserID;
    private String Introduce;
}
