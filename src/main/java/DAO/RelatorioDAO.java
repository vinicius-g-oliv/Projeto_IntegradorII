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
import java.sql.Statement;
import java.util.ArrayList;
import utils.GerenciadorConexao;

/**
 *
 * @author everymind
 */
public class RelatorioDAO {
    
  private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; //Driver do Mysql 8.0
        static utils.GerenciadorConexao gc = new GerenciadorConexao();
        static String LOGIN = gc.getLOGIN();
        static String SENHA = gc.getSENHA();
        static String URL = gc.getURL();
        private static Connection conexao;
        static java.sql.Statement instrucaoSQL;
        
    public static ArrayList<Relatorio> buscar() throws ClassNotFoundException, SQLException
    {
        ArrayList<Relatorio> listaRetorno = new ArrayList<Relatorio>();
        conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
        instrucaoSQL = conexao.createStatement();
        Class.forName(DRIVER);
        ResultSet rs;            
        rs = ((java.sql.Statement) instrucaoSQL).executeQuery("SELECT c.nome, v.valorVenda, v.dataVenda FROM venda as v INNER JOIN clientes AS c ON v.id_cliente = c.id_cliente WHERE dataVenda BETWEEN ? AND ? ;");
        if(rs != null) {
            while ( rs.next() ) {
                Relatorio rel = new Relatorio();
                rel.setNomeCliente(rs.getString("nomeCliente"));
                rel.setValorVenda(rs.getFloat("valorVenda"));
                rel.setDataVenda(rs.getDate("dataVenda"));
               
                listaRetorno.add(rel);
            }
        }
        return listaRetorno;
    }

   
}
