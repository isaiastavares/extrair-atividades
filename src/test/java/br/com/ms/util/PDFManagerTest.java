package br.com.ms.util;

import com.sun.xml.internal.bind.v2.runtime.output.Encoded;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import java.io.*;
import java.nio.charset.Charset;

public class PDFManagerTest {

    private PDFManager pdfManager;

    @Before
    public void init() {
        this.pdfManager = new PDFManager();
    }

    @Test
    public void toText() throws IOException {
        String arquivoPdf = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "doc" + File.separator + "exemplos-radoc" + File.separator + "Radoc-2014-Final.pdf";
        this.pdfManager.setFilePath(arquivoPdf);
        String text = this.pdfManager.toText();
        Assert.assertEquals(text, this.getRadocText());
    }

    private String getRadocText() throws IOException {
        String arquivo = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "doc" + File.separator + "exemplos-radoc" + File.separator + "Radoc-2014-Final.txt";
        File file = new File(arquivo);
        StringBuilder conteudoBuilder = new StringBuilder();
        FileReader fr = new FileReader(file);
        BufferedReader bb = new BufferedReader(fr);
        int content;
        while (bb.ready()) {
            conteudoBuilder.append(bb.readLine());
            conteudoBuilder.append("\r\n");
        }
        String conteudo = conteudoBuilder.toString();
        return conteudo;
    }
}