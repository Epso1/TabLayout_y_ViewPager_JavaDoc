package com.example.tablayout_y_viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar1 = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar1);

        TabLayout tabLayout = findViewById(R.id.appbartabs);


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_fragment, new Fragment1())
                .commit();


        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            Fragment fragment;


            // Cuando se selecciona una pestaña
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // Se cambia el fragmento
                switch (tab.getPosition()) {
                    case 0:
                        fragment = new Fragment1();
                        break;
                    case 1:
                        fragment = new Fragment2();
                        break;
                    case 2:
                        fragment = new Fragment3();
                        break;
                }
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.content_fragment, fragment)
                        .commit();

                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(tab.getText());
                }

            }

            // Cuando se deselecciona una pestaña
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            // Cuando se vuelve a seleccionar una pestaña ya seleccionada
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });


    }
}