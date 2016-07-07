package br.com.ms.atividade.wrapper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.ms.enums.FORMATO_SAIDA;

public class AtividadeWrapperTxt extends AtividadeWrapperAbstractBase {

	private static final String PATTERN_TITULO_TRABALHO = "T�tulo do trabalho: (.*)";
	private static final String PATTERN_TITULO_PROJETO = "T�tulo do Projeto: (.*)";
	private static final String PATTERN_CHA_DTINI_DTFIM = "CHA: ([0-9]+) Data [a-zA-Z]n�cio: ([0-9]{2}\\/[0-9]{2}\\/[0-9]{4}) Data [a-zA-Z]�rmino: ([0-9]{2}\\/[0-9]{2}\\/[0-9]{4}) *";

	@Override
	protected void extrairAtividades(String caminhoPDF, String caminhoSaida) {
		String conteudoPDF = convertPDFToText(caminhoPDF);

		String[] linhas = conteudoPDF.split("\n");

		for (String linha : linhas) {
			//Atividades de orienta��o
			Pattern patternTituloTrabalho = Pattern.compile(PATTERN_TITULO_TRABALHO);
			Matcher matcherTituloTrabalho = patternTituloTrabalho.matcher(linha);
			if (matcherTituloTrabalho.find()) {
				System.out.println("T�tulo: " + matcherTituloTrabalho.group(1));
			}
			Pattern patternChaDtIniDtFim = Pattern.compile(PATTERN_CHA_DTINI_DTFIM);
			Matcher matcherChaDtIniDtFim = patternChaDtIniDtFim.matcher(linha);
			if (matcherChaDtIniDtFim.find()) {
				System.out.println("CHA: " + matcherChaDtIniDtFim.group(1));
				System.out.println("Data in�cio: " + matcherChaDtIniDtFim.group(2));
				System.out.println("Data t�rmino: " + matcherChaDtIniDtFim.group(3));
			}

			//Atividades em projetos
			Pattern patternTituloProjeto = Pattern.compile(PATTERN_TITULO_PROJETO);
			Matcher matcherTituloProjeto = patternTituloProjeto.matcher(linha);
			if (matcherTituloProjeto.find()) {
				System.out.println("T�tulo: " + matcherTituloProjeto.group(1));
			}
		}
	}

	@Override
	protected String getNomeArquivo() {
		return nomeArquivo + FORMATO_SAIDA.TXT.getExtensao();
	}

}
