/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import classes.Endereco;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author 0682160
 */
public class EnderecoDAO implements GenericDAO<Endereco>{
    
     @Override
    public int insert(Endereco en) {
        int chavePrimaria = -1;
        try(Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = 
                connection.prepareStatement(PessoaSQLs.INSERT.getSql())){
        System.out.println("Conexão aberta!");
        stmt.setString(1, en.getLogradouro());
        stmt.setString(2, en.getComplemento());
        stmt.setString(2, en.getUf());
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
    public int update(Endereco en) {
        int chavePrimaria = en.getIdEndereco();
        String logradouro = en.getLogradouro();
        String complemento = en.getComplemento();
        String uf = en.getUf();
        try(Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = 
                connection.prepareStatement("update endereco set logradouro = ?, complemento = ?, uf = ? where idEndereco = ?")){
        System.out.println("Conexão aberta!");
        stmt.setInt(4, chavePrimaria);
        stmt.setString(1, logradouro);
        stmt.setString(2, complemento);
        stmt.setString(3, uf);
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
    public int delete(Endereco en) {
        int chavePrimaria = en.getIdEndereco();
        try(Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = 
                connection.prepareStatement(EnderecoSQLs.DELETE.getSql()))
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
    public  List<Endereco> listAll() {
        List<Endereco> lista = new LinkedList<>();
        
        try(Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement stmt = 
                    connection.prepareStatement(EnderecoSQLs.LISTALL.getSql())){
            
            System.out.println("Conexão aberta!");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String logradouro= rs.getString("logradouro");
                String complemento = rs.getString("complemento");
                String uf = rs.getString("uf");
                lista.add(new Endereco(logradouro, complemento, uf));
            }
            return lista;
        }catch(SQLException e){ System.out.println("Exceção SQL");
        }catch(Exception e){  System.out.println("Exceção no código!");
        }
        return null;
    }
}
