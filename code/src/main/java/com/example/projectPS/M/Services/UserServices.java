package com.example.projectPS.M.Services;


import com.example.projectPS.M.Model.Admin;
import com.example.projectPS.M.Model.User;
import com.example.projectPS.M.Repositories.AdminRepository;
import com.example.projectPS.M.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    UserRepository userRepo;
    User loggedClient;
    public void setLoggedClient(User client){
        loggedClient=client;
    }
    public User getLoggedClient() {
        return loggedClient;
    }
    public List<User> getAllUser()
    {
        return userRepo.findAll();
    }
    public User create(User cr)
    {
        return userRepo.save(cr);
    }
    public void delete(User cr)
    {
        userRepo.delete(cr);
    }
    public void update(User old, User st)
    {
        if(old==null)
        {
            System.out.println("eror at update");
        }
        else
        {
            userRepo.delete(old);
            userRepo.save(st);
        }
    }
    public User findByUserName(String name){return userRepo.findByUserName(name);}
    public User findByPassword(String name){return userRepo.findByPassword(name);}


}
