package com.digitalSignage.video;

import com.digitalSignage.imageUrl.ImageUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class VideoController {
    @Autowired
    VideoRepo videoRepo;


    @PostMapping("insertImgUrl")
    public String insertImgUrl(@RequestBody Video video){
        String message="Successful";
        videoRepo .save(video);
        return message;
    }

    @GetMapping("getImgUrlData")
    public Map<String, List<Video>> getImgUrl(@RequestParam("user_name")String user_name,
                                                 @RequestParam("folder_name")String folder_name){
        List<Video>imageUrls=videoRepo.getMatchUserName(user_name,folder_name);
        HashMap<String,List<Video>> hMap=new HashMap<>();
        hMap.put("imgurl",imageUrls);
        return hMap;
    }
}
