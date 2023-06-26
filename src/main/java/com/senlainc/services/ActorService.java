package com.senlainc.services;

import com.senlainc.container.AutoConnect;
import com.senlainc.models.Actor;
import org.springframework.stereotype.Service;
import com.senlainc.repositories.ActorRepository;

import java.util.List;

@Service
public class ActorService {

    @AutoConnect
    private final ActorRepository actorRepository;

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
        actorRepository.save(actor);
    }

    public void delete(Actor actor){
        actorRepository.delete(actor);
    }

    public void update(int id, Actor actor){
        actorRepository.delete(actorRepository.findById(id));
        actor.setId(id);
        actorRepository.save(actor);
    }

    @Override
    public String toString() {
        return "ActorService{" +
                "actorRepository=" + actorRepository +
                '}';
    }
}
