package com.example.projectPS.M.Repositories;

import com.example.projectPS.M.Model.Season;
import com.example.projectPS.M.Model.TvShow;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.projectPS.M.Model.Movies;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {

    public Season findSeasonByIdSeason(int id);
}