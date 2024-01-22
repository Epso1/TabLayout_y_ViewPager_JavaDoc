package com.example.tablayout_y_viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the ViewPager and set an adapter
        ViewPager2 viewPager = findViewById(R.id.pager);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager(), getLifecycle());
        viewPager.setAdapter(sectionsPagerAdapter);

        Toolbar toolbar1 = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar1);

        TabLayout tabs = findViewById(R.id.tabs);
        new TabLayoutMediator(tabs, viewPager, (tab, position) -> {
            tab.setText("TAB " + (position + 1));
        }).attach();

        // Set the initial item to be selected
        viewPager.setCurrentItem(0, false);


        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            Fragment fragment;


            // Cuando se selecciona una pestaña
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition(), false);
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