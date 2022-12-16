package Biblitex;


/**
 * Classe de transformação textual. 
 * É identificada por um nome.
 * E Implementa a interface AlgoritmoTransformacao.
 * 
 * @author Paulo Victor do Nascimento Cavalcanti
 * @since set 2021
 */
public class InterrogacoesParaPontos implements AlgoritmoTransformacao {

	private String nome;
	

	/**
	 * Construtor da classe InterrogacoesParaPontos. Cria a classe a partir de um nome.
	 */
	public InterrogacoesParaPontos() {
		this.nome = "InterrogaPraPontos";
	}

	
	/**
	 * Troca todos os sinais de Interrogação para ponto final.
	 * @param original. String que será transformada.
	 * @return String com pontos finais no lugar de interrogações.
	 */
	@Override
	public String transforma(String original) {
		return original.replaceAll("\\?", ".");
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
