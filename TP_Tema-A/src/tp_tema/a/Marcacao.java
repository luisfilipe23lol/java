/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_tema.a;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class Marcacao extends TP_TemaA {

    int ID = 0;
    int IDcliente = 0;
    int numero = 0;     //Numero veiculo
    Estado estado;
    String TotalGasto;
    String descricao;

    public Marcacao() {

    }

    public Marcacao(int ID, int IDcliente, int numero, Estado estado, String TotalGasto) {
        this.ID = ID;
        this.IDcliente = IDcliente;
        this.numero = numero;
        this.estado = estado;
        this.TotalGasto = TotalGasto;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIDcliente() {
        return IDcliente;
    }

    public void setIDcliente(int IDcliente) {
        this.IDcliente = IDcliente;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getTotalGasto() {
        return TotalGasto;
    }

    public void setTotalGasto(String TotalGasto) {
        this.TotalGasto = TotalGasto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    

    

    @Override
    public String toString() {
        return this.ID + "," + this.IDcliente + "," + this.numero + "," + this.estado + "," + this.TotalGasto+","+ this.descricao;
    }

    String setTotalGasto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
