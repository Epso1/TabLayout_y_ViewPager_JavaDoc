package com.example.tablayout_y_viewpager;

/*
 * Copyright 2014 Toxic Bakery
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */



import android.view.View;

import androidx.viewpager2.widget.ViewPager2;

/**
 * Clase abstracta que define una animacion de transicion entre paginas para un ViewPager2
 * @author Cesar Alvaro
 * @version 1.0
 * @see ViewPager2
 * @see ViewPager2.PageTransformer
 * @see AccordionTransformer
 */

public abstract class BaseTransformer implements ViewPager2.PageTransformer {

    /**
     * Metodo que define la animacion de transicion entre paginas
     * @param view Vista a la que se aplica la transformacion
     * @param position Posicion de la pagina en el ViewPager2
     */
    protected abstract void onTransform(View view, float position);

    /**
     * Metodo que aplica la transformacion a una pagina
     * @param view Aplica la transformacion a esta vista
     * @param position Posicion de la página en el ViewPager2
     */
    @Override
    public void transformPage(View view, float position) {
        onPreTransform(view, position);
        onTransform(view, position);
        onPostTransform(view, position);
    }

    /**
     * Metodo que se llama antes de {@link #transformPage(android.view.View, float)} para cada página y antes de que se aplique la transformación.
     * Indica si las paginas que no se muestran deben ocultarse
     * @return true si las paginas que no se muestran deben ocultarse, false en caso contrario
     */
    protected boolean hideOffscreenPages() {
        return true;
    }

    /**
     * Indica si el desplazamiento entre paginas esta habilitado
     * @return true si el desplazamiento entre paginas esta habilitado, false en caso contrario
     */
    protected boolean isPagingEnabled() {
        return false;
    }

    /**
     * Metodo que se llama antes de {@link #transformPage(android.view.View, float)} para cada pagina y antes de que se aplique la transformacion.
     * @param view Aplica la transformacion a esta vista
     * @param position Posicion de la pagina en el ViewPager2
     */
    protected void onPreTransform(View view, float position) {
        final float width = view.getWidth();

        view.setRotationX(0);
        view.setRotationY(0);
        view.setRotation(0);
        view.setScaleX(1);
        view.setScaleY(1);
        view.setPivotX(0);
        view.setPivotY(0);
        view.setTranslationY(0);
        view.setTranslationX(isPagingEnabled() ? 0f : -width * position);

        if (hideOffscreenPages()) {
            view.setAlpha(position <= -1f || position >= 1f ? 0f : 1f);
        } else {
            view.setAlpha(1f);
        }
    }

    /**
     * Metodo que se llama despues de {@link #transformPage(android.view.View, float)} para cada pagina y despues de que se aplique la transformacion.
     * @param view Aplica la transformacion a esta vista
     * @param position Posicion de la pagina en el ViewPager2
     */
    protected void onPostTransform(View view, float position) {
    }

}