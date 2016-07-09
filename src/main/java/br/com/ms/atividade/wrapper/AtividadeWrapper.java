package br.com.ms.atividade.wrapper;

import org.apache.commons.lang.NotImplementedException;

import br.com.ms.enums.FORMATO_SAIDA;

/**
 * Atribui para a classe responsavel por extrair
 * as atividades.
 */
public class AtividadeWrapper {

    private AtividadeWrapperTxt atividadeWrapperTxt;
    private AtividadeWrapperXml atividadeWrapperXml;

    /**
     * Construtor padrao
     */
    public AtividadeWrapper() {
        atividadeWrapperTxt = new AtividadeWrapperTxt();
        atividadeWrapperXml = new AtividadeWrapperXml();
    }

    /**
     * Atribui para a classe responsavel por extrair as atividades
     * @param conteudoPDF conteudo do PDF em String
     * @param formatoSaida formato de saida (TXT)
     * @return uma string com as atividades extraidas
     */
    public String wrapperAtividades(String conteudoPDF, FORMATO_SAIDA formatoSaida) {
        switch (formatoSaida) {
            case TXT:
                return atividadeWrapperTxt.extrairAtividades(conteudoPDF);
            case XML:
                return atividadeWrapperXml.extrairAtividades(conteudoPDF);
            default:
                throw new NotImplementedException("Formato não implementado:" + formatoSaida.getNomeFormato());
        }
    }

}
