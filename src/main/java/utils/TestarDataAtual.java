package utils;
import java.time.LocalDate;
//programa que retorne a data de hoje

public class TestarDataAtual {
    public static void main(String[] args) {
        //pegue a data atual
        java.sql.Date dataAtual = java.sql.Date.valueOf(LocalDate.now());
        System.out.println(dataAtual);
    }
}