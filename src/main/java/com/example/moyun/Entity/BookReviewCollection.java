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
@Table(name = "book_review_collection")
public class BookReviewCollection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer BookReviewCollectionID;
    private Integer BookReviewID;
    private String UserID;
    private Timestamp CollectTime;
}
