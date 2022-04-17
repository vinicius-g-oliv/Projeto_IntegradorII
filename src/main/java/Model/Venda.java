/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author everymind
 */
public class Venda {
    
    //atributos
    String nomeProduto;
    String codigoCliente;
    String dataVenda;
    int quantidade;
    double valor;
    
    //Construtor
    public Venda(){
    }
    
    //getters and setters
    public String getNomeProduto(){
        return this.nomeProduto;
    }

    public void setNomeProduto(String novoNome){
        this.nomeProduto = novoNome;
    }
    
    public String getCodigoCliente(){
        return this.codigoCliente;
    }
    
    public void setCodigoCliente(String novoCodigo){
        this.codigoCliente = novoCodigo;
    }
    
    public int getQuantidade(){
        return this.quantidade;
    }
    
    public void setQuatidade(int qtd){
        this.quantidade = qtd;
    }
    
     public double getValor(){
        return this.valor;
    }
    
    public void setValor(double novoValor){
        this.valor = novoValor;
    }
    
    public String getData(){
        return this.dataVenda;
    }
    
    public void setData(String data){
        this.dataVenda = data;
    }
    
    
    
}