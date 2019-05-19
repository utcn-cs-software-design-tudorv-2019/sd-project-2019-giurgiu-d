package com.example.projectPS.C;

import com.example.projectPS.M.Model.Movies;
import com.example.projectPS.M.Services.MoviesServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;


@Controller
public class MovieController {

    @Inject
    private MoviesServices movieS;


    @RequestMapping(value =  "/movies", method = RequestMethod.GET)
    public ModelAndView getMovies(@RequestParam(name = "", required = false) String firstName)
    {
        List<Movies> courseList = movieS.getAllMovies();

        ModelAndView mav = new ModelAndView("MovieView");
        mav.addObject("MovieList", courseList);

        return mav;
    }

}
