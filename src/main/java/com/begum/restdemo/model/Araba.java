package com.begum.restdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "arabalar")
public class Araba {

    private int id;
    private String arabaModel;
    private String arabaRenk;
    private int arabaYili;
    private Long arabaKm;
    private String kullanimDurumu;

    public Araba() {
        super();
    }

    public Araba(int id, String arabaModel, String arabaRenk, int arabaYili, Long arabaKm, String kullanimDurumu) {
        super();
        this.id = id;
        this.arabaModel = arabaModel;
        this.arabaRenk = arabaRenk;
        this.arabaYili = arabaYili;
        this.arabaKm = arabaKm;
        this.kullanimDurumu  = kullanimDurumu;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "arabaModel", nullable = false)
    public String getArabaModel() {
        return arabaModel;
    }

    public void setArabaModel(String arabaModel) {
        this.arabaModel = arabaModel;
    }

    @Column(name = "arabaRenk", nullable = false)
    public String getArabaRenk() {
        return arabaRenk;
    }

    public void setArabaRenk(String arabaRenk) {
        this.arabaRenk = arabaRenk;
    }

    @Column(name = "arabaYili", nullable = false)
    public int getArabaYili() {
        return arabaYili;
    }

    public void setArabaYili(int arabaYili) {
        this.arabaYili = arabaYili;
    }

    @Column(name = "arabaKm", nullable = false)
    public Long getArabaKm() {
        return arabaKm;
    }

    public void setArabaKm(Long arabaKm) {
        this.arabaKm = arabaKm;
    }

    @Column(name = "kullanimDurumu", nullable = false)
    public String getKullanimDurumu() {
        return kullanimDurumu;
    }

    public void setKullanimDurumu(String kullanimDurumu) {
        this.kullanimDurumu = kullanimDurumu;
    }

    @Override
    public String toString() {
        return "Arabalar [id=" + id + ", Araba Model=" + arabaModel
                + "Araba Renk" + arabaRenk + "Araba Yılı" + arabaYili
                + "Araba Km" + arabaKm + "Kullanim Durumu" + kullanimDurumu + "]";
    }

}