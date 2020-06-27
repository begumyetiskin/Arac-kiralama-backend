package com.begum.restdemo.repository;

import com.begum.restdemo.model.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface KullanicilarRepository extends JpaRepository<Kullanici, Integer> {

    Kullanici findByKullaniciNick(final String kullaniciNick);
    Kullanici findByKullaniciSifre(String kullaniciSifre);
}
