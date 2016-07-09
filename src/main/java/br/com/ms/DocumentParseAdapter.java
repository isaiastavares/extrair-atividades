package br.com.ms;

import java.util.logging.Logger;

import br.com.ms.atividade.wrapper.AtividadeWrapper;
import br.com.ms.enums.FORMATO_SAIDA;
import br.com.ms.enums.TIPO_DOCUMENTO;
import org.apache.commons.lang.NotImplementedException;

public class DocumentParseAdapter {

    private AtividadeWrapper wrapperAtividades;

    public DocumentParseAdapter() {
        wrapperAtividades = new AtividadeWrapper();
    }

    public String parsearPDF(TIPO_DOCUMENTO tipoDocumento, String conteudoPDF, FORMATO_SAIDA formatoSaida) {
        switch (tipoDocumento) {
            case RADOC:
                return wrapperAtividades.wrapperAtividades(conteudoPDF, formatoSaida);
            default:
                throw new NotImplementedException("Tipo de documento não implementado: " + tipoDocumento.getNomeDocumento());
        }

    }

}
