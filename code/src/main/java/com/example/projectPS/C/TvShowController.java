package com.example.projectPS.C;

import com.example.projectPS.M.Model.Movies;
import com.example.projectPS.M.Model.TvShow;
import com.example.projectPS.M.Services.MoviesServices;
import com.example.projectPS.M.Services.TvShowServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;
@Controller
public class TvShowController {


    @Inject
    private TvShowServices movieS;


    @RequestMapping(value =  "/shows", method = RequestMethod.GET)
    public ModelAndView getMovies(@RequestParam(name = "", required = false) String firstName)
    {
        List<TvShow> courseList = movieS.getAllAdmins();

        ModelAndView mav = new ModelAndView("TvShowView");
        mav.addObject("ShowList", courseList);

        return mav;
    }

}
