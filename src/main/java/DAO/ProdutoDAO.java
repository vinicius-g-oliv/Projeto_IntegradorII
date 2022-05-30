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
                p.setCodigo(rs.getString("id_produto"));
                p.setPreco(rs.getDouble("preco"));
                p.setNome(rs.getString("nome"));
                p.setQuantidadeEstoque(rs.getInt("quantidade_estoque"));
                listaRetorno.add(p);
            }
        }
        return listaRetorno;
    }

    public static Produto consultarProduto(int id_produto) throws ClassNotFoundException, SQLException
    {
        Produto p = new Produto();
        conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
        instrucaoSQL = conexao.createStatement();
        Class.forName(DRIVER);
        ResultSet rs;            
        rs = ((java.sql.Statement) instrucaoSQL).executeQuery("SELECT * FROM produto WHERE id_produto = "+id_produto+";");
        if(rs != null) {
            while ( rs.next() ) {
                p.setCodigo(rs.getString("id_produto"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                p.setQuantidadeEstoque(rs.getInt("quantidade_estoque"));
            }
        }
        return p;
    }
    
    public static ArrayList<Produto> consultarPorNome(String nome) throws ClassNotFoundException, SQLException
    {
        ArrayList<Produto> listaRetorno = new ArrayList<Produto>();
        
        try{
        conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            String sql = "SELECT * FROM produto WHERE nome LIKE ?";
            java.sql.PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, "%"+nome+"%");
            java.sql.ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produto p = new Produto();
                p.setCodigo(rs.getString("id_produto"));
                p.setPreco(rs.getDouble("preco"));
                p.setNome(rs.getString("nome"));
                p.setQuantidadeEstoque(rs.getInt("quantidade_estoque"));
                listaRetorno.add(p);
            }
            rs.close();
            stmt.close();
        }catch (SQLException e) {
            System.out.println("Erro ao consultar produto: " + e.getMessage());
        }
        return listaRetorno;
    }
    
    public static ArrayList<Produto> consultarPorCodigo(int id_produto) throws ClassNotFoundException, SQLException
    {
        ArrayList<Produto> listaRetorno = new ArrayList<Produto>();
        
        try{
        conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            String sql = "SELECT * FROM produto WHERE id_produto LIKE ?";
            java.sql.PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id_produto); 
            java.sql.ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produto p = new Produto();
                p.setCodigo(rs.getString("id_produto"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                p.setQuantidadeEstoque(rs.getInt("quantidade_estoque"));
                listaRetorno.add(p);
            }
            rs.close();
            stmt.close();
        }catch (SQLException e) {
            System.out.println("Erro ao consultar produto: " + e.getMessage());
        }
        return listaRetorno;
    }
    
    public static void inserir(Produto produto) throws SQLException, ClassNotFoundException {
        conexao = DriverManager.getConnection(gc.getURL(), gc.getLOGIN(), gc.getSENHA());
        String sql = "INSERT INTO produto (nome, id_produto, preco, quantidade_estoque) VALUES (?, ?, ?, ?)";
        java.sql.PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, produto.getNome());
        stmt.setString(2, produto.getCodigo());
        stmt.setDouble(3, produto.getPreco());
        stmt.setInt(4, produto.getQuantidadeEstoque());
        stmt.execute();
        stmt.close();
    }
    
     public static void deletar(int id_produto) throws SQLException {
        conexao = DriverManager.getConnection(gc.getURL(), gc.getLOGIN(), gc.getSENHA());
        String sql = "DELETE FROM produto WHERE id_produto = ?";
        java.sql.PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, id_produto);
        stmt.execute();
        stmt.close();
    }
     
     public static void alterar(Produto produto) throws SQLException {
       conexao = DriverManager.getConnection(gc.getURL(), gc.getLOGIN(), gc.getSENHA());
       String sql = "UPDATE produto SET nome = ?, preco = ?, quantidade_estoque = ?" + "WHERE id_produto = ?";
       java.sql.PreparedStatement stmt = conexao.prepareStatement(sql);
       stmt.setString(1, produto.getNome());
       stmt.setDouble(2, produto.getPreco());
       stmt.setInt(3, produto.getQuantidadeEstoque());
       stmt.setString(4, produto.getCodigo());
       stmt.execute();
       stmt.close();   

    }
}
