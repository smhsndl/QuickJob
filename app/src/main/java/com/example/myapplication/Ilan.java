package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Ilan extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ilan);

        Button kaydet = findViewById(R.id.ilankaydet);
        EditText edt1  = findViewById(R.id.baslik);
        EditText edt2  = findViewById(R.id.fiyat);
        Spinner Kategori = findViewById(R.id.spinner);
        EditText edt3  = findViewById(R.id.aciklama);

        kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("raws");
                dbRef.push().setValue(
                        new raw(
                                edt1.getText().toString(),
                                edt2.getText().toString(),
                                edt3.getText().toString()
                        )
                );

                String baslik = edt1.getText().toString();
                String fiyat = edt2.getText().toString();
                String aciklama = edt3.getText().toString();

                if (v.getId() == kaydet.getId()) {
                    if (baslik.length() == 0) {
                        edt1.requestFocus();
                        edt1.setError("Baslik alani bos bırakilamaz.");
                    } else if (fiyat.length() == 0) {
                        edt2.requestFocus();
                        edt2.setError("Fiyat alani bos bırakilamaz.");
                    } else if (aciklama.length() == 0) {
                        edt3.requestFocus();
                        edt3.setError("Aciklama alani bos bırakilamaz.");
                    }
                    else {
                        Intent intent = new Intent(Ilan.this, basarili.class);
                        startActivity(intent);
                    }

                }
            }
        });
    }
}