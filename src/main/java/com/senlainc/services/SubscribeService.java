package com.senlainc.services;

import com.senlainc.models.Subscribe;
import com.senlainc.models.SubscribeId;
import com.senlainc.repositories.SubscribeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscribeService {

    private final SubscribeRepository subscribeRepository;

    @Autowired
    public SubscribeService(SubscribeRepository subscribeRepository) {
        this.subscribeRepository = subscribeRepository;
    }

    public List<Subscribe> findAll(){
        return subscribeRepository.findAll();
    }

    public Subscribe findById(SubscribeId id){
        return subscribeRepository.findById(id);
    }

    public void save(Subscribe review){
        subscribeRepository.save(review);
    }

    public void delete(Subscribe review){
        subscribeRepository.delete(review);
    }

    public void update(SubscribeId id, Subscribe subscribe){
        subscribeRepository.delete(subscribeRepository.findById(id));
        subscribe.setId(id);
        subscribeRepository.save(subscribe);
    }
}
