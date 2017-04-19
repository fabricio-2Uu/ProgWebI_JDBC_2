/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author 0682160
 */
public enum EnderecoSQLs {
    
    INSERT("insert into endereco(logradouro, complemento, uf) values (?,?,?)"), 
    LISTALL("select * from endereco"),
    DELETE("delete from endereco where idEndereco = ?");
    
    private final String sql;
    EnderecoSQLs(String sql){
        this.sql = sql; 
    
    }

    public String getSql() {
        return sql;
    }    
}
