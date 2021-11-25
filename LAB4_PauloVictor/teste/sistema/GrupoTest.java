package sistema;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GrupoTest {
	
	private Grupo grupo1;
	private Grupo grupo2;
	private Grupo grupo3;
	private Aluno aluno1;
	private Aluno aluno2;

	@BeforeEach
	void setUp() throws Exception {
		grupo1 = new Grupo("Programação 2", null);
		grupo2 = new Grupo("Lab de Programação 2", 1);
		grupo3 = new Grupo("Programação 2", null);
		aluno1 = new Aluno("250", "Gabriel Reyes", "Computação");
		aluno2 = new Aluno("200", "Lili Camposh", "Computação");
		
	}

	@Test
	void testHashCodeIgual() {
		assertEquals(grupo1.hashCode(), grupo3.hashCode());
	}

	@Test
	void testGrupoNomeVazio() {
		try {
			new Grupo("", null);
			fail("Era esperado uma exceção");
		} catch (IllegalArgumentException e) {
		}
	}
	
	@Test
	void testGrupoNomeNulo() {
		try {
			new Grupo(null, null);
			fail("Era esperado uma exceção");
		} catch (NullPointerException e) {
		}
	}
	
	@Test
	void testAlocarGrupoSemRestricao() {
		assertTrue(grupo1.alocar(aluno1));
		assertTrue(grupo1.alocar(aluno2));
	}
	

	@Test
	void testAlocarGrupoComRestricao() {
		assertTrue(grupo2.alocar(aluno1));
		assertFalse(grupo2.alocar(aluno2));
	}

	@Test
	void testPertence() {
		grupo1.alocar(aluno1);
		assertTrue(grupo1.pertence(aluno1));
	}
	
	@Test
	void testNaoPertence() {
		assertFalse(grupo3.pertence(aluno1));
	}

	@Test
	void testEqualsObjectIguais() {
		assertEquals(grupo1, grupo3);
	}
	
	@Test
	void testEqualsObjectDiferentes() {
		assertNotEquals(grupo1, grupo2);
	}
}
