package BiblitexTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Biblitex.UpperCase;

class UpperCaseTest {
	
	private UpperCase upper;

	@BeforeEach
	void setUp() throws Exception {
		 this.upper = new UpperCase();
	}


	@Test
	void testTransforma() {
		assertEquals("SHELDON COOPER", upper.transforma("Sheldon Cooper"));
	}

	@Test
	void testGetNome() {
		assertEquals("upperCase", upper.getNome());
	}

}
