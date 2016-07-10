package br.com.ms.util;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.lang.NotImplementedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PDFManagerTest {

    private PDFManager pdfManager;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void init() {
        this.pdfManager = new PDFManager();
    }

    @Test
    public void toTextComArquivoValido() throws IOException {
    	File arquivoPdf = Arquivo.getArquivoRelativoClasspath("/doc/exemplos-radoc/Radoc-2014-Final.pdf");
        this.pdfManager.setFilePath(arquivoPdf.getAbsolutePath());
        String text = this.pdfManager.toText();
        String radocText = Arquivo.getConteudo("/doc/exemplos-radoc/Radoc-2014-Final.txt");
        assertEquals(text, radocText);
    }

    @Test
    public void toTextComArquivoInvalido() throws IOException {
        thrown.expect(FileNotFoundException.class);
        File arquivoPdf = Arquivo.getArquivoRelativoClasspath("/doc/exemplos-radoc/ArquivoInvalido.pdf");
        this.pdfManager.setFilePath(arquivoPdf.getAbsolutePath());
        String text = this.pdfManager.toText();
    }
}