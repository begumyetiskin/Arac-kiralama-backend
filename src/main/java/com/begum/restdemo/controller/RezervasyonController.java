package com.begum.restdemo.controller;

import com.begum.restdemo.exception.ResourceNotFoundException;
import com.begum.restdemo.model.Araba;
import com.begum.restdemo.model.Rezervasyon;
import com.begum.restdemo.repository.ArabalarRepository;
import com.begum.restdemo.repository.KullanicilarRepository;
import com.begum.restdemo.repository.RezervasyonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class RezervasyonController {

    @Autowired
    private RezervasyonRepository rezervasyonRepository;

    public RezervasyonController(RezervasyonRepository rezervasyonRepository) {
        this.rezervasyonRepository = rezervasyonRepository;
    }

    //get rezervasyonlar
    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/rezervasyonlar")
    public List<Rezervasyon> getAllRezervasyonlar() {
        return this.rezervasyonRepository.findAll();
    }

    //get rezervasyon by id
    @GetMapping("/rezervasyon/{id}")
    public ResponseEntity<Rezervasyon> getRezervasyonById(@PathVariable(value = "id") Integer rezervasyonId)
            throws ResourceNotFoundException {
        Rezervasyon rezervasyon = rezervasyonRepository.findById(rezervasyonId)
                .orElseThrow(() -> new ResourceNotFoundException(rezervasyonId + "id numarali rezervasyon bulunamadi"));
        return ResponseEntity.ok().body(rezervasyon);
    }

    //save rezervasyon
    @CrossOrigin(origins = "http://localhost:8081")
    @PostMapping("/rezervasyonlar")
    public Rezervasyon createRezervasyon(@RequestBody Rezervasyon rezervasyon) {
        return this.rezervasyonRepository.save(rezervasyon);
    }

    //delete rezervasyon
    @DeleteMapping("/rezervasyonlar/{id}")
    public Map<String, Boolean> deleteRezervasyon(@PathVariable(value = "id") Integer rezervasyonId)
            throws ResourceNotFoundException {
        Rezervasyon rezervasyon = rezervasyonRepository.findById(rezervasyonId)
                .orElseThrow(() -> new ResourceNotFoundException(rezervasyonId + "id numarali rezervasyon bulunamadi"));

        rezervasyonRepository.delete(rezervasyon);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
