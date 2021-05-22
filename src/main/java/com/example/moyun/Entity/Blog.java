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
@Table(name = "blog_info")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer BlogID;
    private String BlogTitle;
    private String AuthorID;
    private Timestamp RecentFinishTime;
    private String Content;
    private Boolean isReprint;
    private Integer Likes;
}
