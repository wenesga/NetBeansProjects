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
public class Empregado {
    private String nome;
    private String sobrenome;
    private double salario;

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public double getSalario() {
        return salario;
    }

    public void setNome(String nome1) {
        nome = nome1;
    }

    public void setSobrenome(String sobrenome1) {
        sobrenome = sobrenome1;
    }

    public void setSalario(double salario1) {
        if (salario1 > 0){
            salario = salario1;
        }
    }

    public Empregado(String nomeIn, String sobrenomeIn, double salarioIn) {
        nome = nomeIn;
        sobrenome = sobrenomeIn;
        salario = salarioIn;
    }
    
    public void calculaAumento(){
        salario = salario*1.1;
    }
    
}
