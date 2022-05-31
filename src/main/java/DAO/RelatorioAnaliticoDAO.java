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
        
    public static ArrayList<RelatorioAnaliticoClasse> buscarPorData(java.sql.Date inicio, java.sql.Date fim) throws ClassNotFoundException, SQLException
    {
        ArrayList<RelatorioAnaliticoClasse> listaRetorno = new ArrayList<RelatorioAnaliticoClasse>();
        conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
        instrucaoSQL = conexao.createStatement();
        Class.forName(DRIVER);
        String sql = "SELECT iv.id_produto, iv.quantidade, v.data_venda, cli.nome FROM item_venda as iv INNER JOIN venda as v on iv.id_venda = v.id_venda INNER JOIN cliente as cli on v.id_cliente = cli.id_cliente WHERE data_venda BETWEEN ? AND ? ;";
        java.sql.PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setDate(1, inicio);
        stmt.setDate(2, fim);
        ResultSet rs = stmt.executeQuery();         
        while(rs.next()){
            RelatorioAnaliticoClasse rel = new RelatorioAnaliticoClasse();
            rel.setProdutos(rs.getString("iv.id_produto"));
            rel.setQuantidade(rs.getInt("iv.quantidade"));
            rel.setNomeCli(rs.getString("cli.nome"));
            rel.setData(rs.getDate("v.data_venda"));
           
            listaRetorno.add(rel);
        }
        return listaRetorno;
    }

    
    
}
