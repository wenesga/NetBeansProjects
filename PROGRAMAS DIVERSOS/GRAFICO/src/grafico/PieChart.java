package grafico;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;
/*
 * @Descrição:
 * @author WENES GOMES AQUINO <wenesga@gmail.com>
 * @date 06/03/2016 - @TIPO Classe Grafico
 */
public class PieChart extends JFrame{

    private static final long serialVersionUID = 1L;

    public PieChart(String applicationTitle, String chartTitle) {
        
        super(applicationTitle);
        
        // Isso irá criar o conjunto de dados
        
        PieDataset dataset = createDataset();

        // com base no conjunto de dados que criamos o gráfico
        
        JFreeChart chart = createChart(dataset, chartTitle);

        // vamos colocar o gráfico em um painel
        
        ChartPanel chartPanel = new ChartPanel(chart);

        // default tamanho
        
        chartPanel.setPreferredSize(new java.awt.Dimension(1024, 550));

        // adiciona a nossa aplicação
        
        setContentPane(chartPanel);
    }

    /**
     * Cria um conjunto de dados de amostra
     */
    
    private PieDataset createDataset() {
        
        DefaultPieDataset result = new DefaultPieDataset();
        
        result.setValue("OS Linux", 30);
        
        result.setValue("OS Mac", 20);
        
        result.setValue("OS Windows", 50);
        
        return result;
    }

    /**
     * Cria um gráfico
     */
    
    private JFreeChart createChart(PieDataset dataset, String title) {

        JFreeChart chart = ChartFactory.createPieChart3D(title, // título / gráfico 
                
                dataset, // dados 
                
                true,    // include lenda
                
                true, false);

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        
        plot.setStartAngle(290);
        
        plot.setDirection(Rotation.CLOCKWISE);
        
        plot.setForegroundAlpha(0.5f);
        
        return chart;
    }
}
