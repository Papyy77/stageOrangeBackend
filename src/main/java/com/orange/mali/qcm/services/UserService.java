package com.orange.mali.qcm.services;


import com.orange.mali.qcm.helpers.ResponseWrapper;
import com.orange.mali.qcm.profil.Note;
import com.orange.mali.qcm.profil.User;
import com.orange.mali.qcm.repositories.UserRepo;
import com.orange.mali.qcm.wrappers.LoginWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    public ResponseWrapper findAll(){
        return ResponseWrapper.of(userRepo.findAll());
    }
    public ResponseWrapper findById(Integer id){
        return ResponseWrapper.of(userRepo.findById(id));
    }

    public ResponseWrapper save(User user){
        return ResponseWrapper.of(userRepo.saveAndFlush(user));
    }

    public ResponseWrapper update(Integer id, User user){
        Optional<User> res = userRepo.findById(id);
        if(!res.isPresent()) {
            return ResponseWrapper.error("User not found");
        }
        user.setId(id);
        return ResponseWrapper.of(userRepo.saveAndFlush(user));
    }

    public ResponseWrapper findByLogin(LoginWrapper wrapper){
        return ResponseWrapper.of(userRepo.findByLoginAndPassword(wrapper.getLogin(),wrapper.getPassword()));
    }
}
