package com.jconfig.dao;

import com.jconfig.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by mr on 2017/8/23.
 */
@Repository
public interface UsersDao extends JpaRepository<Users,Integer>{

    @Query("select a from Users a where a.uname=?1")
    public Users findUserByName(String name);
}
