package com.example.projectPS.C;

import com.example.projectPS.M.Model.Actors;
import com.example.projectPS.M.Model.Movies;
import com.example.projectPS.M.Model.TvShow;
import com.example.projectPS.M.Model.User;
import com.example.projectPS.M.Services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.List;

@Controller
public class AdminController {
    @Inject
    MoviesServices movieS;
    @Inject
    TvShowServices tvS;
    @Inject
    UserServices userS;
    @Inject
    ActorsServices actorS;
    @Inject
    ModeratorServices modeS;
    @Inject
    SeasonServices seasonS;
    @Inject
    EpisodesServices epS;
    /*
/////////////MOVIE PART of controller
    @RequestMapping(value = "/MovieViewChange", method = RequestMethod.POST)
    public ModelAndView postMovvie(@ModelAttribute(value = "newMovie") Movies newMovie)
    {
        movieS.create(newMovie);
        return new ModelAndView("MovieViewChange");
    }

    @RequestMapping(value = "/MovieViewChange", method = RequestMethod.DELETE)
    public ModelAndView deleteMovie(@ModelAttribute(value = "newMovie") Movies newMovie)
    {
        ////find the movie woth the name and then delete
        movieS.delete(movieS.findByMovieName(newMovie.getMovieName()));
        return new ModelAndView("MovieViewChange");
    }
    */
    @RequestMapping(value = "/MovieViewChange", method = RequestMethod.POST)
    public ModelAndView modifyMovie(@RequestParam(value = "action") String action, @ModelAttribute(value = "newMovieViewChange") Movies newMovieViewChange)
    {
        if(action.equals("ADD"))
            movieS.create(newMovieViewChange);
        else if(action.equals("UPDATE"))
            movieS.update(movieS.findByMovieName(newMovieViewChange.getMovieName()), newMovieViewChange);
        else
            movieS.delete(movieS.findByMovieName(newMovieViewChange.getMovieName()));
        return new ModelAndView("redirect:MovieViewChange");
    }

    @RequestMapping(value =  "/MovieViewChange", method = RequestMethod.GET)
    public ModelAndView getMovies(@RequestParam(name = "", required = false) String firstName)
    {
        List<Movies> courseList = movieS.getAllMovies();

        ModelAndView mav = new ModelAndView("MovieViewChange");
        mav.addObject("MovieList", courseList);

        return mav;
    }

    //////////////////TvShowPart of controller
    /*
    @RequestMapping(value = "/TvShowViewChange", method = RequestMethod.POST)
    public ModelAndView postTvShow(@ModelAttribute(value = "newTvShow") TvShow newMovie)
    {
        tvS.create(newMovie);
        return new ModelAndView("TvShowViewChange");
    }

*/

    @RequestMapping(value = "/TvShowViewChange", method = RequestMethod.POST)
    public ModelAndView modifyShow(@RequestParam(value = "action") String action, @ModelAttribute(value = "newMovieViewChange") TvShow newMovieViewChange)
    {
        if(action.equals("ADD"))
            tvS.create(newMovieViewChange);
        else if(action.equals("UPDATE"))
            tvS.update(tvS.findByName(newMovieViewChange.getTvName()), newMovieViewChange);
        else
            tvS.delete(tvS.findByName(newMovieViewChange.getTvName()));
        return new ModelAndView("redirect:TvShowViewChange");
    }

    @RequestMapping(value =  "/TvShowViewChange", method = RequestMethod.GET)
    public ModelAndView getTvShow(@RequestParam(name = "", required = false) String firstName)
    {
        List<TvShow> courseList = tvS.getAllAdmins();

        ModelAndView mav = new ModelAndView("TvShowViewChange");
        mav.addObject("ShowList", courseList);

        return mav;
    }

    @RequestMapping(value =  "/AdminView")
    public ModelAndView getAdminView(@RequestParam(name = "", required = false) String firstName)
    {
        //  List<Movies> courseList = movieS.getAllMovies();

        ModelAndView mav = new ModelAndView("AdminView");
        //  mav.addObject("MovieList", courseList);
        return mav;
    }

    @RequestMapping(value =  "/AllUserView", method = RequestMethod.GET)
    public ModelAndView getAllUsers(@RequestParam(name = "", required = false) String firstName)
    {
        List<User> courseList =userS.getAllUser();

        ModelAndView mav = new ModelAndView("AllUserView");
        mav.addObject("UserList", courseList);

        return mav;
    }

    @RequestMapping(value =  "/ActorsViewChange", method = RequestMethod.GET)
    public ModelAndView getAllActors(@RequestParam(name = "", required = false) String firstName)
    {
        List<Actors> courseList =actorS.getAllAdmins();

        ModelAndView mav = new ModelAndView("ActorsViewChange");
        mav.addObject("ActorList", courseList);

        return mav;
    }
    @RequestMapping(value = "/ActorsViewChange", method = RequestMethod.POST)
    public ModelAndView modifyActor(@RequestParam(value = "action") String action, @ModelAttribute(value = "newMovieViewChange") Actors newMovieViewChange)
    {
        if(action.equals("ADD"))
            actorS.create(newMovieViewChange);
        else if(action.equals("UPDATE"))
            actorS.update(actorS.findActorsByActorName(newMovieViewChange.getActorName()), newMovieViewChange);
        else
            actorS.delete(actorS.findActorsByActorName(newMovieViewChange.getActorName()));
        return new ModelAndView("redirect:ActorsViewChange");
    }

    @RequestMapping(value = "/AllUserView", method = RequestMethod.POST)
    public ModelAndView modifyUser(@RequestParam(value = "action") String action, @ModelAttribute(value = "newMovieViewChange") User newMovieViewChange)
    {
        if(action.equals("ADD"))
            userS.create(newMovieViewChange);
        else if(action.equals("UPDATE"))
            userS.update(userS.findByUserName(newMovieViewChange.getUserName()), newMovieViewChange);
        else
            userS.delete(userS.findByUserName(newMovieViewChange.getUserName()));
        return new ModelAndView("redirect:AllUserView");
    }









}
