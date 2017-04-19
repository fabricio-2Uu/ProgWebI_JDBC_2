/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import dao.PessoaDAO;
import java.util.List;

/**
 *
 * @author Silvia
 */
public class Endereco {
    private int idEndereco;
    private String logradouro;
    private String complemento;
    private String uf;

    public Endereco(){}
    public Endereco(String logradouro, String complemento, String uf) {
        this(-1, logradouro, complemento, uf);
    }
    public Endereco(int idEndereco, String logradouro, String complemento, String uf) {
        this.idEndereco = idEndereco;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.uf = uf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "Endereco{" + "logradouro=" + logradouro + ", complemento=" + complemento + ", uf=" + uf + '}';
    }
     public int insert() {
        return -1;
    }
    public List<Endereco> listAll(){
        return null;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }
    
}
