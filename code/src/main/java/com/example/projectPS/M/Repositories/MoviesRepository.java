package com.example.projectPS.M.Repositories;

import com.example.projectPS.M.Model.Movies;
import com.example.projectPS.M.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, Long> {

    public ArrayList<Movies> findMoviesByMovieName(String name);
    public Movies findMoviesByIdMovie(int id);
    public Movies findByMovieName(String name);
    public ArrayList<Movies>findByUsers(User usr);
    public ArrayList<Movies>findByMovieGenre(String genre);
}