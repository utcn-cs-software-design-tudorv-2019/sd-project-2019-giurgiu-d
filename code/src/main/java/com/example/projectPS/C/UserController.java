package com.example.projectPS.C;

import com.example.projectPS.M.Model.Actors;
import com.example.projectPS.M.Model.Movies;
import com.example.projectPS.M.Model.User;
import com.example.projectPS.M.Services.ActorsServices;
import com.example.projectPS.M.Services.MoviesServices;
import com.example.projectPS.M.Services.UserServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
        @Inject
    UserServices userS;
        @Inject
    MoviesServices movieS;


    @RequestMapping(value =  "/user_has_movies", method = RequestMethod.GET)
    public ModelAndView getMovies(@RequestParam(name = "", required = false) String firstName)
    {
        List<Movies> courseList = movieS.getByUser(userS.getLoggedClient());

        ModelAndView mav = new ModelAndView("user_has_movies.html");
        mav.addObject("MovieList", courseList);

        return mav;
    }


    @RequestMapping(value = "/user_has_movies", method = RequestMethod.POST)
    public ModelAndView mbutonAct(@RequestParam(value = "action") String action)
    {
        if(action.equals("RECOMANDATION"))
        {
            User usr = userS.getLoggedClient();
            List<Movies> movieList= movieS.getByUser(usr);
            ArrayList<String>genres= new ArrayList<String>();/////tinem toate genurile de la filme aici
            for(Movies cv: movieList)
            {
                genres.add(cv.getMovieGenre());
            }
            List<List<Movies>> listaaa = null;
            for(String in: genres)
            {
                listaaa.add(movieS.findByGenre(in));
            }
            List<Movies>mr=new ArrayList<Movies>();
            for(List<Movies>ss: listaaa)
            {
                for(Movies cc : ss)
                {
                    mr.add(cc);///lista simpla pentru afisare
                }
            }
            ModelAndView mv= new ModelAndView("Recomandation");
            mv.addObject("MovieList",mr);
        }
        //else if(action.equals("SEARCH_GENRE"))
           // userS.update(userS.findByUserName(newMovieViewChange.getUserName()), newMovieViewChange);
        //else
         //   userS.delete(userS.findByUserName(newMovieViewChange.getUserName()));
        return new ModelAndView("redirect:user_has_movies");
    }




}
