/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicioxml2;
import javax.xml.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAttribute;
/**
 *
 * @author usuario
 */
@XmlRootElement(name="Socio")
@XmlType(propOrder={"nombreSocio","direccion","fechaAlta"})
@XmlAccessorType(XmlAccessType.FIELD) 

public class Socio {
    @XmlAttribute(name="id",required=true)
    private Integer indentificacion;
    @XmlAttribute(name="nombre")
    private String nombreSocio;
    @XmlAttribute(name="direccion")
    private String direccion;
    @XmlAttribute(name="direccion")
    private String fechaAlta;

    public Socio(Integer indentificacion, String nombreSocio, String direccion, String fechaAlta) {
        
    }
    
    
}
