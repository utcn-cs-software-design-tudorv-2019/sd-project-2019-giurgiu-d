package com.example.projectPS.M.Services;


import com.example.projectPS.M.Model.Admin;
import com.example.projectPS.M.Model.TvShow;
import com.example.projectPS.M.Repositories.AdminRepository;
import com.example.projectPS.M.Repositories.TvShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TvShowServices {

    @Autowired
    TvShowRepository tvShowRepo;
    public List<TvShow> getAllAdmins()
    {
        return tvShowRepo.findAll();
    }
    public TvShow create(TvShow cr)
    {
        return tvShowRepo.save(cr);
    }
    public void delete(TvShow cr)
    {
        tvShowRepo.delete(cr);
    }
    public void update(TvShow old, TvShow st)
    {
        if(old==null)
        {
            System.out.println("eror at update");
        }
        else
        {
            tvShowRepo.delete(old);
            tvShowRepo.save(st);
        }
    }
    public TvShow findById(int id){return tvShowRepo.findTvShowByIdTvShow( id);}
    public TvShow findByName(String id){return tvShowRepo.findTvShowByTvName( id);}
    public TvShow findByGenre(String id){return tvShowRepo.findTvShowByTvGenre( id);}

}