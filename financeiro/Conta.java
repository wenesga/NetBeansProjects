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
public class Conta {
    private double saldo;
    
    public void setSaldo(double saldo1){
        saldo = saldo1;
    }
    
    public double getSaldo(){
        return saldo;
    }
    
    public Conta(double saldoIn){
        if(saldoIn > 0){
            saldo = saldoIn;
        }
    }
    
    public void credito(double cash){
        saldo = saldo + cash;
    }
    
    public void debito(double money){
        saldo = saldo - money;
    }
}
