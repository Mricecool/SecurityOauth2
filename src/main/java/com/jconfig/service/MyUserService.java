package com.jconfig.service;

import com.jconfig.dao.UsersDao;
import com.jconfig.model.SecurityUser;
import com.jconfig.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mr on 2017/8/23.
 */
@Component
public class MyUserService implements UserDetailsService {

    @Autowired
    UsersDao adminDao;

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users adminInfo=adminDao.findUserByName(s);
        if(adminInfo==null){
            throw new UsernameNotFoundException("Username not found");
        }
        return new SecurityUser(adminInfo);
    }
}
