package com.digitalSignage.manageFolder;

import com.digitalSignage.login.Login;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManageFolderRepo extends CrudRepository<ManageFolder,Long> {

    @Query("select b1 from ManageFolder b1 where user_name=?1 and folder_name=?2 ")
    List<ManageFolder> getMatchUserName(String user_name, String folder_name);



}
