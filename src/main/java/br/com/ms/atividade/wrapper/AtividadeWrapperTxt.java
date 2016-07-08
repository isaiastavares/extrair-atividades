package br.com.ms.atividade.wrapper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.ms.enums.FORMATO_SAIDA;

public class AtividadeWrapperTxt extends AtividadeWrapperAbstractBase {

	private static final String PATTERN_TITULO_TRABALHO = "Título do trabalho: (.*)";
	private static final String PATTERN_TITULO_PROJETO = "Título do Projeto: (.*)";
	private static final String PATTERN_TABELA = "Tabela: (.*)";
	private static final String PATTERN_CHA_DTINI_DTFIM = "CHA: ([0-9]+) Data [a-zA-Z]nício: ([0-9]{2}\\/[0-9]{2}\\/[0-9]{4}) Data [a-zA-Z]érmino: ([0-9]{2}\\/[0-9]{2}\\/[0-9]{4}) *";

	private static final String QUEBRA_DE_LINHA = "\n";
	private int sequencialAtividade = 0;

	private String caminhoPDF;
	private String caminhoArquivoSaida;
	private String conteudoArquivoSaida;

	@Override
	protected void extrairAtividades(String caminhoPDF, String caminhoArquivoSaida) {
		this.caminhoPDF = caminhoPDF;
		this.caminhoArquivoSaida = caminhoArquivoSaida;
		String conteudoPDF = convertPDFToText();

		String[] linhas = conteudoPDF.split(QUEBRA_DE_LINHA);

		StringBuilder sb = new StringBuilder();
		for (String linha : linhas) {
			//Atividades de orientação
			Pattern patternTituloTrabalho = Pattern.compile(PATTERN_TITULO_TRABALHO);
			Matcher matcherTituloTrabalho = patternTituloTrabalho.matcher(linha);
			if (matcherTituloTrabalho.find()) {
				sb.append(getSequencialAtividade());
				sb.append("descricaoAtividade: ");
				sb.append(matcherTituloTrabalho.group(1));
				sb.append(QUEBRA_DE_LINHA);
			}

			//Quantidade de Horas de Atividade
			//Data Inicio da Atividade
			//Data Final da Atividade
			Pattern patternChaDtIniDtFim = Pattern.compile(PATTERN_CHA_DTINI_DTFIM);
			Matcher matcherChaDtIniDtFim = patternChaDtIniDtFim.matcher(linha);
			if (matcherChaDtIniDtFim.find()) {
				sb.append("qtdeHorasAtividade: ");
				sb.append(matcherChaDtIniDtFim.group(1));
				sb.append(QUEBRA_DE_LINHA);
				sb.append("dtInicioAtividade: ");
				sb.append(matcherChaDtIniDtFim.group(2));
				sb.append(QUEBRA_DE_LINHA);
				sb.append("dtFimAtividade: ");
				sb.append(matcherChaDtIniDtFim.group(3));
				sb.append(QUEBRA_DE_LINHA);
			}

			//Atividades em projetos
			Pattern patternTituloProjeto = Pattern.compile(PATTERN_TITULO_PROJETO);
			Matcher matcherTituloProjeto = patternTituloProjeto.matcher(linha);
			if (matcherTituloProjeto.find()) {
				sb.append(getSequencialAtividade());
				sb.append("descricaoAtividade: ");
				sb.append(matcherTituloProjeto.group(1));
				sb.append(QUEBRA_DE_LINHA);
			}

			//Demais Atividades
			Pattern patternTabela = Pattern.compile(PATTERN_TABELA);
			Matcher matcherTabela = patternTabela.matcher(linha);
			if (matcherTabela.find()) {
				sb.append(getSequencialAtividade());
				sb.append("descricaoAtividade: ");
				sb.append(matcherTabela.group(1));
				sb.append(QUEBRA_DE_LINHA);
			}
		}
		this.conteudoArquivoSaida = sb.toString();
		System.out.println(getConteudoArquivoSaida());
		salvar();
	}

	private String getSequencialAtividade() {
		sequencialAtividade++;
		return "sequencialAtividade: " + sequencialAtividade + QUEBRA_DE_LINHA;
	}

	@Override
	protected String getCaminhoPDF() {
		return caminhoPDF;
	}

	@Override
	protected String getConteudoArquivoSaida() {
		return conteudoArquivoSaida;
	}

	@Override
	protected String getCaminhoArquivoSaida() {
		return caminhoArquivoSaida;
	}

	@Override
	protected String getFormatoArquivo() {
		return FORMATO_SAIDA.TXT.getExtensao();
	}

}
