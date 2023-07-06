package com.senlainc.services.impl;

import com.senlainc.models.Actor;
import com.senlainc.repositories.ActorRepository;
import com.senlainc.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public List<Actor> findAll(){
        return actorRepository.findAll();
    }

    public Actor findById(int id){
        return actorRepository.findById(id);
    }

    public void saveOrUpdate(Actor actor){
        actorRepository.saveOrUpdate(actor);
    }

    public void delete(Actor actor){
        actorRepository.delete(actor);
    }
}
