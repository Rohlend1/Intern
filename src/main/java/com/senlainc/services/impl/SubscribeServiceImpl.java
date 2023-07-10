package com.senlainc.services.impl;

import com.senlainc.models.Subscribe;
import com.senlainc.repositories.SubscribeRepository;
import com.senlainc.services.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscribeServiceImpl implements SubscribeService {

    private final SubscribeRepository subscribeRepository;

    @Autowired
    public SubscribeServiceImpl(SubscribeRepository subscribeRepository) {
        this.subscribeRepository = subscribeRepository;
    }

    public List<Subscribe> findAll(){
        return subscribeRepository.findAll();
    }

    public Subscribe findById(Integer id){
        return subscribeRepository.findById(id);
    }

    public void saveOrUpdate(Subscribe subscribe){
        subscribeRepository.saveOrUpdate(subscribe);
    }

    public void delete(Subscribe subscribe){
        subscribeRepository.delete(subscribe);
    }

}
