package agenda;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AgendaTeste {
	
	private Agenda agenda = new Agenda();

	@Test
	void testAgenda() {
		agenda = new Agenda();
	}

	@Test
	void testCadastraContato() {
		assertTrue(agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000"));
	}
	
	@Test
	void testCadastraContatoPosicaoExistente() {
		assertTrue(	agenda.cadastraContato(1, "Pedro", "Silva", "(84) 98888-1111"));
	}
	
	@Test
	void testCadastraContatoIgual() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		assertFalse(agenda.cadastraContato(3, "Matheus", "Gaudencio", "(83) 99999-0000"));
	}
	
	@Test
	void testCadastraContatoPosicaoLimite() {
		assertTrue(agenda.cadastraContato(100, "Matheus", "Gaudencio", "(83) 99999-0000"));
	}
	
	@Test
	void testCadastraContatoPosicaoAcimaLimite() {
		try {
			agenda.cadastraContato(101, "Matheus", "Gaudencio", "(83) 99999-0000");
			fail("Era esperado uma execeção");
		} catch (IllegalArgumentException e) {
		}
	}
	
	@Test
	void testCadastraContatoPosicaoAbaixoLimite() {
		try {
			agenda.cadastraContato(0, "Matheus", "Gaudencio", "(83) 99999-0000");
			fail("Era esperado uma execeção");
		} catch (IllegalArgumentException e) {
		}
	}
	
	@Test
	void testCadastraContatoTelefoneVazio() {
		try {
			agenda.cadastraContato(1, "Matheus", "Gaudencio", "");
			fail("Era esperado uma execeção");
		} catch (IllegalArgumentException e) {
		}
	}
	
	@Test
	void testCadastraContatoNomeVazio() {
		try {
			agenda.cadastraContato(1, "", "Gaudencio", "(83) 99999-0000");
			fail("Era esperado uma execeção");
		} catch (IllegalArgumentException e){
		}
	}
	
	
	@Test
	void testGetContato() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		assertEquals("Matheus Gaudencio\n(83) 99999-0000\n", agenda.getContato(1));
	}
	
	@Test
	void testGetContatoVazio() {
		assertEquals("POSIÇÃO INVÁLIDA", agenda.getContato(100));
	}
	
	@Test
	void testGetContatoPosicaoLimiteInferior() {
		try {
			agenda.getContato(0);
			fail("Era esperado uma exceção");
		} catch (IllegalArgumentException e) {
		}
	}
	
	@Test
	void testGetContatoPosicaoLimiteSuperior() {
		try {
			agenda.getContato(101);
			fail("Era esperado uma exceção");
		} catch (IllegalArgumentException e) {
		}
	}
	
	@Test
	void testGetContatoFavoritado() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		agenda.adicionaFavorito(1, 1);
		assertEquals("❤️ Matheus Gaudencio\n" + "(83) 99999-0000\n" + "", agenda.getContato(1));
	}
	
	@Test
	void testGetContatoComTags() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		agenda.adicionaTags(1, 1, "professor-ufcg");
		assertEquals("Matheus Gaudencio\n" + "(83) 99999-0000\n" + "professor-ufcg", agenda.getContato(1));
	}
	
	@Test
	void testGetContatoExFavoritado() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		agenda.cadastraContato(4, "Sheldon", "Cooper", "(83) 732137122173");
		agenda.adicionaFavorito(1, 1);
		agenda.adicionaFavorito(4, 1);
		assertEquals("Matheus Gaudencio\n" + "(83) 99999-0000\n" + "", agenda.getContato(1));
	}
	
	
	@Test
	void testGetContatos() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		agenda.cadastraContato(2, "Rick", "Sanchez", "(83) 91234-5678");
		agenda.cadastraContato(3, "Morty", "Smith", "(83) 98765-4321");
		agenda.cadastraContato(4, "Sheldon", "Cooper", "(83) 732137122173");
		assertEquals("1 - Matheus Gaudencio\n2 - Rick Sanchez\n3 - Morty Smith\n4 - Sheldon Cooper\n", agenda.getContatos());
	}
	
	@Test
	void testGetContatosVazio() {
		assertEquals("", agenda.getContatos());
	}
	
	@Test
	void testAdicionaFavorito() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		assertTrue(agenda.adicionaFavorito(1, 1));
	}
	
	@Test
	void testAdicionaFavoritoJaFavoritado() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		agenda.adicionaFavorito(1, 1);
		assertFalse(agenda.adicionaFavorito(1, 2));
		}
	
	@Test
	void testAdicionaFavoritoPosicaoLimite() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		assertTrue(agenda.adicionaFavorito(1, 10));
		}
	
	@Test
	void testAdicionaFavoritoAbaixoLimite() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		try {
			agenda.adicionaFavorito(1, 0);
			fail("Era esperado uma execeção");
		} catch (IllegalArgumentException e) {
		}
	}
	
	@Test
	void testAdicionaFavoritoAcimaLimite() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		try {
			agenda.adicionaFavorito(1, 11);
			fail("Era esperado uma execeção");
		} catch (IllegalArgumentException e) {
		}
	}
	
	@Test
	void testAdicionaFavoritoContatoNulo() {
		try {
			agenda.adicionaFavorito(1, 1);
			fail("Era esperado uma execeção");
		} catch (IllegalArgumentException e) {
		}
	}
	
	
	
	@Test
	void testGetFavoritos () {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		agenda.cadastraContato(2, "Rick", "Sanchez", "(83) 91234-5678");
		agenda.cadastraContato(3, "Morty", "Smith", "(83) 98765-4321");
		agenda.cadastraContato(4, "Sheldon", "Cooper", "(83) 732137122173");
		agenda.adicionaFavorito(1, 1);
		agenda.adicionaFavorito(4, 3);
		assertEquals("1 - Matheus Gaudencio\n3 - Sheldon Cooper\n", agenda.getFavoritos());
		
	}
	
	@Test
	void testGetFavoritosVazio () {
		assertEquals("", agenda.getFavoritos());
	}

	@Test
	void testAdicionaTags() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		agenda.adicionaTags(1, 1, "professor");
		assertEquals("Matheus Gaudencio\n(83) 99999-0000\nprofessor", agenda.getContato(1));
	}
	
	@Test
	void testAdicionaTagsLimite() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		agenda.adicionaTags(1, 4, "professor");
		assertEquals("Matheus Gaudencio\n(83) 99999-0000\nprofessor", agenda.getContato(1));
	}

	@Test
	void testAdicionaTagsPosicaoAbaixoLImite() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		try {
			agenda.adicionaTags(-1, 0, "professor");
			fail("Era esperado uma exceção");
		} catch (IllegalArgumentException e) {
		}
	}
	
	@Test
	void testAdicionaTagsPosicaoAcimaLimite() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		try {
			agenda.adicionaTags(1, 6, "professor");
			fail("Era esperado uma exceção");
		} catch (IllegalArgumentException e) {
		}
	}
	
	@Test
	void testAdicionaTagsContatoNull() {
		try {
			agenda.adicionaTags(1, 1, "professor");
			fail("Era esperado uma exceção");
		} catch (IllegalArgumentException e) {
		}
	}
	
	@Test
	void testAdicionaTagsSobrescrevendo() {
		agenda.cadastraContato(1, "Matheus", "Gaudencio", "(83) 99999-0000");
		agenda.adicionaTags(1, 1, "professor");
		agenda.adicionaTags(1, 1, "Da like");
		assertEquals("Matheus Gaudencio\n(83) 99999-0000\nDa like", agenda.getContato(1));
	}

}
