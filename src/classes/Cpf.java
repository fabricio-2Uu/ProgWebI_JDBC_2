/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author Silvia
 */
public class Cpf {
    private int idCpf;
    private long numero;
    private int digito;

    public Cpf(int idCpf, long numero, int digito) {
        this.idCpf = idCpf;
        this.numero = numero;
        this.digito = digito;
    }

    public Cpf(long numero, int idCpf) {
        this.idCpf = idCpf;
        this.numero = numero;
    }

    
    public int getIdCpf() {
        return idCpf;
    }

    public long getNumero() {
        return numero;
    }

    public int getDigito() {
        return digito;
    }

    public void setIdCpf(int idCpf) {
        this.idCpf = idCpf;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public void setDigito(int digito) {
        this.digito = digito;
    }

    
}
