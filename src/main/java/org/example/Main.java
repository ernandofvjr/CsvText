package org.example;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.example.domain.Registro;
import org.example.utils.ArquivoUtils;

import java.io.IOException;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException {

        Reader reader = Files.newBufferedReader(Paths.get(Thread.currentThread().getContextClassLoader().getResource(ArquivoUtils.NOME_ARQUIVO_).toURI()));

        //Lembrar de substituir o ponto e virgula do csv para virgula
        CsvToBean<Registro> csvToBean = new CsvToBeanBuilder(reader)
                .withType(Registro.class)
                .build();

        List<Registro> registros = csvToBean.parse();

        StringBuilder retorno = new StringBuilder();

        for(Registro reg: registros) {
            retorno.append("UPDATE tabela SET atributo = " +reg.getValor()+ ", obs = 'Ajuste' where boleto='"+reg.getBoleto()+"';");
            retorno.append("\n");
        }

        System.out.println(retorno.toString());

        ArquivoUtils.gravarArquivo(retorno.toString(), "script");

    }


}