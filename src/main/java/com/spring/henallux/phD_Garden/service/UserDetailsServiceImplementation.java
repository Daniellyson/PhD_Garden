package com.spring.henallux.phD_Garden.service;

import com.spring.henallux.phD_Garden.dataAccess.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImplementation implements UserDetailsService {
    private UserDAO userDao;

    @Autowired
    public UserDetailsServiceImplementation(UserDAO userDAO){
        this.userDao = userDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = userDao.findByUsername(username);

        if(user != null) {
            return user;
        }
        throw new UsernameNotFoundException("User not found");
    }
}

