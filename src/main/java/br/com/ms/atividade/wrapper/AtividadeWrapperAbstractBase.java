package br.com.ms.atividade.wrapper;

import java.io.IOException;
import java.util.logging.Logger;

import br.com.ms.util.Arquivo;
import br.com.ms.util.PDFManager;

public abstract class AtividadeWrapperAbstractBase {

	private static final Logger LOG = Logger.getLogger(AtividadeWrapperAbstractBase.class.getName());

	protected static final String nomeArquivo = "AtividadesExtraidas";

	protected abstract String extrairAtividades(String conteudoPDF);

//	protected String convertPDFToText() {
//		try {
//			PDFManager pdfManager = new PDFManager();
//			pdfManager.setFilePath(getCaminhoPDF());
//			return pdfManager.toText();
//		} catch (IOException e) {
//			LOG.severe(e.getMessage());
//		}
//		return null;
//	}

//	protected void salvar() {
//		Arquivo.salvarArquivo(getCaminhoArquivoSaida(),
//				nomeArquivo + getFormatoArquivo(),
//				getConteudoArquivoSaida());
//	}

//	protected abstract String getCaminhoPDF();
//
//	protected abstract String getConteudoArquivoSaida();
//
//	protected abstract String getCaminhoArquivoSaida();
//
//	protected abstract String getFormatoArquivo();

}
