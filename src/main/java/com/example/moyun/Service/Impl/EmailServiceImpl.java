package com.example.moyun.Service.Impl;

import com.example.moyun.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Random;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    JavaMailSender javaMailSender;
    @Override
    public void sendEmail(String Email, HttpSession session){
        String code=randomCode();
        session.setAttribute("code",code);
        try{
            SimpleMailMessage message=new SimpleMailMessage();
            message.setSubject("找回密码邮件");
            message.setFrom("1160411003@qq.com");
            message.setTo(Email);
            message.setText("你的验证码是："+code);
            javaMailSender.send(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private String randomCode() {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();

    }
}
