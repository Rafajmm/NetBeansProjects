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
        ResultSet rs;
        String nombre="",consulta="";
        
        System.out.println("Para consultar datos de un jugador introduce 1.\nPara añadir un jugador a la base de datos pulsa 2.\nPara actualizar el equipo de un jugador pulsa 3.\nPara eliminar un jugador pulsa 4.");
        int opcion=sc.nextInt();
        
        switch(opcion){
            case 1:
                System.out.println("Introduce el nombre");
                nombre=teclado.nextLine();

                rs=sentencia.executeQuery("select * from jugadores where Nombre='"+nombre+"';");

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
                String cadena="";
                System.out.println("Introduce la siguiente informacion a guardar sobre el jugador: ");
                System.out.println("codigo: ");
                cadena+="'"+teclado.nextLine()+"',";
                System.out.println("Nombre: ");
                cadena+="'"+teclado.nextLine()+"',";
                System.out.println("Procedencia: ");
                cadena+="'"+teclado.nextLine()+"',";
                System.out.println("Altura: ");
                cadena+="'"+teclado.nextLine()+"',";
                System.out.println("Peso: ");
                cadena+="'"+teclado.nextLine()+"',";
                System.out.println("Posicion: ");
                cadena+="'"+teclado.nextLine()+"',";
                System.out.println("Nombre de equipo: ");
                cadena+="'"+teclado.nextLine()+"'";
                
                consulta="insert into jugadores values("+cadena+");";
                try{
                    int op=sentencia.executeUpdate(consulta);
                    if(op==1){
                        System.out.println("Jugador introducido.");
                    }
                }
                catch(SQLException e){
                    System.out.println(e.getMessage());
                }                                                                                                                        
                break;
                
            case 3:
                System.out.println("Introduce el nombre del Jugador que ha cambiado de equipo: ");
                nombre=teclado.nextLine();
                System.out.println("Introduce el nuevo equipo");
                String equipo=teclado.nextLine();
                
                consulta="update jugadores set Nombre_equipo='"+equipo+"' where Nombre='"+nombre+"';";
                try{
                    int op3=sentencia.executeUpdate(consulta);
                    if(op3==1){
                        System.out.println("Jugador actualizado");
                    }
                }
                catch(SQLException ex){
                    System.out.println(ex.getMessage());
                }
                break;
            
            case 4:
                System.out.println("Introduce el nombre del jugador a eliminar: ");
                nombre=teclado.nextLine();
                
                consulta="delete from jugadores where Nombre='"+nombre+"';";
                try{
                    int op4=sentencia.executeUpdate(consulta);
                    if(op4==1){
                        System.out.println("Jugador eliminado.");
                    }
                }
                catch(SQLException exe){
                    System.out.println(exe.getMessage());
                }
                break;
        }
        
        
        
        
        
        sentencia.close();
        con.close();
        
        
        
        
    }
}
