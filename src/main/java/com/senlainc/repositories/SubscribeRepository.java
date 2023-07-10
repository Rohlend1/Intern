package com.senlainc.repositories;

import com.senlainc.models.Subscribe;

import java.util.List;

public interface SubscribeRepository {

    List<Subscribe> findAll();

    void saveOrUpdate(Subscribe subscribe);

    Subscribe findById(Integer id);

    void delete(Subscribe subscribe);

}
