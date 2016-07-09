package br.com.ms;

import br.com.ms.enums.FORMATO_SAIDA;
import br.com.ms.enums.TIPO_DOCUMENTO;

public class ExtrairAtividades {

	private static final String CAMINHO_RADOC = "C:\\Users\\Isaias\\Downloads\\Trabalho-3-Exemplos-Radoc\\Radoc-2014-Final.pdf";
	private static final String PASTA_SAIDA = "C:\\Users\\Isaias\\Downloads";

	public static void main(String[] args) {
		DocumentParseAdapter documentParseAdapter = new DocumentParseAdapter();
		documentParseAdapter.parsearPDF(
				TIPO_DOCUMENTO.RADOC,
				/*args[0]*/CAMINHO_RADOC,
				PASTA_SAIDA,
				FORMATO_SAIDA.TXT);
	}

//	public static void main(String[] args) {
//		try {
//			File file = Arquivo.getArquivoRelativoClasspath("Radoc-2015-Final.pdf");
//			System.out.println(file.getAbsolutePath());
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//	}

}