/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebankaccesobd;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author LilCucumbah
 */
public class LogInCliente extends javax.swing.JDialog {

    Cliente cliente;
    Banco eBanco;
    public LogInCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        
    }
    public LogInCliente(java.awt.Frame parent, boolean modal, Banco banco) {
        super(parent, modal);
        initComponents();
        
        eBanco = banco;
        this.setLocationRelativeTo(null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        accesojButton = new javax.swing.JButton();
        borrarjButton = new javax.swing.JButton();
        dniJTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Acceder a Cliente:");

        jLabel2.setText("DNI");

        accesojButton.setText("Acceder");
        accesojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accesojButtonActionPerformed(evt);
            }
        });

        borrarjButton.setText("Borrar");
        borrarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarjButtonActionPerformed(evt);
            }
        });

        dniJTextField.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        dniJTextField.setText("\"Introduzca el DNI de un cliente\"");
        dniJTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        dniJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dniJTextFieldActionPerformed(evt);
            }
        });
        dniJTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dniJTextFieldKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(accesojButton)
                                .addGap(18, 18, 18)
                                .addComponent(borrarjButton))
                            .addComponent(dniJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(dniJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accesojButton)
                    .addComponent(borrarjButton))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void accesojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accesojButtonActionPerformed
        if (dniJTextField.getBackground() != Color.GREEN) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error el campo no está debidamente validado,"
                    + " debe de pulsar ENTER y quedarse el fondo de color VERDE");
        }else{
            JFrame padre = new JFrame();
            AccesoCuentasClienteComboBox acceso = new AccesoCuentasClienteComboBox(padre, false, eBanco, cliente);
            acceso.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_accesojButtonActionPerformed

    private void dniJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dniJTextFieldActionPerformed

        String dni = dniJTextField.getText();
        Cliente cliente = null;

        if(dni.length()== 0){
            javax.swing.JOptionPane.showMessageDialog(null, "Error, el campo DNI está vacío");
        }else if (!FuncionesSobreCaracteres.esDNIValido(dni)) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error, el DNI no es válido"
                + " tiene que cuplir con el formato: xxxxxxxxA, compruebe que lo ha escrito correctamente");
        } else try {
            if (eBanco.buscaDNICliente(dni) == null) {
                javax.swing.JOptionPane.showMessageDialog(null, "Error, ese DNI no está"
                    + " dado de alta en ningún cliente");
            }else{
                dniJTextField.setBackground(Color.green);
                dniJTextField.setEditable(false);

                cliente = eBanco.recuperaCliente(dni);
                                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModificarBorrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_dniJTextFieldActionPerformed

    private void dniJTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dniJTextFieldKeyPressed
        // TODO add your handling code here:
        if (dniJTextField.getText().compareTo("\"Introduzca el DNI de un cliente\"")==0) {
            dniJTextField.setText("");
        }
    }//GEN-LAST:event_dniJTextFieldKeyPressed

    private void borrarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarjButtonActionPerformed
        dniJTextField.setText("");
        dniJTextField.setBackground(Color.white);
        dniJTextField.setEditable(true);
    }//GEN-LAST:event_borrarjButtonActionPerformed

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
            java.util.logging.Logger.getLogger(LogInCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogInCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogInCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogInCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LogInCliente dialog = new LogInCliente(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton accesojButton;
    private javax.swing.JButton borrarjButton;
    private javax.swing.JTextField dniJTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}