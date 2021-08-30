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
public class Gestor {
    private int ID = 0;
    private String nome = "";
    private String morada = "";
    
    public Gestor (int ID, String nome, String morada){
        this.ID = ID;
        this.nome=nome;
        this.morada=morada;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }
    
    
}
