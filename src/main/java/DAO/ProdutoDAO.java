/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author everymind
 */
import Model.Produto;
import utils.GerenciadorConexao;
import java.util.ArrayList;
import utils.GerenciadorConexao;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author everymind
 */
public class ProdutoDAO {
        private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; //Driver do Mysql 8.0
        static utils.GerenciadorConexao gc = new GerenciadorConexao();
        static String LOGIN = gc.getLOGIN();
        static String SENHA = gc.getSENHA();
        static String URL = gc.getURL();
        private static Connection conexao;
        static java.sql.Statement instrucaoSQL;
        
    public static ArrayList<Produto> consultar() throws ClassNotFoundException, SQLException
    {
        ArrayList<Produto> listaRetorno = new ArrayList<Produto>();
        conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
        instrucaoSQL = conexao.createStatement();
        Class.forName(DRIVER);
        ResultSet rs;            
        rs = ((java.sql.Statement) instrucaoSQL).executeQuery("SELECT * FROM produto;");
        if(rs != null) {
            while ( rs.next() ) {
                Produto p = new Produto();
                p.setCodigo(rs.getString("codigo"));
                p.setPreco(rs.getFloat("preco"));
                p.setNome(rs.getString("nome"));
                p.setQuantidadeEstoque(rs.getInt("CPF"));
                listaRetorno.add(p);
            }
        }
        return listaRetorno;
    }
    
    public static void inserir(Produto produto) throws SQLException, ClassNotFoundException {
        conexao = DriverManager.getConnection(gc.getURL(), gc.getLOGIN(), gc.getSENHA());
        String sql = "INSERT INTO produto (nome, codigo, preco, quantidadeEstoque) VALUES (?, ?, ?, ?)";
        java.sql.PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, produto.getNome());
        stmt.setString(2, produto.getCodigo());
        stmt.setFloat(3, produto.getPreco());
        stmt.setInt(4, produto.getQuantidadeEstoque());
        stmt.execute();
        stmt.close();
    }
    
     public static void deletar(Produto produto) throws SQLException {
        conexao = DriverManager.getConnection(gc.getURL(), gc.getLOGIN(), gc.getSENHA());
        String sql = "DELETE FROM produto WHERE codigo = ?";
        java.sql.PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, produto.getCodigo());
        stmt.execute();
        stmt.close();
    }
     
     public static void alterar(Produto produto) throws SQLException {
       conexao = DriverManager.getConnection(gc.getURL(), gc.getLOGIN(), gc.getSENHA());
       String sql = "UPDATE produto SET nome = ?, preco = ?, quantidadeEstoque = ?" + "WHERE codigo = ?";
       java.sql.PreparedStatement stmt = conexao.prepareStatement(sql);
       stmt.setString(1, produto.getNome());
       stmt.setFloat(2, produto.getPreco());
       stmt.setInt(3, produto.getQuantidadeEstoque());
       stmt.setString(4, produto.getCodigo());
       stmt.execute();
       stmt.close();   

    }
}
