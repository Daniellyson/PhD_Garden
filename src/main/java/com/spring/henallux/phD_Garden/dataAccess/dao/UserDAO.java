package com.spring.henallux.phD_Garden.dataAccess.dao;

import com.spring.henallux.phD_Garden.dataAccess.UserDataAccess;
import com.spring.henallux.phD_Garden.dataAccess.entity.UserEntity;
import com.spring.henallux.phD_Garden.dataAccess.repository.UserRepository;
import com.spring.henallux.phD_Garden.dataAccess.util.ProviderConverter;
import com.spring.henallux.phD_Garden.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserDAO implements UserDataAccess {

    private UserRepository userRepository;

    @Autowired
    public UserDAO(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);
        if(userEntity != null) {
            return new ProviderConverter().userEntityToUserModel(userEntity);
        }else {
            throw new UsernameNotFoundException("User not found");
        }


    }

    @Override
    public User save(User user){
        UserEntity userEntity = new ProviderConverter().userModelToUserEntity(user);
        UserEntity newUser = this.userRepository.save(userEntity);
        return new ProviderConverter().userEntityToUserModel(newUser);
    }

    @Override
    public boolean existsByUsername(String username) {
        return this.userRepository.existsByUsername(username);
    }
}
