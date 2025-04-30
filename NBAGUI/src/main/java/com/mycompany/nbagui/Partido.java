package com.mycompany.nbagui;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author usuario
 */
public class Partido {
    private String equipoLocal;
    private String conferenciaLocal;
    private int puntosLocal;
    private int puntosVisitante;
    private String equipoVisitante;
    private String conferenciaVisitante;
    private String temporada;
    
    public Partido(){}
    public Partido(String equipoLocal, String conferenciaLocal, int puntosLocal, int puntosVisitante, String equipoVisitante, String conferenciaVisitante, String temporada){
        this.equipoLocal=equipoLocal;
        this.conferenciaLocal = conferenciaLocal;
        this.puntosLocal = puntosLocal;
        this.puntosVisitante = puntosVisitante;
        this.equipoVisitante = equipoVisitante;
        this.conferenciaVisitante = conferenciaVisitante;
        this.temporada = temporada;
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public String getConferenciaLocal() {
        return conferenciaLocal;
    }

    public int getPuntosLocal() {
        return puntosLocal;
    }

    public int getPuntosVisitante() {
        return puntosVisitante;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public String getConferenciaVisitante() {
        return conferenciaVisitante;
    }

    public String getTemporada() {
        return temporada;
    }
    
}
