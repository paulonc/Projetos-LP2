package sistema;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class SistemaTest {
	
	private Sistema sistema;

	@BeforeEach
	void setUp() {
		sistema = new Sistema();
		sistema.cadastraAluno("250", "Gabriel Reyes", "Computação");
		sistema.cadastraAluno("200", "Lili Camposh", "Computação");
		sistema.cadastraAluno("202", "Angela Ziegler", "Medicina");
		sistema.cadastraAluno("201", "Torbjorn Lindholm", "Engenharia Mecânica");
		sistema.cadastraGrupo("Programação OO", null);
		sistema.cadastraGrupo("Calculo", 5);
	}

	@Test
	void testSistema() {
		new Sistema();
	}

	@Test
	void testCadastraAluno() {
		assertTrue(sistema.cadastraAluno("73","Sheldon Cooper", "Física"));
	}
	
	@Test
	void testCadastraAlunoExistente() {
		assertFalse(sistema.cadastraAluno("250","Leonard Hofstadter", "Física"));
	}

	@Test
	void testExibeAluno() {
		assertEquals("ALUNO: 250 - Gabriel Reyes - Computação", sistema.exibeAluno("250"));
	}
	
	@Test
	void testExibeAlunoNaoCadastrado() {
		assertEquals("ALUNO NÃO CADASTRADO", sistema.exibeAluno("300"));
	}

	@Test
	void testCadastraGrupo() {
		sistema.cadastraGrupo("Programação OO", null);
	}
	
	@Test
	void testCadastraGrupoComRestricao() {
		sistema.cadastraGrupo("Listas", 10);
	}
	
	@Test
	void testCadastraGrupoComNomesIguais() {
		sistema.cadastraGrupo("Listas", 10);
		assertFalse(sistema.cadastraGrupo("Listas", null));
		
	}
		
	@Test
	void testAlocaAluno() {
		assertEquals("ALUNO ALOCADO!", sistema.alocaAluno("200", "Programação OO"));
		assertEquals("ALUNO ALOCADO!", sistema.alocaAluno("202", "Programação OO"));
	}
	
	@Test
	void testAlocaAlunoJaAlocado() {
		assertEquals("ALUNO ALOCADO!", sistema.alocaAluno("200", "Programação OO"));
		assertEquals("ALUNO ALOCADO!", sistema.alocaAluno("202", "Programação OO"));
		assertEquals("ALUNO ALOCADO!", sistema.alocaAluno("202", "Programação OO"));
	}
	
	@Test
	void testAlocaAlunoInexistente() {
		assertEquals("ALUNO NÃO CADASTRADO", sistema.alocaAluno("100", "Programação OO"));
	}
	
	@Test
	void testAlocaAlunoEmGrupoInexistente() {
		assertEquals("GRUPO NÃO CADASTRADO", sistema.alocaAluno("200", "Anatomia"));
	}
	
	@Test
	void testAlocaAlunoEmGrupoCheio() {
		sistema.cadastraGrupo("Listas", 1);
		sistema.alocaAluno("250", "Listas");
		assertEquals("GRUPO CHEIO", sistema.alocaAluno("202", "Listas"));
	}

	@Test
	void testPertenceGrupo() {
		sistema.cadastraGrupo("Listas", null);
		sistema.alocaAluno("250", "Listas");
		assertEquals("ALUNO PERTENCE AO GRUPO", sistema.pertenceGrupo("Listas", "250"));
		assertEquals("ALUNO NÃO PERTENCE AO GRUPO", sistema.pertenceGrupo("Listas", "202"));
	}
	
	@Test
	void testPertenceGrupoNaoCadastrado() {
		assertEquals("GRUPO NÃO CADASTRADO", sistema.pertenceGrupo("Anatomia", "202"));
	}
	
	@Test
	void testPertenceGrupoAlunoNaoCadastrado() {
		assertEquals("ALUNO NÃO CADASTRADO", sistema.pertenceGrupo("Programação OO", "100"));
	}
	

	@Test
	void testRegistraParticipacao() {
		assertEquals("ALUNO REGISTRADO" ,sistema.registraParticipacao("250"));
	}
	
	@Test
	void testRegistraParticipacaoAlunoNaoCadastrado() {
		assertEquals("ALUNO NÃO CADASTRADO" ,sistema.registraParticipacao("300"));
	}

	@Test
	void testImprimirParticipcao() {
		sistema.registraParticipacao("250");
		sistema.registraParticipacao("200");
		sistema.registraParticipacao("202");
		sistema.registraParticipacao("250");
		assertEquals("1. 250 - Gabriel Reyes - Computação\n"
				+ "2. 200 - Lili Camposh - Computação\n"
				+ "3. 202 - Angela Ziegler - Medicina\n"
				+ "4. 250 - Gabriel Reyes - Computação\n", sistema.imprimirParticipcao());
	}
	
	@Test
	void testImprimirParticipcaoSemAlunos() {
		assertEquals("NENHUM ALUNO RESPONDEU QUESTÕES NO QUADRO", sistema.imprimirParticipcao());
	}

	@Test
	void testChecarGrupo() {
		sistema.alocaAluno("250", "Programação OO");
		sistema.alocaAluno("250", "Calculo");
		assertEquals("Grupo: \n"
				+ "- Programação OO\n"
				+ "- Calculo\n" ,sistema.checarGrupo("250"));
	}
	
	@Test
	void testChecarGrupoAlunoSemGrupo() {
		assertEquals("Grupo: \n" ,sistema.checarGrupo("202"));
	}
	
	@Test
	void testChecarGrupoAlunoNãoCadastrado() {
		assertEquals("ALUNO NÃO CADASTRADO" ,sistema.checarGrupo("500"));
	}


}
