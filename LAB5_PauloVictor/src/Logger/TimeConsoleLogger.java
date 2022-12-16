package Logger;


/**
 * Classe que representa o TimeConsoleLogger, responsável por mostrar o momento 
 * em que um método é chamado.
 * 
 * @author Paulo Victor do Nascimento Cavalcanti
 * @since set 2021.
 */
public class TimeConsoleLogger implements Logger {
	
	private long tempoInicial;
	
	/**
	 * Construtor do TimeConsoleLogger, guarda o tempo em que foi instanciado.
	 */
	public TimeConsoleLogger() {
		tempoInicial = System.currentTimeMillis();
	}
	
	/**
	 * Método que calcula o tempo, subtraindo o tempo em que é chamado, com o tempo
	 * guardado no momento em que a classe foi instanciada.
	 * @return o resultado do tempo
	 */
	private long calculaTempo() {
		return System.currentTimeMillis() - tempoInicial;
	}
	
	/**
	 * Método que imprime uma mensagem no momento em que o método é chamado, exibindo 
	 * o método e o primeiro parâmetro e o tempo em ms que foi chamado.
	 */
	@Override
	public void log(String metodo, String parametro) {
		long tempo = calculaTempo();
		System.out.println("[" + metodo + " - " + tempo + "ms] " + parametro);
	}

	/**
	 * Método que imprime uma mensagem no momento em que o método é chamado, exibindo 
	 * o método e o tempo em ms que foi chamado.
	 */
	@Override
	public void log(String metodo) {
		long tempo = calculaTempo();
		System.out.println("[" + metodo + " - " + tempo + "ms]");
	}

}
