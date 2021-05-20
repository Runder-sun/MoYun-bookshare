package com.example.moyun.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "blacklist")
public class Blacklist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int BlacklistID;
    private String UserID;
    private String BanUserID;
    private Timestamp BanTime;

    public Blacklist() {
    }

    public Blacklist(int blacklistID, String userID, String banUserID, Timestamp banTime) {
        BlacklistID = blacklistID;
        UserID = userID;
        BanUserID = banUserID;
        BanTime = banTime;
    }

    public int getBlacklistID() {
        return BlacklistID;
    }

    public void setBlacklistID(int blacklistID) {
        BlacklistID = blacklistID;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getBanUserID() {
        return BanUserID;
    }

    public void setBanUserID(String banUserID) {
        BanUserID = banUserID;
    }

    public Timestamp getBanTime() {
        return BanTime;
    }

    public void setBanTime(Timestamp banTime) {
        BanTime = banTime;
    }
}
