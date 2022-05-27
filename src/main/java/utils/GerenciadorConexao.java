/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.GerenciadorConexao to edit this template
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author aluno
 */
public class GerenciadorConexao {
    
    public static String STATUS = "Não conectado";
    public static String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static String SERVER = "localhost";
    public static String DATABASE = "lojafarmacia";
    public static String LOGIN = "root";
    public static String SENHA = "";
    public static String URL = "jdbc:mysql://" + SERVER + ":3306/" +DATABASE;
    public static Connection CONEXAO = null;

    public GerenciadorConexao() {
    }
    
    public Connection abrirConexao() throws ClassNotFoundException,SQLException {
        
        if(CONEXAO == null)      
        {    
            try {

                Class.forName(DRIVER);
                CONEXAO = DriverManager.getConnection(URL, LOGIN, SENHA);
                if (CONEXAO != null) {
                    STATUS = "Conexão realizada com sucesso!";
                } else {
                    STATUS = "Não foi possivel realizar a conexão";
                }

            } catch (ClassNotFoundException e) {

                throw new ClassNotFoundException("O driver expecificado nao foi encontrado.");

            } catch (SQLException e) {

                throw new SQLException("Erro ao estabelecer a conexão (possívelmente login ou senha errados).");
            }
            
        }
        else
        {
            try {
                if(CONEXAO.isClosed())
                    CONEXAO = DriverManager.getConnection(URL, LOGIN, SENHA);
            } catch (SQLException ex) {
                throw new SQLException("Falha ao fechar a conexão.");
            }
        }
        return CONEXAO;
    }
    
    public static String getStatusConexao() {
        return STATUS;
    }
    
    public boolean fecharConexao() throws SQLException {
 
        boolean retorno = false;
        
        try {
            if(CONEXAO!=null){
                if(!CONEXAO.isClosed())
                    CONEXAO.close();
            }
            
            STATUS = "Não conectado";
            retorno = true;
            
         } catch (SQLException e) {
            retorno = false;
        }
        
        return retorno;
    }

    public String getLOGIN() {
        return LOGIN;
    }

    public static void setLOGIN(String lOGIN) {
        LOGIN = lOGIN;
    }

    public String getSENHA() {
        return SENHA;
    }

    public static void setSENHA(String sENHA) {
        SENHA = sENHA;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public String getDRIVER() {
        return DRIVER;
    }

    public String getSERVER() {
        return SERVER;
    }

    public String getDATABASE() {
        return DATABASE;
    }

    public String getURL() {
        return URL;
    }

    public static Connection getCONEXAO() {
        return CONEXAO;
    }
}
