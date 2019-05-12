package com.example.projectPS.M.Services;


import com.example.projectPS.M.Model.Admin;
import com.example.projectPS.M.Model.Movies;
import com.example.projectPS.M.Repositories.AdminRepository;
import com.example.projectPS.M.Repositories.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesServices {

    @Autowired
    MoviesRepository moviesRepo;
    public List<Movies> getAllMovies()
    {
        return moviesRepo.findAll();
    }
    public Movies create(Movies cr)
    {
        return moviesRepo.save(cr);
    }
    public void delete(Movies cr)
    {
        moviesRepo.delete(cr);
    }
    public void update(Movies old, Movies st)
    {
        if(old==null)
        {
            System.out.println("eror at update");
        }
        else
        {
            moviesRepo.delete(old);
            moviesRepo.save(st);
        }
    }
    public Movies findById(int id)
    {
        return moviesRepo.findMoviesByIdMovie(id);
    }

}