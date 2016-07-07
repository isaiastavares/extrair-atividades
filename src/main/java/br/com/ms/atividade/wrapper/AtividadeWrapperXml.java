package br.com.ms.atividade.wrapper;

import org.apache.commons.lang.NotImplementedException;

import br.com.ms.enums.FORMATO_SAIDA;

public class AtividadeWrapperXml extends AtividadeWrapperAbstractBase {

	@Override
	protected void extrairAtividades(String caminhoPDF, String caminhoSaida) {
		throw new NotImplementedException("Extra��o de Atividades no Formato XML ainda n�o est� implementado");
	}

	@Override
	protected String getNomeArquivo() {
		return nomeArquivo + FORMATO_SAIDA.XML.getExtensao();
	}

}
