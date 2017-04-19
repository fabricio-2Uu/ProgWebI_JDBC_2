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
 * @author Silvia
 */
public class Exemplo3 {
        public static void main(String[] args) throws SQLException, ClassNotFoundException{
        //estabelece uma conexão com o BD
        Connection connection = new ConnectionFactory().getConnection();
        System.out.println("Conexão aberta!");
        //monta a consulta SQL
        String sql = "Select nome from pessoa";
        //cria o statement que aponta para o banco
        Statement stmt = connection.createStatement();
        //executa a consulta e monta a tabela resultante
        ResultSet rs = stmt.executeQuery(sql);
        //aponta para a 1a linha e percorre os registros
        while(rs.next()){
            int idPessoa = rs.getInt(1);
            String nome = rs.getString("nome");
            String endereco = rs.getString("endereco");
            System.out.println("Dados = "+idPessoa + " " + nome + " " + endereco);
        }    
        connection.close();
    }
}
