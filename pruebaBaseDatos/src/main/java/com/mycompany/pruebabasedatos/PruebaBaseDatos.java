/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pruebabasedatos;
import java.sql.*;
import java.sql.Connection;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author usuario
 */
public class PruebaBaseDatos {

    public static void main(String[] args) throws SQLException {
        Scanner sc=new Scanner(System.in),teclado=new Scanner(System.in);
        Connection con;
        con=DriverManager.getConnection("jdbc:mysql://localhost/nba","root","");        
        Statement sentencia=con.createStatement();
        
        System.out.println("Para consultar datos de un jugador introduce 1.\nPara añadir un jugador a la base de datos pulsa 2.\nPara eliminar un jugador pulsa 3.");
        int opcion=sc.nextInt();
        
        switch(opcion){
            case 1:
                System.out.println("Introduce el nombre");
                String nombre=teclado.nextLine();

                ResultSet rs=sentencia.executeQuery("select * from jugadores where Nombre='"+nombre+"';");

                int numColumnas = rs.getMetaData().getColumnCount();

                if(!rs.next()){
                    System.out.println("No existe un jugador con ese nombre");
                }
                else{


                for (int i = 1; i <= numColumnas; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println(); 
                }
                rs.close();
            break;
            
            case 2:
                System.out.println("Introduce la siguiente informacion a guardar sobre el jugador:\ncodigo\nNombre\nProcedencia\nAltura\nPeso\nPosicion\nNombre_equipo");
                
        }
        
        
        
        
        
        sentencia.close();
        con.close();
        
        
        
        
    }
}
