package com.senlainc.repositories;

import com.senlainc.errors.ModelNotFoundException;
import com.senlainc.models.Subscribe;
import com.senlainc.models.SubscribeId;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SubscribeRepository {

    private final List<Subscribe> subscribes = new ArrayList<>();

    public List<Subscribe> findAll() {
        return subscribes;
    }

    public void save(Subscribe subscribe) {
        subscribes.add(subscribe);
    }

    public Subscribe findOne(Subscribe subscribe){
        return subscribes.stream().filter(a->a.equals(subscribe)).findAny().orElseThrow(ModelNotFoundException::new);
    }

    public Subscribe findById(SubscribeId id){
        return subscribes.stream().filter(a->a.getId().equals(id)).findAny().orElseThrow(ModelNotFoundException::new);
    }

    public void delete(Subscribe subscribe){
        subscribes.remove(subscribe);
    }
}
