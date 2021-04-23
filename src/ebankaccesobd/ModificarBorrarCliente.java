/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebankaccesobd;

import java.awt.Color;
import java.awt.Frame;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LilCucumbah
 */
public class ModificarBorrarCliente extends javax.swing.JDialog {

    private Banco eBanco;
    private boolean tipo; //Si es tipo baja, true. Si es tipo modificacion, false
    private TarjetaCredito tarjeta = null;    
    
    public ModificarBorrarCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public ModificarBorrarCliente(Frame owner, String title, Banco eBanco) {
        super(owner, title);
        this.eBanco = eBanco;
        initComponents();
        
        modificarjButton.setVisible(false);
        bajaClientejButton.setVisible(false);
        
        if (title.compareTo("Dar de Baja") == 0) {
            tipo=true;
        }else{
            tipo=false;
        }
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
        telJTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        ap2JTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        dniJTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tituloJLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ap1JTextField = new javax.swing.JTextField();
        direccionJTextField = new javax.swing.JTextField();
        nombreJTextField2 = new javax.swing.JTextField();
        emailJTextField = new javax.swing.JTextField();
        modificarjButton = new javax.swing.JButton();
        cancelarjButton = new javax.swing.JButton();
        bajaClientejButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("DNI");

        telJTextField.setEditable(false);
        telJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telJTextFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre");

        ap2JTextField.setEditable(false);
        ap2JTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ap2JTextFieldActionPerformed(evt);
            }
        });

        jLabel3.setText("Apellido 1");

        dniJTextField.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        dniJTextField.setText("\"Introduzca el DNI de un cliente\"");
        dniJTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        dniJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dniJTextFieldActionPerformed(evt);
            }
        });

        jLabel4.setText("Apellido 2");

        tituloJLabel8.setFont(new java.awt.Font("Eras Bold ITC", 1, 24)); // NOI18N
        tituloJLabel8.setText("  ");

        jLabel5.setText("Direccion");

        jLabel6.setText("Telefono");

        jLabel7.setText("e-mail");

        ap1JTextField.setEditable(false);
        ap1JTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ap1JTextFieldActionPerformed(evt);
            }
        });

        direccionJTextField.setEditable(false);
        direccionJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direccionJTextFieldActionPerformed(evt);
            }
        });

        nombreJTextField2.setEditable(false);
        nombreJTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreJTextField2ActionPerformed(evt);
            }
        });

        emailJTextField.setEditable(false);
        emailJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailJTextFieldActionPerformed(evt);
            }
        });

        modificarjButton.setText("Aplicar Cambios");

        cancelarjButton.setText("Cancelar");

        bajaClientejButton.setText("Borrar Cliente");
        bajaClientejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bajaClientejButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(direccionJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(ap2JTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ap1JTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(telJTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nombreJTextField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dniJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(bajaClientejButton)
                                .addComponent(emailJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cancelarjButton)
                                .addComponent(modificarjButton))))
                    .addComponent(tituloJLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloJLabel8)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(dniJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombreJTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ap1JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ap2JTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(telJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(direccionJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(emailJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(modificarjButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelarjButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bajaClientejButton)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void telJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telJTextFieldActionPerformed

        String tel = telJTextField.getText();
        if (tel.length()==0 || tel.length() < 9) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error el telefono debe de constituirse por 9 cifras numéricas");
        }else{
            boolean telVal = false;
            for (int i = 0; i < tel.length(); i++) {
                telVal = FuncionesSobreCaracteres.esNumeroValido(tel.charAt(i));
            }
            if (!telVal) {
                javax.swing.JOptionPane.showMessageDialog(null, "Error el teléfono solo puede contener dígitos del 0-9");
            }else{
                telJTextField.setBackground(Color.green);
                telJTextField.setEditable(false);
            }
        }
    }//GEN-LAST:event_telJTextFieldActionPerformed

    private void ap2JTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ap2JTextFieldActionPerformed

        String ap2 = ap2JTextField.getText();
        if (ap2.length()==0) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error el apel1ido debe tener una longitud superior a 0");
        }else{
            boolean ap2Val = false;
            for (int i = 0; i < ap2.length(); i++) {
                ap2Val = FuncionesSobreCaracteres.esCaracterAlfabetico(ap2.charAt(i));
            }
            if (!ap2Val) {
                javax.swing.JOptionPane.showMessageDialog(null, "Error el apellido contiene carácteres no válidos, purebe a cambiarlo");
            }else{
                ap2JTextField.setBackground(Color.green);
                ap2JTextField.setEditable(false);
            }
        }
    }//GEN-LAST:event_ap2JTextFieldActionPerformed

    private void dniJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dniJTextFieldActionPerformed

        String dni = dniJTextField.getText();
                
        try {
            if(dni.length()== 0){
                javax.swing.JOptionPane.showMessageDialog(null, "Error, el campo DNI está vacío");
            }else if (!FuncionesSobreCaracteres.esDNIValido(dni)) {
                javax.swing.JOptionPane.showMessageDialog(null, "Error, el DNI no es válido"
                        + " tiene que cuplir con el formato: xxxxxxxxA, compruebe que lo ha escrito correctamente");
            } else if (eBanco.buscaDNICliente(dni) == null) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Error, ese DNI no está"
                            + " dado de alta para ningun cliente, prube con otro DNI, o dar este"
                            + " de alta");
                }else{
                   eqwwqeqw 
                }
                
        } catch (SQLException ex) {
            Logger.getLogger(BancoConIgSerializado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_dniJTextFieldActionPerformed

    private void ap1JTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ap1JTextFieldActionPerformed

        String ap1 = ap1JTextField.getText();
        if (ap1.length()==0) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error el apel1ido debe tener una longitud superior a 0");
        }else{
            boolean ap1Val = false;
            for (int i = 0; i < ap1.length(); i++) {
                ap1Val = FuncionesSobreCaracteres.esCaracterAlfabetico(ap1.charAt(i));
            }
            if (!ap1Val) {
                javax.swing.JOptionPane.showMessageDialog(null, "Error el apellido contiene carácteres no válidos, purebe a cambiarlo");
            }else{
                ap1JTextField.setBackground(Color.green);
                ap1JTextField.setEditable(false);
            }
        }
    }//GEN-LAST:event_ap1JTextFieldActionPerformed

    private void direccionJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direccionJTextFieldActionPerformed

        String dir = direccionJTextField.getText();
        if (dir.length()==0) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error la dirección debe tener una longitud superior a 0");
        }else{
            direccionJTextField.setBackground(Color.green);
            direccionJTextField.setEditable(false);
        }

    }//GEN-LAST:event_direccionJTextFieldActionPerformed

    private void nombreJTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreJTextField2ActionPerformed
        // TODO add your handling code here:
        String nombre = nombreJTextField.getText();
        if (nombre.length()==0) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error el nombre debe tener una longitud superior a 0");
        }else{
            boolean nombreVal = false;
            for (int i = 0; i < nombre.length(); i++) {
                nombreVal = FuncionesSobreCaracteres.esCaracterAlfabetico(nombre.charAt(i));
            }
            if (!nombreVal) {
                javax.swing.JOptionPane.showMessageDialog(null, "Error el nombre contiene carácteres no válidos, purebe a cambiarlo");
            }else{
                nombreJTextField.setBackground(Color.green);
                nombreJTextField.setEditable(false);
            }
        }
    }//GEN-LAST:event_nombreJTextField2ActionPerformed

    private void emailJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailJTextFieldActionPerformed
        String email = emailJTextField.getText();
        if (email.length()==0) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error el email debe tener una longitud superior a 0");
        }else{
            boolean emailVal = false;

            try {
                emailVal = eBanco.esEmailValido(email);
            } catch (SQLException ex) {
                Logger.getLogger(AltaCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (!emailVal) {
                javax.swing.JOptionPane.showMessageDialog(null, "Error el email no tiene un formato válido, solo admite:\n"
                    + "\" . _ % + - \" y nada más que 1 @ ");
            }else{
                emailJTextField.setBackground(Color.green);
                emailJTextField.setEditable(false);
            }
        }
    }//GEN-LAST:event_emailJTextFieldActionPerformed

    private void bajaClientejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bajaClientejButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bajaClientejButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ModificarBorrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarBorrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarBorrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarBorrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModificarBorrarCliente dialog = new ModificarBorrarCliente(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField ap1JTextField;
    private javax.swing.JTextField ap2JTextField;
    private javax.swing.JButton bajaClientejButton;
    private javax.swing.JButton cancelarjButton;
    private javax.swing.JTextField direccionJTextField;
    private javax.swing.JTextField dniJTextField;
    private javax.swing.JTextField emailJTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton modificarjButton;
    private javax.swing.JTextField nombreJTextField;
    private javax.swing.JTextField nombreJTextField1;
    private javax.swing.JTextField nombreJTextField2;
    private javax.swing.JTextField telJTextField;
    private javax.swing.JLabel tituloJLabel8;
    // End of variables declaration//GEN-END:variables
}
