package com.example.demo.service;

import com.example.demo.model.City;
import com.example.demo.respository.CityRespository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

public class HibernateCityService implements ICityService {
    @Autowired
    CityRespository cityRespository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<City> findAll() {
        return cityRespository.findAll();
    }

    @Override
    public void save(City city) {
        cityRespository.save(city);
    }

    @Override
    public Optional<City> findById(int id) {
        return cityRespository.findById(id);
    }

    @Override
    public void update(int id, City city) {
        cityRespository.save(new City(id,city.getName(),city.getNation(),city.getAcreage(),city.getPopulation(),city.getGDP(),city.getDescribes()));
    }

    @Override
    public void delete(int id) {
        cityRespository.deleteById(id);
    }
}
