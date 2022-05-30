/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Essa model representa as classes de entidade das Vendas
 * @author everymind
 * @see VendaDAO
 */
public class Venda {
    
 //atributos
    int id_venda;
    int id_cliente;
    java.sql.Date dataVenda;
    Double valor;

    //Construtor
    public Venda(){
    }

    public int getId_venda() {
        return id_venda;
    }

    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getValor(){
        return this.valor;
    }
    
    public void setValor(Double novoValor){
        this.valor = novoValor;
    }
    
    public Date getData(){
        return this.dataVenda;
    }
    
    public void setData(Date data){
        this.dataVenda = data;
    }
    
    
    
}