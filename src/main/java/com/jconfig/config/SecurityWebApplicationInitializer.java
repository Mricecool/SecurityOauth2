package com.jconfig.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * 相当于在web.xml中注册了springSecurityFilterChain Filter
 * Created by mr on 2017/8/24.
 */
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

    @Override
    protected boolean enableHttpSessionEventPublisher() {
        return true;
    }

}
