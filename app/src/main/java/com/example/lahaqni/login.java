package com.example.lahaqni;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Intent intent = getIntent();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frag_container, new loginFragment())
                .commit();


    }

    public void afficherFragmentLogin(){
        Toast.makeText(getApplicationContext(), "veuillez_vous connecter",
                Toast.LENGTH_SHORT).show();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frag_container, new loginFragment())
                .commit();
    }

    public void afficherFragmentInscription(){
        Toast.makeText(getApplicationContext(), "veuillez_vous inscrire",
                Toast.LENGTH_SHORT).show();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frag_container, new InscriptionFragment())
                .commit();

    }
}