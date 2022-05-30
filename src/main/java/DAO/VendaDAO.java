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
     * @return void
     * @throws SQLException
     */
    public static void inserir(Venda venda) throws SQLException {
    }

    /**
     * Método para inserir uma venda no banco de dados
     * @param venda
     * @return Venda
     * @throws SQLException
     */
    public static Venda consultarVenda() throws SQLException {
        Venda venda = new Venda();
        return venda;
    }

    /**
     * Método para inserir uma venda no banco de dados
     * @param venda
     * @return ArrayList
     * @throws SQLException
     */
    public static ArrayList<Venda> consultarVendas() throws SQLException {
        ArrayList<Venda> vendas = new ArrayList<>();
        String sql = "SELECT * FROM Venda";
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            Venda venda = new Venda();
            vendas.add(venda);
        }
        return vendas;
    }
    
}