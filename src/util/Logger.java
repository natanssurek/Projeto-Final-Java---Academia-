package util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private static final String ARQUIVO_LOG = "gymtonica_log.txt";
    private static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private static void salvar(String nivel, String mensagem) {
        String linha = "[" + LocalDateTime.now().format(formato) + "] [" + nivel + "] " + mensagem;

        System.out.println(linha); // <- exibe no console também

        try (PrintWriter writer = new PrintWriter(new FileWriter(ARQUIVO_LOG, true))) {
            writer.println(linha);
        } catch (IOException e) {
            System.out.println("Erro ao salvar log: " + e.getMessage());
        }
    }

    public static void info(String mensagem) {
        salvar("INFO", mensagem);
    }

    public static void erro(String mensagem) {
        salvar("ERRO", mensagem);
    }

    public static void debug(String mensagem) {
        salvar("DEBUG", mensagem);
    }

    public static void aviso(String mensagem) {
        salvar("AVISO", mensagem);
    }
}