package com.example.lahaqni;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class Homechauffeur extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;

    FirebaseAuth mauth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homechauffeur);
        Intent intent = getIntent();
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.chomech);
        navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this, drawerLayout, toolbar,
               R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState==null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragchauffeur, new ProfilFragment()).commit();
            navigationView.setCheckedItem(R.id.action_profil);

        }
        mauth = FirebaseAuth.getInstance();
    }


    public void onBackPressed() {
       if (drawerLayout.isDrawerOpen(GravityCompat.START)){
           drawerLayout.closeDrawer(GravityCompat.START);
        }else {
       super.onBackPressed();
    }


    }

    @Override

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_cagnote:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragchauffeur,new cagnoteFragment()).commit();
                Toast.makeText(getApplicationContext(), "Money !!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_profil:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragchauffeur,new ProfilFragment()).commit();
                Toast.makeText(getApplicationContext(), "Info Profil", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_notification:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragchauffeur,new NotificationFragment()).commit();
                Toast.makeText(getApplicationContext(), "Info notif", Toast.LENGTH_SHORT).show();

        }
        return true;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
