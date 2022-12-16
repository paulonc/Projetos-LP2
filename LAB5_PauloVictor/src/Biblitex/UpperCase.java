package Biblitex;


/**
 * Classe de transformação textual. 
 * É identificada por um nome.
 * E Implementa a interface AlgoritmoTransformacao.
 * 
 * 
 * @author Paulo Victor do Nascimento Cavalcanti
 * @since set 2021
 */
public class UpperCase implements AlgoritmoTransformacao{
	
	private String nome;
	
	
	/**
	 * Construtor da classe UpperCase. Cria a classe a partir de um nome;
	 */
	public UpperCase() {
		this.nome = "upperCase";
	}

	
	/**
	 * Converte todos os caracteres da String para maiúsculas.
	 * 
	 * @param original. String original que será convertida.
	 * @return String em maiúsculas.
	 */
	@Override
	public String transforma(String original) {
		return original.toUpperCase();
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
