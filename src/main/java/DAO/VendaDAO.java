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
public class VendaDAO {
    
      private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; //Driver do Mysql 8.0
        static utils.GerenciadorConexao gc = new GerenciadorConexao();
        static String LOGIN = gc.getLOGIN();
        static String SENHA = gc.getSENHA();
        static String URL = gc.getURL();
        private static Connection conexao;
        static java.sql.Statement instrucaoSQL;
        
      public static ArrayList<Venda> consultar() throws ClassNotFoundException, SQLException
    {
        ArrayList<Venda> listaRetorno = new ArrayList<Venda>();
        conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
        instrucaoSQL = conexao.createStatement();
        Class.forName(DRIVER);
        ResultSet rs;            
        rs = ((java.sql.Statement) instrucaoSQL).executeQuery("SELECT * FROM venda;");
        if(rs != null) {
            while ( rs.next() ) {
                Venda v = new Venda();
                v.setData(rs.getDate("data"));
                v.setValor(rs.getDouble("valor"));
                listaRetorno.add(v);
            }
        }
        return listaRetorno;
    }
    
      public static void inserir(Venda venda) throws SQLException, ClassNotFoundException {
        conexao = DriverManager.getConnection(gc.getURL(), gc.getLOGIN(), gc.getSENHA());
        String sql = "INSERT INTO venda (valor, data) VALUES (?, ?)";
        java.sql.PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setDouble(1, venda.getValor());
        stmt.setDate(2, venda.getData());
        stmt.execute();
        stmt.close();
    }
      
      public static void deletar(Venda venda) throws SQLException {
        conexao = DriverManager.getConnection(gc.getURL(), gc.getLOGIN(), gc.getSENHA());
        String sql = "DELETE FROM venda WHERE id_venda = ?";
        java.sql.PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, venda.getId_venda());
        stmt.execute();
        stmt.close();
    }
      

}