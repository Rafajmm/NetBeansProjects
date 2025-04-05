package com.mycompany.libretadirecciones;


import jakarta.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rafa
 */
public class AdaptadorDeFechas extends XmlAdapter<String, LocalDate>{


    @Override

    public LocalDate unmarshal(String v) throws Exception {

        return LocalDate.parse(v);

    }


    @Override

    public String marshal(LocalDate v) throws Exception {

        return v.toString();

    }


}
