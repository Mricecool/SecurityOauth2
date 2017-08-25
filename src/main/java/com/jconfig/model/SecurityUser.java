package com.jconfig.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 * Created by mr on 2017/8/23.
 */
public class SecurityUser extends Users implements UserDetails {

    public SecurityUser(Users admin) {
        if (admin != null) {
            this.setId(admin.getId());
            this.setUname(admin.getUname());
            this.setPwd(admin.getPwd());
            this.setRoles(admin.getRoles());
        }
    }


    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        Set<Roles> userRoles = this.getRoles();
        if (userRoles != null) {
            for (Roles roles:userRoles){
                System.out.println(roles.getRolename());
                //“ROLE_”坑死我了
                SimpleGrantedAuthority authority=new SimpleGrantedAuthority("ROLE_"+roles.getRolename());
                authorities.add(authority);
            }
        }
        return authorities;
    }

    public String getPassword() {
        return super.getPwd();
    }

    public String getUsername() {
        return super.getUname();
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }
}
