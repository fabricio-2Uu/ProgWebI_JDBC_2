/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import classes.Pessoa;
import dao.ConnectionFactory;
import java.sql.*;

/**
 *
 * @author Silvia
 */
public class Exemplo8 {
public static void main(String[] args) throws SQLException, ClassNotFoundException{
    int chavePrimaria = -1;
        Connection connection = new ConnectionFactory().getConnection();
        Pessoa p = new Pessoa("Beltrano", "Rua Z, 300");
        System.out.println("Conexão aberta!");
        String sql = "insert into pessoa (nome,endereco) values (?,?)"; 
        PreparedStatement stmt = 
                        connection.prepareStatement(sql, 
                 Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, p.getNome());
        stmt.setString(2, p.getEndereco());
        stmt.execute();
        ResultSet chaves = stmt.getGeneratedKeys();
        if (chaves.next())  chavePrimaria= chaves.getInt(1);
        System.out.println("PK = " + chavePrimaria);
    }
}
