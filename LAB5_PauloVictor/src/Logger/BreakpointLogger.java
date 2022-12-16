package Logger;

/**
 * Classe que representa o BreakpointLogger, responsável por mostrar sempre que 
 * o método passado no construtor é chamado.
 * 
 * @author Paulo Victor do Nascimento Cavalcanti
 * @since set 2021.
 */
public class BreakpointLogger implements Logger {
	
	private String metodo;
	
	/**
	 * Construtor do BreakpointLogger. É definido por um método passado.
	 * @param metodo
	 */
	public BreakpointLogger(String metodo) {
		this.metodo = metodo;
	}
	
	
	/**
	 * Método que exibe uma mensagem quando o método passado é igual ao passado 
	 * no construtor e também exibe o seu primeiro parametro.
	 * 
	 * @param metodo Método chamado
	 * @param parametro Primeiro parâmetro passado para o método
	 */
	@Override
	public void log(String metodo, String parametro) {
		if (this.metodo.equals(metodo)) {
			System.out.println("[INVOCADO - " + metodo + "] " + parametro);
		}
	}

	
	/**
	 * Método que exibe uma mensagem quando o método passado é igual ao passado 
	 * no construtor.
	 * 
	 * @param metodo Método chamado
	 */
	@Override
	public void log(String metodo) {
		if (this.metodo.equals(metodo)) {
			System.out.println("[INVOCADO - " + metodo + "]");
		}
	}


}
