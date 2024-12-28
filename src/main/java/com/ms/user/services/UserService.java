package com.ms.user.services;


import com.ms.user.models.UserModel;
import com.ms.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    @Transactional
    public UserModel save(UserModel userModel){
        return userRepository.save(userModel);
    }

    @Transactional
    public List<UserModel> geti(UserModel userModel){
        return userRepository.findAll();
    }


    @Transactional
    public Optional<UserModel> getPorId(UUID id){
        return userRepository.findById(id);
    }










}
