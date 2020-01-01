package com.spring.henallux.phD_Garden.dataAccess.util;

import com.spring.henallux.phD_Garden.dataAccess.entity.UserEntity;
import com.spring.henallux.phD_Garden.model.User;

public class ProviderConverter {
    public UserEntity userModelToUserEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setUsername(user.getUsername());
        userEntity.setPassword(user.getPassword());
        userEntity.setAuthorities(user.getAuthorities());
        userEntity.setAccountNonExpired(user.isAccountNonExpired());
        userEntity.setAccountNonLocked(user.isAccountNonLocked());
        userEntity.setCredentialsNonExpired(user.isCredentialsNonExpired());
        userEntity.setEnabled(user.isEnabled());
        userEntity.setEmail(user.getEmail());
        userEntity.setFirstname(user.getFirstname());
        userEntity.setLastname(user.getLastname());
        userEntity.setStreet(user.getStreet());
        userEntity.setHouse_number(user.getHouse_number());
        userEntity.setBirthdate(user.getBirthdate());
        userEntity.setLocality(user.getLocality());
        userEntity.setPostalCode(user.getPostalCode());
        userEntity.setPhone(user.getPhone());
        userEntity.setGender(user.getGender());
        return userEntity;
    }

    public User userEntityToUserModel(UserEntity userEntity) {
        User user = new User();
        user.setId(userEntity.getId());
        user.setUsername(userEntity.getUsername());
        user.setPassword(userEntity.getPassword());
        user.setAuthorities(userEntity.getAuthorities());
        user.setAccountNonExpired(userEntity.getAccountNonExpired());
        user.setAccountNonLocked(userEntity.getAccountNonLocked());
        user.setCredentialsNonExpired(userEntity.getCredentialsNonExpired());
        user.setEnabled(userEntity.getEnabled());
        user.setEmail(userEntity.getEmail());
        user.setFirstname(userEntity.getFirstname());
        user.setFirstname(userEntity.getFirstname());
        user.setStreet(userEntity.getStreet());
        user.setHouse_number(userEntity.getHouse_number());
        user.setBirthdate(userEntity.getBirthdate());
        user.setLocality(userEntity.getLocality());
        user.setPostalCode(userEntity.getPostalCode());
        user.setPhone(userEntity.getPhone());
        user.setGender(userEntity.getGender());
        return user;
    }
}
