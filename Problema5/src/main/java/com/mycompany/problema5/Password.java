/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.problema5;

import java.util.*;

/**
 *
 * @author rafa
 */
public class Password {
    private int longitud;
    private String contraseña="";
    private boolean encriptada;
    private ArrayList<Integer> caracteres=new ArrayList<>(Arrays.asList(48,49,50,51,52,53,54,55,56,57,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,48,49,50,51,52,53,54,55,56,57,89,90,97,98,99,100,101,102,103,104,105,48,49,50,51,52,53,54,55,56,57,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122));
    
    Password(){
        longitud=8;
        contraseña="12345678";
    }
    Password(int longitud){
        this.longitud=longitud;
        generar(longitud);
    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public String getContraseña() {
        return contraseña;
    }  
    
    public void generar(int longitud){
        ArrayList<Integer> cg=new ArrayList<>();
        cg.addAll(caracteres);
        Collections.shuffle(cg);        
        Iterator<Integer> itr=cg.iterator();
        for(int i=0;i<longitud;i++){
            int l=(int)itr.next();
            itr.remove();
            contraseña+=(char)l;
        }
    }
    
    public boolean esFuerte(){
        int n=0,min=0,may=0;
        for(int i=0;i<contraseña.length();i++){
            if(Character.isDigit(contraseña.charAt(i))){
                n++;
            }
            else if(Character.isLowerCase(contraseña.charAt(i))){
                min++;
            }
            else if(Character.isUpperCase(contraseña.charAt(i))){
                may++;
            }
        }
        if(n>5 && min>1 && may>2){
            return true;
        }
        else return false;
    }
    
    public void encriptar(int desplazamiento) {
        String contraseñaEncriptada = ""; // Cadena para almacenar la contraseña encriptada
        for (int i = 0; i < contraseña.length(); i++) {
            char c = contraseña.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                char base = Character.isLowerCase(c) ? 'a' : Character.isUpperCase(c) ? 'A' : '0';
                c = (char) (base + (c - base + desplazamiento) % 26);
            }
            contraseñaEncriptada += c; // Concatenar el carácter encriptado
        }
        contraseña = contraseñaEncriptada; // Actualizar la contraseña
        encriptada = true; // Marcar como encriptada
    }

    // Método para desencriptar la contraseña usando el cifrado César
    public void desencriptar(int desplazamiento) {
        String contraseñaDesencriptada = ""; // Cadena para almacenar la contraseña desencriptada
        for (int i = 0; i < contraseña.length(); i++) {
            char c = contraseña.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                char base = Character.isLowerCase(c) ? 'a' : (Character.isUpperCase(c) ? 'A' : '0');
                c = (char) (base + (c - base - desplazamiento + 26) % 26);
            }
            contraseñaDesencriptada += c; // Concatenar el carácter desencriptado
        }
        contraseña = contraseñaDesencriptada; // Actualizar la contraseña
        encriptada = false; // Marcar como desencriptada
    }
}
