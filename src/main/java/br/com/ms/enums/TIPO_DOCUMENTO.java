package br.com.ms.enums;

public enum TIPO_DOCUMENTO {

	RADOC("Radoc");

	private String nomeDocumento;

	private TIPO_DOCUMENTO(String nomeDocumento) {
		this.nomeDocumento = nomeDocumento;
	}

	public String getNomeDocumento() {
		return nomeDocumento;
	}
}
