package com.begum.restdemo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "rezervasyonlar")
public class Rezervasyon {

    private int rezervasyonId;
    private String kullaniciAdSoyad;
    private Long kullaniciTel;
    private String arabaModel;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime alisTarihi;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime teslimTarihi;



        public Rezervasyon() {
        super();
    }

    public Rezervasyon(int rezervasyonId, String kullaniciAdSoyad, Long kullaniciTel, String arabaModel, LocalDateTime alisTarihi, LocalDateTime teslimTarihi) {
        this.rezervasyonId = rezervasyonId;
        this.kullaniciAdSoyad = kullaniciAdSoyad;
        this.kullaniciTel = kullaniciTel;
        this.arabaModel = arabaModel;
        this.alisTarihi = alisTarihi;
        this.teslimTarihi = teslimTarihi;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getRezervasyonId() {
        return rezervasyonId;
    }

    public void setRezervasyonId(int rezervasyonId) {
        this.rezervasyonId = rezervasyonId;
    }

    @Column(name = "KullaniciAdSoyad", nullable = false)
    public String getKullaniciAdSoyad() {
        return kullaniciAdSoyad;
    }

    public void setKullaniciAdSoyad(String kullaniciAdSoyad) {
        this.kullaniciAdSoyad = kullaniciAdSoyad;
    }

    @Column(name = "KullaniciTel", nullable = false)
    public Long getKullaniciTel() {
        return kullaniciTel;
    }

    public void setKullaniciTel(Long kullaniciTel) {
        this.kullaniciTel = kullaniciTel;
    }

    @Column(name = "arabaModel", nullable = false)
    public String getArabaModel() {
        return arabaModel;
    }

    public void setArabaModel(String arabaModel) {
        this.arabaModel = arabaModel;
    }

    @Column(name = "AlisTarihi", nullable = false)
    public LocalDateTime getAlisTarihi() {
        return alisTarihi;
    }

    public void setAlisTarihi(LocalDateTime alisTarihi) {
        this.alisTarihi = alisTarihi;
    }

    @Column(name = "TeslimTarihi", nullable = false)
    public LocalDateTime getTeslimTarihi() {
        return teslimTarihi;
    }

    public void setTeslimTarihi(LocalDateTime teslimTarihi) {
        this.teslimTarihi = teslimTarihi;
    }

    @Override
    public String toString() {
        return "Rezervasyon{" +
                "kullaniciAdSoyad='" + kullaniciAdSoyad + '\'' +
                ", kullaniciTel=" + kullaniciTel +
                ", arabaModel='" + arabaModel + '\'' +
                ", alisTarihi=" + alisTarihi +
                ", teslimTarihi=" + teslimTarihi +
                '}';
    }
}
