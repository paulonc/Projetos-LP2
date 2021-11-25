package sistema;

import java.util.Objects;


/**
 * Representa um Aluno de Programação 2.
 * Cada aluno possui matrícula, nome e curso. 
 * E são identificados exclusivamente pela matrícula. 
 * 
 * @author Paulo Victor do Nascimento Cavalcanti
 * @since ago 2021.
 * @version 1.0
 */
public class Aluno {
	
	private String matricula;
	private String nome;
	private String curso;

	/**
	 * Construtor da classe Aluno. Cria um aluno, a partir da matrícula, nome e curso.
	 * Se os parâmetros matrícula, nome ou telefone forem nulos ou estiverem em branco ocorrerá uma exceção.
	 * @param matricula
	 * @param nome
	 * @param curso
	 */
	public Aluno(String matricula, String nome, String curso) {
		if (matricula == null || nome == null || curso == null) {
			throw new NullPointerException("ALUNO INVÁLIDO.");
		}
		if (matricula.isBlank() || nome.isBlank() || curso.isBlank()) {
			throw new IllegalArgumentException("ALUNO INVÁLIDO");
		}
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}

	/**
	 * Retorna a matrícula do Aluno.
	 * @return matrícula do Aluno 
	 */
	public String getMatricula() {
		return matricula;
	}

	
	/**
	 * Retorna o nome do Aluno.
	 * @return nome do Aluno.
	 */
	public String getNome() {
		return nome;
	}


	/**
	 * Retorna o curso do Aluno.
	 * @return curso do aluno
	 */
	public String getCurso() {
		return curso;
	}

	/**
	 * Método que cria uma representação em inteiro para cada objeto Aluno.
	 * @return retorna um inteiro que representa o aluno
	 */
	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}


	/**
	 * Método que verifica se dois Alunos são iguais. Comparando suas matrículas.
	 * 
	 * @return true se os alunos forem iguais, caso contrário retorna false
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(matricula, other.matricula);
	}
	
	/**
	 * Retorna uma String que representa o aluno. Apresentando a matrícula, nome e curso.
	 * A representação está no seguinte formato: "Matrícula - Nome - Curso".
	 * @return String representando o aluno
	 */
	@Override
	public String toString() {
		return matricula + " - " + nome + " - " + curso;
	}
	
	
	
	
	
}
