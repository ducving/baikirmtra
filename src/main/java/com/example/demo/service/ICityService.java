package com.example.demo.service;

import com.example.demo.model.City;

import java.util.List;
import java.util.Optional;

public interface ICityService {
    List<City> findAll();
    void save(City city);
    Optional findById(int id);
    void update(int id,City city);
    void delete(int id);
}
