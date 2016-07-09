package br.com.ms;

import org.apache.commons.lang.NotImplementedException;

import br.com.ms.atividade.wrapper.AtividadeWrapper;
import br.com.ms.enums.FORMATO_SAIDA;
import br.com.ms.enums.TIPO_DOCUMENTO;

/**
 * Atribui para a classe respons&aacute;vel por ler o documento desejado
 */
public class DocumentParseAdapter {

    private AtividadeWrapper wrapperAtividades;

    /**
     * Construtor padr&atilde;o
     */
    public DocumentParseAdapter() {
        wrapperAtividades = new AtividadeWrapper();
    }

    /**
     * Parsear o PDF passando o tipo de documento, o conte&uacute;do e o formato de sa&iacute;da
     * @param tipoDocumento tipo de documento, por enquanto so atende Radoc
     * @param conteudoPDF conteudo do PDF em String
     * @param formatoSaida formato de Sa&iacute;da (por enquanto s&oacute; esta implementado TXT)
     * @return uma string com as atividades extra&iacute;das do Radoc
     */
    public String parsearPDF(TIPO_DOCUMENTO tipoDocumento, String conteudoPDF, FORMATO_SAIDA formatoSaida) {
        switch (tipoDocumento) {
            case RADOC:
                return wrapperAtividades.wrapperAtividades(conteudoPDF, formatoSaida);
            default:
                throw new NotImplementedException("Tipo de documento n\u00e3o implementado: "
                		+ tipoDocumento.getNomeDocumento());
        }

    }

}
