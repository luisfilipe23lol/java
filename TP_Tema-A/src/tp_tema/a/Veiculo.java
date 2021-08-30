/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_tema.a;

/**
 *
 * @author bruno
 */
public class Veiculo {
    private int numero = 0;
    private String marca = "";
    private int ano = 0;
    
    
    public Veiculo (int numero, String marca, int ano){
        this.numero=numero;
        this.marca=marca;
        this.ano=ano;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
    
    @Override 
    public String toString(){
        return this.numero+","+this.marca+","+this.ano;
    }
    
    
    
}

