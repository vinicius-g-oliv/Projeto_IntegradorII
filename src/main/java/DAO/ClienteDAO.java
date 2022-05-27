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
import utils.GerenciadorConexao;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClienteDAO {

    static utils.GerenciadorConexao gc = new GerenciadorConexao();
    static Connection conexao = null;
    static Statement stmt;

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

    public static void consultar(Cliente cliente) throws SQLException {
        //TODO: implementar consulta
    }

    public static void alterar(Cliente cliente) throws SQLException {
        //TODO: implementar alteração
    }

    public static void deletar(Cliente cliente) throws SQLException {
        //TODO: implementar exclusão
    }
}



