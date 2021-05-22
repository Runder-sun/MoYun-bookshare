package com.example.moyun.Service;

import javax.servlet.http.HttpSession;

public interface EmailService {
    //发送找回密码邮件
    void sendEmail(String Email, HttpSession session);
}
