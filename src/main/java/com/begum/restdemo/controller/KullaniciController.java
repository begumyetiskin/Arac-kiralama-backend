package com.begum.restdemo.controller;

import com.begum.restdemo.exception.ResourceNotFoundException;
import com.begum.restdemo.model.Kullanici;
import com.begum.restdemo.repository.KullanicilarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class KullaniciController {
    @Autowired
    private KullanicilarRepository kullanicilarRepository;


    public KullaniciController(KullanicilarRepository kullanicilarRepository) {
        this.kullanicilarRepository = kullanicilarRepository;
    }

    //get kullanicilar
    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/kullanicilar")
    public List<Kullanici> getAllKullanicilar() {
        return this.kullanicilarRepository.findAll();
    }

    //get kullanici by id
    @GetMapping("/kullanicilar/{id}")
    public ResponseEntity<Kullanici> getKullaniciById(@PathVariable(value = "id") Integer kullaniciId)
            throws ResourceNotFoundException {
        Kullanici kullanici = kullanicilarRepository.findById(kullaniciId)
                .orElseThrow(() -> new ResourceNotFoundException(kullaniciId + "id numarali kullanici bulunamadi"));
        return ResponseEntity.ok().body(kullanici);
    }


    //update kullanici
    @PutMapping("/kullanicilar/{id}")
    public ResponseEntity<Kullanici> updateKullanici(@PathVariable(value = "id") Integer kullaniciId,
                                             @RequestBody Kullanici kullaniciDetails) throws ResourceNotFoundException {
        Kullanici kullanici = kullanicilarRepository.findById(kullaniciId)
                .orElseThrow(() -> new ResourceNotFoundException(kullaniciId + "id numarali kullanici bulunamadi"));

        kullanici.setKullaniciAdSoyad(kullaniciDetails.getKullaniciAdSoyad());
        kullanici.setKullaniciTel(kullaniciDetails.getKullaniciTel());
        kullanici.setKullaniciNick(kullaniciDetails.getKullaniciNick());
        kullanici.setKullaniciSifre(kullaniciDetails.getKullaniciSifre());
        kullanici.setKullaniciSifreTekrar(kullaniciDetails.getKullaniciSifreTekrar());
        kullanici.setRol(kullaniciDetails.getRol());

        final Kullanici updatedKullanici = kullanicilarRepository.save(kullanici);
        return ResponseEntity.ok(updatedKullanici);
    }

    //delete kullanici
    @DeleteMapping("/kullanicilar/{id}")
    public Map<String, Boolean> deleteKullanici(@PathVariable(value = "id") Integer kullaniciId)
            throws ResourceNotFoundException {
        Kullanici kullanici = kullanicilarRepository.findById(kullaniciId)
                .orElseThrow(() -> new ResourceNotFoundException(kullaniciId + "id numarali kullanici bulunamadi"));

        kullanicilarRepository.delete(kullanici);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
