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
public class Cliente {

    //Atributos
    int id_cliente;
    String nome;
    String cpf;
    Date dataNascimento;
    String email;
    String sexo;
    String cep;
    String endereco;
    int numero;
    String complemento;
    String estadoCivil;
    
    //Construtor
    public Cliente(){
    }
    
    //Getters e Setters    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public String getNome(){
        return this.nome;
    }

    public void setNome(String novoNome){
        this.nome = novoNome;
    }
    
    public String getCpf(){
        return this.cpf;
    }
    
    public void setCpf(String novoCpf){
        this.cpf = novoCpf;
    }
    
    public Date getDataNascimento(){
        return this.dataNascimento;
    }
    
    public void setDataNascimento(Date novaData){
        this.dataNascimento = novaData;
    }
    
     public String getEmail(){
        return this.email;
    }
    
    public void setEmail(String novoEmail){
        this.email= novoEmail;
    }
    
     public String getSexo(){
        return this.sexo;
    }
    
    public void setSexo(String novoSexo){
        this.sexo = novoSexo;
    }
    
     public String getCep(){
        return this.cep;
    }
    
    public void setCep(String novoCep){
        this.cep = novoCep;
    }
    
     public String getEndereco(){
        return this.endereco;
    }
    
    public void setEndereco(String novoEndereco){
        this.endereco = novoEndereco;
    }
     public String getComplemento(){
        return this.complemento;
    }
    
    public void setComplemento(String novoComplemento){
        this.complemento = novoComplemento;
    }
     public String getEstadoCivil(){
        return this.estadoCivil;
    }
    
    public void setEstadoCivil(String novoEC){
        this.estadoCivil = novoEC;
    }
    
           
    
}