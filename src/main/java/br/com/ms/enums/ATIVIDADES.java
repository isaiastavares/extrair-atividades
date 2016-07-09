package br.com.ms.enums;

/**
 * Enum contendo as atividades que precisam ser extra&iacute;das
 * do RADOC.
 */
public enum ATIVIDADES {

	ATIVIDADES_ORIENTACAO(1, "AtividadeWrapper de orienta\u00e7\u00e3o"),
	ATIVIDADES_PROJETOS(2, "AtividadeWrapper em projetos"),
	ATIVIDADES_EXTENSAO(3, "AtividadeWrapper de extens\u00e3o"),
	ATIVIDADES_QUALIFICACAO(4, "AtividadeWrapper de qualifica\u00e7\u00e3o"),
	ATIVIDADES_ACADEMICAS(5, "AtividadeWrapper acad\u00eamicas especiais"),
	ATIVIDADES_ADMINISTRATIVAS(6, "AtividadeWrapper administrativas");

	private String nomeAtividade;
	private int ordem;

	ATIVIDADES(int ordem, String nomeAtividade) {
		this.ordem = ordem;
		this.nomeAtividade = nomeAtividade;
	}

	/**
	 * Retorna {@link ATIVIDADES} pela ordem
	 * @param ordem ordem da atividade
	 * @return {@link ATIVIDADES}
	 */
	public static ATIVIDADES atividadesFromOrdem(int ordem) {
		ATIVIDADES[] atividades = ATIVIDADES.values();
		for (int i = 0; i < atividades.length; i++) {
			if (atividades[i].getOrdem() == ordem) {
				return atividades[i];
			}
		}
		return null;
	}

	/**
	 * Retorna o nome da atividade
	 * @return o nome da atividade
	 */
	public String getNomeAtividade() {
		return nomeAtividade;
	}

	/**
	 * Retorna a ordem da atividade no RADOC.
	 * @return a ordem da atividade no RADOC.
	 */
	public int getOrdem() {
		return ordem;
	}
}
