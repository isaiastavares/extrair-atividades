package br.com.ms;

import java.io.IOException;

import br.com.ms.enums.FORMATO_SAIDA;
import br.com.ms.enums.TIPO_DOCUMENTO;

public class ExtrairAtividades {

	private static final String CAMINHO_RADOC = "C:\\Users\\Isaias\\Downloads\\Trabalho-3-Exemplos-Radoc\\Radoc-2014-Final.pdf";

	public static void main(String[] args) throws IOException {
		DocumentParseAdapter documentParseAdapter = new DocumentParseAdapter();
		documentParseAdapter.parsearPDF(
				TIPO_DOCUMENTO.RADOC,
				/*args[0]*/CAMINHO_RADOC,
				"C:\\Users\\Isaias\\Downloads",
				FORMATO_SAIDA.TXT);
	}

}