package com.vam.rsa.emotor.dao;

import java.util.List;

import com.vam.rsa.emotor.entity.Entity;
import com.vam.rsa.emotor.entity.Users;

public interface Dao<T extends Entity, I>
{
    List<T> findAll();
    T find(I id);
    T save(T entity);
    void delete(I id);
    void delete(T entity);
}
