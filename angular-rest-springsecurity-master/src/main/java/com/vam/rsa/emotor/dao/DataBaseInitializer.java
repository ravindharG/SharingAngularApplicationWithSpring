package com.vam.rsa.emotor.dao;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.vam.rsa.emotor.dao.user.UserDao;
import com.vam.rsa.emotor.entity.Role;
import com.vam.rsa.emotor.entity.Users;

/**
 * Initialize the database with some test entries.
 *
 * @author avinash
 */
public class DataBaseInitializer
{
    private UserDao userDao;
    private PasswordEncoder passwordEncoder;
    protected DataBaseInitializer(){
        /* Default constructor for reflection instantiation */
    }

    public DataBaseInitializer(UserDao userDao,PasswordEncoder passwordEncoder)
    {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    public void initDataBase()
    {
        Users userUser = new Users("users", this.passwordEncoder.encode("users"));
        userUser.addRole(Role.USER);
        this.userDao.save(userUser);

        Users adminUser = new Users("admin", this.passwordEncoder.encode("admin"));
        adminUser.addRole(Role.USER);
        adminUser.addRole(Role.ADMIN);
        this.userDao.save(adminUser);
    }
}
