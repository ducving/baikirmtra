package com.example.demo.respository;

import com.example.demo.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRespository extends JpaRepository<City,Integer> {
}
