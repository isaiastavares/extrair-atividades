package br.com.ms.enums;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FORMATO_SAIDATest {

	@Test
	public void testFormatoSaidaGetNomeFormatoDeveRetornarFormatoXml() {
		assertTrue("Formato XML deveria ter o nome Formato XML", FORMATO_SAIDA.XML.getNomeFormato().equals("Formato XML"));
	}

	@Test
	public void testFormatoSaidaGetExtensaoDeveRetornarExtensaoXml() {
		assertTrue("Formato XML deveria ter extensao .xml", FORMATO_SAIDA.XML.getExtensao().equals(".xml"));
	}

	@Test
	public void testFormatoSaidaGetNomeFormatoDeveRetornarFormatoTxt() {
		assertTrue("Formato TXT deveria ter o nome Formato TXT", FORMATO_SAIDA.TXT.getNomeFormato().equals("Formato TXT"));
	}

	@Test
	public void testFormatoSaidaGetExtensaoDeveRetornarExtensaoTxt() {
		assertTrue("Formato TXT deveria ter extensao .xml", FORMATO_SAIDA.TXT.getExtensao().equals(".txt"));
	}

	@Test
	public void testDeveTerSomenteDoisTiposDeFormato() {
		FORMATO_SAIDA[] formatos = FORMATO_SAIDA.values();
		assertTrue("Deveria ter somente dois tipos de formato no Enum", formatos.length == 2);
	}

}
