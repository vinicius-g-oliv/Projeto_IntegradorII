/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Essa model representa as classes de entidade do Relatório
 * @author everymind
 * @see RelatorioDAO
 */
public class Relatorio {
    
    //atributos    
    String codigoProduto;
    String nomeCliente;
    Date dataVenda;
    double valorVenda;
    ArrayList<Venda> vendas = new ArrayList<Venda>();
    ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    ArrayList<ItemVenda> itemVenda = new ArrayList<ItemVenda>();
    //Construtor
    public Relatorio(){
    }
    
    //Getters e Setters 
    public ArrayList<ItemVenda> getItemVenda(){
        return this.itemVenda;
    }
    
    public void setItemVenda(ArrayList<ItemVenda> itens){
        this.itemVenda = itens;
    }
    
    public ArrayList<Cliente> getCliente(){
        return this.clientes;
    }
    
    public void setClientes(ArrayList<Cliente> clientes){
        this.clientes = clientes;
    }
    
    public ArrayList<Venda> getVenda(){
        return this.vendas;
    }
    
    public void setVendas(ArrayList<Venda> vendas){
        this.vendas = vendas;
    }
    
    public String getCodigoProduto(){
        return this.codigoProduto;
    }

    public void setCodigoProduto(String novoProduto){
        this.codigoProduto = novoProduto;
    }
    
    public String getNomeCliente(){
        return this.nomeCliente;
    }

    public void setNomeCliente(String novoCliente){
        this.nomeCliente = novoCliente;
    }
    
    public void setCpf(String nomeCliente){
        this.nomeCliente = nomeCliente;
    }
    
    public Date getDataVenda(){
        return this.dataVenda;
    }
    
    public void setDataVenda(Date novaData){
        this.dataVenda = novaData;
    }
    
     public double getvalorVenda(){
        return this.valorVenda;
    }
    
    public void setValorVenda(double valor){
        this.valorVenda = valor;
    }

    public void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}