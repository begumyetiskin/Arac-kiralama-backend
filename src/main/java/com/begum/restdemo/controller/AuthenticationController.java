package com.begum.restdemo.controller;

import com.begum.restdemo.exception.CustomException;
import com.begum.restdemo.exception.ResourceNotFoundException;
import com.begum.restdemo.model.Kullanici;
import com.begum.restdemo.repository.KullanicilarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class AuthenticationController {
    @Autowired
    private KullanicilarRepository kullanicilarRepository;


    //save kullanici
    @PostMapping("/kayit-ol")
    public Kullanici kayitOl(@RequestBody Kullanici kullanici) {
        kullanici.setRol(1);
        if (kullanici.getKullaniciNick() == null || kullanici.getKullaniciNick().isEmpty()) {
            throw new CustomException("Kullanıcı adı boş geçilemez");
        }
        if (kullanici.getKullaniciSifre() == null || kullanici.getKullaniciSifre().isEmpty()) {
            throw new CustomException("Şifre boş geçilemez.");
        }
        if (kullanici.getKullaniciAdSoyad() == null || kullanici.getKullaniciAdSoyad().isEmpty()) {
            throw new CustomException("Ad-soyad boş geçilemez");
        }
        if (kullanici.getKullaniciTel() == null) {
            throw new CustomException("Telefon numarası boş geçilemez");
        }
        String sifre = kullanici.getKullaniciSifre();
        String sifreTekrar = kullanici.getKullaniciSifreTekrar();
        if (!(sifre.equals(sifreTekrar))) {
            throw new CustomException("Şifreyi yanlış girdiniz!");
        }

        /*
        if (kullanici.getKullaniciAdSoyad().length() < 10) {
            throw new CustomException("Ad-soyad en az 10 karakter olmalıdır");
        }*/

        Kullanici byKullaniciNick = kullanicilarRepository.findByKullaniciNick(kullanici.getKullaniciNick());

        if (byKullaniciNick != null) {
            throw new CustomException("Bu kullanıcı kayıtlarımızda zaten mevcut. Lütfen farklı bir kullanıcı adı deneyiniz.");
        }

        System.out.println(kullanici);
        // kullanici.setKullaniciSifre(bCryptPasswordEncoder.encode(kullanici.getKullaniciSifre()));
        this.kullanicilarRepository.save(kullanici);
        return kullanici;
    }

    @PostMapping("/girisYap")
    public Kullanici girisYap(@RequestBody Kullanici kullanici) {
        Kullanici byKullaniciSifre = kullanicilarRepository.findByKullaniciSifre(kullanici.getKullaniciSifre());
        Kullanici byKullaniciNick = kullanicilarRepository.findByKullaniciNick(kullanici.getKullaniciNick());
        if(byKullaniciSifre == null){
            throw new CustomException("Kullanıcı adı ya da şifreyi yanlış girdiniz.");
        }
        if(byKullaniciNick == null){
            System.out.println(byKullaniciNick);
            throw new CustomException("Kullanıcı adı ya da şifreyi yanlış girdiniz.");
        }
        Kullanici result = kullanicilarRepository.findByKullaniciNick(kullanici.getKullaniciNick());
        result.setKullaniciSifre(null);
        result.setKullaniciSifreTekrar(null);
        System.out.println(kullanici);
        return result;
    }



}
