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
public class Exemplo2 {
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        Connection connection = new ConnectionFactory().getConnection();
        System.out.println("Conexão aberta!");
        connection.close();
    }
}
