package Biblitex;


/**
 * Classe de transformação textual. 
 * É identificada por um nome.
 * E Implementa a interface AlgoritmoTransformacao.
 * 
 * @author Paulo Victor do Nascimento Cavalcanti
 * @since set 2021
 */
public class MeioaMeio implements AlgoritmoTransformacao{
	
	private String nome;
	
	/**
	 * Construtor da classe MeioaMeio. Cria a classe a partir de um nome.
	 */
	public MeioaMeio() {
		this.nome = "MeioaMeio";
	}

	/**
	 * Método que transforma uma String, na qual metade dos caracteres ficarão em maiúsculas
	 * e a outra metade em minúsculas.
	 * @param original. String que será transformada.
	 * @return String com metade dos caracteres em maiúsculas e a outra metade em minúsculas.
	 */
	@Override
	public String transforma(String original) {
		String resultado = "";
		for(int i = 0; i < original.length(); i++) {
			char c = original.charAt(i);
			if (i <= original.length() / 2) {
				resultado += Character.toUpperCase(c);
			} else {
				resultado += Character.toLowerCase(c);
			}
		}
		return resultado;
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
