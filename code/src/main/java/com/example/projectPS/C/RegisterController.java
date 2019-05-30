package com.example.projectPS.C;

import com.example.projectPS.M.Model.User;
import com.example.projectPS.M.Services.UserServices;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

public class RegisterController {



    ////////////Registering a User
    @Inject
    UserServices userS;


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("RegisterView", new User());

        return "registration";
    }




}
