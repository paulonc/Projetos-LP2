package sistema;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AlunoTest {


	@Test
	void testHashCodeIgual() {
		Aluno aluno1 = new Aluno("250", "Paulo", "Computação");
		Aluno aluno2 = new Aluno("250", "Maria", "Computação");
		assertEquals(aluno1.hashCode(), aluno2.hashCode());
	}

	@Test
	void testAluno() {
		new Aluno("250", "Paulo", "Computação");
	}
	
	@Test
	void testAlunoMatriculaVazia() {
		try{
			new Aluno("", "Paulo", "Computação");
			fail("Era esperado uma execeção");
		} catch (IllegalArgumentException e) {
		}
	}
	
	@Test
	void testAlunoMatriculaNula() {
		try{
			new Aluno(null, "Paulo", "Computação");
			fail("Era esperado uma execeção");
		} catch (NullPointerException e) {
		}
	}
	
	@Test
	void testAlunoNomeVazio() {
		try{
			new Aluno("250", "", "Computação");
			fail("Era esperado uma execeção");
		} catch (IllegalArgumentException e) {
		}
	}
	
	@Test
	void testAlunoNomeNulo() {
		try{
			new Aluno("250", null, "Computação");
			fail("Era esperado uma execeção");
		} catch (NullPointerException e) {
		}
	}
	
	@Test
	void testAlunoCursoVazio() {
		try{
			new Aluno("250", "Paulo", "");
			fail("Era esperado uma execeção");
		} catch (IllegalArgumentException e) {
		}
	}
	
	@Test
	void testAlunoCursoNulo() {
		try{
			new Aluno("250", "Paulo", null);
			fail("Era esperado uma execeção");
		} catch (NullPointerException e) {
		}
	}
	
	@Test
	void testEqualsObjectIguais() {
		Aluno aluno1 = new Aluno("250", "Paulo", "Computação");
		Aluno aluno2 = new Aluno("250", "Maria", "Computação");
		assertEquals(aluno1, aluno2);
	}
	
	
	@Test
	void testEqualsObjectDiferentes() {
		Aluno aluno1 = new Aluno("250", "Paulo", "Computação");
		Aluno aluno2 = new Aluno("251", "Maria", "Computação");
		assertNotEquals(aluno1, aluno2);
	}

	@Test
	void testToString() {
		Aluno aluno = new Aluno("250", "Paulo", "Computação");
		assertEquals("250 - Paulo - Computação", aluno.toString());
	}

}
