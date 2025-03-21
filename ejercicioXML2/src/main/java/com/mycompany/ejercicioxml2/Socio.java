/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejercicioxml2;
import java.util.ArrayList;
import javax.xml.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
/**
 *
 * @author usuario
 */
@XmlRootElement(name="Socio")
@XmlType(propOrder={"nombreSocio","direccion","fechaAlta","amigos"})
@XmlAccessorType(XmlAccessType.FIELD) 

public class Socio {
    @XmlAttribute(name="id",required=true)
    private Integer indentificacion;
    @XmlElement(name="nombre")
    private String nombreSocio;
    
    private String direccion;
    @XmlElement(name="fechaAlta")
    private String fechaAlta;
    @XmlElement(name="amigos")
    private ArrayList<Socio> amigos=new ArrayList<>();
    
    public Socio(Integer indentificacion, String nombreSocio, String direccion, String fechaAlta) {
        this.indentificacion=indentificacion;
        this.nombreSocio=nombreSocio;
        this.direccion=direccion;
        this.fechaAlta=fechaAlta;
        
    }
    
    Socio(){
        
    }
    
    public void amigoA(Socio amigo){
        amigos.add(amigo);
    }
    public void amigoS(ArrayList amigos){
        this.amigos.addAll(amigos);
    }

    @Override
    public String toString() {
        return "\n"+"Socio{" + "indentificacion=" + indentificacion + ", nombreSocio=" + nombreSocio + ", direccion=" + direccion + ", fechaAlta=" + fechaAlta + ", amigos=" + amigos + '}';
    }
    
    
    
    
}
