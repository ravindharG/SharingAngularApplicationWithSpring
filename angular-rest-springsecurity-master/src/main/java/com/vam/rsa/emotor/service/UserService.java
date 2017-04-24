package com.vam.rsa.emotor.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.vam.rsa.emotor.entity.AccessToken;
import com.vam.rsa.emotor.entity.Users;

/**
 * @author avinash
 */
public interface UserService extends UserDetailsService
{
    Users findUserByAccessToken(String accessToken);

    AccessToken createAccessToken(Users user);
}