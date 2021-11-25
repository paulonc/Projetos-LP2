package lab2;


/**
* Representa a rotina de descanso de um estudante do curso de Ciência da Computação. 
* Sua rotina é representada pelas horas de descanso e o número de semanas.
*
* @author Paulo Victor do Nascimento Cavalcanti
* @since jul 2021.
* @version 1.0
*/
public class Descanso {

    private int horasDescanso;
    private int numeroSemanas;

    
    /** 
     * Define as horas de descanso que o estudante possui.
     * 
     * @param horas representa as horas de descanso
     */
    public void defineHorasDescanso(int horas) {
        horasDescanso = horas;
    }

    
    /** 
     * Define o número de semanas.
     * 
     * @param valor representa o número de semanas
     */
    public void defineNumeroSemanas(int valor) {
        numeroSemanas = valor;
    }
    
    
    /**
     * 
     * Método que avalia os status do estudante com base no cálculo (Horas de descanso / Número de semana).
     * Se o resultado do cálculo for maior ou igual a 26, o estudante estará descansado, caso contrário, estará cansado.
     * 
     * @return String os status de descanso do estudante
     */
    public String getStatusGeral() {
        if (numeroSemanas > 0 && horasDescanso / numeroSemanas >= 26) {
            return "descansado";
        } else {
            return "cansado";
        }
    }

}
