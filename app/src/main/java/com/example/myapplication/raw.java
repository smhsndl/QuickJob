package com.example.myapplication;

public class raw {
    private String Baslik;
    private String Fiyat;
    private String Aciklama;

    public raw(String baslik, String fiyat, String aciklama) {
        Baslik = baslik;
        Fiyat = fiyat;
        Aciklama = aciklama;
    }

    public String getBaslik() {
        return Baslik;
    }

    public void setBaslik(String baslik) {
        Baslik = baslik;
    }

    public String getFiyat() {
        return Fiyat;
    }

    public void setFiyat(String fiyat) {
        Fiyat = fiyat;
    }

    public String getAciklama() {
        return Aciklama;
    }

    public void setAciklama(String aciklama) {
        Aciklama = aciklama;
    }
}
