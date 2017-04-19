/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Silvia Bertagnolli
 */
public enum PessoaSQLs {
    INSERT("insert into pessoa(nome, endereco) values (?, ?)"), 
    LISTALL("select * from pessoa"),
    DELETE("delete from pessoa where idPessoa = ?");
    
    private final String sql;
    PessoaSQLs(String sql){
        this.sql = sql; 
    
    }

    public String getSql() {
        return sql;
    }    
}

