package br.com.ms.util;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class PDFManagerTest {

    private PDFManager pdfManager;

    @Before
    public void init() {
        this.pdfManager = new PDFManager();
    }

    @Test
    public void toText() throws IOException {
    	File arquivoPdf = Arquivo.getArquivoRelativoClasspath("/doc/exemplos-radoc/Radoc-2014-Final.pdf");
        this.pdfManager.setFilePath(arquivoPdf.getAbsolutePath());
        String text = this.pdfManager.toText();
        String radocText = Arquivo.getConteudo("/doc/exemplos-radoc/Radoc-2014-Final.txt");
        assertEquals(text, radocText);
    }
}