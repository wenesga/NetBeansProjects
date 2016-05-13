package ControleDaFarmacia;
/**
 * @author WENES
 */
public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        cadastro = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mcadastro = new javax.swing.JMenu();
        cproduto = new javax.swing.JMenuItem();
        mestoque = new javax.swing.JMenu();
        MenuRemedio = new javax.swing.JMenuItem();
        MenuHigiene = new javax.swing.JMenuItem();

        jMenu2.setText("File");
        jMenuBar2.add(jMenu2);

        jMenu3.setText("Edit");
        jMenuBar2.add(jMenu3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Controle de Farmácia");

        javax.swing.GroupLayout cadastroLayout = new javax.swing.GroupLayout(cadastro);
        cadastro.setLayout(cadastroLayout);
        cadastroLayout.setHorizontalGroup(
            cadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 740, Short.MAX_VALUE)
        );
        cadastroLayout.setVerticalGroup(
            cadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 486, Short.MAX_VALUE)
        );

        mcadastro.setText("Cadastro");

        cproduto.setText("Produtos");
        cproduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cprodutoActionPerformed(evt);
            }
        });
        mcadastro.add(cproduto);

        jMenuBar1.add(mcadastro);

        mestoque.setText("Estoque");

        MenuRemedio.setText("Remédio");
        MenuRemedio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuRemedioActionPerformed(evt);
            }
        });
        mestoque.add(MenuRemedio);

        MenuHigiene.setText("Higiene");
        MenuHigiene.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuHigieneActionPerformed(evt);
            }
        });
        mestoque.add(MenuHigiene);

        jMenuBar1.add(mestoque);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cadastro)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cadastro)
        );

        setSize(new java.awt.Dimension(756, 545));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cprodutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cprodutoActionPerformed
        Cadastro prod = new Cadastro();
        cadastro.add(prod);
        prod.setVisible(true);
    }//GEN-LAST:event_cprodutoActionPerformed

    private void MenuHigieneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuHigieneActionPerformed
        EstoqueHigiene estoqueH = new EstoqueHigiene();
        cadastro.add(estoqueH);
        estoqueH.setVisible(true);
    }//GEN-LAST:event_MenuHigieneActionPerformed

    private void MenuRemedioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuRemedioActionPerformed
        EstoqueRemedio estoqueR = new EstoqueRemedio();
        cadastro.add(estoqueR);
        estoqueR.setVisible(true);
    }//GEN-LAST:event_MenuRemedioActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem MenuHigiene;
    private javax.swing.JMenuItem MenuRemedio;
    private javax.swing.JDesktopPane cadastro;
    private javax.swing.JMenuItem cproduto;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenu mcadastro;
    private javax.swing.JMenu mestoque;
    // End of variables declaration//GEN-END:variables
}
