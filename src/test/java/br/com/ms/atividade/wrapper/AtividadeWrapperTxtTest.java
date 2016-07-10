package br.com.ms.atividade.wrapper;

import static org.junit.Assert.assertEquals;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.com.ms.util.Arquivo;

@Ignore
public class AtividadeWrapperTxtTest {

	private AtividadeWrapperTxt atividadeWrapperTxt;

	private static final String BARRA_R = "\r";

	@Before
	public void init() {
		atividadeWrapperTxt = new AtividadeWrapperTxt();
	}

	@Test
	public void testExtracaoAtividadesOrientacao() {
		String grupoAtividades = Arquivo.getConteudo("/extracao-atividades/grupoAtividadesOrientacao.txt");
		String atividadesExtraidas = atividadeWrapperTxt.extrairAtividadesOrientacao(grupoAtividades);

		String atividadesEsperado = Arquivo.getConteudo("/extracao-atividades/atividadesOrientacaoEsperado.txt");
		atividadesEsperado = atividadesEsperado.replace(BARRA_R, "");
		assertEquals(atividadesEsperado, atividadesExtraidas);
	}

	@Test
	public void testExtracaoAtividadesProjetos() {
		String grupoAtividades = Arquivo.getConteudo("/extracao-atividades/grupoAtividadesProjetos.txt");
		String atividadesExtraidas = atividadeWrapperTxt.extrairAtividadesProjetos(grupoAtividades);
		Charset.forName("UTF-8").encode(atividadesExtraidas);

		String atividadesEsperado = Arquivo.getConteudo("/extracao-atividades/atividadesProjetosEsperado.txt");
		atividadesEsperado = atividadesEsperado.replace(BARRA_R, "");
		assertEquals(atividadesEsperado, atividadesExtraidas);
	}

	@Test
	public void testExtracaoAtividadesExtensao() {
		String grupoAtividades = Arquivo.getConteudo("/extracao-atividades/grupoAtividadesExtensao.txt");
		String atividadesExtraidas = atividadeWrapperTxt.extrairAtividadesExtensao(grupoAtividades);

		String atividadesEsperado = Arquivo.getConteudo("/extracao-atividades/atividadesExtensaoEsperado.txt");
		atividadesEsperado = atividadesEsperado.replace(BARRA_R, "");
		assertEquals(atividadesEsperado, atividadesExtraidas);
	}

	@Test
	public void testExtracaoAtividadesQualificacao() {
		String grupoAtividades = Arquivo.getConteudo("/extracao-atividades/grupoAtividadesQualificacao.txt");
		String atividadesExtraidas = atividadeWrapperTxt.extrairAtividadesQualificacao(grupoAtividades);

		String atividadesEsperado = Arquivo.getConteudo("/extracao-atividades/atividadesQualificacaoEsperado.txt");
		atividadesEsperado = atividadesEsperado.replace(BARRA_R, "");
		assertEquals(atividadesEsperado, atividadesExtraidas);
	}

	@Test
	public void testExtracaoAtividadesAcademicas() {
		String grupoAtividades = Arquivo.getConteudo("/extracao-atividades/grupoAtividadesAcademicas.txt");
		String atividadesExtraidas = atividadeWrapperTxt.extrairAtividadesAcademicas(grupoAtividades);

		String atividadesEsperado = Arquivo.getConteudo("/extracao-atividades/atividadesAcademicasEsperado.txt");
		atividadesEsperado = atividadesEsperado.replace(BARRA_R, "");
		assertEquals(atividadesEsperado, atividadesExtraidas);
	}

	@Test
	public void testExtracaoAtividadesAdministrativas() {
		String grupoAtividades = Arquivo.getConteudo("/extracao-atividades/grupoAtividadesAdministrativas.txt");
		String atividadesExtraidas = atividadeWrapperTxt.extrairAtividadesAdministrativas(grupoAtividades);

		String atividadesEsperado = Arquivo.getConteudo("/extracao-atividades/atividadesAdministrativasEsperado.txt");
		atividadesEsperado = atividadesEsperado.replace(BARRA_R, "");
		assertEquals(atividadesEsperado, atividadesExtraidas);
	}

}
