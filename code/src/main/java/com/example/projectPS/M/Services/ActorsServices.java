package com.example.projectPS.M.Services;

import com.example.projectPS.M.Model.Actors;
import com.example.projectPS.M.Model.Admin;
import com.example.projectPS.M.Repositories.ActorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorsServices {
    @Autowired
    ActorsRepository actorRepo;
    public List<Actors> getAllAdmins()
    {
        return actorRepo.findAll();
    }
    public Actors create(Actors cr)
    {
        return actorRepo.save(cr);
    }
    public void delete(Actors cr)
    {
        actorRepo.delete(cr);
    }
    public void update(Actors old, Actors st)
    {
        if(old==null)
        {
            System.out.println("eror at update");
        }
        else
        {
            actorRepo.delete(old);
            actorRepo.save(st);
        }
    }
    public Actors findActorsByIdActors(int id)
    {
        Actors act= actorRepo.findActorsByIdActors(id);
        if(act==null)
        {
            return null;
        }
        else
        {
            return act;
        }
    }
    public Actors findActorsByActorName(String id)
    {
        Actors act= actorRepo.findActorsByActorName(id);
        if(act==null)
        {
            return null;
        }
        else
        {
            return act;
        }
    }
}
