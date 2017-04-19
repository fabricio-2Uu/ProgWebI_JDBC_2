/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import classes.Endereco;
import classes.Pessoa;
import dao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Silvia
 */
public class Teste1 {
    public static void main(String args[]) {
        LinkedList<Endereco> lista = new LinkedList<>();
        lista.add(new Endereco(-1, "logradouro1", "complemento1", "uf"));
        lista.add(new Endereco(-1, "logradouro2", "complemento2", "uf"));
        lista.add(new Endereco(-1, "logradouro3", "complemento3", "uf"));
        
        try(Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement stmt = 
                    connection.prepareStatement("insert into endereco" +
                " (logradouro, complemento, uf)" +
                " values (?,?,?)");){
                    
                for (Endereco endereco : lista) {
                   stmt.setString(1, endereco.getLogradouro()); 
                   stmt.setString(2, endereco.getComplemento()); 
                   stmt.setString(3, endereco.getUf()); 
                   stmt.execute();
                }
        }catch(SQLException e){
            System.out.println("Exceção no teste1 - cadastrar");
        }catch(ClassNotFoundException e){
            System.out.println("Classe não encontrada!");
        }
        
         String sql = "Select * from pessoa";
        
       try(Connection connection = new ConnectionFactory().getConnection();){
        System.out.println("Conexão aberta!");
        
           sql = "Select * from endereco";
        
           Statement stmt = connection.createStatement();
           ResultSet rs = stmt.executeQuery(sql);
           while(rs.next()){
               int idEndereco = rs.getInt("idendereco");
               String logradouro = rs.getString("logradouro");
               String complemento = rs.getString("complemento");
               String uf = rs.getString("uf");
            //adiciona os objetos na lista
               lista.add(new Endereco(idEndereco, logradouro, complemento, uf));
            }  
        }catch (ClassNotFoundException e){
            System.out.println("Classo não encontrada.");
        }catch(SQLException e){
            System.out.println("Exceção no teste1 - cadastrar");
        }
        
    }
}
