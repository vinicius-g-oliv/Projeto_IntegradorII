
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Model;


/**
 *
 * @author everymind
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Produto prod = new Produto();
        prod.setNome("teste1");
        Relatorio rel = new Relatorio();
        
        rel.setCodigoProduto(prod.nome);
        System.out.println("Nome: " + rel.getCodigoProduto());
       
               
    }
    
}