/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package questoes4a6;

/**
 *
 * @author silviacb
 */
public class TestesEnumMarcas {
    public static void main(String[] args) {
	Marcas marca = Marcas.HP;	
	System.out.println("Nome da Marca = "+marca.name());
        for (Marcas m : marca.values()) {
            System.out.println("m="+m);           
        }
    }
}
