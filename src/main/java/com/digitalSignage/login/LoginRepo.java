package com.digitalSignage.login;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface LoginRepo extends CrudRepository<Login,Long> {

    @Query("select b1 from Login b1 where user_name=?1")
    List<Login> getLogin(String user_name);


    @Query("select b1 from Login b1 where user_name=?1 and password=?2")
    List<Login> getLogin(String user_name, String password);

    @Query("select b1 from Login b1 where user_type='user'")
    List<Login> getUserList();

    @Modifying
    @Query(value = "delete from login  where user_name=?1", nativeQuery = true)
    @Transactional
    int deletePostgres(String user_name);

}
