package br.com.ms.atividade.wrapper;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import br.com.ms.enums.ATIVIDADES;
import br.com.ms.util.Patterns;

/**
 * Implementa&ccedil;&atilde;o da classe {@link IAtividadeWrapper} para arquivos
 * do tipo TXT
 */
public class AtividadeWrapperTxt implements IAtividadeWrapper {

	private static final String QUEBRA_DE_LINHA = "\n";
	private int sequencialAtividade = 0;

	private StringBuilder atividadesOrientacao;
	private StringBuilder atividadesProjeto;
	private StringBuilder atividadesExtensao;
	private StringBuilder atividadesQualificacao;
	private StringBuilder atividadesAcademicas;
	private StringBuilder atividadesAdministrativas;

	public String extrairAtividades(String conteudoPDF) {

		String[] linha = conteudoPDF.split(QUEBRA_DE_LINHA);

		atividadesOrientacao = new StringBuilder();
		atividadesProjeto = new StringBuilder();
		atividadesExtensao = new StringBuilder();
		atividadesQualificacao = new StringBuilder();
		atividadesAcademicas = new StringBuilder();
		atividadesAdministrativas = new StringBuilder();
		int ordem = 1;
		for (int i = 0; i < linha.length; i++) {
			if (linha[i].contains(ATIVIDADES.atividadesFromOrdem(ordem).getNomeAtividade())) {
				i++;
				while (!linha[i].contains(ATIVIDADES.atividadesFromOrdem(ordem + 1).getNomeAtividade())) {
					atividadesOrientacao.append(linha[i++] + QUEBRA_DE_LINHA);
				}
				ordem++;
			}
			if (linha[i].contains(ATIVIDADES.atividadesFromOrdem(ordem).getNomeAtividade())) {
				i++;
				while (!linha[i].contains(ATIVIDADES.atividadesFromOrdem(ordem + 1).getNomeAtividade())) {
					atividadesProjeto.append(linha[i++] + QUEBRA_DE_LINHA);
				}
				ordem++;
			}
			if (linha[i].contains(ATIVIDADES.atividadesFromOrdem(ordem).getNomeAtividade())) {
				i++;
				while (!linha[i].contains(ATIVIDADES.atividadesFromOrdem(ordem + 1).getNomeAtividade())) {
					atividadesExtensao.append(linha[i++] + QUEBRA_DE_LINHA);
				}
				ordem++;
			}
			if (linha[i].contains(ATIVIDADES.atividadesFromOrdem(ordem).getNomeAtividade())) {
				i++;
				while (!linha[i].contains(ATIVIDADES.atividadesFromOrdem(ordem + 1).getNomeAtividade())) {
					atividadesQualificacao.append(linha[i++] + QUEBRA_DE_LINHA);
				}
				ordem++;
			}
			if (linha[i].contains(ATIVIDADES.atividadesFromOrdem(ordem).getNomeAtividade())) {
				i++;
				while (!linha[i].contains(ATIVIDADES.atividadesFromOrdem(ordem + 1).getNomeAtividade())) {
					atividadesAcademicas.append(linha[i++] + QUEBRA_DE_LINHA);
				}
				ordem++;
			}
			if (linha[i].contains(ATIVIDADES.atividadesFromOrdem(ordem).getNomeAtividade())) {
				i++;
				while (!linha[i].contains("Produtos")) {
					atividadesAdministrativas.append(linha[i++] + QUEBRA_DE_LINHA);
				}
				ordem++;
				break;
			}
		}

		StringBuilder atividadesExtraidas = new StringBuilder();
		atividadesExtraidas.append(extrairAtividadesOrientacao(atividadesOrientacao.toString()));
		atividadesExtraidas.append(extrairAtividadesProjetos(atividadesProjeto.toString()));
		atividadesExtraidas.append(extrairAtividadesExtensao(atividadesExtensao.toString()));
		atividadesExtraidas.append(extrairAtividadesQualificacao(atividadesQualificacao.toString()));
		atividadesExtraidas.append(extrairAtividadesAcademicas(atividadesAcademicas.toString()));
		atividadesExtraidas.append(extrairAtividadesAdministrativas(atividadesAdministrativas.toString()));

		return atividadesExtraidas.toString();
	}

	/**
	 * Extrai as atividades de Orienta&ccedil;&atilde;o
	 * @param atividade string contendo o grupo de atividades de orienta&ccedil;&atilde;o
	 * @return string contendo as atividades de orienta&ccedil;&atilde;o
	 */
	private String extrairAtividadesOrientacao(String atividade) {
		StringBuilder sb = new StringBuilder();
		String[] linhas = atividade.split(QUEBRA_DE_LINHA);

		for (String linha : linhas) {
			Pattern patternTituloTrabalho = Pattern.compile(Patterns.PATTERN_TITULO_TRABALHO);
			Matcher matcherTituloTrabalho = patternTituloTrabalho.matcher(linha);
			if (matcherTituloTrabalho.find()) {
				sb.append(getSequencialAtividade());
				sb.append("descricaoAtividade: ");
				sb.append(matcherTituloTrabalho.group(1));
				sb.append(QUEBRA_DE_LINHA);
			}

			Pattern patternChaDtIniDtFim = Pattern.compile(Patterns.PATTERN_CHA_DTINI_DTFIM);
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
		}
		return sb.toString();
	}

	/**
	 * Extrai as atividades de Projetos
	 * @param atividade string contendo o grupo de atividades de projetos
	 * @return string contendo as atividades de projetos
	 */
	private String extrairAtividadesProjetos(String atividade) {
		StringBuilder sb = new StringBuilder();
		String[] linhas = atividade.split(QUEBRA_DE_LINHA);

		for (String linha : linhas) {
			Pattern patternTituloProjeto = Pattern.compile(Patterns.PATTERN_TITULO_PROJETO);
			Matcher matcherTituloProjeto = patternTituloProjeto.matcher(linha);
			if (matcherTituloProjeto.find()) {
				sb.append(getSequencialAtividade());
				sb.append("descricaoAtividade: ");
				sb.append(matcherTituloProjeto.group(1));
				sb.append(QUEBRA_DE_LINHA);
			}

			Pattern patternChaDtIniDtFim = Pattern.compile(Patterns.PATTERN_CHA_DTINI_DTFIM);
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
		}
		return sb.toString();
	}

	/**
	 * Extrai as atividades de Extens&atilde;o
	 * @param atividade string contendo o grupo de atividades de Extens&atilde;o
	 * @return string contendo as atividades de Extens&atilde;o
	 */
	private String extrairAtividadesExtensao(String atividade) {
		StringBuilder sb = new StringBuilder();
		String[] linhas = atividade.split(QUEBRA_DE_LINHA);

		String descricaoAtividade = "";
		String descricaoClientela = "";
		String qtdeHorasAtividade = "";
		String dtInicioAtividade = "";
		String dtFimAtividade = "";
		for (String linha : linhas) {
			Pattern patternDescricaoAtividade = Pattern.compile(Patterns.PATTERN_DESCRICAO_ATIVIDADE);
			Matcher matcherDescricaoAtividade = patternDescricaoAtividade.matcher(linha);
			if (matcherDescricaoAtividade.find()) {
				descricaoAtividade = matcherDescricaoAtividade.group(1);
			}
			Pattern patternDescricaoClientela = Pattern.compile(Patterns.PATTERN_DESCRICAO_CLIENTELA);
			Matcher matcherDescricaoClientela = patternDescricaoClientela.matcher(linha);
			if (matcherDescricaoClientela.find()) {
				descricaoClientela = matcherDescricaoClientela.group(1);
				sb.append(getSequencialAtividade());
				sb.append("descricaoAtividade: ");
				sb.append(descricaoAtividade);
				sb.append(" - ");
				sb.append(descricaoClientela);
				sb.append(QUEBRA_DE_LINHA);
				sb.append("qtdeHorasAtividade: ");
				sb.append(qtdeHorasAtividade);
				sb.append(QUEBRA_DE_LINHA);
				sb.append("dtInicioAtividade: ");
				sb.append(dtInicioAtividade);
				sb.append(QUEBRA_DE_LINHA);
				sb.append("dtFimAtividade: ");
				sb.append(dtFimAtividade);
				sb.append(QUEBRA_DE_LINHA);
			}

			Pattern patternChaDtIniDtFim = Pattern.compile(Patterns.PATTERN_CHA_DTINI_DTFIM);
			Matcher matcherChaDtIniDtFim = patternChaDtIniDtFim.matcher(linha);
			if (matcherChaDtIniDtFim.find()) {
				qtdeHorasAtividade = matcherChaDtIniDtFim.group(1);
				dtInicioAtividade = matcherChaDtIniDtFim.group(2);
				dtFimAtividade = matcherChaDtIniDtFim.group(3);
			}
		}
		return sb.toString();
	}

	/**
	 * Extrai as atividades de Qualifica&ccedil;&atilde;o
	 * @param atividade string contendo o grupo de atividades de Qualifica&ccedil;&atilde;o
	 * @return string contendo as atividades de Qualifica&ccedil;&atilde;o
	 */
	private String extrairAtividadesQualificacao(String atividade) {
		StringBuilder sb = new StringBuilder();
		String[] linhas = atividade.split(QUEBRA_DE_LINHA);

		for (String linha : linhas) {
			Pattern patternDescricao = Pattern.compile(Patterns.PATTERN_DESCRICAO);
			Matcher matcherDescricao = patternDescricao.matcher(linha);
			if (matcherDescricao.find()) {
				sb.append(getSequencialAtividade());
				sb.append("descricaoAtividade: ");
				sb.append(matcherDescricao.group(1));
				sb.append(QUEBRA_DE_LINHA);
			}

			Pattern patternChaDtIniDtFim = Pattern.compile(Patterns.PATTERN_CHA_DTINI_DTFIM);
			Matcher matcherChaDtIniDtFim = patternChaDtIniDtFim.matcher(linha.replace("de ", ""));
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
		}
		return sb.toString();
	}

	/**
	 * Extrai as atividades Acad&ecirc;micas
	 * @param atividade string contendo o grupo de atividades Acad&ecirc;micas
	 * @return string contendo as atividades Acad&ecirc;micas
	 */
	private String extrairAtividadesAcademicas(String atividade) {
		StringBuilder sb = new StringBuilder();
		String[] linhas = atividade.split(QUEBRA_DE_LINHA);

		String qtdeHorasAtividade = "";
		String dtInicioAtividade = "";
		String dtFimAtividade = "";
		for (String linha : linhas) {
			Pattern patternDescricaoComplementar = Pattern.compile(Patterns.PATTERN_DESCRICAO_COMPLEMENTAR);
			Matcher matcherDescricaoComplementar = patternDescricaoComplementar.matcher(linha);
			if (matcherDescricaoComplementar.find()) {
				sb.append(getSequencialAtividade());
				sb.append("descricaoAtividade: ");
				sb.append(matcherDescricaoComplementar.group(1));
				sb.append(QUEBRA_DE_LINHA);
				sb.append("qtdeHorasAtividade: ");
				sb.append(qtdeHorasAtividade);
				sb.append(QUEBRA_DE_LINHA);
				sb.append("dtInicioAtividade: ");
				sb.append(dtInicioAtividade);
				sb.append(QUEBRA_DE_LINHA);
				sb.append("dtFimAtividade: ");
				sb.append(dtFimAtividade);
				sb.append(QUEBRA_DE_LINHA);
			}

			Pattern patternChaDtIniDtFim = Pattern.compile(Patterns.PATTERN_CHA_DTINI_DTFIM);
			Matcher matcherChaDtIniDtFim = patternChaDtIniDtFim.matcher(linha);
			if (matcherChaDtIniDtFim.find()) {
				qtdeHorasAtividade = matcherChaDtIniDtFim.group(1);
				dtInicioAtividade = matcherChaDtIniDtFim.group(2);
				dtFimAtividade = matcherChaDtIniDtFim.group(3);
			}
		}
		return sb.toString();
	}

	/**
	 * Extrai as atividades Administrativas
	 * @param atividade string contendo o grupo de atividades Administrativas
	 * @return string contendo as atividades Administrativas
	 */
	private String extrairAtividadesAdministrativas(String atividade) {
		StringBuilder sb = new StringBuilder();

		String[] linhas = atividade.split(QUEBRA_DE_LINHA);
		List<String> list = Arrays.asList(linhas);

		String tabela = "";
		for (String linha : list) {
			Pattern patternTabela = Pattern.compile(Patterns.PATTERN_TABELA);
			Matcher matcherTabela = patternTabela.matcher(linha);
			if (matcherTabela.find()) {
				tabela = matcherTabela.group(1);
			}
			Pattern patternDescricao = Pattern.compile(Patterns.PATTERN_DESCRICAO);
			Matcher matcherDescricao = patternDescricao.matcher(linha);
			if (matcherDescricao.find()) {
				sb.append(getSequencialAtividade());
				sb.append("descricaoAtividade: ");
				sb.append(tabela);
				sb.append(" - ");
				int posicaoDescricao = list.indexOf(linha);
				List<String> subList = list.subList(posicaoDescricao, list.size() - 1);
				StringBuilder subListBuilder = new StringBuilder();
				for (String string : subList) {
					subListBuilder.append(string + QUEBRA_DE_LINHA);
				}
				String descricaoCustomizada = "";
				Pattern patternDescricaoCustomizada = Pattern.compile(Patterns.PATTERN_DESCRICAO_CUSTOMIZADA);
				Matcher matcher = patternDescricaoCustomizada.matcher(subListBuilder.toString());
				if (matcher.find()) {
					descricaoCustomizada = matcher.group(2) + matcher.group(4);
				}
				sb.append(StringUtils.isNotBlank(descricaoCustomizada) ? descricaoCustomizada : matcherDescricao.group(1));
				sb.append(QUEBRA_DE_LINHA);
			}

			Pattern patternChaDtIniDtFim = Pattern.compile(Patterns.PATTERN_CHA_DTINI_DTFIM);
			Matcher matcherChaDtIniDtFim = patternChaDtIniDtFim.matcher(linha.replace("de ", ""));
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
		}
		return sb.toString();
	}

	private String getSequencialAtividade() {
		sequencialAtividade++;
		return "sequencialAtividade: " + sequencialAtividade + QUEBRA_DE_LINHA;
	}

}
