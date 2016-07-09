package br.com.ms.enums;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TIPO_DOCUMENTOTest {

	@Test
	public void testRadocGetNomeDocumentoDeveRetornarRadoc() {
		assertTrue("Radoc deveria ser igual a Radoc", TIPO_DOCUMENTO.RADOC.getNomeDocumento().equals("Radoc"));
	}

	@Test
	public void testDeveTerSomenteUmTipoDeDocumento() {
		TIPO_DOCUMENTO[] documentos = TIPO_DOCUMENTO.values();
		assertTrue("Deveria ter somente um tipo de documento no Enum", documentos.length == 1);
	}
}
