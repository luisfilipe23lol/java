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
public class Cliente {

    private int ID;
    private String nome = "";
    private String morada = "";
    private Veiculo veiculos[];

    public Cliente(int ID, String nome, String morada) {
        this.ID = ID;
        this.nome = nome;
        this.morada = morada;
    }

    Cliente(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public Veiculo[] getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(Veiculo[] veiculos) {
        this.veiculos = veiculos;
    }

    @Override
    public String toString() {
        return this.ID + "," + this.nome + "," + this.morada;
        
    }

}
