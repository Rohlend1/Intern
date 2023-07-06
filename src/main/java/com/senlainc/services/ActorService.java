package com.senlainc.services;

import com.senlainc.models.Actor;

import java.util.List;

public interface ActorService {

    List<Actor> findAll();

    Actor findById(int id);

    void saveOrUpdate(Actor actor);

    void delete(Actor actor);
}
