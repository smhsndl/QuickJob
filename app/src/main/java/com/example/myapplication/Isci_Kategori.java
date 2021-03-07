package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Isci_Kategori extends AppCompatActivity {

    FloatingActionButton Fmain;
    Button Fis, Fisci ;
    ImageButton Btn_hizmet, Btn_insaat, Btn_tamir, Btn_tarim, Btn_tasarim, Btn_yemek, Btn_diger;
    Float translationYaxis = 100f;
    Boolean menuOpen = false;

    OvershootInterpolator interpolator = new OvershootInterpolator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isci__kategori);

        Btn_hizmet = findViewById(R.id.btn_hizmet);
        Btn_insaat = findViewById(R.id.btn_insaat);
        Btn_tamir = findViewById(R.id.btn_tamir);
        Btn_tarim = findViewById(R.id.btn_tarim);
        Btn_tasarim = findViewById(R.id.btn_tasarim);
        Btn_yemek = findViewById(R.id.btn_yemek);
        Btn_diger = findViewById(R.id.btn_diger);

        Btn_hizmet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Isci_Kategori.this,Isci_hizmet.class);
                startActivity(intent);
            }
        });

        Btn_insaat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Isci_Kategori.this,Isci_insaat.class);
                startActivity(intent);
            }
        });

        Btn_tamir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Isci_Kategori.this,Isci_tamir.class);
                startActivity(intent);
            }
        });

        Btn_tarim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Isci_Kategori.this,Isci_tarim.class);
                startActivity(intent);
            }
        });

        Btn_tasarim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Isci_Kategori.this,Isci_tasarim.class);
                startActivity(intent);
            }
        });

        Btn_yemek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Isci_Kategori.this,Isci_yemek.class);
                startActivity(intent);
            }
        });

        Btn_diger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Isci_Kategori.this,Isci_diger.class);
                startActivity(intent);
            }
        });

        ShowMenu();
    }

    private void ShowMenu() {
        Fmain = findViewById(R.id.floatingActionButton2);
        Fis = findViewById(R.id.fis);
        Fisci = findViewById(R.id.fisci);

        Fis.setAlpha(0f);
        Fisci.setAlpha(0f);

        Fis.setTranslationY(translationYaxis);
        Fisci.setTranslationY(translationYaxis);

        Fmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(menuOpen){
                    Closemenu();
                }
                else{
                    OpenMenu();
                }
            }
        });

        Fis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Isci_Kategori.this,Ilan.class);
                startActivity(intent);
            }
        });

        Fisci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Isci_Kategori.this,Ilan.class);
                startActivity(intent);
            }
        });



    }

    private void OpenMenu() {
        menuOpen = ! menuOpen;
        Fmain.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24);
        Fis.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        Fisci.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
    }

    private void Closemenu() {
        menuOpen = ! menuOpen;
        Fmain.setImageResource(R.drawable.ic_baseline_add_24);
        Fis.animate().translationY(translationYaxis).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        Fisci.animate().translationY(translationYaxis).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
    }
}