package com.vam.rsa.emotor.dao.accesstoken;

import com.vam.rsa.emotor.dao.Dao;
import com.vam.rsa.emotor.entity.AccessToken;

/**
 * @author avinash
 */
public interface AccessTokenDao extends Dao<AccessToken, Long>
{
    AccessToken findByToken(String accessTokenString);
}
