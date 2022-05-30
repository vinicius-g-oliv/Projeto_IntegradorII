package DAO;

import Model.ItemVenda;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import utils.GerenciadorConexao;

public class ItemVendaDAO {
   
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; //Driver do Mysql 8.0
        static utils.GerenciadorConexao gc = new GerenciadorConexao();
        static String LOGIN = gc.getLOGIN();
        static String SENHA = gc.getSENHA();
        static String URL = gc.getURL();
        private static Connection conexao;
        static java.sql.Statement instrucaoSQL;
        
    public static ArrayList<ItemVenda> consultar() throws ClassNotFoundException, SQLException
    {
        ArrayList<ItemVenda> listaRetorno = new ArrayList<ItemVenda>();
        conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
        instrucaoSQL = conexao.createStatement();
        Class.forName(DRIVER);
        ResultSet rs;            
        rs = ((java.sql.Statement) instrucaoSQL).executeQuery("SELECT * FROM ItemVenda;");
        if(rs != null) {
            while ( rs.next() ) {
                ItemVenda iv = new ItemVenda();
                iv.setId_produto(rs.getInt("codigo"));
                iv.setId_venda(rs.getInt("venda"));
                iv.setQuantidade(rs.getInt("quatidade"));
                iv.setValor(rs.getDouble("valor"));
                listaRetorno.add(iv);
            }
        }
        return listaRetorno;
    }
    
    
    
    public static void inserir(ItemVenda itemVenda) throws SQLException, ClassNotFoundException {
        conexao = DriverManager.getConnection(gc.getURL(), gc.getLOGIN(), gc.getSENHA());
        String sql = "INSERT INTO itemVenda (id_venda, id_produto, quantidade, valor) VALUES (?, ?, ?, ?)";
        java.sql.PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, itemVenda.getId_venda());
        stmt.setInt(2, itemVenda.getId_produto());
        stmt.setInt(3, itemVenda.getQuantidade());
        stmt.setDouble(4, itemVenda.getValor());
        stmt.execute();
        stmt.close();
    }
    
     public static void deletar(ItemVenda itemVenda) throws SQLException {
        conexao = DriverManager.getConnection(gc.getURL(), gc.getLOGIN(), gc.getSENHA());
        String sql = "DELETE FROM itemVenda WHERE id_itemVenda = ?";
        java.sql.PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, itemVenda.getId_itemVenda());
        stmt.execute();
        stmt.close();
    }
 
    
}
