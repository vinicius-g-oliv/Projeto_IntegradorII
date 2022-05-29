/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 * Essa DAO representa o armazenamento das vendas realizadas
 * São feitas através do número de CPF do cliente
 * e depois da continuidade para a compra.
 * Assim, fica armazenado nos relatórios as vendas feitas.
 * @author everymind
 * @see TelaVendas
 * @see Relatorio
 * @see RelatorioAnalitico
 */
import Model.Venda;
import utils.GerenciadorConexao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author everymind
 */
public class VendaDAO {

    static final utils.GerenciadorConexao gc = new GerenciadorConexao();
    static final Connection conexao = null;
    static final String LOGIN = gc.getLOGIN();
    static final String SENHA = gc.getSENHA();
    static final String URL = gc.getURL();
    static final Statement stmt = null;

    /**
     * Método para inserir uma venda no banco de dados
     * @param venda
     * @return
     * @throws SQLException
     */


    //consulta
    //inserir

    public static void consultar(){
        //TODO
    }

    public static void inserir(Venda venda) throws SQLException {
        //TODO: inserir venda no banco de dados
    }

    // public static ArrayList<Venda> consultarProdutos() throws ClassNotFoundException, SQLException
    //     {
    //     ArrayList<Venda> listaRetorno = new ArrayList<Venda>();
    //     try {
        
    //         Class.forName(DRIVER);
    //         //conexao = DriverManager.getConnection(url, LOGIN, SENHA);
    //         Statement instrucaoSQL = (Statement) (ResultSet) conexao.createStatement();
    //         ResultSet rs;
            
    //         rs = instrucaoSQL.executeQuery("SELECT * FROM produto;");
    //         if(rs != null){
    //             while ( rs.next() ) {
    //             Venda v = new Venda();
    //             v.setData(rs.getDate("data"));
    //             //TODO: Criar um construtor que recebe os valores
    //             // v.setQuatidade(rs.getInt("quantidade"));
    //             v.setValor(rs.getDouble("valor"));
                              
    //             listaRetorno.add(v);
    //             }
    //         }
    //         else
    //         {
    //             throw new SQLException();
    //         }
    //     }catch (SQLException e) {
    //         listaRetorno = null;
    //     }catch (ClassNotFoundException ex) {
    //         listaRetorno = null;
    //     } finally{
       
    //     /*try {
    //         Object rs;
    //         if(rs!=null)
    //             rs.close();
    //         if(instrucaoSQL!=null)
    //             instrucaoSQL.close();
    //         if(conexao!=null)
    //             conexao.close();
    //     } catch (SQLException ex) {
    //     }
    //     }*/
    //         return listaRetorno;
    //     }
    
}