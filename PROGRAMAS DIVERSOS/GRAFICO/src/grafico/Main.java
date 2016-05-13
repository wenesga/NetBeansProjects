package grafico;

/*
 * @Descrição:
 * @author WENES GOMES AQUINO <wenesga@gmail.com>
 * @date 06/03/2016 - @TIPO Classe Main
 */
public class Main {

    public static void main(String[] args) {
        
        PieChart demo = new PieChart("Janela de Estatística", 
                "Teste de Gráfico em Java - Por Wenes Gomes Aquino");
        
        demo.pack();
        
        demo.setVisible(true);
    }

}
