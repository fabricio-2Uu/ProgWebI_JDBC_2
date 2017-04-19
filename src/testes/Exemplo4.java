/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import dao.ConnectionFactory;
import java.sql.*;

/**
 *
 * @author silviacb
 */
public class Exemplo4 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        Connection connection = new ConnectionFactory().getConnection();
        System.out.println("Conexão aberta!");
        
        String nome = "Silvia";
        String endereco = "Rua X, 10";
     
        
        String sql = "insert into pessoa (nome, endereco)" +
        " values ('" + nome + "', '" + endereco +  "')";
        System.out.println(sql);
        
        Statement s = connection.createStatement();
        if(s.executeUpdate(sql)>0)
            System.out.println("Dados inseridos!");
        else
            System.out.println("Erro ao inserir dados!");
        connection.close();
    }
            
}
