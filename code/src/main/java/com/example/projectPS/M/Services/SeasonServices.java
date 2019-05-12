package com.example.projectPS.M.Services;

import com.example.projectPS.M.Model.Admin;
import com.example.projectPS.M.Model.Season;
import com.example.projectPS.M.Repositories.AdminRepository;
import com.example.projectPS.M.Repositories.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeasonServices {

    @Autowired
    SeasonRepository seasonRepo;
    public List<Season> getAllSeason()
    {
        return seasonRepo.findAll();
    }
    public Season create(Season cr)
    {
        return seasonRepo.save(cr);
    }
    public void delete(Season cr)
    {
        seasonRepo.delete(cr);
    }
    public void update(Season old, Season st)
    {
        if(old==null)
        {
            System.out.println("eror at update");
        }
        else
        {
            seasonRepo.delete(old);
            seasonRepo.save(st);
        }
    }
    public Season findByid(int id){return seasonRepo.findSeasonByIdSeason(id);}

}