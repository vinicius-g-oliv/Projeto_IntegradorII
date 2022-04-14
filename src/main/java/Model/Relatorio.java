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
    
   /* public String getDataNascimento(){
        return this.dataNascimento;
    }
    
    public void setDataNascimento(String novaData){
        this.dataNascimento = novaData;
    }
    
     public String getEmail(){
        return this.email;
    }
    
    public void setEmail(String novoEmail){
        this.dataNascimento = novoEmail;
    }
    
     public String getSexo(){
        return this.sexo;
    }
    
    public void setSexo(String novoSexo){
        this.sexo = novoSexo;
    }*/
    
    
}
