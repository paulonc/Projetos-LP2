 package Biblitex;

 /**
  * 
  * Classe de transformação textual. 
  * É identificada por um nome.
  * E Implementa a interface AlgoritmoTransformacao.
  * 
  * 
  * @author Paulo Victor do Nascimento Cavalcanti
  * @since set 2021
  */
public class CamelCasefy implements AlgoritmoTransformacao{
	
	private String nome;
	
	/**
	 * Construtor da classe CamelCasefy. Cria a classe de Transformação textual a partir de um nome.
	 */
	public CamelCasefy() {
		this.nome = "CaMeLcAsEfY";
	}
	
	/**
	 * Método que transforma uma String, de modo que os caracteres nas posições pares fiquem em maiúsculas
	 * e nas posições ímpares fiquem em minúsculas.
	 * 
	 * @param original. String original que será convertida.
	 * @return String em CamelCase
	 */
	@Override
	public String transforma(String original) {
		String resultado = "";
		for (int i = 0; i < original.length(); i++) {
			char c = original.charAt(i);
			if (i % 2 == 0) {
				resultado += Character.toUpperCase(c);
			} else {
				resultado += Character.toLowerCase(c);
			}
		}
		return resultado;
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
