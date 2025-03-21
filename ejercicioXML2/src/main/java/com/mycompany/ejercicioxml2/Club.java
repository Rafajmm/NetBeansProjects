package com.mycompany.ejercicioxml2;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * The Club class represents a club containing a list of socios (members).
 * JAXB annotations are used to specify how this class will be serialized/deserialized to/from XML.
 */
@XmlRootElement(name="Club")
@XmlType(propOrder={"id","socios"})
@XmlAccessorType(XmlAccessType.FIELD) 

public class Club {
    @XmlAttribute(name="id")
    private int id;
    @XmlElementWrapper(name="amigos") 
    @XmlElement(name="socios") 
    private ArrayList<Socio> socios = new ArrayList<>();
    
   
    Club(int id, ArrayList<Socio> conj) {
        this.id=id;
        this.socios.addAll(conj);
    }
    
    Club(){}

    @Override
    public String toString() {
        return "Club{" + "socios=" + socios + '}';
    }
}
