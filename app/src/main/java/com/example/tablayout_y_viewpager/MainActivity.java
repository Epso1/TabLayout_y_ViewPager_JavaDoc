package com.example.tablayout_y_viewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

/**
 * Clase que define la actividad principal de la aplicacion
 * @author Cesar Alvaro
 * @version 1.0
 * @see AppCompatActivity
 * @see SectionsPagerAdapter
 * @see ViewPager2
 * @see TabLayout
 * @see TabLayoutMediator
 * @see AccordionTransformer
 * @see Toolbar
 * @see Fragment
 * @see Bundle
 */
public class MainActivity extends AppCompatActivity {
    /**
     * Metodo que se llama cuando se crea la actividad
     * @param savedInstanceState Objeto Bundle que contiene el estado previamente guardado de la actividad
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializa el ViewPager2 y su adaptador
        ViewPager2 viewPager = findViewById(R.id.pager);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager(), getLifecycle());
        viewPager.setAdapter(sectionsPagerAdapter);
        viewPager.setPageTransformer(new AccordionTransformer());

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


            /**
             * Metodo que se llama cuando se selecciona una pestaña
             * @param tab La pestaña seleccionada
             */
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition(), false);
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(tab.getText());
                }
            }

            /**
             * Metodo que se llama cuando se deselecciona una pestaña
             * @param tab La pestaña deseleccionada
             */
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            /**
             * Metodo que se llama cuando se vuelve a seleccionar una pestaña
             * @param tab La pestaña reseleccionada
             */
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });


    }
}