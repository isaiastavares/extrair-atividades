package br.com.ms.enums;

public enum FORMATO_SAIDA {

	TXT("Formato TXT", ".txt"),
	XML("Formato XML", ".xml");

	private String nomeFormato;
	private String extensao;

	private FORMATO_SAIDA(String nomeFormato, String extensao) {
		this.nomeFormato = nomeFormato;
		this.extensao = extensao;
	}

	public String getNomeFormato() {
		return nomeFormato;
	}

	public String getExtensao() {
		return extensao;
	}

}
