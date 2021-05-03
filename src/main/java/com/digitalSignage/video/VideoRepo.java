package com.digitalSignage.video;

import com.digitalSignage.imageUrl.ImageUrl;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepo extends CrudRepository<Video,Long> {

    @Query("select b1 from Video b1 where user_name=?1 and folder_name=?2 ")
    List<Video> getMatchUserName(String user_name, String folder_name);

}
