/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.lang.reflect.Array;
import java.sql.Date;
import java.util.ArrayList;

/**
 * Essa model representa as classes de entidade das Vendas
 * @author everymind
 * @see VendaDAO
 */
public class Venda {
    
 //atributos
    ArrayList<ItemVenda> itemDaVenda = new ArrayList<ItemVenda>();
    //String codigoCliente;
    int id_cliente;
    Date dataVenda;
    double valor;
    int id_venda;

    
    //Construtor
    public Venda(){
    }
    
    //getters and setters
    // public void setCodigoProduto(String codigo){
    //     this.codigoProduto = codigo;
    // } 
    
    // public int getQuantidade(){
    //     return this.quantidade;
    // }
    
    // public void setQuatidade(int qtd){
    //     this.quantidade = qtd;
    // }
    
     public double getValor(){
        return this.valor;
    }
    
    public void setValor(double novoValor){
        this.valor = novoValor;
    }
    
    public Date getData(){
        return this.dataVenda;
    }
    
    public void setData(Date data){
        this.dataVenda = data;
    }
    
    
     public int getId_venda(){
        return this.id_venda;
    }
    
    
    
}