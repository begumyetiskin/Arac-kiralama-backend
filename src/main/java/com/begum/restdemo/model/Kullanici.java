package com.begum.restdemo.model;

import javax.persistence.*;

@Entity
@Table(name = "kullanicilar")
public class Kullanici {

    private int kullaniciId;
    private String kullaniciAdSoyad;
    private Long kullaniciTel;
    private String kullaniciNick;
    private String kullaniciSifre;
    private String kullaniciSifreTekrar;
    private int rol; //kullanici-> 1 - Admin -> 0

    public Kullanici() {
        super();
    }

    public Kullanici(int kullaniciId, String kullaniciAdSoyad, Long kullaniciTel, String kullaniciNick, String kullaniciSifre, int rol) {
        super();
        this.kullaniciId = kullaniciId;
        this.kullaniciAdSoyad = kullaniciAdSoyad;
        this.kullaniciTel = kullaniciTel;
        this.kullaniciNick = kullaniciNick;
        this.kullaniciSifre = kullaniciSifre;
        this.kullaniciSifreTekrar = kullaniciSifreTekrar;
        this.rol = rol;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(int kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    @Column(name = "KullaniciAdSoyad", nullable = false)
    public String getKullaniciAdSoyad(){
        return kullaniciAdSoyad;
    }

    public void setKullaniciAdSoyad(String kullaniciAdSoyad){
        this.kullaniciAdSoyad = kullaniciAdSoyad;
    }

    @Column(name = "KullaniciTel", nullable = false)
    public Long getKullaniciTel(){
        return kullaniciTel;
    }

    public void setKullaniciTel(Long kullaniciTel){
        this.kullaniciTel = kullaniciTel;
    }

    @Column(name = "kullaniciNick", nullable = false, unique = true)
    public String getKullaniciNick() {
        return kullaniciNick;
    }

    public void setKullaniciNick(String kullaniciNick) {
        this.kullaniciNick = kullaniciNick;
    }

    @Column(name = "KullaniciSifre", nullable = false)
    public String getKullaniciSifre() {
        return kullaniciSifre;
    }

    public void setKullaniciSifre(String kullaniciSifre) {
        this.kullaniciSifre = kullaniciSifre;
    }

    @Column(name = "KullaniciSifreTekrar", nullable = false)
    public String getKullaniciSifreTekrar() {
        return kullaniciSifreTekrar;
    }

    public void setKullaniciSifreTekrar(String kullaniciSifreTekrar) {
        this.kullaniciSifreTekrar = kullaniciSifreTekrar;
    }

    @Column(name = "Rol", nullable = false)
    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Kullanici{" +
                "kullaniciId=" + kullaniciId +
                ", kullaniciAdSoyad='" + kullaniciAdSoyad + '\'' +
                ", kullaniciTel=" + kullaniciTel +
                ", kullaniciNick='" + kullaniciNick + '\'' +
                ", kullaniciSifre='" + kullaniciSifre + '\'' +
                ", kullaniciSifreTekrar='" + kullaniciSifreTekrar + '\'' +
                ", rol=" + rol +
                '}';
    }
}
