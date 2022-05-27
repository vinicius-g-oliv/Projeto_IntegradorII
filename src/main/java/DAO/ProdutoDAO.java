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
        //private static final String LOGIN = “root"; //nome do usuário do banco
        private static final String SENHA = ""; //senha de acesso ao banco de dados
        private static final String url = "jdbc:mysql://localhost:3306/lojamvc?useTimezone=true&serverTimezone=UTC";
        private static Connection conexao;
         static utils.GerenciadorConexao gc = new GerenciadorConexao();
        
        
        public static ArrayList<Produto> consultar() throws ClassNotFoundException, SQLException
        {
        ArrayList<Produto> listaRetorno = new ArrayList<Produto>();
        try {
        
            Class.forName(DRIVER);
            //conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            Statement instrucaoSQL = (Statement) (ResultSet) conexao.createStatement();
            ResultSet rs;
            
           /* rs = instrucaoSQL.executeQuery("SELECT * FROM produto;");
            if(rs != null){
                while ( rs.next() ) {
                Produto p = new Produto();
                p.setCodigo(rs.getString("codigo"));
                p.setPreco(rs.getFloat("preco"));
                p.setNome(rs.getString("nome"));
                p.setQuantidadeEstoque(rs.getInt("CPF"));
               
                listaRetorno.add(p);
                }
            }
            else
            {
                throw new SQLException();
            }*/
        }catch (SQLException e) {
            listaRetorno = null;
        }catch (ClassNotFoundException ex) {
            listaRetorno = null;
        } finally {
       
        /*try {
            Object rs;
            if(rs!=null)
                rs.close();
            if(instrucaoSQL!=null)
                instrucaoSQL.close();
            if(conexao!=null)
                conexao.close();
        } catch (SQLException ex) {
        }
        }*/
        return listaRetorno;
        }
    
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
}
