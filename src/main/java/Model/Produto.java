/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * Essa model representa as classes de entidade de Produto
 * @author everymind
 * @see PrudutoDAO
 */
public class Produto {
    
    //Atributos
    String codigo;
    String nome;
    Double preco;
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
    
    public Double getPreco(){
        return this.preco;
    }
    
    public void setPreco(Double novoPreco){
        this.preco = novoPreco;
    }
}
