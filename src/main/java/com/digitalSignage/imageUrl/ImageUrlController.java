package com.digitalSignage.imageUrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ImageUrlController {
    @Autowired
    ImageUrlRepo imageUrlRepo;

    @PostMapping("insertImgUrl")
    public String insertImgUrl(@RequestBody ImageUrl imageUrl){
        String message="Successful";
        imageUrlRepo.save(imageUrl);
        return message;
    }

    @GetMapping("getImgUrlData")
    public Map<String, List<ImageUrl>>getImgUrl(@RequestParam("user_name")String user_name,
                                                @RequestParam("folder_name")String folder_name){
        List<ImageUrl>imageUrls=imageUrlRepo.getMatchUserName(user_name,folder_name);
        HashMap<String,List<ImageUrl>>hMap=new HashMap<>();
        hMap.put("imgurl",imageUrls);
        return hMap;
    }
}
