package br.com.ms;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;

import br.com.ms.enums.FORMATO_SAIDA;
import br.com.ms.enums.TIPO_DOCUMENTO;
import br.com.ms.util.Arquivo;

public class DocumentParseAdapterTest {

	private static final String CAMINHO_SAIDA = "C:\\Users\\Isaias\\Downloads";
	private static final String CAMINHO_RADOC = "C:\\Users\\Isaias\\Downloads\\Trabalho-3-Exemplos-Radoc\\Radoc-2014-Final.pdf";
	private static final String ATIVIDADES_EXTRAIDAS = "AtividadesExtraidas.txt";

	private DocumentParseAdapter documentParseAdapter;

	@Before
	public void init() {
		documentParseAdapter = new DocumentParseAdapter();
	}
	@Test
	public void test() {
//		Arquivo.getArquivoRelativoClasspath(ATIVIDADES_EXTRAIDAS);

//		documentParseAdapter.parsearPDF(
//				TIPO_DOCUMENTO.RADOC,
//				CAMINHO_RADOC,
//				PASTA_SAIDA,
//				FORMATO_SAIDA.TXT);
//		File file = new File(ATIVIDADES_EXTRAIDAS);
//		assertTrue(file.exists());
	}

}
