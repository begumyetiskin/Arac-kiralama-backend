package com.begum.restdemo.repository;

import com.begum.restdemo.model.Araba;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArabalarRepository extends JpaRepository <Araba, Integer> {
    Araba findByKullanimDurumu(String kullanimDurumu);


}
