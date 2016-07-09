package br.com.ms.atividade.wrapper;

/**
 *	Interface para implementar uma extra&ccedil;&atilde;o de AtividadeWrapper.
 */
public interface IAtividadeWrapper {

	/**
	 * Atrav&eacute;s do conte&uacute;do do PDF extrai as atividades
	 * @param conteudoPDF conteudo do PDF em String
	 * @return as atividas extraidas
	 */
	String extrairAtividades(String conteudoPDF);

}
