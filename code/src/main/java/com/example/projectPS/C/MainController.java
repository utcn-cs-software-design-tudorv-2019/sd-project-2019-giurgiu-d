package com.example.projectPS.C;

import com.example.projectPS.M.Model.Movies;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {

    @RequestMapping(value =  "/")
    public ModelAndView getMovies(@RequestParam(name = "", required = false) String firstName)
    {
      //  List<Movies> courseList = movieS.getAllMovies();

        ModelAndView mav = new ModelAndView("MainView");
      //  mav.addObject("MovieList", courseList);
        return mav;
    }



}