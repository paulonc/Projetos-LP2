package Biblitex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Logger.Logger;

/**
 * Classe que representa o sistema da Biblitex. E guarda vários tipos de transformações textuais
 * armzenando também, as Strins originais, um histórico das transformações e a quantidade de transformações
 * feitas.
 * 
 * @author Paulo Victor do Nascimento Cavalcanti
 * @since set 2021.
 * @version 1.0
 *
 */
public class TransformaTexto{
	
	
	private Map<String, AlgoritmoTransformacao> transformacoes;
	private List<String> historico;
	private Set<String> originais;
	private int quantTransformacoes;
	private Logger logger;

	/**
	 * Construtor padrão da classe TransformaTexto
	 * Instancia o Map de transformações, List do histórico, Set dos originais e 
	 * um int das quantidades de transformaçãoes.
	 * Por padrão a classe já cadastra seis transformações textuais:
	 * CamelCasefy, Clean, InterrogacoesParaPontos, UpperCase, CleanSpaces, MeioaMeio
	 */
	public TransformaTexto() {
		this.transformacoes = new HashMap<>();
		this.historico = new ArrayList<>();
		this.originais = new HashSet<>();	
		this.quantTransformacoes = 0;
		// Transformações padrões
		this.transformacoes.put("CaMeLcAsEfY", new CamelCasefy());
		this.transformacoes.put("clean", new Clean());
		this.transformacoes.put("InterrogaPraPontos", new InterrogacoesParaPontos());
		this.transformacoes.put("upperCase", new UpperCase());
		this.transformacoes.put("cleanSpaces", new CleanSpaces());
		this.transformacoes.put("meioaMeio", new MeioaMeio());
	}
	
	
	/**
	 * Construtor da classe TransformaTexto
	 * Instancia o Map de transformações, List do histórico, Set dos originais e 
	 * um int das quantidades de transformaçãoes.
	 * Por padrão a classe já cadastra seis transformações textuais:
	 * CamelCasefy, Clean, InterrogacoesParaPontos, UpperCase, CleanSpaces, MeioaMeio
	 * E possui um logger para registras as operações do sistema.
	 * @param logger Logger.
	 */
	public TransformaTexto(Logger logger) {
		this.transformacoes = new HashMap<>();
		this.historico = new ArrayList<>();
		this.originais = new HashSet<>();	
		this.quantTransformacoes = 0;
		this.logger = logger;
		// Transformações padrões
		this.transformacoes.put("CaMeLcAsEfY", new CamelCasefy());
		this.transformacoes.put("clean", new Clean());
		this.transformacoes.put("InterrogaPraPontos", new InterrogacoesParaPontos());
		this.transformacoes.put("upperCase", new UpperCase());
		this.transformacoes.put("cleanSpaces", new CleanSpaces());
		this.transformacoes.put("meioaMeio", new MeioaMeio());
	}
	
	
	/**
	 * Método responsável por cadastrar um algoritmo de transformação no sistema.
	 * 
	 * @param nome Nome da transformação textual
	 * @param meuAlgoritmo Algoritmo de transformação
	 */
	public void cadastraTransformacao(String nome, AlgoritmoTransformacao meuAlgoritmo) {
		if (logger != null) {
			logger.log("cadastraTransformacao");
		}
		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("NOME INVÁLIDO!");
		}
		this.transformacoes.put(nome, meuAlgoritmo);
	}
	
	/**
	 * Método que transforma uma String com base na transformação passada como 
	 * parâmetro. Se não existir nenhuma transformação textual com o nome passado, 
	 * é exibido uma mensagem de TRANSFORMAÇÃO NÃO CADASTRADA.
	 * 
	 * @param transformacao Transformação textual
	 * @param original String que será transformada
	 * @return A String transformada.
	 */
	public String transforma(String transformacao, String original) {
		if (logger != null) {
			logger.log("transforma", transformacao);
		}
		if (original == null || original.isBlank()) {
			throw new IllegalArgumentException("ENTRADA INVÁLIDA!");
		}
		
		if (this.transformacoes.get(transformacao) != null) {
			adicionaOriginal(original);
			addTransformacao();
			String resultado = this.transformacoes.get(transformacao).transforma(original);
			addHistorico(transformacao, original, resultado);
			return resultado;
		} 
		return "TRANSFORMAÇÃO NÃO CADASTRADA!";
	}
	
	
	/**
	 * Método que retorna quantas transformações foram feitas.
	 * @return um inteiro represetando a quantidade de transformações feitas
	 */
	public int contaTransformacao() {
		if (logger != null) {
			this.logger.log("contaTransformacao");
		}
		return quantTransformacoes;
	}
	
	/**
	 * Método que exibe uma transformação feita de acordo com a posição passada 
	 * como parâmetro, se for passada uma posição inválida, será exibido uma mensagem 
	 * de POSIÇÃO INVÁLIDA
	 * 
	 * @param pos Posição do histórico
	 * @return uma String que mostra o histórico
	 */
	public String historico(int pos) {
		if (logger != null) {
			logger.log("historico", Integer.toString(pos));
		}
		if (pos >= 0 && pos < historico.size()) {
			return this.historico.get(pos);
		}
		return "POSIÇÃO INVÁLIDA";
	}
	
	/**
	 * Método que lista todas as transformações textuais cadastradas em ordem alfabética.
	 * 
	 * @return uma String com todoas as transformações cadastradas
	 */
	public String listarTransformacoes() {
		if(logger != null) {
			logger.log("listarTransformacoes");
		}
		String resultado = "";
		List<String> ordenada = ordenarTransformacoes();
		for (String chaves : ordenada) {
			resultado += transformacoes.get(chaves).getNome() + System.lineSeparator();
		}
		return resultado.strip();
	}
	
	/**
	 * Método que lista todas as String originais que foram transformadas.
	 * @return uma lista com as String originais.
	 */
	public String listarOriginais() {
		if(logger != null) {
			logger.log("listarOriginais");
		}
		String retorno = "";
		for (String original : originais) {
			retorno += original + System.lineSeparator();		
		}
		return retorno.strip();	
	}
	
	private void adicionaOriginal(String original) {
		originais.add(original);
	}
	
	private void addHistorico(String transformacao, String msg, String resultado) {
		this.historico.add(msg + " " + transformacao + " -> " + resultado);
	}
	
	
	private void addTransformacao() {
		this.quantTransformacoes += 1;	
	}
	

	private List<String> ordenarTransformacoes() {	
		List<String> nomeTransformacao = new ArrayList<>(transformacoes.keySet());
		Collections.sort(nomeTransformacao);
		return nomeTransformacao;
	}

}
