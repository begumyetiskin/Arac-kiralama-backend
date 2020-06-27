package com.begum.restdemo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.begum.restdemo.exception.ResourceNotFoundException;
import com.begum.restdemo.model.Araba;
import com.begum.restdemo.model.Kullanici;
import com.begum.restdemo.repository.ArabalarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ArabaController {
    @Autowired
    private ArabalarRepository arabalarRepository;

    public ArabaController(ArabalarRepository arabalarRepository) {
        this.arabalarRepository = arabalarRepository;
    }

    //get arabalar
    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/arabalar")
    public List<Araba> getAllArabalar() {
        return this.arabalarRepository.findAll();
    }


    //get araba kullanımDurumu bosta olanlar
    @GetMapping("/arabalar/bosta")
    public Araba bosAraba(@RequestBody Araba araba) {
        Araba byKullanimDurumu = arabalarRepository.findByKullanimDurumu(araba.getKullanimDurumu());
        System.out.println(byKullanimDurumu + "bunu oku");
        if(byKullanimDurumu.toString().equals("bosta")){
            return byKullanimDurumu;
        }
        else{
            return null;
        }
    }

    //get araba by id
    @GetMapping("/arabalar/{id}")
    public ResponseEntity<Araba> getArabaById(@PathVariable(value = "id") Integer arabaId)
            throws ResourceNotFoundException {
        Araba araba = arabalarRepository.findById(arabaId)
                .orElseThrow(() -> new ResourceNotFoundException(arabaId + "id numarali araba bulunamadi"));
        return ResponseEntity.ok().body(araba);
    }

    //save araba
    @PostMapping("/arabalar")
    public Araba createAraba(@RequestBody Araba araba) {
        return this.arabalarRepository.save(araba);
    }

    //update araba
    @PutMapping("/arabalar/{id}")
    public ResponseEntity<Araba> updateAraba(@PathVariable(value = "id") Integer arabaId,
                                             @RequestBody Araba arabaDetails) throws ResourceNotFoundException {
        Araba araba = arabalarRepository.findById(arabaId)
                .orElseThrow(() -> new ResourceNotFoundException(arabaId + "id numarali araba bulunamadi"));

        araba.setArabaModel(arabaDetails.getArabaModel());
        araba.setArabaRenk(arabaDetails.getArabaRenk());
        araba.setArabaYili(arabaDetails.getArabaYili());
        araba.setArabaKm(arabaDetails.getArabaKm());
        araba.setKullanimDurumu(arabaDetails.getKullanimDurumu());
        final Araba updatedAraba = arabalarRepository.save(araba);
        return ResponseEntity.ok(updatedAraba);
    }

    //delete araba
    @DeleteMapping("/arabalar/{id}")
    public Map<String, Boolean> deleteAraba(@PathVariable(value = "id") Integer arabaId)
            throws ResourceNotFoundException {
        Araba araba = arabalarRepository.findById(arabaId)
                .orElseThrow(() -> new ResourceNotFoundException(arabaId + "id numarali araba bulunamadi"));

        arabalarRepository.delete(araba);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}