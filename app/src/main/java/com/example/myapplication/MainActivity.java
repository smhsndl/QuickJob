package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ShowableListMenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText edt4  = findViewById(R.id.emaill);
        EditText edt5  = findViewById(R.id.sifree);
        Button Kayitol = findViewById(R.id.kayitol);
        Kayitol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,kaydol.class);
                startActivity(intent);
            }
        });


        Button giris = findViewById(R.id.giris);

        firebaseAuth = FirebaseAuth.getInstance();

        giris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                firebaseAuth.signInWithEmailAndPassword(edt4.getText().toString(),edt5.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        String e_mail = edt4.getText().toString();
                        String password = edt5.getText().toString();

                        if(task.isSuccessful()){
                            Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                            startActivity(intent);
                        }
                        else{
                            edt5.requestFocus();
                            edt5.setError("Yanlis Girdiniz.");
                        }

                    }
                });

                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });

    }
}