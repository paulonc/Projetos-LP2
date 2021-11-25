package agenda;

/**
 * Uma agenda que mantém uma lista de contatos e uma lista de favoritos com posições. 
 * Podem existir 100 contatos e 10 favoritos. 
 * 
 * 
 * @author Paulo Victor do Nascimento Cavalcanti
 * @version 1.0
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 100;
	private static final int TAMANHO_FAVORITOS = 10;
	
	private Contato[] contatos;
	private Contato[] favoritos;

	/**
	 * Cria uma agenda de contatos e favoritos.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Contato[TAMANHO_FAVORITOS];
	}
	

	/**
	 * Formata os contatos apresentando sua posição, nome e sobrenome.
	 * @return Os contatos de forma listada.
	 */
	public String getContatos() {
		String s = "";
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				s += (i + 1) + " - " + contatos[i] + "\n";
			}
		}
		return s;
	}
	
	/**
	 * Formata os contatos favoritados em uma lista, apresentando sua posição, nome e sobrenome.
	 * @return Os favoritos de forma listada.
	 */
	public String getFavoritos() {
		String s = "";
		for (int i = 0; i < favoritos.length; i++) {
			if (favoritos[i] != null) {
				s += (i + 1) + " - " + favoritos[i] + "\n";
			}
		}
		return s;
	}
	
	
	/**
	 * Acessa os dados de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @return Retorna uma String com os dados do contato ou Retorna POSIÇÃO INVÁLIDA se não há contato na posição.
	 */
	public String getContato(int posicao) {
		if (posicao < 1 || posicao > 100) {
			throw new IllegalArgumentException("POSIÇÃO INVÁLIDA");
		}
		Contato c = contatos[posicao - 1];
		if (c == null) {
			return "POSIÇÃO INVÁLIDA";
		} else {
			return contatoFormatado(posicao);
		}
	}

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior. 
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 * @return Retorna um valor booleano. Se o contato for cadastrado retorna true, caso contrário, retorna false.
	 */
	public boolean cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		if (posicao < 1 || posicao > 100) {
			throw new IllegalArgumentException("POSIÇÃO INVÁLIDA");
		}
		if (!verificaContato(nome, sobrenome, telefone)) {
			this.contatos[posicao - 1] = new Contato(nome, sobrenome, telefone);
			return true;
		}
		return false;
	}
	
	
	/**
	 * Verifica se os dados passados como parâmetros já estão cadastrados no array Contatos. Comparando nomes e sobrenomes.
	 * @param nome
	 * @param sobrenome
	 * @param telefone
	 * @return Retorna um valor booleano. Se o contato já estiver no array Contato retorna true, caso contrário,
	 * retorna false.
	 */
	private boolean verificaContato(String nome, String sobrenome, String telefone) {
		Contato c = new Contato(nome, sobrenome, telefone);
		for (Contato contato : contatos) {
			if (contato != null && contato.equals(c)) {
				return true;
			}
		}	
		return false;
	}
		
	
	/**
	 * Adiciona um contato a um array de Favoritos em uma posição. 
	 * Se adicionar um contato à uma posição existente, ele sobrescreve o anterior.
	 * @param posicaoContato
	 * @param posicaoFavorito
	 * @return Retorna um valor booleano. Se o contato for favoritado retorna true, caso contrário, retorna false.
	 */
	public boolean adicionaFavorito(int posicaoContato, int posicaoFavorito) {
		if (posicaoContato < 1 || posicaoContato > 100) {
			throw new IllegalArgumentException("POSIÇÃO INVÁLIDA");
		}
		if (posicaoFavorito < 1 || posicaoFavorito > 10) {
			throw new IllegalArgumentException("POSIÇÃO INVÁLIDA");
		}
		if (contatos[posicaoContato - 1] == null) {
			throw new IllegalArgumentException("CONTATO INVÁLIDO");
		}
		if (!verificaFavorito(posicaoContato)) {
			this.favoritos[posicaoFavorito - 1] = contatos[posicaoContato - 1];
			return true;
		}
		return false;
	}
	
	
	/**
	 * Verifica se o contato já está presente no array de favoritos. 
	 * @param posContato
	 * @return Retorna um valor booleano. Se o contato já estiver no array de favoritos retorna true, caso contrário
	 * retorna false.
	 */
	private boolean verificaFavorito(int posContato) {
		for (Contato favorito : favoritos) {
			if (favorito != null && favorito.equals(contatos[posContato - 1])) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * Adiciona uma tag a um contato.
	 * @param posicaoContato
	 * @param posicaoTag
	 * @param tag
	 */
	public void adicionaTags(int posicaoContato, int posicaoTag, String tag) {
		if (posicaoContato < 1 || posicaoContato > 100) {
			throw new IllegalArgumentException("POSIÇÃO INVÁLIDA");
		}
		if (contatos[posicaoContato - 1] == null) {
			throw new IllegalArgumentException("CONTATO INVÁLIDO");
		}
		
		this.contatos[posicaoContato - 1].adicionaTags(posicaoTag, tag);
	}

	/**
	 * Formata o contato, exibindo todas as suas informações.
	 * @param posicao
	 * @return Retorna uma String, com todos os dados do contato.
	 */
	private String contatoFormatado(int posicao) {
		Contato contato = contatos[posicao - 1];
		String s = "";
		if (verificaFavorito(posicao)) {
			s += "❤️ ";
		} 
		s += contato + "\n" + 
		contato.getTelefone() + "\n" + 
		contato.getTags();
 		return s;
	}
}
