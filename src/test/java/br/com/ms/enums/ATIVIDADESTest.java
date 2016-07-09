package br.com.ms.enums;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ATIVIDADESTest {

	@Test
	public void testAtividadesOrigentacaoGetOrdemDeveRetornarUm() {
		assertTrue("Enum ATIVIDADES_ORIENTACAO deveria retornar ordem igual a 1",
				ATIVIDADES.ATIVIDADES_ORIENTACAO.getOrdem() == 1);
	}

	@Test
	public void testOrdemUmDeveRetornarAtividadesOrientacao() {
		assertTrue("Ordem 1 deveria retornar o Enum ATIVIDADES_ORIENTACAO",
				ATIVIDADES.atividadesFromOrdem(1).equals(ATIVIDADES.ATIVIDADES_ORIENTACAO));
	}

	@Test
	public void testAtividadesOrientacaoGetNomeAtividadeDeveRetornarAtividadeDeOrientacao() {
		assertTrue("Enum ATIVIDADES_ORIENTACAO deveria ter o nome Atividades de orienta\u00e7\u00e3o",
				ATIVIDADES.ATIVIDADES_ORIENTACAO.getNomeAtividade().equals("Atividades de orienta\u00e7\u00e3o"));
	}

	@Test
	public void testAtividadesEmProjetosGetOrdemDeveRetornarDois() {

		assertTrue("Enum ATIVIDADES_PROJETOS deveria retornar ordem igual a 2",
				ATIVIDADES.ATIVIDADES_PROJETOS.getOrdem() == 2);
	}

	@Test
	public void testOrdemDoisDeveRetornarAtividadesProjetos() {
		assertTrue("Ordem 2 deveria retornar o Enum ATIVIDADES_PROJETOS",
				ATIVIDADES.atividadesFromOrdem(2).equals(ATIVIDADES.ATIVIDADES_PROJETOS));
	}

	@Test
	public void testAtividadesEmProjetosGetNomeAtividadeDeveRetornarAtividadeEmProjetos() {
		assertTrue("Enum ATIVIDADES_PROJETOS deveria ter o nome Atividades em projetos",
				ATIVIDADES.ATIVIDADES_PROJETOS.getNomeAtividade().equals("Atividades em projetos"));
	}

	@Test
	public void testAtividadesDeExtensaoGetOrdemDeveRetornarTres() {
		assertTrue("Enum ATIVIDADES_EXTENSAO deveria retornar ordem igual a 3",
				ATIVIDADES.ATIVIDADES_EXTENSAO.getOrdem() == 3);
	}

	@Test
	public void testOrdemTresDeveRetornarAtividadesExtensao() {
		assertTrue("Ordem 3 deveria retornar o Enum ATIVIDADES_EXTENSAO",
				ATIVIDADES.atividadesFromOrdem(3).equals(ATIVIDADES.ATIVIDADES_EXTENSAO));
	}

	@Test
	public void testAtividadesDeExtensaoGetNomeAtividadeDeveRetornarAtividadeDeExtensao() {
		assertTrue("Enum ATIVIDADES_EXTENSAO deveria ter o nome Atividades de extens\u00e3o",
				ATIVIDADES.ATIVIDADES_EXTENSAO.getNomeAtividade().equals("Atividades de extens\u00e3o"));
	}

	@Test
	public void testAtividadesDeQualificacaoGetOrdemDeveRetornarQuatro() {
		assertTrue("Enum ATIVIDADES_QUALIFICACAO deveria retornar ordem igual a 4",
				ATIVIDADES.ATIVIDADES_QUALIFICACAO.getOrdem() == 4);
	}

	@Test
	public void testOrdemQuatroDeveRetornarAtividadesQualificacao() {
		assertTrue("Ordem 4 deveria retornar o Enum ATIVIDADES_QUALIFICACAO",
				ATIVIDADES.atividadesFromOrdem(4).equals(ATIVIDADES.ATIVIDADES_QUALIFICACAO));
	}

	@Test
	public void testAtividadesDeQualificacaoGetNomeAtividadeDeveRetornarAtividadeDeQualificacao() {
		assertTrue("Enum ATIVIDADES_QUALIFICACAO deveria ter o nome Atividades de qualifica\u00e7\u00e3o",
				ATIVIDADES.ATIVIDADES_QUALIFICACAO.getNomeAtividade().equals("Atividades de qualifica\u00e7\u00e3o"));
	}

	@Test
	public void testAtividadesAcademicasGetOrdemDeveRetornarCinco() {
		assertTrue("Enum ATIVIDADES_ACADEMICAS deveria retornar ordem igual a 5",
				ATIVIDADES.ATIVIDADES_ACADEMICAS.getOrdem() == 5);
	}

	@Test
	public void testOrdemCincoDeveRetornarAtividadesAcademicas() {
		assertTrue("Ordem 5 deveria retornar o Enum ATIVIDADES_ACADEMICAS",
				ATIVIDADES.atividadesFromOrdem(5).equals(ATIVIDADES.ATIVIDADES_ACADEMICAS));
	}

	@Test
	public void testAtividadesAcademicasGetNomeAtividadeDeveRetornarAtividadesAcademicas() {
		assertTrue("Enum ATIVIDADES_ACADEMICAS deveria ter o nome Atividades acad\u00eamicas especiais",
				ATIVIDADES.ATIVIDADES_ACADEMICAS.getNomeAtividade().equals("Atividades acad\u00eamicas especiais"));
	}

	@Test
	public void testAtividadesAdministrativasGetOrdemDeveRetornarSeis() {
		assertTrue("Enum ATIVIDADES_ADMINISTRATIVAS deveria retornar ordem igual a 6",
				ATIVIDADES.ATIVIDADES_ADMINISTRATIVAS.getOrdem() == 6);
	}

	@Test
	public void testOrdemSeisDeveRetornarAtividadesAdministrativas() {
		assertTrue("Ordem 6 deveria retornar o Enum ATIVIDADES_ADMINISTRATIVAS",
				ATIVIDADES.atividadesFromOrdem(6).equals(ATIVIDADES.ATIVIDADES_ADMINISTRATIVAS));
	}

	@Test
	public void testAtividadesAdministrativasGetNomeAtividadeDeveRetornarAtividadesAdministrativas() {
		assertTrue("Enum ATIVIDADES_ADMINISTRATIVAS deveria ter o nome Atividades administrativas",
				ATIVIDADES.ATIVIDADES_ADMINISTRATIVAS.getNomeAtividade().equals("Atividades administrativas"));
	}

	@Test
	public void testDeveTerSeisTiposDeAtividades() {
		ATIVIDADES[] formatos = ATIVIDADES.values();
		assertTrue("Deveria ter seis tipos de atividades no Enum", formatos.length == 6);
	}

}
