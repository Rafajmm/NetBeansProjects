package com.mycompany.libretadirecciones;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;

import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "personas") //Define el nombre del elemento raíz XML

public class Empaquetador {


    private List<Persona> personas;


    @XmlElement(name = "persona") //Opcional para el elemento especificado

    public List<Persona> getPersonas(){

        return personas;

    }


    public void setPersonas(List<Persona> personas){

        this.personas = personas;

    }


}