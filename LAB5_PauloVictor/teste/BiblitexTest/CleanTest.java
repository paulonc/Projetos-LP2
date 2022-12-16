package BiblitexTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Biblitex.Clean;

class CleanTest {
	
	private Clean clean;

	@BeforeEach
	void setUp() throws Exception {
		clean = new Clean();
	}

	@Test
	void testTransforma() {
		assertEquals("BOM DIA", clean.transforma("B!*O,..M )#D??!I&#A"));
	}

	@Test
	void testGetNome() {
		assertEquals("clean", clean.getNome());
	}

}
