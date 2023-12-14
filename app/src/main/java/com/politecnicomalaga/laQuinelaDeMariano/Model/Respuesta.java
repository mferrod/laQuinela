package com.politecnicomalaga.NasdaqOilPrices.Model;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Clase respuesta. Encapsulará los datos que nos devuelve la API REST
 * opendata de Nasdaq.
 *
 * El controlador le dará el texto a "analizar" en JSON y proporcionará
 * una serialización de los datos "amigable" para la vista. Es en
 * realidad un procesador de textos (parser)
 */

public class Respuesta {
    //ESTADO
    protected String datos;


    //COMPORTAMIENTO
    public Respuesta(String entrada) {
        datos = entrada;
    }


    public List<Partido> getData() {
        LinkedList<Partido> dataList = new LinkedList<>();

        String datoscasiBuenos = this.datos.substring(this.datos.indexOf("<meta property=\"og:description\""));
        String datosCasiParseados = datoscasiBuenos.substring(datoscasiBuenos.indexOf("\n\n\n") + 3, datoscasiBuenos.indexOf("\n\nE"));
        ArrayList<String[]> datosArr = new ArrayList<>();
        String datosTemp;
        for (int i = 0; i < 15; i++) {
            String[] c = new String[3];
            if (i < 14)
                datosTemp = datosCasiParseados.substring(0, datosCasiParseados.indexOf("\n"));
            else
                datosTemp = datosCasiParseados.substring(10);

            c[0] = datosTemp.substring(2, datosTemp.indexOf(" -"));
            if (i < 14) {
                c[1] = datosTemp.substring(datosTemp.indexOf("- ") + 2, datosTemp.length() - 2);
                c[2] = datosTemp.substring(datosTemp.length() - 1);
                datosCasiParseados = datosCasiParseados.substring(datosCasiParseados.indexOf("\n") + 1);
            } else {
                c[1] = datosTemp.substring(datosTemp.indexOf("- ") + 2, datosTemp.length() - 6);
                c[2] = datosTemp.substring(datosTemp.indexOf("- ") + 8, datosTemp.length() - 4);
            }
            datosArr.add(c);
        }
        for (int i = 0; i < datosArr.size(); i++)
            dataList.add(new Partido(datosArr.get(i)[0], datosArr.get(i)[1], datosArr.get(i)[2]));
        return dataList;
    }
}
