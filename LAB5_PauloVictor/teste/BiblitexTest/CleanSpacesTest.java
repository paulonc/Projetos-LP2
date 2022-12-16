package BiblitexTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Biblitex.CleanSpaces;

class CleanSpacesTest {
	
	private CleanSpaces cleanSpaces;

	@BeforeEach
	void setUp() throws Exception {
		this.cleanSpaces = new CleanSpaces();
	}


	@Test
	void testTransforma() {
		assertEquals("RickeMorty", cleanSpaces.transforma("  Rick e Morty   "));
	}

	@Test
	void testGetNome() {
		assertEquals("cleanSpaces", cleanSpaces.getNome());
	}

}
