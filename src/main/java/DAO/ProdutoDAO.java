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
        static String DRIVER = "com.mysql.cj.jdbc.Driver"; //Driver do Mysql 8.0
        static utils.GerenciadorConexao gc = new GerenciadorConexao();
        static String LOGIN = gc.getLOGIN();
        static String SENHA = gc.getSENHA();
        static String URL = gc.getURL();
        private static Connection conexao;
        static java.sql.Statement instrucaoSQL;
        
    /**
     * Método para consultar um produto no banco de dados
     * @param produto
     * @return ArrayList<Produto>
     */
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

    /**
     * Método para consultar um produto no banco de dados
     * @param produto
     * @return Produto
     */
    public static Produto consultarProduto(int id_produto) throws SQLException {
        if(verificarProdutoExistente(id_produto) == false){
            throw new SQLException("Produto Não Encontrado");
        }
        Produto p = new Produto();
        conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
        instrucaoSQL = conexao.createStatement();
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
    
    /**
     * Método para verificar se um produto existe no banco de dados
     * @param produto
     * @return boolean false se não existir, true se existir
     */
    private static boolean verificarProdutoExistente(int id_produto) throws SQLException {
        conexao = DriverManager.getConnection(gc.getURL(), gc.getLOGIN(), gc.getSENHA());
        String sql = "SELECT * FROM produto WHERE id_produto = ?";
        java.sql.PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, id_produto);
        java.sql.ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return true;
        }
        return false;
    }

    /**
     * Método para consultar um produto no banco de dados por nome
     * @param String nome
     * @return ArrayList<Produto>
     */
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
    
    /**
     * Método para consultar um produto no banco de dados por codigo (id_produto)
     * @param id_produto
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
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
    
    /**
     * Método para consultar um produto no banco de dados por preço
     * @param preco
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void inserir(Produto produto) throws SQLException, ClassNotFoundException {
        if(verificarProdutoExistente(produto.getCodigo())){
            throw new SQLException("Produto já existente\n"+"Se deseja alterar o produto, clique em \"ALTERAR\"");
        }
        conexao = DriverManager.getConnection(gc.getURL(), gc.getLOGIN(), gc.getSENHA());
        String sql = "INSERT INTO produto (nome, preco, quantidade_estoque) VALUES (?, ?, ?)";
        java.sql.PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, produto.getNome());
        stmt.setDouble(2, produto.getPreco());
        stmt.setInt(3, produto.getQuantidadeEstoque());
        stmt.execute();
        stmt.close();
    }
    
    /**
     * Método para verificar um produto no banco de dados
     * @param id_produto
     * @return boolean false se não existir, true se existir
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private static boolean verificarProdutoExistente(String id_produto) throws ClassNotFoundException, SQLException {
        conexao = DriverManager.getConnection(gc.getURL(), gc.getLOGIN(), gc.getSENHA());
        String sql = "SELECT * FROM produto WHERE id_produto = ?";
        java.sql.PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, id_produto);
        java.sql.ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return true;
        }
        return false; //se não existir, retorna false
    }

    /**
     * Método para deletar um produto no banco de dados
     * @param int id_produto
     * @throws SQLException
     */
    public static void deletar(int id_produto) throws SQLException {
        conexao = DriverManager.getConnection(gc.getURL(), gc.getLOGIN(), gc.getSENHA());
        String sql = "DELETE FROM produto WHERE id_produto = ?";
        java.sql.PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, id_produto);
        stmt.execute();
        stmt.close();
    }
     
    /**
     * Método para alterar um produto no banco de dados
     * @param Produto produto
     * @return Produto
     * @throws SQLException
     */
    public static Produto alterar(Produto produto) throws SQLException {
       conexao = DriverManager.getConnection(gc.getURL(), gc.getLOGIN(), gc.getSENHA());
       String sql = "UPDATE produto SET nome = ?, preco = ?, quantidade_estoque = ? WHERE id_produto = ?";
       java.sql.PreparedStatement stmt = conexao.prepareStatement(sql);
       stmt.setString(1, produto.getNome());
       stmt.setDouble(2, produto.getPreco());
       stmt.setInt(3, produto.getQuantidadeEstoque());
       stmt.setString(4, produto.getCodigo());
       stmt.execute();
       stmt.close();
       return produto;
    }

    /**
     * Método para consultar o último produto no banco de dados
     * @return Produto
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Produto buscarUltimo() throws ClassNotFoundException, SQLException {
        Produto p = new Produto();
        try {
            conexao = DriverManager.getConnection(gc.getURL(), gc.getLOGIN(), gc.getSENHA());
            String sql = "SELECT * FROM produto ORDER BY id_produto DESC LIMIT 1";
            java.sql.PreparedStatement stmt = conexao.prepareStatement(sql);
            java.sql.ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                p.setCodigo(rs.getString("id_produto"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                p.setQuantidadeEstoque(rs.getInt("quantidade_estoque"));
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new SQLException("Erro ao gerar id para produto: " + e.getMessage());
        }
        return p;
    }

    /**
     * Método para atualizar um produto no banco de dados
     * @param produto
     * @throws SQLException
     * @return void
     */
    public static void atualizarProduto(Produto produto) throws SQLException {
        conexao = DriverManager.getConnection(gc.getURL(), gc.getLOGIN(), gc.getSENHA());
        String sql = "UPDATE produto SET nome = ?, preco = ?, quantidade_estoque = ? WHERE id_produto = ?";
        java.sql.PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, produto.getNome());
        stmt.setDouble(2, produto.getPreco());
        stmt.setInt(3, produto.getQuantidadeEstoque());
        stmt.setString(4, produto.getCodigo());
        stmt.execute();
        stmt.close();
    }

    /**
     * Método para atualizar um estoque do produto no banco de dados
     * @param produto
     * @throws SQLException
     */
    public static void atualizarEstoque(Produto produto) throws SQLException {
        conexao = DriverManager.getConnection(gc.getURL(), gc.getLOGIN(), gc.getSENHA());
        String sql = "UPDATE produto SET quantidade_estoque = ? WHERE id_produto = ?";
        java.sql.PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, produto.getQuantidadeEstoque());
        stmt.setString(2, produto.getCodigo());
        stmt.execute();
        stmt.close();
    }
}
