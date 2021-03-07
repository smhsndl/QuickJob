package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class kaydol extends AppCompatActivity {
    EditText edt6, edt7, edt8, edt9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kaydol);

        Button kullanicikayit = findViewById(R.id.kullanicikayit);
        EditText isimSoyisim = findViewById(R.id.Isim_soyisim);
        EditText email = findViewById(R.id.email);
        EditText sifre = findViewById(R.id.sifre);
        EditText telefon = findViewById(R.id.telefon);

        kullanicikayit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("users");
                dbRef.push().setValue(
                        new User(
                                edt6.getText().toString(),
                                edt7.getText().toString(),
                                edt8.getText().toString(),
                                edt9.getText().toString()
                        )
                );

                String isim_soyisim = edt6.getText().toString();
                String e_mail = edt7.getText().toString();
                String password = edt8.getText().toString();
                String telefon = edt9.getText().toString();

                if (v.getId() == kullanicikayit.getId()) {
                    if (isim_soyisim.length() == 0) {
                        edt6.requestFocus();
                        edt6.setError("İsim-Soyisim alani bos bırakilamaz.");
                    } else if (e_mail.length() == 0) {
                        edt7.requestFocus();
                        edt7.setError("E-mail alani bos bırakilamaz.");
                    } else if (password.length() == 0) {
                        edt8.requestFocus();
                        edt8.setError("Password alani bos bırakilamaz.");
                    } else if (telefon.length() == 0) {
                        edt9.requestFocus();
                        edt9.setError("Telefon alani bos bırakilamaz.");
                    } else {
                        Intent intent = new Intent(kaydol.this, MainActivity2.class);
                        startActivity(intent);
                    }

                }
            }
        });
    }
}