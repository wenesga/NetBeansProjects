/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro;

/**
 *
 * @author sandra
 */
public class EmpregadoTest {
    public static void main(String[] args) {
        Empregado empregado1 = new Empregado("Joao", "Da Silva", 800);
        Empregado empregado2 = new Empregado("Chica", "Da Silva", 900);
        
        System.out.printf("O salario anual do %s e: %f\n", empregado1.getNome(), empregado1.getSalario()*12);
        System.out.printf("O salario anual do %s e: %f\n", empregado2.getNome(), empregado2.getSalario()*12);
        
        empregado1.calculaAumento();
        empregado2.calculaAumento();
        
        
        System.out.printf("O salario atual de %s %s e: %f\n", empregado1.getNome(), empregado1.getSobrenome(), empregado1.getSalario());
        System.out.printf("O salario atual de %s %s e: %f\n", empregado2.getNome(), empregado2.getSobrenome(), empregado2.getSalario());
      
    }   
    
    
}
