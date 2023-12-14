package com.politecnicomalaga.laQuinelaDeMariano.Model;

public class Partido {
    private String equipo1;
    private String equipo2;
    private String resultado;

    public Partido(String equipo1, String equipo2, String resultado) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.resultado = resultado;
    }

    public String getEquipo1() {
        return this.equipo1;
    }
    public String getEquipo2() {
        return this.equipo2;
    }

    public String getResultado() {
        return this.resultado;
    }
}
