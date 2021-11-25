package lab2;

import java.util.Arrays;

/**
* Representa a disciplina em que o estudante está matriculado.
* Cada disciplina é identificada pelo nome e possui como característica as horas de estudo e suas 4 notas.
*
* @author Paulo Victor do Nascimento Cavalcanti
* @since jul 2021.
* @version 1.0
*/

public class Disciplina {


    private String nomeDisciplina;
    private double[] notas;
    private int horas;
    private double media;

    /**
    * Constrói uma disciplina a partir de seu nome
    *    
    * @param nomeDisciplina o nome da disciplina
    */
    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.notas = new double[4];
        this.horas = 0;
        this.media = 0;
    }
 
    /** 
     * Método que cadastra as horas que um estudante dedicou a disciplina
     * 
     * @param horas as horas de estudo para a disciplina
     */
    public void cadastraHoras(int horas) {
        this.horas = horas;
    }

    
    /** 
     * Método que cadastra as notas em um Array 
     * 
     * @param indiceNota índice onde a nota será guardada
     * @param valorNota a nota
     */
    public void cadastraNota(int indiceNota, double valorNota) {
        notas[indiceNota - 1] = valorNota;
    }


    /** 
     * Método que calcula a média aritmética das notas, somando-as e dividindo por 4
     * 
     */
    private void calculaMedia() {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
       this.media = soma / 4;
    }

    
    /** 
     * Método que retorna um boolean de acordo com a verificação da média.
     * Se a média for igual ou maior a 7 retornará true, caso contrário retornará false.
     * 
     * @return boolean os status de aprovado do estudante
     */
    public boolean aprovado() {
    	calculaMedia();
        return this.media >= 7.0;
    }

    
    /** 
     * Retorna uma String representando a disciplina. Apresentando o nome, horas estudadas, média e todas as notas.
     * A representação está no seguinte formato "nomeDisciplina horas media notas".
     * 
     * @return String a representação da disciplina 
     */
    public String toString() {
        return this.nomeDisciplina + " " +
        this.horas + " " +
        this.media + " " +
        Arrays.toString(notas);
    }
}