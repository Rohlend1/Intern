package com.senlainc.services;

import com.senlainc.models.Actor;
import com.senlainc.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    private final ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public List<Actor> findAll(){
        return actorRepository.findAll();
    }

    public Actor findById(int id){
        return actorRepository.findById(id);
    }

    public void save(Actor actor){
        if(actor.getId() != null){
            update(actor.getId(),actor);
        }
        else {
            actorRepository.save(actor);
        }
    }

    public void delete(Actor actor){
        actorRepository.delete(actor);
    }

    public void update(int id, Actor actor){
        actor.setId(id);
        actorRepository.update(actor);
    }
}
