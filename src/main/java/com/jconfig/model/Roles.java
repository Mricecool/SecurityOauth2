package com.jconfig.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mr on 2017/8/23.
 */
@Entity
@Table(name = "roles")
public class Roles implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String rolename;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid",nullable = false)
    private Users users;

    /**
     * 获取
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     *
     * @return
     */
    public String getRolename() {
        return rolename;
    }

    /**
     * 设置
     *
     * @param rolename
     */
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    /**
     * 获取
     *
     * @return
     */
    public Users getUsers() {
        return users;
    }

    /**
     * 设置
     *
     * @param users
     */
    public void setUsers(Users users) {
        this.users = users;
    }
}
