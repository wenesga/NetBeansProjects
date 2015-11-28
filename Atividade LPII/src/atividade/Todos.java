package atividade;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane; 
public class Todos extends javax.swing.JDialog {

    /**
     * Creates new form Todos
     */
    public Todos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        preencherTabela();
    }
    public void preencherTabela()
    {
        DAO dao = new DAO();
        ArrayList dados = new ArrayList();

        String[] Colunas = new String[] {"ID","Nome","Email","Senha"}  ;     
        
        try 
        {
        dao.instrucao = dao.conexao.prepareStatement( "SELECT id,nome,email,senha FROM usuarios" );
        dao.resultado = dao.instrucao.executeQuery();
        dao.resultado.first();
        
            do{
                dados.add(new Object[]{dao.resultado.getInt("id"),dao.resultado.getString("nome"),dao.resultado.getString("email"),dao.resultado.getString("senha")});
               } 
            while(dao.resultado.next());
        } 
        catch(SQLException ex) 
        {
            JOptionPane.showMessageDialog(null,"Falha na conexão!");
        }
        

        ModeloTabela modelo = new ModeloTabela(dados,Colunas);
        
        tabela.setModel(modelo);

        tabela.getColumnModel().getColumn(0).setPreferredWidth(332); 
        tabela.getColumnModel().getColumn(1).setPreferredWidth(332);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(332);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(332);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabela);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 10, 375, 275);

        setSize(new java.awt.Dimension(462, 387));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Todos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Todos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Todos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Todos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Todos dialog = new Todos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
