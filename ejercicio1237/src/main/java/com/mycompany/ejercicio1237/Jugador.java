package com.mycompany.ejercicio1237;
import java.util.*;


public class Jugador {
    private String dni;
    private String nombre;
    private String posicion;

    public Jugador(String dni, String nombre, String posicion) {
        setDni(dni);
        setNombre(nombre);
        setPosicion(posicion);
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
    
    static void altaJugador(Map<Integer,Jugador> equipo, Integer uno){
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce dni");
        String dni=teclado.next();
        System.out.println("Introduce Nombre");
        String nombre=teclado.next();
        System.out.println("Introduce posicion");
        String pos=teclado.next();
        Jugador nuevo=new Jugador(dni,nombre,pos);
        
        equipo.put(uno, nuevo);                
    }
    
}
