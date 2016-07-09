package br.com.ms.atividade.wrapper;

import org.apache.commons.lang.NotImplementedException;

import br.com.ms.enums.FORMATO_SAIDA;

/**
 * Atribui para a classe respons&aacute;vel por extrair
 * as atividades.
 */
public class AtividadeWrapper {

    private AtividadeWrapperTxt atividadeWrapperTxt;
    private AtividadeWrapperXml atividadeWrapperXml;

    /**
     * Construtor padr&atilde;o
     */
    public AtividadeWrapper() {
        atividadeWrapperTxt = new AtividadeWrapperTxt();
        atividadeWrapperXml = new AtividadeWrapperXml();
    }

    /**
     * Atribui para a classe respons&aacute;vel por extrair as atividades
     * @param conteudoPDF conte&uacute;do do PDF em String
     * @param formatoSaida formato de sa&iacute;da (TXT)
     * @return uma string com as atividades extra&iacute;das
     */
    public String wrapperAtividades(String conteudoPDF, FORMATO_SAIDA formatoSaida) {
        switch (formatoSaida) {
            case TXT:
                return atividadeWrapperTxt.extrairAtividades(conteudoPDF);
            case XML:
                return atividadeWrapperXml.extrairAtividades(conteudoPDF);
            default:
                throw new NotImplementedException("Formato n\u00e3o implementado:" + formatoSaida.getNomeFormato());
        }
    }

}
