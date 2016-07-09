package br.com.ms.atividade.wrapper;

import org.apache.commons.lang.NotImplementedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.ms.atividade.wrapper.AtividadeWrapperXml;

public class AtividadeWrapperXmlTest {

	private AtividadeWrapperXml atividadeWrapperXml;

	@Rule
    public ExpectedException thrown = ExpectedException.none();

	@Before
	public void init() {
		atividadeWrapperXml = new AtividadeWrapperXml();
	}

	@Test
	public void testExtrairAtividadesDeveLancaExcecao() {
		thrown.expect(NotImplementedException.class);
		atividadeWrapperXml.extrairAtividades("");
	}

}
