package br.com.ms;

import br.com.ms.enums.FORMATO_SAIDA;
import br.com.ms.enums.TIPO_DOCUMENTO;
import br.com.ms.util.Arquivo;
import br.com.ms.util.PDFManager;

import java.io.File;
import java.io.IOException;

public class ExtrairAtividades {

    public static void main(String[] args) {
        if (args.length == 2) {
            String caminhoPDF = args[0];
            String caminhoResultado = args[1];
            File file = new File(caminhoPDF);
            File pastaResultado = new File(caminhoResultado);
            if (pastaResultado.exists() && pastaResultado.isDirectory()) {
                if (file.exists() && file.isFile()) {
                    PDFManager pdfManager = new PDFManager();
                    pdfManager.setFilePath(file.getAbsolutePath());
                    try {
                        String textPdf = pdfManager.toText();
                        DocumentParseAdapter documentParseAdapter = new DocumentParseAdapter();
                        String txt = documentParseAdapter.parsearPDF(TIPO_DOCUMENTO.RADOC, textPdf, FORMATO_SAIDA.TXT);
                        Arquivo.salvarArquivo(pastaResultado.getAbsolutePath(), "AtividadesExtra\u00eddas.txt", txt);
                    } catch (IOException e) {
                        System.err.println("Erro ao abrir o arquivo." + e.getMessage());
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                } else {
                    System.err.println("Arquivo informado n\u00e3o foi encontrado");
                }
            } else {
                System.err.println("Diretório de destino n\u00e3o existe.");
            }
        } else {
            System.err.println("Informe como primeiro par\u00e2metro com o nome do arquivo RADOC e segundo par\u00e2metro o destino do aquivo AtividadesExtraidas.txt");
        }
    }
}