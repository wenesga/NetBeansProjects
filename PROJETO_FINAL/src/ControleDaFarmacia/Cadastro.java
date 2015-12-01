package ControleDaFarmacia;
import Dao.HigieneDao;
import Dao.RemedioDao;
import Entidade.Higiene;
import Entidade.Remedio;
import javax.swing.JOptionPane;
/**
 * @author WENES
 */
public class Cadastro extends javax.swing.JInternalFrame {
    
    public Cadastro() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        fcadastro = new javax.swing.JPanel();
        precoDeCompra = new javax.swing.JLabel();
        PercentualDeLucro = new javax.swing.JLabel();
        fDescricao = new javax.swing.JTextField();
        fPrecoDeCompra = new javax.swing.JTextField();
        fPercentualDeLucro = new javax.swing.JTextField();
        descricao = new javax.swing.JLabel();
        fSalvar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jcbcategoria = new javax.swing.JComboBox();

        jButton1.setText("jButton1");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastro de Produto");
        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        fcadastro.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                fcadastroAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        precoDeCompra.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        precoDeCompra.setText("Preço de Compra:");

        PercentualDeLucro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PercentualDeLucro.setText("Percentual de Lucro:");

        fPrecoDeCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fPrecoDeCompraActionPerformed(evt);
            }
        });

        descricao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        descricao.setText("Descrição:");

        fSalvar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fSalvar.setText("Salvar");
        fSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fSalvarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Categoria:");

        jcbcategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Higiene", "Remédio" }));
        jcbcategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbcategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout fcadastroLayout = new javax.swing.GroupLayout(fcadastro);
        fcadastro.setLayout(fcadastroLayout);
        fcadastroLayout.setHorizontalGroup(
            fcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fcadastroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(fcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(precoDeCompra)
                        .addComponent(PercentualDeLucro)
                        .addComponent(jLabel1))
                    .addGroup(fcadastroLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fPrecoDeCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fPercentualDeLucro, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fcadastroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(fSalvar)
                .addGap(187, 187, 187))
        );
        fcadastroLayout.setVerticalGroup(
            fcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fcadastroLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(fcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descricao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(fcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jcbcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(fcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(precoDeCompra)
                    .addComponent(fPrecoDeCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(fcadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PercentualDeLucro)
                    .addComponent(fPercentualDeLucro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(fSalvar)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fcadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fcadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(140, 70, 462, 316);
    }// </editor-fold>//GEN-END:initComponents

    private void fcadastroAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_fcadastroAncestorAdded
        
    }//GEN-LAST:event_fcadastroAncestorAdded

    public void limpaCampo(){
        fDescricao.setText("");
        fPrecoDeCompra.setText("");
        fPercentualDeLucro.setText("");
    }
    
    private void fSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fSalvarActionPerformed

        if(jcbcategoria.getSelectedItem().toString() == "Higiene"){
            
            HigieneDao higieneDao = new HigieneDao();
            Higiene higiene = new Higiene();
            higiene.setDescricao(fDescricao.getText());
            higiene.setPrecoDeCompra(Float.parseFloat(fPrecoDeCompra.getText()));
            higiene.setPercentualDeLucro(Float.parseFloat(fPercentualDeLucro.getText())); 
            higieneDao.setHigiene(higiene);
            int result = higieneDao.inserir();
            
            limpaCampo();
       
            if(result == 1 ){
                JOptionPane.showMessageDialog(null, "Inserido com sucesso");
            }else
            JOptionPane.showMessageDialog(null, "Falha");
  
        
        }else if(jcbcategoria.getSelectedItem().toString() == "Remédio"){
            
            Remedio remedio = new Remedio();
            RemedioDao remedioDao = new RemedioDao();
            remedio.setDescricao(fDescricao.getText());
            remedio.setPrecoDeCompra(Float.parseFloat(fPrecoDeCompra.getText()));
            remedio.setPercentualDeLucro(Float.parseFloat(fPercentualDeLucro.getText()));
            remedioDao.setRemedio(remedio); 
            int result = remedioDao.inserir();
            
            limpaCampo();
       
            if(result == 1 ){
                JOptionPane.showMessageDialog(null, "Inserido com sucesso");
            }else
            JOptionPane.showMessageDialog(null, "Falha");     
        }
  
    }//GEN-LAST:event_fSalvarActionPerformed

    private void fPrecoDeCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fPrecoDeCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fPrecoDeCompraActionPerformed

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_formAncestorAdded

    private void jcbcategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbcategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbcategoriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PercentualDeLucro;
    private javax.swing.JLabel descricao;
    private javax.swing.JTextField fDescricao;
    private javax.swing.JTextField fPercentualDeLucro;
    private javax.swing.JTextField fPrecoDeCompra;
    private javax.swing.JButton fSalvar;
    private javax.swing.JPanel fcadastro;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox jcbcategoria;
    private javax.swing.JLabel precoDeCompra;
    // End of variables declaration//GEN-END:variables
}
