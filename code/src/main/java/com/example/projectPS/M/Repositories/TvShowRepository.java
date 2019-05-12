package com.example.projectPS.M.Repositories;

import com.example.projectPS.M.Model.TvShow;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.projectPS.M.Model.Movies;
import org.springframework.stereotype.Repository;

@Repository
public interface TvShowRepository extends JpaRepository<TvShow, Long> {

    public TvShow findTvShowByIdTvShow(int id);
    public TvShow findTvShowByTvName(String id);
    public TvShow findTvShowByTvGenre(String genre);
}