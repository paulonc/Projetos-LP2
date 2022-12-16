package BiblitexTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Biblitex.Clean;
import Biblitex.TransformaTexto;
import Logger.ConsoleLogger;

class TransformaTextoTest {
	
	private TransformaTexto tt;
	private Clean clean;
	private ConsoleLogger logger;

	@BeforeEach
	void setUp() throws Exception {
		this.tt = new TransformaTexto();
		tt.transforma("CaMeLcAsEfY", "oi, como vc vai?");
		tt.transforma("clean", "Oi, como vc vai?");
	}

	@Test
	void testTransformaTexto() {
		new TransformaTexto();
	}

	@Test
	void testTransformaTextoLogger() {
		logger = new ConsoleLogger();
		new TransformaTexto(logger);
	}

	@Test
	void testTransforma() {
		assertEquals("OI, COMO VC VAI?", tt.transforma("upperCase", "oi, como vc vai?"));
	}
	
	@Test
	void testTransformaTransformacaoInvalida() {
		assertEquals("TRANSFORMAÇÃO NÃO CADASTRADA!", tt.transforma("TrocaRporL", "oi Maria"));
	}
	
	@Test
	void testCadastraTransformacao() {
		this.tt.cadastraTransformacao("CLEAN", clean);
	
	}

	@Test
	void testContaTransformacao() {
		assertEquals(2, tt.contaTransformacao());
	}

	@Test
	void testHistorico() {
		assertEquals("oi, como vc vai? CaMeLcAsEfY -> Oi, CoMo vC VaI?", tt.historico(0));
	}
	
	@Test
	void testHistoricoPosicaoMaiorQueALista() {
		assertEquals("POSIÇÃO INVÁLIDA", tt.historico(3));
	}
	
	@Test
	void testHistoricoPosicaoInvalida() {
		assertEquals("POSIÇÃO INVÁLIDA", tt.historico(-1));
	}

	@Test
	void testListarTransformacoes() {
		assertEquals("CaMeLcAsEfY\n"
				+ "InterrogaPraPontos\n"
				+ "clean\n"
				+ "cleanSpaces\n"
				+ "MeioaMeio\n"
				+ "upperCase", tt.listarTransformacoes());
	}

	@Test
	void testListarOriginais() {
		assertEquals("oi, como vc vai?\nOi, como vc vai?", tt.listarOriginais());
	}
	
	@Test
	void testCadastraNomeNulo() {
		try {
			tt.cadastraTransformacao(null, clean);
			fail("Era esperado uma execeção");
		} catch (IllegalArgumentException e) {
		}
		
	}
	
	@Test
	void testCadastraNomeVazio() {
		try {
			tt.cadastraTransformacao("", clean);
			fail("Era esperado uma execeção");
		} catch (IllegalArgumentException e) {
		}
		
	}
	
	
}
