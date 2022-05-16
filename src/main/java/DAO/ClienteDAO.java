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
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ClienteDAO {
    
        /*    private static final String DRIVER = "com.mysql.cj.jdbc.Driver"; //Driver do Mysql 8.0
        //private static final String LOGIN = “root"; //nome do usuário do banco
        private static final String SENHA = ""; //senha de acesso ao banco de dados
        private static final String url = "jdbc:mysql://localhost:3306/lojamvc?useTimezone=true&serverTimezone=UTC";
        private static Connection conexao;
        public static ArrayList<Cliente> consultarClientes() throws ClassNotFoundException, SQLException
        {
        ArrayList<Cliente> listaRetorno = new ArrayList<>();
        try {
            //Carrego o driver para acesso ao banco
            Class.forName(DRIVER);
            //conexao = DriverManager.getConnection(url, LOGIN, SENHA);
            Statement instrucaoSQL = (Statement) (ResultSet) conexao.createStatement();
            ResultSet rs;
            
        rs = instrucaoSQL.executeQuery("SELECT * FROM cliente;");
            if(rs != null){
                while ( rs.next() ) {
                Cliente c = new Cliente();
                c.setCep(rs.getString("cep"));
                c.setComplemento(rs.getNString("complemento"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("CPF"));
                c.setEmail(rs.getString("email"));
                c.setEstadoCivil(rs.getString("estado civil"));
                c.setDataNascimento(rs.getDate("data de nascimento"));
                c.setNumero(rs.getInt("numero"));
                c.setEndereco(rs.getString("endereco"));
                c.setSexo(rs.getString("sexo"));
                listaRetorno.add( c );
                }
            }
            else
            {
                throw new SQLException();
            }
        }catch (SQLException e) {
            listaRetorno = null;
        }catch (ClassNotFoundException ex) {
            listaRetorno = null;
        } finally{
       
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
        }
        return listaRetorno;
        }
    
        }*/
}



