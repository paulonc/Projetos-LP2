package agenda;

import java.util.Objects;


/**
 * Representa um contato de uma agenda telefônica.
 * Cada contato é identificado pelo seu nome e sobrenome açém de possuir um telefone e 5 tags.
 * 
 * @author Paulo Victor do Nascimento Cavalcanti
 * @since ago 2021.
 * @version 1.0
 */
public class Contato {
	
	private static final int QUANT_TAGS = 5;
	
	
	private String nome;
	private String sobrenome;
	private String telefone;
	private String[] tags;

	
	/**
	 * Construtor da classe Contato. Cria um contato, a partir do nome, sobrenome e telefone.
	 * Inicia também um array de 5 posições que representa as tags.
	 * Se os parâmetros nome e telefone forem nulos ou estiverem em branco. Ocorrerá uma exceção.
	 * @param nome
	 * @param sobrenome
	 * @param telefone
	 */
	public Contato(String nome, String sobrenome, String telefone) {
		if (nome == null || nome.isBlank() || telefone == null || telefone.isBlank()) {
			throw new IllegalArgumentException("CONTATO INVÁLIDO");
		}
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
		this.tags = new String[QUANT_TAGS];
	}

	/**
	 *  Retorna o nome do contato.
	 * @return nome do contato.
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Retorna o sobrenome do contato.
	 * @return sobrenome do contato.
	 */
	public String getSobrenome() {
		return sobrenome;
	}
	
	/**
	 * Retorna o telefone do contato.
	 * @return telefone do contato.
	 */
	public String getTelefone() {
		return telefone;
	}
	
	/**
	 * Retorna as tags que forem diferentes de null do contato, já formatadas em uma String.
	 * @return tags do contato
	 */
	public String getTags() {
		String s = "";
		for (String tag : tags) {
			if (tag != null) {
			s += tag + " ";
			}
		}
		return s.trim();
	}
	
	
	/**
	 * Adiciona uma tag ao contato. Se posição da tag for inválida ou a tag for nula ou vaiza
	 * será lançada uma exceção.
	 * @param posTag
	 * @param tag
	 */
	public void adicionaTags(int posTag, String tag) {
		if (posTag < 1 || posTag > 5) {
			throw new IllegalArgumentException("POSIÇÃO INVÁLIDA");
		}
		if (tag == null || tag.isBlank()) {
			throw new IllegalArgumentException("TAG INVÁLIDA");
		}
		this.tags[posTag - 1] = tag;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nome, sobrenome);
	}
	
	
	/**
	 * Método que verifica se dois contatos são iguais. Comparando seus nomes e sobrenomes.
	 * 
	 * @return Retorna true se os contatos forem iguais, caso contrário retorna false.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(sobrenome, other.sobrenome);
	}

	
	/**
	 * Retorna uma String que representa o contato. Apresentando o nome e sobrenome.
	 * A representação está no seguinte formato: "Nome Sobrenome".
	 * @return String representando o contato
	 */
	@Override
	public String toString() {
		return nome + " " + sobrenome;
	}
	
}
