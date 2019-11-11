package com.servprod.apptcc.service;


import org.springframework.security.core.context.SecurityContextHolder;
import com.servprod.apptcc.security.UserSS;

public class UserService {

    public static UserSS authenticated() {
        try {
            return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        }
        catch (Exception e) {
            return null;
        }
    }

}
