/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Relatorio;
import Model.RelatorioAnaliticoClasse;
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
public class RelatorioAnaliticoDAO {
    
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; //Driver do Mysql 8.0
        static utils.GerenciadorConexao gc = new GerenciadorConexao();
        static String LOGIN = gc.getLOGIN();
        static String SENHA = gc.getSENHA();
        static String URL = gc.getURL();
        private static Connection conexao;
        static java.sql.Statement instrucaoSQL;
        
    public static ArrayList<RelatorioAnaliticoClasse> buscar() throws ClassNotFoundException, SQLException
    {
        ArrayList<RelatorioAnaliticoClasse> listaRetorno = new ArrayList<RelatorioAnaliticoClasse>();
        conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
        instrucaoSQL = conexao.createStatement();
        Class.forName(DRIVER);
        ResultSet rs;            
        rs = ((java.sql.Statement) instrucaoSQL).executeQuery("SELECT iv.id_produto, iv.quantidade, v.data_venda, cli.nome \n" +
"FROM item_venda as iv INNER JOIN venda as v on iv.id_venda = v.id_venda INNER JOIN cliente as cli on v.id_cliente = cli.id_cliente WHERE data_venda BETWEEN ? AND ? ;");
        if(rs != null) {
            while ( rs.next() ) {
                RelatorioAnaliticoClasse rel = new RelatorioAnaliticoClasse();
                rel.setProdutos(rs.getString("produtos"));
                rel.setQuantidade(rs.getInt("quantidade"));
                rel.setNomeCli(rs.getString("nomeCliente"));
                rel.setData(rs.getDate("data"));
               
                listaRetorno.add(rel);
            }
        }
        return listaRetorno;
    }

    
    
}
