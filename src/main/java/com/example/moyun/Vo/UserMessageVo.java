package com.example.moyun.Vo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class UserMessageVo {
    Integer UserMessageID;
    Timestamp SendTime;
    String SendID;
    String GetID;
}
