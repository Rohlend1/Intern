package com.senlainc.services.impl;

import com.senlainc.dto.subscribes.SubscribeDTO;
import com.senlainc.models.Subscribe;
import com.senlainc.repositories.SubscribeRepository;
import com.senlainc.services.SubscribeService;
import com.senlainc.util.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscribeServiceImpl implements SubscribeService {

    private final SubscribeRepository subscribeRepository;

    private final Converter converter;

    @Autowired
    public SubscribeServiceImpl(SubscribeRepository subscribeRepository, Converter converter) {
        this.subscribeRepository = subscribeRepository;
        this.converter = converter;
    }

    public List<SubscribeDTO> findAll(){
        return converter.convertListToSubscribeDTO(subscribeRepository.findAll());
    }

    public SubscribeDTO findById(Integer id){
        return converter.convertToSubscribeDTO(subscribeRepository.findById(id));
    }

    public void saveOrUpdate(SubscribeDTO subscribeDTO){
        subscribeRepository.saveOrUpdate(converter.convertToSubscribe(subscribeDTO));
    }

    public void delete(SubscribeDTO subscribeDTO){
        subscribeRepository.delete(converter.convertToSubscribe(subscribeDTO));
    }

    public void delete(int id) {
        subscribeRepository.delete(id);
    }
}
