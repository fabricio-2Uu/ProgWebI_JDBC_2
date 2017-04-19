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
public enum SQLs {
    INSERT_EMPREGADO("insert into empregado(nome, endereco) values (?, ?)"), 
    LISTALL("select * from empregado"),
    DELETE("delete from empregado where idEmpregado = ?");
    
    private final String sql;
    SQLs(String sql){
        this.sql = sql; 
    
    }

    public String getSql() {
        return sql;
    }    
}
