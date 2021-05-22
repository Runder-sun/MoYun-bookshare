package com.example.moyun.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterVo {
    private String UserID;
    private String Password1;
    private String Password2;
    private String Email;
}
