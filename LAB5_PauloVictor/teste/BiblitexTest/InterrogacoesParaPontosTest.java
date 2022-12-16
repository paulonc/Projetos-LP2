package BiblitexTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Biblitex.InterrogacoesParaPontos;

class InterrogacoesParaPontosTest {

	private InterrogacoesParaPontos interrogaPraPontos;
	
	@BeforeEach
	void setUp() throws Exception {
		this.interrogaPraPontos = new InterrogacoesParaPontos();
	}

	@Test
	void testTransforma() {
		assertEquals("Tudo bem...", interrogaPraPontos.transforma("Tudo bem???"));
	}

	@Test
	void testGetNome() {
		assertEquals("InterrogaPraPontos", interrogaPraPontos.getNome());
	}

}
