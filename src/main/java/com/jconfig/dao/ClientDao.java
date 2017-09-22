package com.jconfig.dao;

import com.jconfig.model.ClientOAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by mr on 2017/9/19.
 */
@Repository
public interface ClientDao extends JpaRepository<ClientOAuth, String> {

    @Query("select c from ClientOAuth c where c.client_id=?1")
    public ClientOAuth findClientByName(String name);

}
