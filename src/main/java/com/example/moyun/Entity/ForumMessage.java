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
@Table(name = "forum_message")
public class ForumMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ForumMessageID;
    private Integer ForumID;
    private String UserID;
    private String Comment;
    private Timestamp CommentTime;
}
