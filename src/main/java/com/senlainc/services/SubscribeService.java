package com.senlainc.services;

import com.senlainc.models.Subscribe;

import java.util.List;

public interface SubscribeService {
    List<Subscribe> findAll();

    Subscribe findById(Integer id);

    void saveOrUpdate(Subscribe subscribe);

    void delete(Subscribe subscribe);
}
