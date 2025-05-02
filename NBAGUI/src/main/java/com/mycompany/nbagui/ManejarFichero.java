package com.mycompany.nbagui;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@XmlRootElement(name="ManejarFichero")
@XmlType(propOrder={"contenido","dbUrl","usuario","psswd","colorFilaPar","colorFilaImpar"})
@XmlAccessorType(XmlAccessType.FIELD) 
public class ManejarFichero {
    @XmlElement(name="contenido")
    private LinkedHashMap<String, String> contenido = new LinkedHashMap<>();
    
    @XmlElement(name="dbUrl")
    private String dbUrl;
    @XmlElement(name="usuario")
    private String usuario;
    @XmlElement(name="psswd")
    private String psswd;
    
    @XmlElement(name="colorFilaPar")
    private String colorFilaPar = "#ADD8E6"; 
    @XmlElement(name="colorFilaImpar")
    private String colorFilaImpar = "#D3D3D3";
    
    public ManejarFichero(String ruta) {
        if (!ruta.endsWith(".ini") && !ruta.endsWith(".xml")) {
            throw new IllegalArgumentException("El archivo debe tener extensión .ini o .xml");
        }
        cargarArchivo(ruta);
    }
    public ManejarFichero(){
        contenido.put("dbUrl", "");
        contenido.put("usuario", "");
        contenido.put("psswd", "");
        contenido.put("colorFilaPar", "#ADD8E6");
        contenido.put("colorFilaImpar", "#D3D3D3");
        dbUrl="";
        usuario="";
        psswd="";
        colorFilaPar = "#ADD8E6";
        colorFilaImpar = "#D3D3D3";
    }
    
    private void cargarArchivo(String ruta) {
        if(ruta.endsWith(".ini")){
            try (BufferedReader leer = new BufferedReader(new FileReader(ruta))) {
                String linea;
                while ((linea = leer.readLine()) != null) {
                    linea = linea.trim();
                    if (linea.isEmpty() || linea.startsWith("[") || 
                        linea.startsWith(";") || linea.startsWith("#")) {
                        continue;
                    }

                    String[] partes = linea.split("=", 2);
                    String clave = partes[0].trim();
                    String valor = partes.length > 1 ? partes[1].trim() : null;
                    

                    if ("dbUrl".equals(clave)) {
                        this.dbUrl = valor;
                    } 
                    else if ("usuario".equals(clave)) {
                        this.usuario = valor;
                    } 
                    else if ("psswd".equals(clave)) {
                        this.psswd = valor;
                    }
                    else if("colorFilaPar".equals(clave)){
                        this.colorFilaPar=valor;
                    }
                    else if("colorFilaImpar".equals(clave)){
                        this.colorFilaImpar=valor;
                    }
                }
            } catch (IOException e) {
                System.err.println("Error al leer archivo: " + e.getMessage());
                contenido.put("dbUrl", "");
                contenido.put("usuario", "");
                contenido.put("psswd", "");
                contenido.put("colorFilaPar", "");
                contenido.put("colorFilaImpar", "");
            }
        }
        else{
            try{
                JAXBContext contexto = JAXBContext.newInstance(ManejarFichero.class);
                Unmarshaller um=contexto.createUnmarshaller();
                ManejarFichero temp=(ManejarFichero)um.unmarshal(new File("config.xml"));
                this.contenido=temp.contenido;
                this.dbUrl = temp.dbUrl;
                this.usuario = temp.usuario;
                this.psswd = temp.psswd;
                this.colorFilaPar=temp.colorFilaPar;
                this.colorFilaImpar=temp.colorFilaImpar;
            }
            catch (JAXBException ex) {
                Logger.getLogger(ManejarFichero.class.getName()).log(Level.SEVERE, null, ex);
                contenido.put("dbUrl", "");
                contenido.put("usuario", "");
                contenido.put("psswd", "");
                contenido.put("colorFilaPar", "");
                contenido.put("colorFilaImpar", "");
            }
        }
    }
    
    public void guardarArchivo(String ruta) {
        if(ruta.endsWith(".ini")){
            try (BufferedWriter escribir = new BufferedWriter(new FileWriter(ruta))) {
                for (Map.Entry<String, String> entrada : contenido.entrySet()) {
                    escribir.write(entrada.getKey() + "=" +(entrada.getValue() != null ? entrada.getValue() : ""));
                    escribir.newLine();
                }
            } 
            catch (IOException ex) {
                System.err.println("Error al guardar archivo: " + ex.getMessage());
            }
        }
        else if(ruta.endsWith(".xml")){
            try{
                JAXBContext contexto = JAXBContext.newInstance(ManejarFichero.class);
                Marshaller m = contexto.createMarshaller();
                m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                m.marshal(this, new File(ruta));
            }
            catch(JAXBException ex){
                System.err.println("Error al guardar archivo XML: " + ex.getMessage());
            }
        }
    }
    
    
    
    public boolean cambiar(String key, String value){
        if(contenido.containsKey(key)){            
            if(key.equals("dbUrl")){
               this.dbUrl=value;
            }
            else if(key.equals("usuario")){
               this.usuario=value;
            }
            else if(key.equals("psswd")){
               this.psswd=value;
            }
            else if(key.equals("colorFilaPar")){
                this.colorFilaPar=value;
            }
            else if(key.equals("colorFilaImpar")){
                this.colorFilaImpar=value;
            }
            contenido.replace(key, value);
            return true;
        }
        else return false;
    }
    
    public boolean añadir(String key, String value){
        if(contenido.containsKey(key)) return false;
        else{
            contenido.put(key, value);
            return true;
        }
    }
    
    public String consultar(String key){
        if(contenido.containsKey(key)){
            return contenido.get(key);
        }
        else return null;
    }
    
    public boolean borrar(String key){
        if(contenido.containsKey(key)){
            contenido.remove(key);            
            return true;
        }
        else return false;
    }
    
    public LinkedHashMap getContenido(){
        return contenido;
    }

    public String getDbUrl() {
        return dbUrl;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPsswd() {
        return psswd;
    }
    
    public void resetearAtributos(){
        cambiar("dbUrl","");
        cambiar("usuario","");
        cambiar("psswd","");
    }
    
    public String getColorFilaPar() {
        return colorFilaPar;
    }

    public void setColorFilaPar(String colorFilaPar) {
        this.colorFilaPar = colorFilaPar;
    }

    public String getColorFilaImpar() {
        return colorFilaImpar;
    }

    public void setColorFilaImpar(String colorFilaImpar) {
        this.colorFilaImpar = colorFilaImpar;
    }

    @Override
    public String toString() {
        return "ManejarFichero{" + "contenido=" + contenido + ", dbUrl=" + dbUrl + ", usuario=" + usuario + ", psswd=" + psswd + ", colorFilaPar=" + colorFilaPar + ", colorFilaImpar=" + colorFilaImpar + '}';
    }
    
    
        
}
