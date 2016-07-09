package br.com.ms.atividade.wrapper;

import org.apache.commons.lang.NotImplementedException;

import br.com.ms.enums.FORMATO_SAIDA;

public class AtividadeWrapperXml extends AtividadeWrapperAbstractBase {

    @Override
    protected String extrairAtividades(String conteudoPDF) {
        throw new NotImplementedException("Extração de Atividades no Formato XML ainda não está implementado");
    }

}
