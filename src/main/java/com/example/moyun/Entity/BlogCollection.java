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
@Table(name = "blog_collection")
public class BlogCollection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer BlogCollectionID;
    private Integer BlogID;
    private String UserID;
    private Timestamp CollectTime;
}
