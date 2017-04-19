package classes;

import dao.EmpregadoDAO;
import dao.PessoaDAO;
import java.util.List;

/**
 *
 * @author Silvia Bertagnolli
 */
public class Empregado {
    private int idEmpregado;
    private String nome;
    private String endereco;
    private String telefone;
    private Cpf cpf;

    public Empregado(int idEmpregado, String nome, String endereco, String telefone, Cpf cpf) {
        this.idEmpregado = idEmpregado;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public Empregado(int idEmpregado, String nome, String endereco, String telefone) {
        this.idEmpregado = idEmpregado;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }
    
    

    public int getIdEmpregado() {
        return idEmpregado;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public Cpf getCpf() {
        return cpf;
    }

    public void setIdEmpregado(int idEmpregado) {
        this.idEmpregado = idEmpregado;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCpf(Cpf cpf) {
        this.cpf = cpf;
    }

    

}
