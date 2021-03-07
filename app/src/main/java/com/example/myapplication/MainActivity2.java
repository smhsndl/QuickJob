package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity2 extends AppCompatActivity {
    FloatingActionButton Fmain;
    Button Fis, Fisci, Isara, Isciara ;
    Float translationYaxis = 100f;
    Boolean menuOpen = false;

    OvershootInterpolator interpolator = new OvershootInterpolator();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Isara = findViewById(R.id.isara);
        Isciara = findViewById(R.id.isciara);

        Isara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, kategori.class);
                startActivity(intent);
            }
        });

        Isciara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, Isci_Kategori.class);
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
                Intent intent = new Intent(MainActivity2.this,Ilan.class);
                startActivity(intent);
            }
        });

        Fisci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this,Ilan.class);
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