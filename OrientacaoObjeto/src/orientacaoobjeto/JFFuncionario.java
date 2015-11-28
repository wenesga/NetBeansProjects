package orientacaoobjeto;

import javax.swing.JOptionPane;

public class JFFuncionario extends javax.swing.JFrame {
    Funcionario funcionario = new Funcionario();
    Conexao conexao = new Conexao();
 
    public JFFuncionario() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        nome = new javax.swing.JLabel();
        campo_nome = new javax.swing.JTextField();
        endereco = new javax.swing.JLabel();
        campo_endereco = new javax.swing.JTextField();
        idade = new javax.swing.JLabel();
        campo_idade = new javax.swing.JTextField();
        salario = new javax.swing.JLabel();
        cargo = new javax.swing.JLabel();
        campo_salario = new javax.swing.JTextField();
        campo_cargo = new javax.swing.JTextField();
        botao_salvar = new javax.swing.JButton();

        jToggleButton1.setText("jToggleButton1");

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nome.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nome.setText("Nome:");

        campo_nome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_nomeActionPerformed(evt);
            }
        });

        endereco.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        endereco.setText("Endereço:");

        idade.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        idade.setText("Idade:");

        campo_idade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_idadeActionPerformed(evt);
            }
        });

        salario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        salario.setText("Salário:");

        cargo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cargo.setText("Cargo:");

        campo_salario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campo_salarioActionPerformed(evt);
            }
        });

        botao_salvar.setText("Salvar");
        botao_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botao_salvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(idade)
                                .addGap(36, 36, 36)
                                .addComponent(campo_idade, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(salario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campo_salario))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(nome)
                                            .addComponent(cargo))
                                        .addGap(36, 36, 36)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(campo_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(campo_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(endereco)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(campo_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(botao_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nome)
                    .addComponent(campo_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idade)
                    .addComponent(campo_idade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salario)
                    .addComponent(campo_salario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(endereco)
                    .addComponent(campo_endereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campo_cargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cargo))
                .addGap(52, 52, 52)
                .addComponent(botao_salvar)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campo_nomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_nomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_nomeActionPerformed

    private void botao_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botao_salvarActionPerformed
        // TODO add your handling code here:
        funcionario.setNome(campo_nome.getText());
        funcionario.setEndereco(campo_endereco.getText());
        funcionario.setIdade(Integer.parseInt(campo_idade.getText()));
        funcionario.setSalario(Double.parseDouble((campo_salario.getText())));
        funcionario.setCargo(campo_cargo.getText());
        
        int result = conexao.addFuncionario(funcionario);
        if(result == 1 ){
            JOptionPane.showMessageDialog(null, "Inserido com sucesso");
        }else
            JOptionPane.showMessageDialog(null, "Falha");
    }//GEN-LAST:event_botao_salvarActionPerformed

    private void campo_idadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_idadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_idadeActionPerformed

    private void campo_salarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campo_salarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campo_salarioActionPerformed

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
            java.util.logging.Logger.getLogger(JFFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFFuncionario().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botao_salvar;
    private javax.swing.JTextField campo_cargo;
    private javax.swing.JTextField campo_endereco;
    private javax.swing.JTextField campo_idade;
    private javax.swing.JTextField campo_nome;
    private javax.swing.JTextField campo_salario;
    private javax.swing.JLabel cargo;
    private javax.swing.JLabel endereco;
    private javax.swing.JLabel idade;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel nome;
    private javax.swing.JLabel salario;
    // End of variables declaration//GEN-END:variables
}
