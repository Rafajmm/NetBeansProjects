/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cifrar;

/**
 *
 * @author usuario
 */
public class Cesar 
{
        private String msg; //mensaje guardado en cada objeto
	private int desp; //desplazamiento dentro de la tabla ASCII
	
	Cesar()
	{
            msg="";
            desp=0;
	}
	
	Cesar(String msg, int desp)
	{
		this.msg = msg;
		this.desp = desp;
	}
	
	String cifrar()
	{
		String resul="";
		
		for(int i=0; i<msg.length(); i++)
		{
			resul = resul + Character.toString(msg.charAt(i) + desp);
			//falta tener en cuenta los casos particulares: z, Z, 9, espacio...
		}
		
		return resul;
	}
	
	String descifrar()
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
