package com.example.myapplication;

public class User {
    private String sifre;
    private String adsoyad;
    private String email;
    private String telefon;

    public User(String adsoyad, String sifre , String email, String telefon) {
        this.adsoyad = adsoyad;
        this.email = email;
        this.sifre = sifre;
        this.telefon = telefon;
    }

    public User(){

    }


    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getAdsoyad() {
        return adsoyad;
    }

    public void setAdsoyad(String adsoyad) {
        this.adsoyad = adsoyad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}
