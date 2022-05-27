/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author everymind
 */
import Model.Cliente;
import d156.pdvfarmacia.Login;
import utils.GerenciadorConexao;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {

    static utils.GerenciadorConexao gc = new GerenciadorConexao();
    static Connection conexao = null;
    static Statement stmt;
    static String LOGIN = gc.getLOGIN();
    static String SENHA = gc.getSENHA();
    static String URL = gc.getURL();

    //Conecta ao banco de dados com utils.GerenciadorConexao
    public static void inserir(Cliente cliente) throws SQLException, ClassNotFoundException {
        conexao = DriverManager.getConnection(gc.getURL(), gc.getLOGIN(), gc.getSENHA());
        String sql = "INSERT INTO cliente (nome, cpf, date, email, sexo, endereco, cep, numero, complemento, estadoCivil) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        java.sql.PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, cliente.getNome());
        stmt.setString(2, cliente.getCpf());
        stmt.setString(3, cliente.getDataNascimento().toString());
        stmt.setString(4, cliente.getEmail());
        stmt.setString(5, cliente.getSexo());
        stmt.setString(6, cliente.getEndereco());
        stmt.setString(7, cliente.getCep());
        stmt.setString(8, Integer.toString(cliente.getNumero()));
        stmt.setString(9, cliente.getComplemento());
        stmt.setString(10, cliente.getEstadoCivil());
        stmt.execute();
        stmt.close();
    }

    public static ArrayList<Cliente> consultar(){
        ArrayList<Cliente> array_clientes = new ArrayList<Cliente>();
        try {
            conexao = DriverManager.getConnection(URL, LOGIN, SENHA);
            String sql = "SELECT * FROM cliente";
            java.sql.PreparedStatement stmt = conexao.prepareStatement(sql);
            java.sql.ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setDataNascimento(rs.getDate("date"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSexo(rs.getString("sexo"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setCep(rs.getString("cep"));
                cliente.setNumero(rs.getInt("numero"));
                cliente.setComplemento(rs.getString("complemento"));
                cliente.setEstadoCivil(rs.getString("estadoCivil"));
                array_clientes.add(cliente); //Adiciona o cliente na lista
            }
            rs.close();
            stmt.close();
        }catch (SQLException e) {
            System.out.println("Erro ao consultar clientes: " + e.getMessage());
        }
        return array_clientes;
    }

    public static void alterar(Cliente cliente) throws SQLException {
        //TODO: implementar alteração

    }

    public static void deletar(Cliente cliente) throws SQLException {
        //deletar cliente
        conexao = DriverManager.getConnection(gc.getURL(), gc.getLOGIN(), gc.getSENHA());
        String sql = "DELETE FROM cliente WHERE id_cliente = ?";
        java.sql.PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, cliente.getId_cliente());
        stmt.execute();
        stmt.close();
    }
}



