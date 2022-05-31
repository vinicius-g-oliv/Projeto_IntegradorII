/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 * Essa DAO representa o armazenamento dos relatórios de compras realizadas
 * pelos clientes.
 * A busca pode ser feita através de um período de datas.
 * Podem ser consultados relatório e relatório analítico
 * @author everymind
 * @see Relatorio
 * @see RelatorioAnalitico
 */
import Model.Produto;
import Model.Relatorio;
import Model.Venda;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.GerenciadorConexao;

/**
 *
 * @author everymind
 */
public class RelatorioDAO {
    
        static utils.GerenciadorConexao gc = new GerenciadorConexao();
        static String LOGIN = gc.getLOGIN();
        static String SENHA = gc.getSENHA();
        static String URL = gc.getURL();
        private static Connection conexao;
        static java.sql.Statement instrucaoSQL;
        
    /**
     * Método para consultar o relatório no banco de dados por data
     * @param inicio
     * @param fim
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static ArrayList<Relatorio> buscar(String inicio, String fim) throws ClassNotFoundException, SQLException
    {
        ArrayList<Relatorio> listaRetorno = new ArrayList<Relatorio>();
        conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
        instrucaoSQL = conexao.createStatement();
        String sql = "SELECT c.nome, v.valor, v.data_venda FROM venda as v INNER JOIN cliente AS c ON c.id_cliente = v.id_cliente WHERE data_venda BETWEEN ? AND ?;";
        java.sql.PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, inicio);
        stmt.setString(2, fim);
        ResultSet rs = stmt.executeQuery();
        if(rs != null) {
            while ( rs.next() ) {
                Relatorio rel = new Relatorio();
                rel.setNomeCliente(rs.getString("c.nome"));
                rel.setValorVenda(rs.getFloat("v.valor"));
                rel.setDataVenda(rs.getDate("v.data_venda"));
               
                listaRetorno.add(rel);
            }
        }
        return listaRetorno;
    }

   
}
