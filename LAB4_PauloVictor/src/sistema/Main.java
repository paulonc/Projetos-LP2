package sistema;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Sistema sistema = new Sistema();
		Scanner scanner = new Scanner(System.in);
		
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, sistema, scanner);
		}		
		

	}
	private static String menu(Scanner scanner) {
		System.out.print("\n"
				+ "(C)adastrar Aluno\n"
				+ "(E)xibir Aluno\n"
				+ "(N)ovo Grupo\n"
				+ "(A)locar Aluno no Grupo e Verificar pertinência a Grupos\n"
				+ "(R)egistrar Aluno que Respondeu\n"
				+ "(I)mprimir Alunos que Responderam\n"
				+ "(O)lhaí quais Grupos o Aluno Tá.\n"
				+ "(S)im, quero Fechar o Programa!\n"
				+ "Opção> ");
		return scanner.nextLine().toUpperCase();
	}
	
	
	private static void comando(String opcao, Sistema sistema, Scanner scanner) {
		switch(opcao) {
		case "C":
			cadastrarAluno(sistema, scanner);
			break;
		case "E":
			exibirAluno(sistema, scanner);
			break;
		case "N":
			cadastrarGrupo(sistema, scanner);
			break;
		case "A":
			alocarAluno(sistema, scanner);
			break;
		case "R":
			registrarParticipacao(sistema, scanner);
			break;
		case "I":
			imprimirParticipacao(sistema);
			break;
		case "O":
			checarGrupo(sistema, scanner);
			break;
		case "S":
			sair();
			break;
		default:
			System.out.println("OPÇÃO INVÁLIDA!");
		}
	}
	
	private static void cadastrarAluno(Sistema sistema, Scanner scanner) {
		System.out.print("\nMatrícula: ");
		String matricula = scanner.nextLine();
		System.out.print("Nome: ");
		String nome = scanner.nextLine();
		System.out.print("Curos: ");
		String curso = scanner.nextLine();
		if (matricula.isBlank() || nome.isBlank() || curso.isBlank()) {
			System.out.println("ALUNO INVÁLIDO");
		} else {
			if (sistema.cadastraAluno(matricula, nome, curso)) {
				System.out.println("CADASTRO REALIZADO!");
			} else {
				System.out.println("MATRÍCULA JÁ CADASTRADA!");
			}
		}
	}
	
	private static void exibirAluno(Sistema sistema, Scanner scanner) {
		System.out.print("\nMatrícula: ");
		String matricula = scanner.nextLine();
		System.out.println(sistema.exibeAluno(matricula));
		
	}
	
	private static void cadastrarGrupo(Sistema sistema, Scanner scanner) {
		System.out.print("\nGrupo: ");
		String grupo = scanner.nextLine();
		System.out.print("Tamanho: ");
		int tamanho = scanner.nextInt();
		scanner.nextLine();
		if (grupo.isBlank()) {
			System.out.println("GRUPO INVÁLIDO");
		} else {
			if (sistema.cadastraGrupo(grupo, tamanho)) {
				System.out.println("CADASTRO REALIZADO!");
			} else {
				System.out.println("GRUPO JÁ CADASTRADO!");
			}
		}
	}
	
	private static void alocarAluno(Sistema sistema, Scanner scanner) {
		System.out.print("(A)locar Aluno ou (P)ertinência a Grupo? ");
		String opcao = scanner.nextLine().toUpperCase();
		if (opcao.equals("A")) {
			System.out.print("\nMatrícula: ");
			String matricula = scanner.nextLine();
			System.out.print("Grupo: ");
			String grupo = scanner.nextLine();
			System.out.println(sistema.alocaAluno(matricula, grupo));
		} else if (opcao.equals("P")) {
			System.out.print("\nGrupo: ");
			String grupo = scanner.nextLine();
			System.out.print("Matrícula: ");
			String matricula = scanner.nextLine();
			System.out.println(sistema.pertenceGrupo(grupo, matricula));
		}
	}
	
	private static void registrarParticipacao(Sistema sistema, Scanner scanner) {
		System.out.print("\nMatrícula: ");
		String matricula = scanner.nextLine();
		System.out.println(sistema.registraParticipacao(matricula));
	}
	
	private static void imprimirParticipacao(Sistema sistema) {
		System.out.println(sistema.imprimirParticipcao());
	}
	
	
	private static void checarGrupo(Sistema sistema, Scanner scanner) {
		System.out.print("Matrícula: ");
		String matricula = scanner.nextLine();
		System.out.println(sistema.checarGrupo(matricula));
	}
	

	private static void sair() {
		System.exit(0);
	}

}
