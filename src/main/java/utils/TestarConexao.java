package utils;
import java.util.Scanner;


public class TestarConexao {
    static Scanner sc = new Scanner(System.in);
    static GerenciadorConexao gc = new GerenciadorConexao();
    public static void main(String[] args) {
        try {
            System.out.println("Testando conexão com o banco de dados...");
            gc.abrirConexao();
            imprimirStatus();
            gc.fecharConexao();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void imprimirStatus() {
        System.out.println(
                    "--------------------------------------------------------------------------------\n" +
                    "Driver: " + gc.getDRIVER() + "\n" +
                    "Server: " + gc.getSERVER() + "\n" +
                    "Database: " + gc.getDATABASE() + "\n" +
                    "Login: " + gc.getLOGIN() + "\n" +
                    "Senha: " + gc.getSENHA() + "\n" +
                    "URL: " + gc.getURL() + "\n" +
                    "Status: " + gc.getSTATUS() + "\n"
        );
    }
}
