package com.example.tablayout_y_viewpager;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

/**
 * Clase que define el adaptador para el ViewPager2
 * @author Cesar Alvaro
 * @version 1.0
 * @see FragmentStateAdapter
 * @see Context
 * @see FragmentManager
 * @see Lifecycle
 * @see PlaceholderFragment
 * @see Fragment
 * @see SectionsPagerAdapter
 */
public class SectionsPagerAdapter extends FragmentStateAdapter {

    private Context context = null;

    /**
     * Constructor de la clase
     * @param context Contexto de la aplicación
     * @param fragmentManager Gestor de fragmentos
     * @param lifecycle Ciclo de vida
     */
    public SectionsPagerAdapter(Context context, FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        this.context = context;
    }

    /**
     * Metodo que crea un fragmento
     * @param position Posicion del fragmento
     * @return Devuelve un fragmento
     */
    @Override
    public Fragment createFragment(int position) {
        return PlaceholderFragment.newInstance(position + 1);
    }

    /**
     * Metodo que devuelve el numero de fragmentos
     * @return Devuelve el numero de fragmentos
     */
    @Override
    public int getItemCount() {
        return 3;
    }
}
