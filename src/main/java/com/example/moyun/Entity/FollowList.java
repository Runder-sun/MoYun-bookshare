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
@Table(name = "follow_list")
public class FollowList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer FollowListID;
    private String FollowerID;
    private String FollowedID;
    private Timestamp FollowTime;
}
