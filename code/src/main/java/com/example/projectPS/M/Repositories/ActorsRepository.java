package com.example.projectPS.M.Repositories;
import com.example.projectPS.M.Model.Actors;
import com.example.projectPS.M.Model.Episodes;
import com.example.projectPS.M.Model.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ActorsRepository extends JpaRepository<Actors, Long> {

    public Actors findActorsByIdActors(int courseId);
    public Actors findActorsByActorName(String name);
    public Set<Actors> findActorsByMovies(Movies mov);
}