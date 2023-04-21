package org.example.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ArquivoUtils {

    public static final String NOME_ARQUIVO_ = "registros.csv";
    public static void gravarArquivo(String conteudo, String nomeArquivo) throws IOException, URISyntaxException {
        System.out.println("-----------------------------Gravando arquivo: "+nomeArquivo +"------------------------------");
//        String path = "C:\\Projetos\\CsvText\\src\\main\\resources\\";
        String path = "C:\\Projetos\\arquivosRetorno\\";
        String pathFinal = path+nomeArquivo+".txt";
        Files.write(Paths.get(pathFinal), conteudo.getBytes());
        System.out.println("----------------------------Gravação concluída-----------------------------");
    }
}
