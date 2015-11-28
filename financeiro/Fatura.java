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
public class Fatura {
    private String numero;
    private String descricao;
    private int quantidade;
    private double preco;
    
    public String getNumero(){
        return numero;
    }
    public void setNumero(String valor){
        numero = valor;
    }
    public String getDescricao(){
        return descricao;
    }
    public void setDescricao(String valor){
        descricao = valor;
    }
    public int getQuantidade(){
        return quantidade;
    }
    public void setQuantidade(int valor){
        if(valor > 0){
            quantidade = valor;
        }
        else{
            quantidade = 0;
        }
    }
    public double getPreco(){
        return preco;
    }
    public void setPreco(double valor){
        if(valor > 0){
            preco = valor;
        }
        else{
            preco = 0;
        }
        }
    public Fatura(String numIn, String descIn, int quantIn, double precoIn){
       numero = numIn;
       descricao = descIn;
       if(quantIn > 0){
           quantidade = quantIn;
       }
       if(preco >0){
           preco = precoIn;
       }
    }
    public double calculaFatura(){
        double total;
        total = quantidade * preco;
        return total;
    }
}
