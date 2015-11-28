/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro;

import java.util.Scanner;

/**
 *
 * @author sandra
 */
public class FaturaTest {
    public static void main(String[] args) {
        Fatura f = new Fatura("01",null, 0, 0);
        Fatura f2 = new Fatura(null, null, 0, 0);
        Scanner scanner = new Scanner(System.in);
        
         
        System.out.println("Informe a descricao");
        String desc;
        desc = scanner.nextLine();
        f.setDescricao(desc);
        
        System.out.printf("Informe a quantidade do produto %s", f.getDescricao());
        int quant;
        quant = scanner.nextInt();
        f.setQuantidade(quant);
        
        System.out.println("Informe o preco");
        double preco;
        preco = scanner.nextDouble();
        f.setPreco(preco);
       
        double total;
        total = f.calculaFatura();
        
        
        System.out.printf("numero %s descricao %s quantidade %d preco %f. O valor da fatura e %f ",
                f.getNumero(), f.getDescricao(), f.getQuantidade(),
                f.getPreco(), total);
    }
}
