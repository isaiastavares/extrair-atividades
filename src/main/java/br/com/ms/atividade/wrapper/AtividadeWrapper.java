package br.com.ms.atividade.wrapper;

import br.com.ms.enums.FORMATO_SAIDA;
import org.apache.commons.lang.NotImplementedException;

public class AtividadeWrapper {

    private AtividadeWrapperTxt atividadeWrapperTxt;
    private AtividadeWrapperXml atividadeWrapperXml;

    public AtividadeWrapper() {
        atividadeWrapperTxt = new AtividadeWrapperTxt();
        atividadeWrapperXml = new AtividadeWrapperXml();
    }

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
