/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author everymind
 */
public class Produto {
    
    //Atributos
    String codigo;
    String nome;
    float preco;
    int quantidadeEstoque;
    
    //Construtor
    public Produto(){
    }
    
    //getters and setters
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidade) {
        this.quantidadeEstoque = quantidade;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String novoNome){
        this.nome = novoNome;
    }
    
    public String getCodigo(){
        return this.codigo;
    }
    
    public void setCodigo(String novoCodigo){
        this.codigo = novoCodigo;
    }
    
    public float getPreco(){
        return this.preco;
    }
    
    public void setPreco(float novoPreco){
        this.preco = novoPreco;
    }
}
