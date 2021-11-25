package agenda;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 * 
 * @author nazarenoandrade
 *
 */
public class MainAgenda {

	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo. 
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}
	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.print(
				"\n---\nMENU\n" + 
						"(C)adastrar Contato\n" + 
						"(L)istar Contatos\n" + 
						"(E)xibir Contato\n" + 
						"(F)avoritos\n" +
						"(A)dicionar Favorito\n" +
						"(T)ags\n" +
						"(S)air\n" + 
						"\n" + 
						"Opção> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda, scanner);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "F":
			listaFavoritos(agenda);
			break;
		case "A":
			adicionaFavorito(agenda, scanner);
			break;
		case "T":
			adicionaTags(agenda, scanner);
			break;
		case "S":
			sai();
			break;
		default:
			System.out.println("OPÇÃO INVÁLIDA!");
		}
	}

	/**
	 * Imprime lista de contatos da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println("\nLista de contatos: ");
		System.out.println(agenda.getContatos());
	}

	/**
	 * Imprime os detalhes de um dos contatos da agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nQual contato> ");
		int posicao = scanner.nextInt();
		if (posicao < 0 || posicao > 100) {
			System.out.println("\nPOSIÇÃO INVÁLIDA");
			return;
		}
		String contato = agenda.getContato(posicao);
		System.out.print("Dados do contato:\n" + contato);
	}

	/**
	 * Cadastra um contato na agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosição na agenda> ");
		int posicao = scanner.nextInt();
		scanner.nextLine();
		if (posicao < 1 || posicao > 100) {
			System.out.println("\nPOSIÇÃO INVÁLIDA");
			return;
		}
		System.out.print("\nNome> ");
		String nome = scanner.nextLine();
		System.out.print("Sobrenome> ");
		String sobrenome = scanner.nextLine();
		System.out.print("Telefone> ");
		String telefone = scanner.nextLine();
		if (nome.isBlank() || telefone.isBlank()) {
			System.out.println("\nCONTATO INVÁLIDO");
		} else {
			if (agenda.cadastraContato(posicao, nome, sobrenome, telefone)) {
				System.out.println("\nCADASTRADO REALIZADO");
			} else {
				System.out.println("\nCONTATO JÁ CADASTRADO");
			}
		}
	}
	
	
	/**
	 * Adiciona um contato à lista de favoritos.
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void adicionaFavorito(Agenda agenda, Scanner scanner) {
		System.out.print("\nContato> ");
		int posContato = scanner.nextInt();
		if (posContato < 0 || posContato > 100) {
			System.out.println("\nPOSIÇÃO INVÁLIDA");
			return;
		}
		System.out.print("Posição> ");
		int posFavorito = scanner.nextInt();
		if (posFavorito < 0 || posFavorito > 9) {
			System.out.println("\nPOSIÇÃO INVÁLIDA");
			return;
		}
		if (agenda.adicionaFavorito(posContato, posFavorito)) {
			System.out.println("\nCONTATO FAVORITADO NA POSIÇÃO " + posFavorito + "!");
		} else {
			System.out.println("\nCONTATO JÁ FAVORITADO");
		}
	}
	
	
	/**
	 * Imprime a lista de Favoritos
	 * 
	 * @param agenda A agenda.
	 */
	private static void listaFavoritos(Agenda agenda) {
		System.out.println("\nLista de Favoritos: ");
		System.out.println(agenda.getFavoritos());
	}

	
	/**
	 * Adiciona tags ao contato
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void adicionaTags(Agenda agenda, Scanner scanner) {
		System.out.print("\nContato(s)> ");
		scanner.nextLine();
		String[] posContatos = scanner.nextLine().split(" ");
		System.out.print("Tag> ");
		String tag = scanner.next();
		scanner.nextLine();
		System.out.print("Posição tag> ");
		int posTag = scanner.nextInt();
		if (posTag < 1 || posTag > 5) {
			System.out.println("\nPOSIÇÃO INVÁLIDA");
		} else {
			for (String posContato : posContatos) {
				int posicao = Integer.parseInt(posContato);
				agenda.adicionaTags(posicao, posTag, tag);
			}
		}
	}
	
	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.exit(0);
	}
	
	/**
	 * Lê uma agenda de um arquivo csv. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados. 
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		
		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}
}
