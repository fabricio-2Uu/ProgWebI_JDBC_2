/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Cpf;
import dao.CpfDAO;
import classes.Empregado;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author silviacb
 */
public class EmpregadoDAO implements GenericDAO<Empregado>{

    
     @Override
    public int insert(Empregado em) {
        int chavePrimaria = -1;
        int idCpf = new CpfDAO().insert(em.getCpf());
        try(Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = 
                connection.prepareStatement(SQLs.INSERT_EMPREGADO.getSql(),
                        Statement.RETURN_GENERATED_KEYS)){
        System.out.println("Conexão aberta!");
        stmt.setString(1, em.getNome());
        stmt.setString(2, em.getEndereco());
        stmt.setString(3, em.getTelefone());
        stmt.setInt(4, idCpf);
        
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
    public int update(Empregado em) {
        int chavePrimaria = em.getIdEmpregado();
        String nome = em.getNome();
        String endereco = em.getEndereco();
        String telefone = em.getTelefone();
        try(Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = 
                connection.prepareStatement("update empregado set logradouro = ?, complemento = ?, uf = ? where idEndereco = ?")){
        System.out.println("Conexão aberta!");
        stmt.setInt(4, chavePrimaria);
        stmt.setString(1, nome);
        stmt.setString(2, endereco);
        stmt.setString(3, telefone);
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
    public int delete(Empregado em) {
        int chavePrimaria = em.getIdEmpregado();
        try(Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = 
                connection.prepareStatement(SQLs.DELETE.getSql()))
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
    public  List<Empregado> listAll() {
        List<Empregado> lista = new LinkedList<>();
        
        try(Connection connection = new ConnectionFactory().getConnection();
            PreparedStatement stmt = 
                    connection.prepareStatement(SQLs.LISTALL.getSql())){
            
            System.out.println("Conexão aberta!");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                String nome= rs.getString("nome");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                int cpf = rs.getInt("cpf");
                lista.add(new Empregado(-1, nome, endereco, telefone));
            }
            return lista;
        }catch(SQLException e){ System.out.println("Exceção SQL");
        }catch(Exception e){  System.out.println("Exceção no código!");
        }
        return null;
    }
}
