package com.digitalSignage.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    LoginRepo loginRepo;
   // @CrossOrigin(origins = "http://192.168.1.8:3000")
    @PostMapping("insertLogin")
    public String insertLogin(@RequestBody Login login){
        String message="UnSuccessful";
        List<Login>loginList=loginRepo.getLogin(login.getUser_name());
        if(loginList.size()>0){
            message="Try another user name";
        }else {
            loginRepo.save(login);
            message="Inserted";
        }
        return message;
    }

    @GetMapping("getLogin")
    public String getLogin(@RequestParam("user_name")String user_name,@RequestParam("password")String password
                           ){
        String message="Not Login";
        List<Login>loginList=loginRepo.getLogin(user_name,password);
        if(loginList.size()>0){
            if(loginList.get(0).getUser_type().equalsIgnoreCase("admin")){
                message="admin";
            }
            else{

                message="user";
            }
        }
        return  message;
    }


    /*@GetMapping("getAllUserList")
    public Map<String,List<Login>>getAllUserList(){
        List<Login>logins=loginRepo.getUserList();
        HashMap<String,List<Login>>hMap=new HashMap<>();
        hMap.put("userList",logins);
        return hMap;
    }
*/
    @GetMapping("getUserList")
    public Map<String,List<Login>>getUserList(){
        ArrayList<Login>loginArrayList=new ArrayList<>();
        List<Login>logins= (List<Login>) loginRepo.findAll();
        for(Login login:logins){
            if(login.getUser_type().equalsIgnoreCase("User")){
                loginArrayList.add(login);
            }
        }
        HashMap<String,List<Login>>hMap=new HashMap<>();
        hMap.put("userList",loginArrayList);
        return hMap;

    }
}
