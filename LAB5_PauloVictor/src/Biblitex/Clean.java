package Biblitex;

/**
 * 
 * Classe de transformação textual. 
 * É identificada por um nome.
 * E Implementa a interface AlgoritmoTransformacao.
 * 
 * @author Paulo Victor do Nascimento Cavalcanti
 * @since set 2021
 */
public class Clean implements AlgoritmoTransformacao{
	
	private String nome;
	
	/**
	 * Construtor da classe Clean. Cria a classe a partir de um nome.
	 */
	public Clean() {
		this.nome = "clean";
	}

	/**
	 * Remove todos os sinais de pontuação da String.
	 * @param original. String oringal que será transformada.
	 * @return String sem sinais de pontuação.
	 */
	@Override
	public String transforma(String original) {
		return original.replaceAll("\\p{Punct}", "");
	}

	/**
	 * Retorna o nome da transformação textual
	 * @return nome da transformação textual.
	 */
	@Override
	public String getNome() {
		return nome;
	}

}
