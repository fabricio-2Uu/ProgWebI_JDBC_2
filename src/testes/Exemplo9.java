/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes;

import classes.Pessoa;
import dao.PessoaDAO;
import java.sql.SQLException;

/**
 *
 * @author silviacb
 */
public class Exemplo9 {
    public static void main(String[] args) throws SQLException{  
        Pessoa p = new Pessoa("Silvia 4", "Rua X, 40");
        int pk = p.insert();
        System.out.println("PK = "+pk);
    }
}

