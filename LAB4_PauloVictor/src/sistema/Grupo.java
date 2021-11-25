package sistema;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Representa um grupo de estudo para os alunos de Programação 2.
 * O grupo possuí nome e um conjunto de alunos. Os grupos podem ou não ter um limite de tamanho.
 * São identificados exclusivamento pelo nome.
 * 
 * @author Paulo Victor do Nascimento Cavalcanti
 * @since ago 2021.
 * @version 1.0
 *
 */
public class Grupo {

	private String nome;
	private Integer tamanho;
	private Set<Aluno> alunos;
	

	/**
	 * Construtor da classe Grupo. Cria um grupo a partir do nome e do tamanho. Se o tamanho for 
	 * nulo, o grupo não terá restrição de tamanho.
	 * Se o parâmetro nome for nulo ou vazio ocorrerá uma execeção.
	 * @param nome Nome de grupo
	 * @param tamanho Tamanho do grupo(opcional)
	 */
	public Grupo(String nome, Integer tamanho) {
		if (nome == null) {
			throw new NullPointerException("NOME DO GRUPO NÃO PODE SER NULO");
		}
		if (nome.isBlank()) {
			throw new IllegalArgumentException("NOME DO GRUPO NÃO PODE SER VAZIO");
		}
		this.nome = nome;
		this.tamanho = tamanho;
		this.alunos = new HashSet<>();
	}

	/**
	 * Retorna o nome do grupo
	 * @return nome do grupo
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Adiciona um aluno no grupo.
	 * Se o tamanho do grupo for definido, é analisado se tem espaço, se tiver o aluno é alocado e retorna true
	 * se não apenas é retornado um false.
	 * Se o tamanho do grupo for nulo, então não possui restrição de tamanho.
	 * @param aluno
	 * @return um valor booleando, true indica que o aluno foi alocado e false que não foi alocado.
	 */
	public boolean alocar(Aluno aluno) {
		if (tamanho == null) {
			this.alunos.add(aluno);
			return true;
		} else if (alunos.size() < tamanho) {
			this.alunos.add(aluno);
			return true;
		}
		return false;
	}		
		
	/**
	 * Retorna um boolean indicando se um aluno está no grupo.
	 * @param aluno
	 * @return true se o aluno está no grupo ou false se não está
	 */
	public boolean pertence(Aluno aluno) {
		return this.alunos.contains(aluno);
	}

	/**
	 * Método que cria uma representação em inteiro para cada objeto Grupo.
	 * @return um inteiro que representa o grupo
	 */
	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	
	/**
	 * Método que verifica se dois Grupos são iguais. Comparando seus nomes.
	 * 
	 * @return true se os grupos forem iguais, caso contrário retorna false
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grupo other = (Grupo) obj;
		return Objects.equals(nome, other.nome);
	}	
}

