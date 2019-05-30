package com.example.projectPS.C;

import com.example.projectPS.M.Model.Actors;
import com.example.projectPS.M.Model.Movies;
import com.example.projectPS.M.Services.ActorsServices;
import com.example.projectPS.M.Services.MoviesServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;
@Controller
public class ActorController {



    @Inject
    ActorsServices actS;

    @RequestMapping(value =  "/actors", method = RequestMethod.GET)
    public ModelAndView getAllActors(@RequestParam(name = "", required = false) String firstName)
    {
        List<Actors> courseList =actS.getAllAdmins();

        ModelAndView mav = new ModelAndView("AllActorsView");
        mav.addObject("ActorList", courseList);

        return mav;
    }


}
