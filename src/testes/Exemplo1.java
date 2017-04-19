/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;
import java.sql.*;

/**
 *
 * @author Silvia Bertagnolli
 */
public class Exemplo1{
   public static void main(String[] args) {
     try{  
         Class.forName("com.mysql.jdbc.Driver");
         String urlBD="jdbc:mysql://localhost:3306/bd";
        try(Connection conexao = DriverManager.getConnection(urlBD, "root", "");){
            System.out.println("Conectou!"); 
        }catch(SQLException e){
            System.out.println("Não conseguiu conectar com o BD!");
        }
     }catch(ClassNotFoundException e){
         System.out.println("Driver não encontrado!");
     }
   }
}

