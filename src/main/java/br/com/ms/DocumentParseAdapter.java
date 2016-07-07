package br.com.ms;

import java.util.logging.Logger;

import br.com.ms.atividade.wrapper.AtividadeWrapper;
import br.com.ms.enums.FORMATO_SAIDA;
import br.com.ms.enums.TIPO_DOCUMENTO;

public class DocumentParseAdapter {

	private static final Logger LOG = Logger.getLogger(DocumentParseAdapter.class.getName());

	private AtividadeWrapper wrapperAtividades;

	public DocumentParseAdapter() {
		wrapperAtividades = new AtividadeWrapper();
	}

	public void parsearPDF(TIPO_DOCUMENTO tipoDocumento, String caminhoPDF, String caminhoSaida,
			FORMATO_SAIDA formatoSaida) {
		switch (tipoDocumento) {
		case RADOC:
			wrapperAtividades.wrapperAtividades(caminhoPDF, caminhoSaida, formatoSaida);
			break;
		default:
			LOG.info("Tipo de documento não reconhecido: " + tipoDocumento.getNomeDocumento());
			break;
		}

	}

}
