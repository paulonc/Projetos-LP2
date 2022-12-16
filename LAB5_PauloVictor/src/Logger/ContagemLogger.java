package Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe que representa o ContagemLogger, responsável por contar quantas vezes um método é chamado.
 * 
 * 
 * @author Paulo Victor do Nascimento Cavalcanti
 * @since set 2021.
 */
public class ContagemLogger implements Logger{
	
	private Map<String, Integer> metodos;
	
	/**
	 * Construtro padrão do ContagemLogger, instancia um Map.
	 */
	public ContagemLogger() {
		this.metodos = new HashMap<>();
	}
	
	/**
	 * Método que conta a quantidade de vezes quando o metodo é invocado.
	 * 
	 * @param metodo Método chamado
	 * @param parametro Primeiro parâmetro
	 */
	@Override
	public void log(String metodo, String parametro) {	
		contagem(metodo);
	}
	
	/**
	 * Método que conta a quantidade de vezes quando o metodo é invocado.
	 * 
	 * @param metodo Método chamado
	 */
	@Override
	public void log(String metodo) {
		contagem(metodo);
	}
	
	/**
	 * Método que realiza a contagem dos métodos.
	 * Se o método não estiver no Map, ele é adicionado com a quantidade 1.
	 * Se ja estiver, ele é substituido pelo mesmo método, mas com 1 quantidade a mais.
	 * @param metodo Método chamado
	 */
	private void contagem(String metodo) {
		if (metodos.containsKey(metodo)) {
			metodos.replace(metodo, metodos.get(metodo) + 1);
		} else {
			this.metodos.put(metodo, 1);
		}
	}
	
	/**
	 * Representação textual da classe ContagemLogger
	 * Exibe todos os métodos e a quantidade de vezes invocados.
	 * 
	 * @return Uma String com os métodos e a quantidade
	 */
	@Override
	public String toString() {
		String resultado = "";
		for (Map.Entry<String,Integer> metodo : metodos.entrySet()) {
		    resultado += metodo.getKey() + " - " + metodo.getValue() + System.lineSeparator();
		}	
		return resultado;
	}
	
}