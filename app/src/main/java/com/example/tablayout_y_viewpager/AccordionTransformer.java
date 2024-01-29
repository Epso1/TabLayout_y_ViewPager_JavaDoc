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

/**
 * Clase que define una animacion de tipo acordeon para las transiciones entre paginas
 * @author Toxic Bakery
 * @version 2.0
 * @see BaseTransformer
 */

public class AccordionTransformer extends BaseTransformer {

    /**
     * Metodo que define la animacion de transicion entre paginas
     * @param view Vista a la que se aplica la transformacion
     * @param position Posicion de la pagina en el ViewPager2
     */
    @Override
    protected void onTransform(View view, float position) {
        view.setPivotX(position < 0 ? 0 : view.getWidth());
        view.setScaleX(position < 0 ? 1f + position : 1f - position);
    }

}