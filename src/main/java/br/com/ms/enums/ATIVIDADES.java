package br.com.ms.enums;

/**
 * Enum contendo as atividades que precisam ser extra&iacute;das
 * do RADOC.
 */
public enum ATIVIDADES {

	ATIVIDADES_ORIENTACAO(1, "Atividades de orientação"),
	ATIVIDADES_PROJETOS(2, "Atividades em projetos"),
	ATIVIDADES_EXTENSAO(3, "Atividades de extensão"),
	ATIVIDADES_QUALIFICACAO(4, "Atividades de qualificação"),
	ATIVIDADES_ACADEMICAS(5, "Atividades acadêmicas especiais"),
	ATIVIDADES_ADMINISTRATIVAS(6, "Atividades administrativas");

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
