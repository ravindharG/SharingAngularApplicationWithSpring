package com.vam.rsa.emotor.dao.user;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.vam.rsa.emotor.dao.Dao;
import com.vam.rsa.emotor.entity.Users;

public interface UserDao extends Dao<Users, Long>
{
    Users loadUserByUsername(String username) throws UsernameNotFoundException;

    Users findByName(String name);
    
    Users validateUser(String name,String password);
}
