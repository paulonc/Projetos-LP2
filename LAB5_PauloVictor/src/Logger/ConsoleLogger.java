package Logger;

/**
 * Classe que representa o ConsoleLogger, responsável por mostrar quais métodos foram invocados
 * e quais parâmetros se possuir um.
 * 
 * @author Paulo Victor do Nascimento Cavalcanti
 * @since set 2021.
 */

public class ConsoleLogger implements Logger{
	
	/**
	 * Método que exibe o método chamado e o primeiro parâmetro
	 * 
	 * @param metodo Método chamado
	 * @param parametro Primeiro parâmetro passado para o método
	 */
	@Override
	public void log(String metodo, String parametro) {
		System.out.println("[" + metodo + "] " + parametro);
	}

	/**
	 * Método que exibe o método chamado
	 * 
	 * @param metodo Método chamado
	 */
	@Override
	public void log(String metodo) {
		System.out.println("[" + metodo + "]");
	}
	


}
