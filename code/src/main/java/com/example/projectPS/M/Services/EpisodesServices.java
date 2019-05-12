package com.example.projectPS.M.Services;


import com.example.projectPS.M.Model.Admin;
import com.example.projectPS.M.Model.Episodes;
import com.example.projectPS.M.Repositories.AdminRepository;
import com.example.projectPS.M.Repositories.EpisodesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodesServices {

    @Autowired
    EpisodesRepository episodesRepo;
    public List<Episodes> getAllEpisodes()
    {
        return episodesRepo.findAll();
    }
    public Episodes create(Episodes cr)
    {
        return episodesRepo.save(cr);
    }
    public void delete(Episodes cr)
    {
        episodesRepo.delete(cr);
    }
    public void update(Episodes old, Episodes st)
    {
        if(old==null)
        {
            System.out.println("eror at update");
        }
        else
        {
            episodesRepo.delete(old);
            episodesRepo.save(st);
        }
    }

}