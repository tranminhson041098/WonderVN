package com.example.koreanapp;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    NavigationView nav;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();

    }

    private void init() {
        final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle actionBarDrawerToggle
                = new ActionBarDrawerToggle(this,drawer,toolbar,0,0);

        drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        CategoryFragment categoryFragment = new CategoryFragment();
        FragmentTransaction fragmentTransaction
                = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, categoryFragment);
        fragmentTransaction.commit();

        nav = findViewById(R.id.nav);
        nav.setCheckedItem(R.id.nav_contact);
        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_cat: {
                        CategoryFragment categoryFragment = new CategoryFragment();
                        FragmentTransaction fragmentTransaction
                                = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.container, categoryFragment);
                        fragmentTransaction.commit();

                        break;
                    }
                    case R.id.nav_place: {
                        PlaceFragment placeFragment = new PlaceFragment();
                        FragmentTransaction fragmentTransaction
                                = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.container, placeFragment);
                        fragmentTransaction.commit();

                        break;
                    }
                    case R.id.nav_contact: {
                        ContactFragment contactFragment = new ContactFragment();
                        FragmentTransaction fragmentTransaction1Contact = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction1Contact.replace(R.id.container, contactFragment);
                        fragmentTransaction1Contact.commit();
                        break;
                    }
                    case R.id.nav_promotion: {

                        PromotionFragment promotionFragment = new PromotionFragment();
                        FragmentTransaction fragmentTransaction1Promotion = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction1Promotion.replace(R.id.container, promotionFragment);
                        fragmentTransaction1Promotion.commit();
                        break;
                    }
                }


                drawer.closeDrawer(GravityCompat.START);

                return true;
            }
        });
    }
}
