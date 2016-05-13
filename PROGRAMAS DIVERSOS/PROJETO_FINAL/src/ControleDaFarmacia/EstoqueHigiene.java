package ControleDaFarmacia;
import Dao.HigieneDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Entidade.*;
/**
 * @author WENES
 */
public class EstoqueHigiene extends javax.swing.JInternalFrame {

    public EstoqueHigiene() {
        initComponents();
        preencherTabela();
    }
    
    public void preencherTabela()
    {
        HigieneDao dao = new HigieneDao();
        ArrayList dados = new ArrayList();

        String[] Colunas = new String[] {"codigo","descricao","precodecompra","percentualdelucro","precodevenda"}  ;     
        
        try 
        {
        ResultSet rs = dao.consultaHigiene();
        
        rs.first();
            do{
                dados.add(new Object[]{rs.getInt("codigo"),rs.getString("descricao"),rs.getFloat("precodecompra"),rs.getFloat("percentualdelucro"),rs.getFloat("precodevenda")});
               } 
            while(rs.next());
        } 
        catch(SQLException ex) 
        {
            JOptionPane.showMessageDialog(null,"Falha na conexão!");
        }
  
        Tabela modelo = new Tabela(dados,Colunas);
        
        jTable1.setModel(modelo);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(80); 
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(400);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(170);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(190);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(160);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Estoque de Produto de Higiene");

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
        );

        setBounds(65, 50, 614, 385);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
