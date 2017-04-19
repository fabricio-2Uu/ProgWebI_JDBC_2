/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Cpf;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author silviacb
 */
public class CpfDAO implements GenericDAO<Cpf>{

    public int insert(Cpf cpf){
        
        return 0;
    }
    
    public int update(Cpf cpf){
        
        return 0;
    }
    
    public int delete(Cpf cpf){
        
        return 0;
    }
    
    public java.util.List<Cpf> listAll(){
        List<Cpf> lista = new LinkedList<Cpf>();
        
        return lista;
    }
    
    public Cpf find (Connection con, int idCpf){
        try{
            PreparedStatement stmt = 
                    con.prepareStatement("select * from cpf where idcpf=?");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                long numero = rs.getLong("numero");
                int digito = rs.getInt("digito");
                return new Cpf(numero, digito);
            }
        }catch(SQLException e){
            System.out.println("Exceção find CpfDAO");
        }
        return null;
    }
}
