package br.com.ms.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Formatter;
import java.util.logging.Logger;

/**
 * Classe utilit&aacute;ria para trabalhar com Arquivo.
 */
public final class Arquivo {

	private static final Class<Arquivo> LOADER_CLASS = Arquivo.class;
	private static final Logger LOG = Logger.getLogger(LOADER_CLASS.getName());

	/**
	 * Construtor padrao
	 */
	private Arquivo() {
		super();
	}

	/**
	 * Salva o arquivo passando o caminho, nome do arquivo e o conteudo
	 *
	 * @param caminho
	 *            caminho onde deseja salvar o arquivo
	 * @param nomeArquivo
	 *            nome do arquivo que deseja salvar
	 * @param conteudo
	 *            conteudo do arquivo
	 */
	public static void salvarArquivo(String caminho, String nomeArquivo, String conteudo) {
		File file = new File(caminho, nomeArquivo);
		try {
			Formatter saida = new Formatter(file);
			Charset.forName("UTF-8").encode(conteudo);
			saida.format(conteudo);
            saida.flush();
			saida.close();
			LOG.info("Arquivo salvo com sucesso no caminho: " + file.getAbsolutePath());
		} catch (FileNotFoundException e) {
			LOG.warning("Falha ao salvar arquivo na pasta " + caminho);
			LOG.severe(e.getMessage());
		}
	}

	/**
	 * Obt&eacute;m o arquivo do caminho relativo
	 *
	 * @param caminhoRelativo
	 *            nome do arquivo
	 * @return o arquivo como File
	 * @throws FileNotFoundException
	 *             exce&ccedil;&atilde;o lan&ccedil;ada caso n&atilde;o encontre
	 *             o arquivo
	 */
	public static File getArquivoRelativoClasspath(String caminhoRelativo) throws FileNotFoundException {
		URL url = LOADER_CLASS.getResource(garantirBarraInicio(caminhoRelativo));
		if (url == null) {
			throw new FileNotFoundException(
					"O caminho especificado nao aponta para um arquivo ou diretorio existente relativo a raiz do classpath: "
							+ caminhoRelativo);
		}
		return new File(url.getPath());
	}

	/**
	 * Passa o nome do arquivo e retorna o conte&uacute;do em String
	 * @param nomeArquivo nome do arquivo
	 * @return o conte&uacute;do do arquivo
	 */
	public static String getConteudo(String nomeArquivo) {
		StringBuffer conteudo = new StringBuffer();
		try {
			File file = getArquivoRelativoClasspath(nomeArquivo);
			FileReader arq = new FileReader(file);
			BufferedReader lerArq = new BufferedReader(arq);

			String linha = null;
            while (( linha = lerArq.readLine()) != null) {
            	conteudo.append(linha);
            	conteudo.append(System.getProperty("line.separator"));
            }

			arq.close();
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo: %s.", e.getMessage());
		}
		return conteudo.toString();
	}

	private static String garantirBarraInicio(String path) {
		if (!(path.startsWith("/") || path.startsWith("\\") || path.indexOf(":") > 0)) {
			path = ((path.indexOf("\\") > 0) ? "\\" : "/") + path;
		}
		return path;
	}

}
