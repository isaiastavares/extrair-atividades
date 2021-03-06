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
	private static final String SEQUENCIAL_ATIVIDADE = "sequencialAtividade: ";
	private static final String DESCRICAO_ATIVIDADE = "descricaoAtividade: ";
	private static final String QTDE_HORAS_ATIVIDADE = "qtdeHorasAtividade: ";
	private static final String DT_INICIO_ATIVIDADE = "dtInicioAtividade: ";
	private static final String DT_FIM_ATIVIDADE = "dtFimAtividade: ";
	private static final String SEPARADOR = " - ";
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
	protected String extrairAtividadesOrientacao(String atividade) {
		StringBuilder sb = new StringBuilder();
		String[] linhas = atividade.split(QUEBRA_DE_LINHA);

		sb.append(getTituloAtividade(ATIVIDADES.ATIVIDADES_ORIENTACAO.getNomeAtividade()));

		for (String linha : linhas) {
			Pattern patternTituloTrabalho = Pattern.compile(Patterns.PATTERN_TITULO_TRABALHO);
			Matcher matcherTituloTrabalho = patternTituloTrabalho.matcher(linha);
			if (matcherTituloTrabalho.find()) {
				sb.append(QUEBRA_DE_LINHA);
				sb.append(getSequencialAtividade());
				sb.append(DESCRICAO_ATIVIDADE);
				sb.append(matcherTituloTrabalho.group(1));
				sb.append(QUEBRA_DE_LINHA);
			}

			sb.append(getChaDtInicioDtFim(linha));
		}
		return sb.toString();
	}

	/**
	 * Extrai as atividades de Projetos
	 * @param atividade string contendo o grupo de atividades de projetos
	 * @return string contendo as atividades de projetos
	 */
	protected String extrairAtividadesProjetos(String atividade) {
		StringBuilder sb = new StringBuilder();
		String[] linhas = atividade.split(QUEBRA_DE_LINHA);

		sb.append(getTituloAtividade(ATIVIDADES.ATIVIDADES_PROJETOS.getNomeAtividade()));

		for (String linha : linhas) {
			Pattern patternTituloProjeto = Pattern.compile(Patterns.PATTERN_TITULO_PROJETO);
			Matcher matcherTituloProjeto = patternTituloProjeto.matcher(linha);
			if (matcherTituloProjeto.find()) {
				sb.append(QUEBRA_DE_LINHA);
				sb.append(getSequencialAtividade());
				sb.append(DESCRICAO_ATIVIDADE);
				sb.append(matcherTituloProjeto.group(1));
				sb.append(QUEBRA_DE_LINHA);
			}

			sb.append(getChaDtInicioDtFim(linha));
		}
		return sb.toString();
	}

	/**
	 * Extrai as atividades de Extens&atilde;o
	 * @param atividade string contendo o grupo de atividades de Extens&atilde;o
	 * @return string contendo as atividades de Extens&atilde;o
	 */
	protected String extrairAtividadesExtensao(String atividade) {
		StringBuilder sb = new StringBuilder();
		String[] linhas = atividade.split(QUEBRA_DE_LINHA);

		sb.append(getTituloAtividade(ATIVIDADES.ATIVIDADES_EXTENSAO.getNomeAtividade()));

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
				sb.append(QUEBRA_DE_LINHA);
				sb.append(getSequencialAtividade());
				sb.append(DESCRICAO_ATIVIDADE);
				sb.append(descricaoAtividade);
				sb.append(SEPARADOR);
				sb.append(descricaoClientela);
				sb.append(QUEBRA_DE_LINHA);
				sb.append(QTDE_HORAS_ATIVIDADE);
				sb.append(qtdeHorasAtividade);
				sb.append(QUEBRA_DE_LINHA);
				sb.append(DT_INICIO_ATIVIDADE);
				sb.append(dtInicioAtividade);
				sb.append(QUEBRA_DE_LINHA);
				sb.append(DT_FIM_ATIVIDADE);
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
	protected String extrairAtividadesQualificacao(String atividade) {
		StringBuilder sb = new StringBuilder();
		String[] linhas = atividade.split(QUEBRA_DE_LINHA);

		sb.append(getTituloAtividade(ATIVIDADES.ATIVIDADES_QUALIFICACAO.getNomeAtividade()));

		for (String linha : linhas) {
			Pattern patternDescricao = Pattern.compile(Patterns.PATTERN_DESCRICAO);
			Matcher matcherDescricao = patternDescricao.matcher(linha);
			if (matcherDescricao.find()) {
				sb.append(QUEBRA_DE_LINHA);
				sb.append(getSequencialAtividade());
				sb.append(DESCRICAO_ATIVIDADE);
				sb.append(matcherDescricao.group(1));
				sb.append(QUEBRA_DE_LINHA);
			}

			Pattern patternChaDtIniDtFim = Pattern.compile(Patterns.PATTERN_CHA_DTINI_DTFIM);
			Matcher matcherChaDtIniDtFim = patternChaDtIniDtFim.matcher(linha.replace("de ", ""));
			if (matcherChaDtIniDtFim.find()) {
				sb.append(QTDE_HORAS_ATIVIDADE);
				sb.append(matcherChaDtIniDtFim.group(1));
				sb.append(QUEBRA_DE_LINHA);
				sb.append(DT_INICIO_ATIVIDADE);
				sb.append(matcherChaDtIniDtFim.group(2));
				sb.append(QUEBRA_DE_LINHA);
				sb.append(DT_FIM_ATIVIDADE);
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
	protected String extrairAtividadesAcademicas(String atividade) {
		StringBuilder sb = new StringBuilder();
		String[] linhas = atividade.split(QUEBRA_DE_LINHA);

		sb.append(getTituloAtividade(ATIVIDADES.ATIVIDADES_ACADEMICAS.getNomeAtividade()));

		String qtdeHorasAtividade = "";
		String dtInicioAtividade = "";
		String dtFimAtividade = "";
		for (String linha : linhas) {
			Pattern patternDescricaoComplementar = Pattern.compile(Patterns.PATTERN_DESCRICAO_COMPLEMENTAR);
			Matcher matcherDescricaoComplementar = patternDescricaoComplementar.matcher(linha);
			if (matcherDescricaoComplementar.find()) {
				sb.append(QUEBRA_DE_LINHA);
				sb.append(getSequencialAtividade());
				sb.append(DESCRICAO_ATIVIDADE);
				sb.append(matcherDescricaoComplementar.group(1));
				sb.append(QUEBRA_DE_LINHA);
				sb.append(QTDE_HORAS_ATIVIDADE);
				sb.append(qtdeHorasAtividade);
				sb.append(QUEBRA_DE_LINHA);
				sb.append(DT_INICIO_ATIVIDADE);
				sb.append(dtInicioAtividade);
				sb.append(QUEBRA_DE_LINHA);
				sb.append(DT_FIM_ATIVIDADE);
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
	protected String extrairAtividadesAdministrativas(String atividade) {
		StringBuilder sb = new StringBuilder();

		String[] linhas = atividade.split(QUEBRA_DE_LINHA);
		List<String> list = Arrays.asList(linhas);

		sb.append(getTituloAtividade(ATIVIDADES.ATIVIDADES_ADMINISTRATIVAS.getNomeAtividade()));

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
				sb.append(QUEBRA_DE_LINHA);
				sb.append(getSequencialAtividade());
				sb.append(DESCRICAO_ATIVIDADE);
				sb.append(tabela);
				sb.append(SEPARADOR);
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

			sb.append(getChaDtInicioDtFim(linha));
		}
		return sb.toString();
	}

	private String getChaDtInicioDtFim(String linha) {
		StringBuilder sb = new StringBuilder();
		Pattern patternChaDtIniDtFim = Pattern.compile(Patterns.PATTERN_CHA_DTINI_DTFIM);
		Matcher matcherChaDtIniDtFim = patternChaDtIniDtFim.matcher(linha);
		if (matcherChaDtIniDtFim.find()) {
			sb.append(QTDE_HORAS_ATIVIDADE);
			sb.append(matcherChaDtIniDtFim.group(1));
			sb.append(QUEBRA_DE_LINHA);
			sb.append(DT_INICIO_ATIVIDADE);
			sb.append(matcherChaDtIniDtFim.group(2));
			sb.append(QUEBRA_DE_LINHA);
			sb.append(DT_FIM_ATIVIDADE);
			sb.append(matcherChaDtIniDtFim.group(3));
			sb.append(QUEBRA_DE_LINHA);
		}
		return sb.toString();
	}

	private String getTituloAtividade(String titulo) {
		return "\n################ " + titulo + " ################\n";
	}

	private String getSequencialAtividade() {
		sequencialAtividade++;
		return SEQUENCIAL_ATIVIDADE + sequencialAtividade + QUEBRA_DE_LINHA;
	}

}
