package graficabarras;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
/*
 * @Descrição:
 * @author WENES GOMES AQUINO <wenesga@gmail.com>
 * @date 06/03/2016 - @TIPO Classe Grafica
 */

public class Grafica
{
    public void graficar(int []y,String [] x,String titulo)
    {
       DefaultPieDataset data = new DefaultPieDataset();
        for(int d=0;d<y.length;d++)
        {
         data.setValue(x[d],y[d]);  
        }
        JFreeChart chart = ChartFactory.createPieChart(titulo,data,true,true,true);
        ChartFrame frame=new ChartFrame(titulo,chart);
        frame.pack();
        frame.setVisible(true);
    }
}
