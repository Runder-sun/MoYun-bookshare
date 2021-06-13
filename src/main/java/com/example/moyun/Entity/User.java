package com.example.moyun.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="user_info")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;
    private String UserID;
    private String Password;
    private String Username;
    private Integer isTeacher;
    private Integer Sex;
    private String Email;
    private Date Birthday;
    private String Signature;
    private String HeadImage;
    private String BackgroundImage;
    private Integer isForbidden;
}
