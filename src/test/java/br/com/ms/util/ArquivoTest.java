package br.com.ms.util;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;


public class ArquivoTest {
    private String nomeArquivo = "ArquivoDeTeste.txt";

    @Test
    public void salvarArquivo() throws Exception {
        String conteudoArquivo = "Teste gravacao arquivo";
        String pasta = "/doc/";
        Arquivo.salvarArquivo("target/classes/doc/", nomeArquivo, conteudoArquivo);
        Assert.assertEquals(Arquivo.getConteudo(pasta + nomeArquivo), conteudoArquivo);
    }

}