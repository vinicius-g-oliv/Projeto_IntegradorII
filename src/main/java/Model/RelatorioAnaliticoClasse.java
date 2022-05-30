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
public class RelatorioAnaliticoClasse {
    
    String nomeCliente;
    Date data;
    String produtos;
    int quantidade;
    
    public String getNomeCli() {
        return nomeCliente;
    }

    public void setNomeCli(String nome) {
        this.nomeCliente = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    public String getProdutos() {
        return produtos;
    }

    public void setProdutos(String prod) {
        this.produtos = prod;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int qtd) {
        this.quantidade = qtd;
    }
    
}
