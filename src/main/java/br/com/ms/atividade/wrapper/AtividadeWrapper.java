package br.com.ms.atividade.wrapper;

import java.util.logging.Logger;

import br.com.ms.enums.FORMATO_SAIDA;

public class AtividadeWrapper {

	private static final Logger LOG = Logger.getLogger(AtividadeWrapper.class.getName());

	private AtividadeWrapperTxt atividadeWrapperTxt;
	private AtividadeWrapperXml atividadeWrapperXml;

	public AtividadeWrapper() {
		atividadeWrapperTxt = new AtividadeWrapperTxt();
		atividadeWrapperXml = new AtividadeWrapperXml();
	}

	public void wrapperAtividades(String caminhoPDF, String caminhoSaida, FORMATO_SAIDA formatoSaida) {
		switch (formatoSaida) {
		case TXT:
			atividadeWrapperTxt.extrairAtividades(caminhoPDF, caminhoSaida);
			break;
		case XML:
			atividadeWrapperXml.extrairAtividades(caminhoPDF, caminhoSaida);
			break;
		default:
			LOG.info("Formato não reconhecido: " + formatoSaida.getNomeFormato());
			break;
		}

	}

}
