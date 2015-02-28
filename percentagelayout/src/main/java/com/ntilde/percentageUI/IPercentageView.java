package com.ntilde.percentageUI;

import android.view.View;

public interface IPercentageView{

    /**
     * Devuelve el padre que se usara para caltular el porcentaje.
     * En funcion de como se especificase el porcentaje iterara up-to-down,
     * devolvera el rootview o el elemento especificado.
     * @return Elemento respecto al que se calculará el porcentaje
     */
    public View getPercentageParent();

    /**
     * Devuelve la cantidad de pixeles no usados debido a la conversion de float a int para fijar
     * el parametro indicado como anchura
     *
     * @return Numero entre 0 y 0.9 periodico puro
     */
    public float getUnusedPixelWidth();

    /**
     * Devuelve la cantidad de pixeles no usados debido a la conversion de float a int para fijar
     * el parametro indicado como altura
     *
     * @return Numero entre 0 y 0.9 periodico puro
     */
    public float getUnusedPixelHeight();

    /**
     * Fija los porcentajes de la vista segun los casos:
     *
     *  2 parametros:  ancho, alto
     *  3 parametros:  2p + margen general
     *  4 parametros:  3p + padding general,
     *  6 parametros:  2p + margen superior, margen derecho, margen inferior, margen izquierdo
     *  10 parametros: 6p + padding superior, padding derecho, padding inferior, padding izquierdo
     *
     *
     * Cadenas validas para especificar porcentaje:
     *
     *  null:      No modifica el elemento fijado a null
     *  30%:       30% respecto al primer IPercentageLayout padre o rootView si no se encontrase
     *  30%s:      30% respecto a la pantalla
     *  30%idElem: 30% respecto al elemento idElem
     *
     *
     * Ejemplos:
     *
     *  setPercentageParameters("30%", "50%s");
     *  setPercentageParameters("30%idElemento", "50%s");
     *  setPercentageParameters("30%s", "50%s", null, "10%");
     *
     * @param percentages Porcentajes a fijar
     */
    public void setPercentageParameters(String... percentages);

    /**
     * Fija los porcentajes del margen de la vista segun los casos:
     *
     *  1 parametro:  margen aplicable a los cuatro margenes
     *  2 parametros: margen izquierdo y derecho, margen superior e inferior
     *  4 parametros: margen superior, margen derecho, margen inferior, margen izquierdo
     *
     *
     *  Cadenas validas para especificar porcentaje:
     *
     *  null: No modifica el elemento fijado a null
     *  30%:  30% respecto al elemento actual
     *
     *
     *  Ejemplos:
     *
     *  setPercentageMargin("5%");
     *  setPercentageMargin("5%", null);
     *  setPercentageMargin(null, "5%", "5%", null);
     *
     * @param percentages Porcentajes a fijar
     */
    public void setPercentageMargin(String... percentages);

    /**
     * Fija los porcentajes del padding de la vista segun los casos:
     *
     *  1 parametro:  padding aplicable a los cuatro padding
     *  2 parametros: padding izquierdo y derecho, padding superior e inferior
     *  4 parametros: padding superior, padding derecho, padding inferior, padding izquierdo
     *
     *
     *  Cadenas validas para especificar porcentaje:
     *
     *  null: No modifica el elemento fijado a null
     *  30%:  30% respecto al elemento actual
     *
     *
     *  Ejemplos:
     *
     *  setPercentagePadding("5%");
     *  setPercentagePadding("5%", null);
     *  setPercentagePadding(null, "5%", "5%", null);
     *
     * @param percentages Porcentajes a fijar
     */
    public void setPercentagePadding(String... percentages);
}
