/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Pessoa;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author silviacb
 */
public class PessoaDAO implements GenericDAO<Pessoa>{
    @Override
    public int insert(Pessoa p) {
        int chavePrimaria = -1;
        try(Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = 
                connection.prepareStatement(PessoaSQLs.INSERT.getSql())){
        System.out.println("Conexão aberta!");
        stmt.setString(1, p.getNome());
        stmt.setString(2, p.getEndereco());
        stmt.execute();
        System.out.println("Dados Gravados!");
        ResultSet chaves = stmt.getGeneratedKeys();
        if (chaves.next())  chavePrimaria= chaves.getInt(1);
        }catch(SQLException e){
                System.out.println("exceção com recursos");
        }catch(ClassNotFoundException e){
            System.out.println("Classe não encontrada!");
        }
        return chavePrimaria;
       
    }
    @Override
    public int update(Pessoa p) {
        int chavePrimaria = p.getIdPessoa();
        String nome = p.getNome();
        String endereco = p.getEndereco();
        try(Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = 
                connection.prepareStatement("update pessoa set nome = ?, endereco = ?, where idPessoa = ?")){
        System.out.println("Conexão aberta!");
        stmt.setInt(1, chavePrimaria);
        stmt.setString(2, nome);
        stmt.setString(3, endereco);
        System.out.println("Dados Atualizados!");
        return stmt.executeUpdate();
        }catch(SQLException e){
                System.out.println("exceção com recursos");
        }catch(ClassNotFoundException e){
            System.out.println("Classe não encontrada!");
        }
        return chavePrimaria;
       
    }
     @Override
    public int delete(Pessoa p) {
        int chavePrimaria = p.getIdPessoa();
        try(Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = 
                connection.prepareStatement(PessoaSQLs.DELETE.getSql()))
        {
        System.out.println("Conexão aberta!");
        stmt.setInt(1, chavePrimaria);
        System.out.println("Dados Deletados!");
        return stmt.executeUpdate();
        }catch(SQLException e){
                System.out.println("exceção com recursos");
        }catch(ClassNotFoundException e){
            System.out.println("Classe não encontrada!");
        }
        return 0;
       
    }
    @Override
    public  List<Pessoa> listAll() {
        List<Pessoa> lista = new LinkedList<>();
        
        try(Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement stmt = 
                    connection.prepareStatement(PessoaSQLs.LISTALL.getSql())){
            
            System.out.println("Conexão aberta!");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                lista.add(new Pessoa(nome, endereco));
            }
            return lista;
        }catch(SQLException e){ System.out.println("Exceção SQL");
        }catch(Exception e){  System.out.println("Exceção no código!");
        }
        return null;
    }
}
