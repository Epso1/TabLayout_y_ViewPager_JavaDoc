package com.example.tablayout_y_viewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

/**
 * Clase que define un fragmento de la aplicacion
 * @author Cesar Alvaro
 * @version 1.0
 * @see Fragment
 * @see Bundle
 * @see LayoutInflater
 * @see ViewGroup
 * @see View
 * @see TextView
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    public PlaceholderFragment() {
        // Required empty public constructor
    }

    /**
     * Metodo que crea una instancia de PlaceholderFragment
     * @param sectionNumber Numero de seccion
     * @return Devuelve una instancia de PlaceholderFragment
     */
    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Metodo que se llama cuando se crea el fragmento
     * @param savedInstanceState Si el fragmento se esta reanudando desde un estado anterior, este es el estado guardado
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Metodo que se llama cuando se crea la vista del fragmento
     * @param inflater El LayoutInflater que se usa para inflar la vista
     * @param container Si no es nulo, este es el grupo de vistas al que se adjuntara la vista de fragmento
     * @param savedInstanceState Si no es nulo, este fragmento se esta reanudando a partir de un estado guardado
     *
     * @return Devuelve la vista del fragmento
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    /**
     * Metodo que se llama cuando la vista del fragmento se ha creado, pero antes de que se haya restaurado a su estado guardado
     * @param view La vista inflada del fragmento o nulo si no hay vista proporcionada
     * @param savedInstanceState Si no es nulo, este fragmento se está reanudando a partir de un estado guardado anterior de esta vista
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null && getArguments().containsKey(ARG_SECTION_NUMBER)) {
            int sectionNumber = getArguments().getInt(ARG_SECTION_NUMBER);
            TextView textView = view.findViewById(R.id.section_label);
            textView.setText("FRAGMENT " + String.valueOf(sectionNumber));
        }
    }

}
