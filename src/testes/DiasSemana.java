/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questao3;

/**
 *
 * @author silviacb
 */
public enum DiasSemana {
    DOMINGO(1),SEGUNDA(2),TERCA(3),QUARTA(4),QUINTA(5),SEXTA(6),SABADO(7);  
    private final int valor;  
    // construtor private
    // usado somente pela próprie Enum
    private DiasSemana(int valor){   
      this.valor= valor;  
    }  

    public int getValor() {
        return valor;
    }
    @Override
    public String toString(){
        return this.name() + " - " + valor;
    }
}
