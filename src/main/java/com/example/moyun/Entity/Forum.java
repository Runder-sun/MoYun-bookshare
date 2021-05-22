package com.example.moyun.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "forum_info")
public class Forum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ForumID;
    private String Topic;
    private Integer GroupID;
    private String CreateID;
    private String CreateTime;
    private String Kind;
    private Integer ForumMessages;
}
