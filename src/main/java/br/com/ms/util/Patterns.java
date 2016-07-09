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

	public static final String PATTERN_TITULO_TRABALHO = "Título do trabalho: (.*)";
	public static final String PATTERN_TITULO_PROJETO = "Título do Projeto: (.*)";
	public static final String PATTERN_DESCRICAO = "Descrição:(.*)";
	public static final String PATTERN_DESCRICAO_CUSTOMIZADA = "(Descrição:.*\n)(.*)(\r\n)(.*)(\nÓrgão emissor.*)";
	public static final String PATTERN_DESCRICAO_ATIVIDADE = "Descrição da atividade: (.*)";
	public static final String PATTERN_DESCRICAO_CLIENTELA = "Descrição da clientela: (.*)";
	public static final String PATTERN_DESCRICAO_COMPLEMENTAR = "Descrição Complementar: (.*)";
	public static final String PATTERN_TABELA = "Tabela: (.*)";
	public static final String PATTERN_CHA_DTINI_DTFIM = "CHA: ([0-9]+) Data [a-zA-Z]nício: ([0-9]{2}\\/[0-9]{2}\\/[0-9]{4}) Data [a-zA-Z]érmino: ([0-9]{2}\\/[0-9]{2}\\/[0-9]{4}) *";

}
