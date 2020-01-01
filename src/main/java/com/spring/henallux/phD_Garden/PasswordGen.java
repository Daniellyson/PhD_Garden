package com.spring.henallux.phD_Garden;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGen {
    public static void main(String[] args) {
        String test = "mp";
        BCryptPasswordEncoder mp = new BCryptPasswordEncoder();
        System.out.println(mp.encode(test));
    }
}
