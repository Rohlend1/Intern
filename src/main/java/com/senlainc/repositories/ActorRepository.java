package com.senlainc.repositories;

import com.senlainc.models.Actor;

import java.util.List;

public interface ActorRepository {

    List<Actor> findAll();

    void saveOrUpdate(Actor actor);

    Actor findById(int id);

    void delete(Actor actor);
}
