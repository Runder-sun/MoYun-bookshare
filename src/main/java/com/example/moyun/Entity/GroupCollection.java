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
@Table(name = "group_collection")
public class GroupCollection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer GroupCollectionID;
    private String UserID;
    private Integer GroupID;
    private Timestamp CollectTime;
}
