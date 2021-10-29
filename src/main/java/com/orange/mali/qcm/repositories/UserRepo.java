package com.orange.mali.qcm.repositories;

import com.orange.mali.qcm.profil.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
    User findByLoginAndPassword(String login,String password);
}
