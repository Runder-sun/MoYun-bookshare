package com.example.moyun.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book_review")
public class BookReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer BookReviewID;
    private Integer BookID;
    private String UserID;
    private Timestamp ReviewTime;
    private String Content;
    private String Title;
    private Integer Score;
    private Integer Likes;
}
