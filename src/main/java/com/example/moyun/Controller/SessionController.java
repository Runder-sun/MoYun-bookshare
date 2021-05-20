package com.example.moyun.Controller;

import com.example.moyun.Entity.User;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@RestController
public abstract class SessionController {
    private static final String user0 = "0";

    private HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }

    public User getUser() {
        HttpSession session = getRequest().getSession();
        return (User) session.getAttribute(user0);
    }

    public void setUser(User user) {
        HttpSession session = getRequest().getSession();
        session.setAttribute(user0, user);
    }
}
