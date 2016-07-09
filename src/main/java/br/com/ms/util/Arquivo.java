package br.com.ms.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Formatter;
import java.util.logging.Logger;

public final class Arquivo {

	private static final Class<Arquivo> LOADER_CLASS = Arquivo.class;
	private static final Logger LOG = Logger.getLogger(LOADER_CLASS.getName());

	private Arquivo() {
		super();
	}

	public static void salvarArquivo(String caminho, String nomeArquivo, String conteudo) {
		File file = new File(caminho, nomeArquivo);
		try {
			Formatter saida = new Formatter(file);
			Charset.forName("UTF-8").encode(conteudo);
			saida.format(conteudo);
			saida.close();
			LOG.info("Arquivo salvo com sucesso no caminho: " + file.getAbsolutePath());
		} catch (FileNotFoundException e) {
			LOG.warning("Falha ao salvar arquivo na pasta " + caminho);
			LOG.severe(e.getMessage());
		}
	}

	public static File getArquivoRelativoClasspath(String caminhoRelativo) throws FileNotFoundException {
		URL url = LOADER_CLASS.getResource(garantirBarraInicio(caminhoRelativo));
		if (url == null) {
			throw new FileNotFoundException("O caminho especificado nao aponta para um arquivo ou diretorio existente relativo a raiz do classpath: " + caminhoRelativo);
		}
//		try {
//			return new File(URLDecoder.decode(resource.getPath(), "UTF-8"));
//		} catch (UnsupportedEncodingException e) {
//			log.error("Nao foi possivel decodificar url '" + url.getPath() + "'", e);
//		}
		return new File(url.getPath());
	}

	private static String garantirBarraInicio(String path) {
		if (!(path.startsWith("/") || path.startsWith("\\") || path.indexOf(":") > 0) ) {
			path = ((path.indexOf("\\") > 0) ? "\\" : "/") + path;
		}
		return path;
	}

}
