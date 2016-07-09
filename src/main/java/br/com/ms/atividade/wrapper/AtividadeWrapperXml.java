package br.com.ms.atividade.wrapper;

import org.apache.commons.lang.NotImplementedException;

import br.com.ms.enums.FORMATO_SAIDA;

public class AtividadeWrapperXml extends AtividadeWrapperAbstractBase {

	private String caminhoPDF;
	private String caminhoArquivoSaida;
	private String conteudoArquivoSaida;

	@Override
	protected void extrairAtividades(String caminhoPDF, String caminhoArquivoSaida) {
		this.caminhoPDF = caminhoPDF;
		this.caminhoArquivoSaida = caminhoArquivoSaida;
		throw new NotImplementedException("Extração de Atividades no Formato XML ainda não está implementado");
	}

	@Override
	protected String getCaminhoPDF() {
		return caminhoPDF;
	}

	@Override
	protected String getConteudoArquivoSaida() {
		return conteudoArquivoSaida;
	}

	@Override
	protected String getCaminhoArquivoSaida() {
		return caminhoArquivoSaida;
	}

	@Override
	protected String getFormatoArquivo() {
		return FORMATO_SAIDA.XML.getExtensao();
	}

}
