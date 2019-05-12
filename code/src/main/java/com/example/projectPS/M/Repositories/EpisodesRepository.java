package com.example.projectPS.M.Repositories;
import com.example.projectPS.M.Model.Episodes;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface EpisodesRepository extends JpaRepository<Episodes, Long> {

}