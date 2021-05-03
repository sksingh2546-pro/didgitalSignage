package com.digitalSignage.manageFolder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ManageFolderController {
    @Autowired
    ManageFolderRepo manageFolderRepo;

    @PostMapping("insertManageFolder")
    public String insertManageFolder(@RequestBody ManageFolder manageFolder){
        String message="UnSuccessful";
        List<ManageFolder> manageFolderList=manageFolderRepo.getMatchUserName(manageFolder.getUser_name(),
                manageFolder.getFolder_name());

        if(manageFolderList.size()>0){
            message="Already Exist Try another";
        }else{
            manageFolderRepo.save(manageFolder);
            message="Inserted";
        }
        return  message;
    }

    @GetMapping("getManageFolderData")
    public Map<String,List<ManageFolder>>getManageFolderData(@RequestParam("user_name")String user_name,
                                                             @RequestParam("folder_name") String folder_name){
        List<ManageFolder>manageFolderList=manageFolderRepo.getMatchUserName(user_name,folder_name);
        HashMap<String,List<ManageFolder>>hMap=new HashMap<>();
        hMap.put("folderData",manageFolderList);
        return hMap;
    }

}
