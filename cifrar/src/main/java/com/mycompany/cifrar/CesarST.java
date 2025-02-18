/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cifrar;

/**
 *
 * @author usuario
 */
public class CesarST 
//hace lo mismo que Cesar pero con métodos estáticos
{	
	public static String cifrar(String msg, int desp)
	{
		String resul="";
		
		for(int i=0; i<msg.length(); i++)
		{
			resul = resul + Character.toString(msg.charAt(i) + desp);
			//falta tener en cuenta los casos particulares: z, Z, 9, espacio...
		}
		
		return resul;
	}
	
	public static String descifrar(String msg, int desp)
	{
		String resul="";
		
		for(int i=0; i<msg.length(); i++)
		{
			resul = resul + Character.toString(msg.charAt(i) - desp);
			//falta tener en cuenta los casos particulares: a, A, 0, espacio...
		}
		
		return resul; 
        }  
}
