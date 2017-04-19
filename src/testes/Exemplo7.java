/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import classes.Pessoa;
import dao.ConnectionFactory;
import java.sql.*;
import java.util.LinkedList;

/**
 *
 * @author Silvia
 */
public class Exemplo7 {
        public static void main(String[] args) throws SQLException, ClassNotFoundException{

        /*
            14)	Crie o Exemplo7.java que deve ler no banco de dados 
            (tabela pessoa) vários objetos do tipo Pessoa. 
            Esses objetos podem estar armazenados em um vetor ou 
            em uma coleção. 
            Após, im-prima essa coleção e verifique se todos os
            dados do banco de dados foram carregados.
            */
        LinkedList<Pessoa> lista = new LinkedList<>();
        
        Connection connection = new ConnectionFactory().getConnection();
        System.out.println("Conexão aberta!");
        
        String sql = "Select * from pessoa";
        
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            int idPessoa = rs.getInt("idpessoa");
            String nome = rs.getString("nome");
            String endereco = rs.getString("endereco");
            //adiciona os objetos na lista
            lista.add(new Pessoa(idPessoa, nome, endereco));
        }      
    }
}
