package com.senlainc.services;

import com.senlainc.dto.subscribes.SubscribeDTO;
import com.senlainc.models.Subscribe;

import java.util.List;

public interface SubscribeService {
    List<SubscribeDTO> findAll();

    SubscribeDTO findById(Integer id);

    void saveOrUpdate(SubscribeDTO subscribe);

    void delete(SubscribeDTO subscribe);

    void delete(int id);
}
