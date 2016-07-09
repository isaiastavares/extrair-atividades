package br.com.ms.enums;

/**
 * Enum contendo os tipos de documentos que
 * a aplica&ccedil;&atilde;o ir&aacute; ler.
 *
 * Por enquanto, s&oacute; est&aacute; implementado o RADOC.
 */
public enum TIPO_DOCUMENTO {

	RADOC("Radoc");

	private String nomeDocumento;

	private TIPO_DOCUMENTO(String nomeDocumento) {
		this.nomeDocumento = nomeDocumento;
	}

	/**
	 * @return o nome do documento
	 */
	public String getNomeDocumento() {
		return nomeDocumento;
	}
}
