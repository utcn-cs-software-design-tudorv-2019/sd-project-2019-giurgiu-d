package com.example.projectPS.M.Services;


import com.example.projectPS.M.Model.Moderator;
import com.example.projectPS.M.Repositories.ModeratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeratorServices {

    @Autowired
    ModeratorRepository moderatorRepo;

    public List<Moderator> getAllModerator()
    {
        return moderatorRepo.findAll();
    }
    public Moderator create(Moderator cr)
    {
        return moderatorRepo.save(cr);
    }
    public void delete(Moderator cr)
    {
        moderatorRepo.delete(cr);
    }
    public void update(Moderator old, Moderator st)
    {
        if(old==null)
        {
            System.out.println("eror at update");
        }
        else
        {
            moderatorRepo.delete(old);
            moderatorRepo.save(st);
        }
    }

}