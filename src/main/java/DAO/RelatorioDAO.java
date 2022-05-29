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
import static DAO.VendaDAO.instrucaoSQL;
import Model.Cliente;
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
import static utils.GerenciadorConexao.DRIVER;

/**
 *
 * @author everymind
 */
public class RelatorioDAO {
    
    static utils.GerenciadorConexao gc = new GerenciadorConexao();
    static Connection conexao = null;
    static java.beans.Statement stmt;
    static String LOGIN = gc.getLOGIN();
    static String SENHA = gc.getSENHA();
    static String URL = gc.getURL();
    
    public static ArrayList<Relatorio> consultarVendaCliente() throws ClassNotFoundException, SQLException
    {
        ArrayList<Relatorio> listaRetorno = new ArrayList<Relatorio>();
        conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
        instrucaoSQL = conexao.createStatement();
        Class.forName(DRIVER);
        ResultSet rs;            
        rs = ((java.sql.Statement) instrucaoSQL).executeQuery("SELECT dataVenda, valor FROM venda as v JOIN (SELECT nomeCliente FROM cliente) as cli on v.id_cliente = cli.id_cliente INNER JOIN (SELECT  id_produto FROM itemVenda) as iv on iv.id_venda = v.id_venda ;");
        if(rs != null) {
            while ( rs.next() ) {
                Relatorio rel = new Relatorio();
                rel.setNomeCliente(rs.getString("cliente"));
                rel.setVendas((ArrayList<Venda>) rs.getArray("vendas"));
                rel.setClientes((ArrayList<Cliente>) rs.getArray("clientes"));
                listaRetorno.add(rel);
            }
        }
        return listaRetorno;
    }

}
