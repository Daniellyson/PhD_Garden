package com.spring.henallux.phD_Garden.dataAccess;

import com.spring.henallux.phD_Garden.model.User;

public interface UserDataAccess {
    User findByUsername(String username);
    User save(User user);
    boolean existsByUsername(String username);
}
