package br.com.ms.atividade.wrapper;

import org.apache.commons.lang.NotImplementedException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.ms.atividade.wrapper.AtividadeWrapper;
import br.com.ms.enums.FORMATO_SAIDA;

public class AtividadeWrapperTest {

	private AtividadeWrapper atividadeWrapper;

	@Rule
    public ExpectedException thrown = ExpectedException.none();

	@Before
	public void init() {
		atividadeWrapper = new AtividadeWrapper();
	}

	@Test
	public void testWrapperAtividadesFormatoXmlDeveLancaExcecao() {
		thrown.expect(NotImplementedException.class);
		atividadeWrapper.wrapperAtividades("", FORMATO_SAIDA.XML);
	}

}
