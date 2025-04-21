package com.mycompany.nbagui;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class ManejarIni {
    private LinkedHashMap<String, String> contenido = new LinkedHashMap<>();
    private String dbUrl;
    private String usuario;
    private String psswd;
    
    public ManejarIni(String ruta) {
        if (!ruta.endsWith(".ini")) {
            throw new IllegalArgumentException("El archivo debe tener extensión .ini");
        }
        cargarArchivo(ruta);
    }
    
    private void cargarArchivo(String ruta) {
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

                contenido.put(clave, valor);
                
                if ("dbUrl".equals(clave)) {
                    this.dbUrl = valor;
                } else if ("usuario".equals(clave)) {
                    this.usuario = valor;
                } else if ("psswd".equals(clave)) {
                    this.psswd = valor;
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer archivo: " + e.getMessage());
            contenido.put("dbUrl", "localhost");
            contenido.put("usuario", "admin");
            contenido.put("psswd", "");
            guardarArchivo(ruta);
        }
    }
    
    public void guardarArchivo(String ruta) {
        try (BufferedWriter escribir = new BufferedWriter(new FileWriter(ruta))) {
            for (Map.Entry<String, String> entrada : contenido.entrySet()) {
                escribir.write(entrada.getKey() + "=" + 
                             (entrada.getValue() != null ? entrada.getValue() : ""));
                escribir.newLine();
            }
        } catch (IOException ex) {
            System.err.println("Error al guardar archivo: " + ex.getMessage());
        }
    }
    
    
    
    public boolean cambiar(String key, String value){
       if(contenido.containsKey(key)){
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
        
}
