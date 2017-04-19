package classes;

import dao.PessoaDAO;
import java.util.List;

/**
 *
 * @author Silvia Bertagnolli
 */
public class Pessoa {
    private int idPessoa;
    private String nome;
    private String endereco;

    public Pessoa(){}
    public Pessoa(String nome, String endereco){
        this(-1, nome, endereco);
    }
    public Pessoa(int idPessoa, String nome, String endereco) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.endereco = endereco;
    }
    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", endereco=" + endereco + '}';
    }  
    public int insert() {
        return new PessoaDAO().insert(this);
    }
    public List<Pessoa> listAll(){
        return new PessoaDAO().listAll();
    }

}
