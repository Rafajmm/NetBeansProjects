/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cifrar;

/**
 *
 * @author usuario
 */
public class Cifrar 
{

    public static void main(String[] args) 
    {
        
        Cesar objCesar=new Cesar("Zola", 3);

        String temp = objCesar.cifrar();

        System.out.println("Mensaje original cifrado: " + temp);

        objCesar = new Cesar(temp, 3); //reutilizamos la variable objCesar, pero podríamos haber usado otra nueva

        System.out.println("Mensaje descifrado: " + objCesar.descifrar());
        
        //Ahora con la clase estática
        
        temp = CesarST.cifrar("Hola", 3);

        System.out.println("Mensaje original cifrado: " + temp);

        
        
    }
}
