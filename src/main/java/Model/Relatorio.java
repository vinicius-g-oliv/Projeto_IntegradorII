/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author everymind
 */
public class Relatorio {
    
    //atributos    
    String codigoProduto;
    String nomeCliente;
    String dataVenda;
    double valorVenda;
    
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
    
    public void setCpf(String nomeCliente){
        this.nomeCliente = nomeCliente;
    }
    
    public String dataVenda(){
        return this.dataVenda;
    }
    
    public void setDataVenda(String novaData){
        this.dataVenda = novaData;
    }
    
     public double getvalorVenda(){
        return this.valorVenda;
    }
    
    public void setvalorVenda(double valor){
        this.valorVenda = valor;
    }
    
    
}