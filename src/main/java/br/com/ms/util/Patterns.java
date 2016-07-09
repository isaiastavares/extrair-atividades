package br.com.ms.util;

/**
 * Classe utilit&aacute;ria contendo todos os Patterns utilizados
 */
public final class Patterns {

	/**
	 * Construtor padrao
	 */
	private Patterns() {
		super();
	}

	public static final String PATTERN_TITULO_TRABALHO = "T\u00edtulo do trabalho: (.*)";
	public static final String PATTERN_TITULO_PROJETO = "T\u00edtulo do Projeto: (.*)";
	public static final String PATTERN_DESCRICAO = "Descri\u00e7\u00e3o:(.*)";
	public static final String PATTERN_DESCRICAO_CUSTOMIZADA = "(Descri\u00e7\u00e3o:.*\n)(.*)(\r\n)(.*)(\n\u00d3rg\u00e3o emissor.*)";
	public static final String PATTERN_DESCRICAO_ATIVIDADE = "Descri\u00e7\u00e3o da atividade: (.*)";
	public static final String PATTERN_DESCRICAO_CLIENTELA = "Descri\u00e7\u00e3o da clientela: (.*)";
	public static final String PATTERN_DESCRICAO_COMPLEMENTAR = "Descri\u00e7\u00e3o Complementar: (.*)";
	public static final String PATTERN_TABELA = "Tabela: (.*)";
	public static final String PATTERN_CHA_DTINI_DTFIM = "CHA: ([0-9]+) Data [a-zA-Z]n\u00edcio: ([0-9]{2}\\/[0-9]{2}\\/[0-9]{4}) Data [a-zA-Z]\u00e9rmino: ([0-9]{2}\\/[0-9]{2}\\/[0-9]{4}) *";

}
