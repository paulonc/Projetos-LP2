package BiblitexTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Biblitex.MeioaMeio;

class MeioaMeioTest {

	MeioaMeio meioameio;
	
	@BeforeEach
	void setUp() throws Exception {
		this.meioameio = new MeioaMeio();
	}

	@Test
	void testTransforma() {
		assertEquals("THE BIG BAng theory", meioameio.transforma("The Big Bang Theory"));
	}

	@Test
	void testGetNome() {
		assertEquals("MeioaMeio", meioameio.getNome());
	}

}
