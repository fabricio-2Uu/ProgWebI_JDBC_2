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
public class Exemplo5 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
Connection connection = new ConnectionFactory().getConnection();
        System.out.println("Conexão aberta!");
        
        String sql = "insert into pessoa" +
                " (nome,endereco)" +
                " values (?,?)";
        PreparedStatement stmt = connection.prepareStatement(sql);
        // preenche os valores
        stmt.setString(1, "Silvia 2");
        stmt.setString(2, "Rua X, 20");
        System.out.println(sql);
        
       // executa
        stmt.execute();
        stmt.close();
 
        System.out.println("Dados Gravados!");

        connection.close();
    }
            
}
