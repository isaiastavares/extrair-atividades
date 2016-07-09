import br.com.ms.DocumentParseAdapter;
import br.com.ms.enums.FORMATO_SAIDA;
import br.com.ms.enums.TIPO_DOCUMENTO;
import br.com.ms.util.Arquivo;
import br.com.ms.util.PDFManager;

import java.io.File;
import java.io.IOException;

public class ExtrairAtividades {

    public static void main(String[] args) {
        if (args.length == 1) {
            String caminhoArquivo = args[0];
            File file = new File(caminhoArquivo);
            if (file.exists() && file.isFile()) {
                PDFManager pdfManager = new PDFManager();
                pdfManager.setFilePath(file.getAbsolutePath());
                try {
                    String textPdf = pdfManager.toText();
                    DocumentParseAdapter documentParseAdapter = new DocumentParseAdapter();
                    String txt = documentParseAdapter.parsearPDF(TIPO_DOCUMENTO.RADOC, textPdf, FORMATO_SAIDA.TXT);
                    Arquivo.salvarArquivo("", "AtividadesExtraídas.txt", txt);
                } catch (IOException e) {
                    System.err.println("Erro ao abrir o arquivo." + e.getMessage());
                }
            } else {
                System.err.println("Arquivo informado não foi encontrado");
            }
        } else {
            System.err.println("Informe um parâmetro com o nome do arquivo RADOC");
        }
    }
}