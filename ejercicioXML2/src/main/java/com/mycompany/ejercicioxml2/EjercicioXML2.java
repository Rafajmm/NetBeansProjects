/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicioxml2;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author usuario
 */
public class EjercicioXML2 {

    public static void main(String[] args) throws JAXBException {
        
        Socio s1=new Socio(1,"pepe","calle parra","21/03/2025");
        Socio s3=new Socio(2,"juan","calle perro","01/03/2025");
        Socio s4=new Socio(3,"miguel","calle porra","12/03/2025");
        Socio s5=new Socio(4,"luis","calle puerro","20/03/2025");
        Socio s6=new Socio(5,"antonio","calle porro","16/03/2025");
        s4.amigoA(s6);
        s6.amigoA(s5);
        System.out.println(s1);
        
        ArrayList<Socio> amigos=new ArrayList<>(Arrays.asList(s3,s4,s5,s6));
        s1.amigoS(amigos);
        
        JAXBContext contexto = JAXBContext.newInstance(Socio.class);
        
        Marshaller m=contexto.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        m.marshal(s1, new File("socio.xml"));
        m.marshal(s1, System.out);
        
        
        
        Unmarshaller um=contexto.createUnmarshaller();
        Socio s2=(Socio)um.unmarshal(new File("socio.xml"));
        System.out.println(s2);
        
        
        Club c1=new Club(1,amigos);
        
        JAXBContext contexto1 = JAXBContext.newInstance(Club.class,Socio.class);
        Marshaller m1=contexto1.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);                
        m1.marshal(c1, new File("club1.xml"));
        m1.marshal(c1, System.out);
    }
}
