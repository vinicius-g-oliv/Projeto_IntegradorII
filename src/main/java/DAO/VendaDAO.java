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
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author everymind
 */
public class VendaDAO {

    static utils.GerenciadorConexao gc = new GerenciadorConexao();
    static Connection conexao = null;
    static String LOGIN = gc.getLOGIN();
    static String SENHA = gc.getSENHA();
    static String URL = gc.getURL();
    static Statement stmt = null;

    /**
     * Método para inserir uma venda no banco de dados
     * @param venda
     * @return void
     * @throws SQLException
     */
    public static void inserir(Venda venda) throws SQLException {
        String sql = "INSERT INTO venda (id_cliente, data_venda, valor) VALUES (?, ?, ?)";
        conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
        java.sql.PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, venda.getId_cliente());
        stmt.setDate(2, venda.getDataVenda());
        stmt.setDouble(3, venda.getValor());
        stmt.execute();
        conexao.close();
    }

    /**
     * Método para consultar uma venda no banco de dados
     * @param venda
     * @return Venda
     * @throws SQLException
     */
    public static Venda consultarVenda() throws SQLException {
        Venda venda = new Venda();
        String sql = "SELECT * FROM venda WHERE id_cliente = ? AND id_produto = ? AND dataVenda = ?;";
        return venda;
    }

    /**
     * Método para consultar vendas no banco de dados
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

    /**
     * Método para obter o id de uma venda no banco de dados
     * @return int id
     */
    public static int getIdVenda() {
        int idVenda = 0;
        String sql = "SELECT MAX(id_venda) FROM venda";
        try {
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            stmt = conexao.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                idVenda = rs.getInt("MAX(id_venda)");
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar id da venda: " + ex.getMessage());
        }
        return idVenda;
    }
    
}