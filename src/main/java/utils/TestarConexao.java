package utils;
import utils.GerenciadorConexao;
import java.util.Scanner;


public class TestarConexao {
    static Scanner sc = new Scanner(System.in);

    
    public static void main(String[] args) {
        try {
            if(GerenciadorConexao.getSENHA().toString() == null){
                System.out.println(
                "Senha atual:"+GerenciadorConexao.getSENHA()+"\n"+   
                "Digite a senha do banco de dados:"
                );
                GerenciadorConexao.setSENHA(
                    sc.next()
                );
                System.out.println("\n");   
            }
            GerenciadorConexao.abrirConexao();
            imprimirStatus();
            GerenciadorConexao.fecharConexao();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void imprimirStatus() {
        System.out.println(
                    "--------------------------------------------------------------------------------\n" +
                    "Driver: " + GerenciadorConexao.getDRIVER() + "\n" +
                    "Server: " + GerenciadorConexao.getSERVER() + "\n" +
                    "Database: " + GerenciadorConexao.getDATABASE() + "\n" +
                    "Login: " + GerenciadorConexao.getLOGIN() + "\n" +
                    "Senha: " + GerenciadorConexao.getSENHA() + "\n" +
                    "URL: " + GerenciadorConexao.getURL() + "\n" +
                    "Status: " + GerenciadorConexao.getSTATUS() + "\n"
        );
    }
}
