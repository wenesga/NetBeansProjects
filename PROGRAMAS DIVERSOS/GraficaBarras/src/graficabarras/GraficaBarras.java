package graficabarras;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartUtilities;
import java.io.File;
import org.jfree.chart.plot.*;
import java.io.*;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * @Descrição:
 * @author WENES GOMES AQUINO <wenesga@gmail.com>
 * @date 06/03/2016 - @TIPO Classe GraficaBarras
 */

public class GraficaBarras {

    public void graficarbarras(int[] y, String[] x, String datah, String datav, String titulo) {
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        for (int d = 0; d < y.length; d++) {
            data.setValue(y[d], x[d], x[d]);
        }
        JFreeChart chart = ChartFactory.createBarChart(titulo, datah, datav, data, PlotOrientation.VERTICAL, false,
                true, false);
        ChartFrame frame = new ChartFrame(titulo, chart);
        frame.pack();
        frame.setVisible(true);
    }
}
