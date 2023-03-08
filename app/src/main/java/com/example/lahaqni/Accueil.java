package com.example.lahaqni;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Accueil extends AppCompatActivity {

    Button chauffeur, client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        chauffeur = findViewById(R.id.chauffeur);
        client = findViewById(R.id.client);

        chauffeur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ch = new Intent(getApplicationContext(), login.class);
                startActivity(ch);
            }
        });
       client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cl = new Intent(getApplicationContext(), login.class);
                startActivity(cl);
            }
        });


    }
}