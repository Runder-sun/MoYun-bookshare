package com.example.moyun.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "group_apply")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupApply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer GroupApplyID;
    private Integer GroupID;
    private String ApplyUserID;
    private Timestamp ApplyTime;
}
