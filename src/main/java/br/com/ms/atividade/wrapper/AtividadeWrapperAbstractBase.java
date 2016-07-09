package br.com.ms.atividade.wrapper;

import java.io.IOException;
import java.util.logging.Logger;

import br.com.ms.util.Arquivo;
import br.com.ms.util.PDFManager;

public abstract class AtividadeWrapperAbstractBase {

	protected abstract String extrairAtividades(String conteudoPDF);

}
