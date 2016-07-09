package br.com.ms.enums;

/**
 *	Enum contendo os formatos poss&iacute;veis para Extra&ccedil;&atilde;o das Atividades
 */
public enum FORMATO_SAIDA {

	TXT("Formato TXT", ".txt"),
	XML("Formato XML", ".xml");

	private String nomeFormato;
	private String extensao;

	private FORMATO_SAIDA(String nomeFormato, String extensao) {
		this.nomeFormato = nomeFormato;
		this.extensao = extensao;
	}

	/**
	 * @return o nome do formato
	 */
	public String getNomeFormato() {
		return nomeFormato;
	}

	/**
	 * @return a extens&atilde;o do formato
	 */
	public String getExtensao() {
		return extensao;
	}

}
