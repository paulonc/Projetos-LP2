package BiblitexTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Biblitex.CamelCasefy;

class CamelCasefyTest {

	private CamelCasefy camelCasefy;
	
	@BeforeEach
	void setUp() throws Exception {
		this.camelCasefy = new CamelCasefy();
	}

	@Test
	void testTransforma() {
		assertEquals("PrOgRaMaÇãO 2", camelCasefy.transforma("Programação 2"));
	}

	@Test
	void testGetNome() {
		assertEquals("CaMeLcAsEfY", camelCasefy.getNome());
	}

}
