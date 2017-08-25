package com.jconfig.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mr on 2017/8/23.
 */
@Entity
@Table(name = "users")
public class Users implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String uname;
    private String pwd;
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "users")
    private Set<Roles> roles;

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
    public String getUname() {
        return uname;
    }

    /**
     * 设置
     *
     * @param uname
     */
    public void setUname(String uname) {
        this.uname = uname;
    }

    /**
     * 获取
     *
     * @return
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * 设置
     *
     * @param pwd
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * 获取
     *
     * @return
     */
    public Set<Roles> getRoles() {
        return roles;
    }

    /**
     * 设置
     *
     * @param roles
     */
    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }
}
