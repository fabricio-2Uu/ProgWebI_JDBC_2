/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import dao.ConnectionFactory;
import classes.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author silviacb
 */
public class Exemplo6 {
    public static void main(String[] args) {
        
        try(Connection connection = new ConnectionFactory().getConnection();
             PreparedStatement stmt = connection.prepareStatement("insert into pessoa" +
                " (nome,endereco)" +
                " values (?,?)");){
        System.out.println("Conexão aberta!");
 
        Pessoa p = new Pessoa("Silvia 3", "Rua X, 30");
        stmt.setString(1, p.getNome());
        stmt.setString(2, p.getEndereco());

        //System.out.println(sql);
        // executa
        stmt.execute();
        System.out.println("Dados Gravados!");
        }catch(SQLException e){
            System.out.println("Exceção SQL");
        }catch(Exception e){
            System.out.println("Exceção no código!");
        }
    }
}
