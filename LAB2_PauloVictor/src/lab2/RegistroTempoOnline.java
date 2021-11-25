package lab2;

/**
* Representa o registo de tempo online que o estudante dedica a uma determinada disciplina.
* É representa pelo nome da disciplina, o tempo esperado e o tempo em que o estudante dedicou.
* 
* @author Paulo Victor do Nascimento Cavalcanti
* @since jul 2021.
* @version 1.0
*/
public class RegistroTempoOnline {

    private String nomeDisciplina;
    private int tempoOnlineEsperado;
    private int tempoOnline;

    
    /**
    * Constrói um registro de tempo a partir do nome da disciplina e do tempo que se espera que o estudante dedique a essa disciplina.
    *
    * @param nomeDisciplina o nome da disciplina
    * @param tempoOnlineEsperado o tempo que se espera que o estudante cumpra
    */
    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = tempoOnlineEsperado;
    }

    /**
    * Constrói um registro de tempo a partir do nome da disciplina.
    * Por padrão o tempo online esperado é definido como sendo de 120 horas.
    *
    * @param nomeDisciplina o nome da disciplina
    */
    public RegistroTempoOnline(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = 120;
    }

    
    /** 
     * Método que acumula o tempo em que o estudante já dedicou a disciplina.
     * 
     * @param horas as horas que o aluno já estudou para a disciplina
     */
    public void adicionaTempoOnline(int horas) {
        tempoOnline += horas;
    }

    
    /** 
     * Método que analisa se o tempo online que o estudante dedicou à disciplina atingiu o tempo esperado.
     * Retornando true se o tempo online for maior ou igual ao tempo esperado, ou false caso contrário.
     * 
     * @return boolean valor se atingiu ou não o tempo esperado
     */
    public boolean atingiuMetaTempoOnline() {
       return tempoOnline >= tempoOnlineEsperado; 
    }

    
    /** 
     * Retorna a String que representa a disciplina e a comparação entre o tempo dedicado e o tempo esperado.
     * A representação está no formato "nomeDisciplina tempoOnline / tempoOnlineESperado ".
     * 
     * @return String a representação em string do registro de tempo online
     */
    public String toString() {
        return this.nomeDisciplina + " " + 
        this.tempoOnline + "/" + 
        this.tempoOnlineEsperado;
    }
}