/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Date;

/**
 *
 * @author everymind
 */
public class Relatorio {
    
    //atributos    
    String codigoProduto;
    String nomeCliente;
    Date dataVenda;
    double valorVenda;
    
    //Construtor
    public Relatorio(){
    }
    
    //Getters e Setters    
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
    
    public Date dataVenda(){
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
    
    
}