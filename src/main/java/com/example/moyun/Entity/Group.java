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
@Table(name = "group_info")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer GroupID;
    private String GroupName;
    private String Tag;
    private String CreateID;
    private Timestamp CreateTime;
    private Integer MemberNum;
    private Boolean isPrivate;
    private String Introduce;
    private String GroupImage;
}
