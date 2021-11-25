package sistema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Classe que representa o Sistema do controle de alunos de Programação 2.
 * Possui dois Maps de alunos e grupos e uma ArrayList que representa a participação.
 * 
 * @author Paulo Victor do Nascimento Cavalcanti
 * @since ago 2021.
 * @version 1.0
 */
public class Sistema {
	
	private Map<String, Aluno> alunos;
	private Map<String, Grupo> grupos;
	private List<Aluno> participacao;
	
	/**
	 * Construtor padrão do sistema.
	 * Instancia o Map de alunos, o Map de grupo e o ArrayList de participação.
	 */
	public Sistema() {
		this.alunos = new HashMap<>();
		this.grupos = new HashMap<>();
		this.participacao = new ArrayList<>();
	}
	
	/**
	 * Método responsável por cadastrar um aluno no sistema. 
	 * Primeiro verifica se o aluno foi cadastrado, se não foi, ele é cadastrado
	 * em um HashMap.
	 * 
	 * @param matricula Matrícula do Aluno
	 * @param nome Nome do Aluno
	 * @param curso Curso do Aluno
	 * @return true se o aluno foi cadastrado ou false se não foi
	 */
	public boolean cadastraAluno(String matricula, String nome, String curso) {
		if (!consultaAluno(matricula)) {
			this.alunos.put(matricula, new Aluno(matricula, nome, curso));
			return true;
		}
		return false;
		
	}
	
	/**
	 * Método que exibe um Aluno.
	 * Se o aluno estiver cadastrado ele o retorna no seguinte formato: "ALUNO: MATRÍCULA - NOME - CURSO"
	 * caso contrário, retornará "ALUNO NÃO CADASTRADO".
	 * @param matricula Matrícula do aluno
 	 * @return uma String que exibe o aluno, ou uma mensagem de que o aluno não foi cadastrado
	 */
	public String exibeAluno(String matricula) {
		if (consultaAluno(matricula)) {
			return "ALUNO: " + this.alunos.get(matricula).toString();
		}
		return "ALUNO NÃO CADASTRADO";
		
	}
		
	
	/**
	 * Método que cadastra um grupo.
	 * Primeiro verifica se o grupo foi cadastrado, se não foi, ele é cadastrado 
	 * em um HashMap.
	 * 
	 * @param nomeGrupo Nome do grupo
	 * @param tamanho Tamanho do grupo
	 * @return true se o grupo foi cadastrado ou false se não foi
	 */
	public boolean cadastraGrupo(String nomeGrupo, Integer tamanho) {
		if (!consultaGrupo(nomeGrupo)) {
			Grupo grupo = new Grupo(nomeGrupo, tamanho);
			this.grupos.put(nomeGrupo.toLowerCase(), grupo);
			return true;
		}
		return false;
		
	}
	
	/**
	 * Aloca um aluno a um grupo.
	 * Se o aluno não estiver cadastrado retornará a mensagem "ALUNO NÃO CADASTRADO".
	 * Se o grupo não estiver cadastrado retornará a mensagem "GRUPO NÃO CADASTRADO".
	 * Caso o grupo já esteja cheio retornará a mensagem "GRUPO CHEIO".
	 * @param matricula Matrícula do aluno
	 * @param nomeGrupo Nome do grupo
	 * @return uma string indicando se o aluno foi alocado ou não
	 */
	public String alocaAluno(String matricula, String nomeGrupo) {
		if (!consultaAluno(matricula)) {
			return "ALUNO NÃO CADASTRADO";
		} 
		if (!consultaGrupo(nomeGrupo)) {
			return "GRUPO NÃO CADASTRADO";
		}
		Grupo grupo = this.grupos.get(nomeGrupo.toLowerCase());
		Aluno aluno = this.alunos.get(matricula);
		if (grupo.alocar(aluno)) {
			return "ALUNO ALOCADO!";
		}
		return "GRUPO CHEIO";
	}
	
	/**
	 * Método que verifica se o aluno pertence ou não ao grupo.
	 * Se o aluno não estiver cadastrado retornará a mensagem "ALUNO NÃO CADASTRADO".
	 * Se o grupo não estiver cadastrado retornará a mensagem "GRUPO NÃO CADASTRADO".
	 * @param nomeGrupo Nome do grupo
	 * @param matricula Matrícula do aluno
	 * @return uma sting indicando se o aluno pertence ou não ao grupo
	 */
	public String pertenceGrupo(String nomeGrupo, String matricula) {
		if (!consultaAluno(matricula)) {
			return "ALUNO NÃO CADASTRADO";
		} 
		if (!consultaGrupo(nomeGrupo)) {
			return "GRUPO NÃO CADASTRADO";
		}
		Grupo grupo = this.grupos.get(nomeGrupo.toLowerCase());
		Aluno aluno = this.alunos.get(matricula);
		if (grupo.pertence(aluno)) {
			return "ALUNO PERTENCE AO GRUPO";
		}
		return "ALUNO NÃO PERTENCE AO GRUPO";
	}
	
	/**
	 * Método que registra os alunos que responderam questões no quadro.
	 * 
	 * @param matricula Matrícula do aluno
	 * @return uma string indicando se o aluno foi registrado
	 */
	public String registraParticipacao(String matricula) {
		if (consultaAluno(matricula)) {
			this.participacao.add(this.alunos.get(matricula));
			return "ALUNO REGISTRADO";
		}
		return "ALUNO NÃO CADASTRADO";	
	}
	

	/**
	 * Método que imprime as participações dos alunos.
	 * Se nenhum aluno participou retornará a mensagem NENHUM ALUNO RESPONDEU QUESTÕES NO QUADRO".
	 * @return uma string de todos os alunos que participaram
	 */
	public String imprimirParticipcao() {
		if (participacao.size() == 0) {
			return "NENHUM ALUNO RESPONDEU QUESTÕES NO QUADRO";
		}
		int cont = 1;
		String retorno = "";
		for (Aluno aluno : participacao) {
			retorno += cont + ". " + aluno + System.lineSeparator();
			cont += 1;
		}
		return retorno;

	}

	/**
	 * Método que imprime todos os grupos dos quais o aluno faz parte.
	 * @param matricula Matrícula do aluno
	 * @return uma string com todos os grupos que o aluno faz parte
	 */
	public String checarGrupo(String matricula) {
		if (!consultaAluno(matricula)) {
			return "ALUNO NÃO CADASTRADO";
		} 
		String retorno = "Grupo: \n";
		Aluno aluno = alunos.get(matricula);
		for (Grupo grupo : grupos.values()) {
			if (grupo.pertence(aluno)) {
				retorno += "- " + grupo.getNome() + System.lineSeparator();
			}
		}
		return retorno;
		}
	
	
	/**
	 * Método que verifica se o aluno está cadastrado.
	 * @param matricula Matrícula do aluno
	 * @return retorna true se estiver cadastrado, caso contrário retorna false.
	 */
	private boolean consultaAluno(String matricula) {
		return this.alunos.containsKey(matricula);
	}
	
	/**
	 * Método que verifica se o grupo está cadastrado.
	 * @param nome NOme do grupo
	 * @return retorna true se estiver cadastrado, caso contrário retorna false.
	 */
	private boolean consultaGrupo(String nome) {
		return this.grupos.containsKey(nome.toLowerCase());
	}
}
