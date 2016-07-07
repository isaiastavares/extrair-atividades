package br.com.ms.atividade.wrapper;

import java.io.IOException;
import java.util.logging.Logger;

import br.com.ms.util.PDFManager;

public abstract class AtividadeWrapperAbstractBase {

	private static final Logger LOG = Logger.getLogger(AtividadeWrapperAbstractBase.class.getName());

	protected static final String nomeArquivo = "AtividadesExtraidas";

	protected String convertPDFToText(String caminhoPDF) {
		try {
			PDFManager pdfManager = new PDFManager();
			pdfManager.setFilePath(caminhoPDF);
			return pdfManager.toText();
		} catch (IOException e) {
			LOG.severe(e.getMessage());
		}
		return null;
	}

	protected abstract void extrairAtividades(String caminhoPDF, String caminhoSaida);

	protected abstract String getNomeArquivo();

}
