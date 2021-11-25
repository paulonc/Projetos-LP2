package lab2;


/**
* Representa o registro de finanças do estudante, auxiliando a gerenciar os seus ganhos e despesas.
* O registro de finanças é representado pelos ganhos iniciais, ganhos subsequentes e pelas despesas
* todos na unidade de centavos.
*
* @author Paulo Victor do Nascimento Cavalcanti
* @since jul 2021.
* @version 1.0
*/
public class RegistroFinancas {

    private int dinheiroNaConta;
    private int ganhosIniciais;
    private int[] valores;
    private int totalDespesas;          



    /**
    * Constrói um registro de finanças com os ganhos iniciais e a quantidade de ganhos que irá receber.
    * Criando um Array para armazenar os ganhos
    * 
    * @param ganhosIniciais representa o primeiro ganho em centavos
    * @param totalDeGanhos representa a quantidade de vezes que irá adicionar mais um ganho
    */
    public RegistroFinancas(int ganhosIniciais, int totalDeGanhos) {
        this.ganhosIniciais = ganhosIniciais;
        this.valores = new int[totalDeGanhos];
    }
    
    
    /** 
     * Método que adiciona um valor a uma determinada posição no Array.
     * 
     * @param valorCentavos o valor em centavos a ser armazenado
     * @param posicaoGanho a posição em o ganho deve ser alocado
     */
    public void adicionaGanhos(int valorCentavos, int posicaoGanho) {
        this.valores[posicaoGanho - 1] = valorCentavos;
    }

    
    /** 
     * Método que acumula as despesas
     * 
     * @param valorCentavos valor das despesas
     */
    public void pagaDespesa(int valorCentavos) {
        this.totalDespesas += valorCentavos;
    }

    
    /** 
     * Método que calcula o valor total que o estudante possui em sua conta.
     * Somando todos os ganhos adicionais mais o ganho inicial.
     * 
     * @return int valor total que possuí
     */
    private int totalRecebido() {
        this.dinheiroNaConta = ganhosIniciais;
        for (int valor : valores) {
            this.dinheiroNaConta += valor;
        }
        return this.dinheiroNaConta;
    }

    
    /** 
     * Método que calcula o saldo liquido, subtraindo o total pelas despesas.
     * 
     * @return int representa o saldo líquido
     */
    private int saldoLiquido() {
        return totalRecebido() - this.totalDespesas;
    }

    
    /** 
     * Método que retorna uma String exibindo os ganhos e suas posições.
     * No formato "posição - ganhos"
     * 
     * @return String apresenta os ganhos e suas posições
     */
    public String exibeGanhos() {
        String ganhosFormatado = "";
        for (int i = 0; i < valores.length; i++){
            if (i < valores.length - 1) {
            ganhosFormatado += String.format("%d - %d%n", i+1, valores[i]);
        } else {
            ganhosFormatado += String.format("%d - %d", i+1, valores[i]);
        }
        }
        return ganhosFormatado;
    }

    
    /** 
     * Retorna uma String representando o registro de finanças do estudante.
     * Apresentando o total que possuí, despesas e saldo líquido.
     * Segue o seguinte formato "Total recebido, despesas, saldo líquido"
     * 
     * @return String a representação do registro de finanças
     */
    public String toString() {
        return "Total recebidos: " + 
        totalRecebido() + ", " + 
        "Despesas totais: " + 
        this.totalDespesas + ", " + 
        "Total disponivel: " + 
        saldoLiquido();
    }
}
