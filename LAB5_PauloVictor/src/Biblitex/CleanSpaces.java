package Biblitex;


/**
 * Classe de transformação textual. 
 * É identificada por um nome.
 * E Implementa a interface AlgoritmoTransformacao.
 * 
 * @author Paulo Victor do Nascimento Cavalcanti
 * @since set 2021
 */
public class CleanSpaces implements AlgoritmoTransformacao{
	
	private String nome;
	
	/**
	 * Construtor da classe CleanSpaces. Cria a classe a partir de um nome.
	 */
	public CleanSpaces() {
		this.nome = "cleanSpaces";
	}

	/**
	 * Remove todos os espaços da String.
	 * @param original. String que será convertida.
	 * @return String sem espaços.
	 */
	@Override
	public String transforma(String original) {
		return original.replaceAll(" ", "");
	}

	/**
	 * Retorna o nome da transformação textual.
	 * @return nome da transformação textual.
	 */
	@Override
	public String getNome() {
		return nome;
	}
}
