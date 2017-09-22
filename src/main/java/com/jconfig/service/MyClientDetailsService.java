package com.jconfig.service;

import com.jconfig.dao.ClientDao;
import com.jconfig.dao.UsersDao;
import com.jconfig.model.ClientOAuth;
import com.jconfig.model.Roles;
import com.jconfig.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * 实现客户端信息的查询（获取token）
 * Created by app on 2017/2/15.
 */
@Component
public class MyClientDetailsService implements ClientDetailsService{

    @Autowired
    ClientDao clientDao;

    public MyClientDetailsService() {
    }

    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {

        if (clientDao == null) {
            System.out.println("loginRepository is null");
        }

        ClientOAuth clientOAuth = clientDao.findClientByName(s);
        if (clientOAuth == null) {
            System.out.println("User not found");
            throw new NoSuchClientException("No client recognized with id: " + s);
        } else {
            List<String> authorizedGrantTypes = new ArrayList<String>();
            List<String> scopeGrantTypes = new ArrayList<String>();
            authorizedGrantTypes.add("authorization_code");
            authorizedGrantTypes.add("password");
            authorizedGrantTypes.add("refresh_token");
            authorizedGrantTypes.add("client_credentials");
            authorizedGrantTypes.add("implicit");

            scopeGrantTypes.add("read");
            scopeGrantTypes.add("write");
            scopeGrantTypes.add("trust");
            BaseClientDetails clientDetails = new BaseClientDetails();
            clientDetails.setClientId(clientOAuth.getClient_id());
            clientDetails.setClientSecret(clientOAuth.getClient_secret());
            clientDetails.setScope(scopeGrantTypes);
            clientDetails.setAuthorizedGrantTypes(authorizedGrantTypes);
            Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

            SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");
            authorities.add(authority);
            clientDetails.setAuthorities(authorities);
            return clientDetails;
        }
    }

    private Collection<GrantedAuthority> getGrantedAuthorities(Set<Roles> userRoles) {
        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        if (userRoles != null) {
            for (Roles roles : userRoles) {
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + roles.getRolename());
                authorities.add(authority);
            }
        }
        return authorities;
    }
}
