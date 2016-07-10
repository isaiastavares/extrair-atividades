package br.com.ms.util;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class ArquivoTest {

    private String nomeArquivo = "ArquivoDeTeste.txt";

    @Test
    public void salvarArquivo() throws Exception {
        String conteudoArquivo = "Teste gravacao arquivo";
        Arquivo.salvarArquivo("target/classes/doc/", nomeArquivo, conteudoArquivo);
        assertEquals(Arquivo.getConteudo("/doc/" + nomeArquivo), conteudoArquivo);
    }

}