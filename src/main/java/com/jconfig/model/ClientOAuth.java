package com.jconfig.model;

import javax.persistence.*;

/**
 * Created by mr on 2017/9/19.
 */
@Entity
@Table(name = "oauth_client_details")
public class ClientOAuth {

    @Id
    private String client_id;
    private String resource_ids;
    private String client_secret;
    private String scope;
    private String authorized_grant_types;
    private String web_server_redirect_uri;
    private String authorities;
    private Integer access_token_validity;
    private Integer refresh_token_validity;
    private String additional_information;
    private String autoapprove;

    /**
     * 获取
     *
     * @return
     */
    public String getClient_id() {
        return client_id;
    }

    /**
     * 设置
     *
     * @param client_id
     */
    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    /**
     * 获取
     *
     * @return
     */
    public String getResource_ids() {
        return resource_ids;
    }

    /**
     * 设置
     *
     * @param resource_ids
     */
    public void setResource_ids(String resource_ids) {
        this.resource_ids = resource_ids;
    }

    /**
     * 获取
     *
     * @return
     */
    public String getClient_secret() {
        return client_secret;
    }

    /**
     * 设置
     *
     * @param client_secret
     */
    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    /**
     * 获取
     *
     * @return
     */
    public String getScope() {
        return scope;
    }

    /**
     * 设置
     *
     * @param scope
     */
    public void setScope(String scope) {
        this.scope = scope;
    }

    /**
     * 获取
     *
     * @return
     */
    public String getAuthorized_grant_types() {
        return authorized_grant_types;
    }

    /**
     * 设置
     *
     * @param authorized_grant_types
     */
    public void setAuthorized_grant_types(String authorized_grant_types) {
        this.authorized_grant_types = authorized_grant_types;
    }

    /**
     * 获取
     *
     * @return
     */
    public String getWeb_server_redirect_uri() {
        return web_server_redirect_uri;
    }

    /**
     * 设置
     *
     * @param web_server_redirect_uri
     */
    public void setWeb_server_redirect_uri(String web_server_redirect_uri) {
        this.web_server_redirect_uri = web_server_redirect_uri;
    }

    /**
     * 获取
     *
     * @return
     */
    public String getAuthorities() {
        return authorities;
    }

    /**
     * 设置
     *
     * @param authorities
     */
    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    /**
     * 获取
     *
     * @return
     */
    public Integer getAccess_token_validity() {
        return access_token_validity;
    }

    /**
     * 设置
     *
     * @param access_token_validity
     */
    public void setAccess_token_validity(Integer access_token_validity) {
        this.access_token_validity = access_token_validity;
    }

    /**
     * 获取
     *
     * @return
     */
    public Integer getRefresh_token_validity() {
        return refresh_token_validity;
    }

    /**
     * 设置
     *
     * @param refresh_token_validity
     */
    public void setRefresh_token_validity(Integer refresh_token_validity) {
        this.refresh_token_validity = refresh_token_validity;
    }

    /**
     * 获取
     *
     * @return
     */
    public String getAdditional_information() {
        return additional_information;
    }

    /**
     * 设置
     *
     * @param additional_information
     */
    public void setAdditional_information(String additional_information) {
        this.additional_information = additional_information;
    }

    /**
     * 获取
     *
     * @return
     */
    public String getAutoapprove() {
        return autoapprove;
    }

    /**
     * 设置
     *
     * @param autoapprove
     */
    public void setAutoapprove(String autoapprove) {
        this.autoapprove = autoapprove;
    }
}
