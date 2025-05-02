package com.mycompany.nbagui;

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

    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public void setConferenciaLocal(String conferenciaLocal) {
        this.conferenciaLocal = conferenciaLocal;
    }

    public void setPuntosLocal(int puntosLocal) {
        this.puntosLocal = puntosLocal;
    }

    public void setPuntosVisitante(int puntosVisitante) {
        this.puntosVisitante = puntosVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public void setConferenciaVisitante(String conferenciaVisitante) {
        this.conferenciaVisitante = conferenciaVisitante;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }
    
    
    
}
