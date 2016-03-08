package graficabarras;

import java.sql.*;
import java.util.Map;
import java.util.HashMap;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.*;
import net.sf.jasperreports.view.save.JRPdfSaveContributor.*;
import net.sf.jasperreports.view.JRViewer.*;
import net.sf.jasperreports.view.save.JRMultipleSheetsXlsSaveContributor.*;

/*
 * @Descrição:
 * @author WENES GOMES AQUINO <wenesga@gmail.com>
 * @date 06/03/2016 - @TIPO Classe StarReport
 */

public class StarReport {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String RUTA = "jdbc:mysql://localhost/bdbiblioteca";
    public static final String USER = "root";
    public static final String PASSWORD = "itsj";
    public static Connection CONEXION;

    public void ejecutarReporte(String parametro, String valorParametro, String ruta) {

        try {
            Class.forName(DRIVER);
            CONEXION = DriverManager.getConnection(RUTA, USER, PASSWORD);
            javax.swing.JOptionPane.showMessageDialog(null, "Cargando reporte...");

            //String template="Reporte.jasper";
            String template = ruta;
            JasperReport reporte = null;
            reporte = (JasperReport) JRLoader.loadObject(template);

            Map param = new HashMap();
            param.put(parametro, valorParametro);

            JasperPrint jasperprint = JasperFillManager.fillReport(reporte, param, CONEXION);
            JasperViewer visor = new JasperViewer(jasperprint, false);
            visor.setTitle("Reportes Biblioteca");
            visor.setVisible(true);

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, e);

        }
    }

}
