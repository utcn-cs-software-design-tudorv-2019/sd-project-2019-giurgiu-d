package com.example.projectPS.C;

import com.example.projectPS.M.Model.User;
import com.example.projectPS.M.Services.AdminServices;
import com.example.projectPS.M.Services.ModeratorServices;
import com.example.projectPS.M.Services.UserServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;

@Controller
public class LoginController {
    @Inject
    private UserServices clientService;
    @Inject
    private AdminServices adminService;
    @Inject
    private ModeratorServices modService;

 /*   @RequestMapping(value="",method = RequestMethod.GET)
    public String getIndexForm(){
        return "index";
    }
    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String getLoginForm(){
        return "login";
    }

    @RequestMapping(value="/reg",method = RequestMethod.GET)
    public String getRegistationForm(){
        return "reg";
    }

  @RequestMapping(method=RequestMethod.POST)
    public String Login(@ModelAttribute(name="LoginForm") LoginForm loginForm, Model model) {
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();

        if (clientService.findByUsername(username) != null)
            if(clientService.findByUsername(username).getPassword().equals(password)) {
                clientService.setLoggedClient(clientService.findByUsername(username));
                return "client";
            }
        if (adminService.findByUsername(username) != null)
            if(adminService.findByUsername(username).getPassword().equals(password)) {
                return "admin";
            }
        return "login";
    }

    @RequestMapping(value="/reg",method =RequestMethod.POST)
    public String CreateAccount(@ModelAttribute(name="Client") Client client,Model model){
        if(clientService.findByUsername(client.getUsername())==null)
            clientService.addClient(client);
        else{
            model.addAttribute("username already exists",client.getUsername());
            return "reg";
        }
        return "login";
    }


    @RequestMapping(value =  "/login")
    public ModelAndView getMovies(@RequestParam(name = "", required = false) String firstName)
    {
        //  List<Movies> courseList = movieS.getAllMovies();

        ModelAndView mav = new ModelAndView("LoginView");
        //  mav.addObject("MovieList", courseList);
        return mav;
    }

 */

        @RequestMapping(value="/login",method = RequestMethod.GET)
        public String getLoginForm(){
            return "login";
        }

        @RequestMapping(value="/login",method=RequestMethod.POST)
        public String Login(@RequestParam String username,@RequestParam String password,Model model) {
            if (clientService.findByUserName(username) != null)
                if(clientService.findByUserName(username).getPassword().equals(password)) {
                    clientService.setLoggedClient(clientService.findByUserName(username));
                    return "UserView";
                }
            if (adminService.findByAdminName(username) != null)
                if(adminService.findByAdminName(username).getPassword().equals(password)) {
                    return "AdminView";
                }

            return "login";
        }


        @RequestMapping(value="/reg",method = RequestMethod.GET)
        public String getRegistationForm(){
            return "reg";
        }


        @RequestMapping(value="/reg",method =RequestMethod.POST)
        public String CreateAccount(User client, Model model){
            if(clientService.findByUserName(client.getUserName())==null)
                clientService.create(client);
            else{
                model.addAttribute("username already exists",client.getUserName());
                return "reg";
            }
            return "login";
        }
    }

