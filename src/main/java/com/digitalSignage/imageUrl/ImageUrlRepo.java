package com.digitalSignage.imageUrl;

import com.digitalSignage.manageFolder.ManageFolder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageUrlRepo extends CrudRepository<ImageUrl,Long> {

    @Query("select b1 from ImageUrl b1 where user_name=?1 and folder_name=?2 ")
    List<ImageUrl> getMatchUserName(String user_name, String folder_name);
}
