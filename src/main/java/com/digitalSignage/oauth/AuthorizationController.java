package com.digitalSignage.oauth;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@CrossOrigin("*")
public class AuthorizationController {
    @RequestMapping(value = {"login"}, method = {RequestMethod.GET})
    public String login(Model model) {
        model.addAttribute("msg", (Object) "Please Enter Your Login Details");
        return "login";
    }


}
