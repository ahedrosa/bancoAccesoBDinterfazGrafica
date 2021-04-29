/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ebankaccesobd;

import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author LilCucumbah
 */
public class AltaCliente extends javax.swing.JDialog {

    private Cliente cliente = null;
    private Banco eBanco = null;
    
    public AltaCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public AltaCliente(java.awt.Frame parent, Banco banco ,boolean modal) {
        super(parent, modal);
        initComponents();
        
        this.setLocationRelativeTo(null);
        this.eBanco = banco;
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        ap1JTextField = new javax.swing.JTextField();
        direccionJTextField = new javax.swing.JTextField();
        nombreJTextField = new javax.swing.JTextField();
        emailJTextField = new javax.swing.JTextField();
        telJTextField = new javax.swing.JTextField();
        ap2JTextField = new javax.swing.JTextField();
        dniJTextField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        letraJLabel11 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("DNI");

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido 1");

        jLabel4.setText("Apellido 2");

        jLabel5.setText("Direccion");

        jLabel6.setText("Telefono");

        jLabel7.setText("e-mail");

        ap1JTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ap1JTextFieldActionPerformed(evt);
            }
        });

        direccionJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direccionJTextFieldActionPerformed(evt);
            }
        });

        nombreJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreJTextFieldActionPerformed(evt);
            }
        });

        emailJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailJTextFieldActionPerformed(evt);
            }
        });

        telJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telJTextFieldActionPerformed(evt);
            }
        });

        ap2JTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ap2JTextFieldActionPerformed(evt);
            }
        });

        dniJTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        dniJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dniJTextFieldActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Eras Bold ITC", 1, 24)); // NOI18N
        jLabel8.setText("Nuevo Cliente");

        letraJLabel11.setText(" ");

        jLabel11.setText("Para facilitar la faena introduciremos 8 numeros en dni y la letra se asignará automáticamente");

        jButton1.setText("Aceptar Alta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Borrar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
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
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(direccionJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(ap2JTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(ap1JTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(telJTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(nombreJTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(dniJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(letraJLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel10))
                                            .addComponent(emailJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel8)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel11)))
                .addGap(0, 27, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(dniJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(letraJLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nombreJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dniJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dniJTextFieldActionPerformed
        
        String dni = dniJTextField.getText();
        
            if(dni.length()== 0){
                javax.swing.JOptionPane.showMessageDialog(null, "Error, el campo DNI está vacío");
            }else if (!FuncionesSobreCaracteres.esDNIValido(dni)) {
                javax.swing.JOptionPane.showMessageDialog(null, "Error, el DNI no es válido"
                        + " tiene que cuplir con el formato: xxxxxxxxA, compruebe que lo ha escrito correctamente");
            } else try {
                if (eBanco.buscaDNICliente(dni) != null) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Error, ese DNI ya está"
                            + " dado de alta para un cliente");
                }else{
                    dniJTextField.setBackground(Color.green);
                    dniJTextField.setEditable(false);
                    
                    cliente = eBanco.recuperaCliente(dni);
                    nombreJTextField.setText(cliente.getNombre());
                    ap1JTextField.setText(cliente.getAp1());
                    ap2JTextField.setText(cliente.getAp2());
                    direccionJTextField.setText(cliente.getDireccion());
                    telJTextField.setText(cliente.getTelefono());
                    emailJTextField.setText(cliente.getEmail());
                    
                    
                }
        } catch (SQLException ex) {
            Logger.getLogger(ModificarBorrarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }//GEN-LAST:event_dniJTextFieldActionPerformed

    private void nombreJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreJTextFieldActionPerformed
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
    }//GEN-LAST:event_nombreJTextFieldActionPerformed

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

    private void direccionJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_direccionJTextFieldActionPerformed
        
        String dir = direccionJTextField.getText();
        if (dir.length()==0) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error la dirección debe tener una longitud superior a 0");
        }else{
                direccionJTextField.setBackground(Color.green);
                direccionJTextField.setEditable(false);
            }
        
    }//GEN-LAST:event_direccionJTextFieldActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        dispose();
    }//GEN-LAST:event_formWindowClosing

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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if (dniJTextField.getBackground() != Color.GREEN || 
                nombreJTextField.getBackground() != Color.GREEN ||
                ap1JTextField.getBackground() != Color.GREEN ||
                ap2JTextField.getBackground() != Color.GREEN ||
                direccionJTextField.getBackground() != Color.GREEN ||
                emailJTextField.getBackground() != Color.GREEN) {
            
            javax.swing.JOptionPane.showMessageDialog(null, "Error, no se han validado todos los campos"
                    + " ha de pulsar enter en cada uno de ellos");
            
        }else{        
            String dni =dniJTextField.getText()+letraJLabel11.getText();

            cliente = new Cliente(dni, 
                    nombreJTextField.getText(), 
                    ap1JTextField.getText(),
                    ap2JTextField.getText(),
                    direccionJTextField.getText(),
                    telJTextField.getText(),
                    emailJTextField.getText());
            
            try {
                eBanco.altaCliente(cliente);
            } catch (SQLException ex) {
                Logger.getLogger(AltaCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            javax.swing.JOptionPane.showMessageDialog(null,"Ha dado de alta al cliente "+cliente.getNombre() +" satisfactoriamente");
            
            dispose();
        }
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        dniJTextField.setText("");
        dniJTextField.setBackground(Color.white);
        dniJTextField.setEditable(true);
        
        nombreJTextField.setText("");
        nombreJTextField.setBackground(Color.white);
        nombreJTextField.setEditable(true);
        
        ap1JTextField.setText("");
        ap1JTextField.setBackground(Color.white);
        ap1JTextField.setEditable(true);
        
        ap2JTextField.setText("");
        ap2JTextField.setBackground(Color.white);
        ap2JTextField.setEditable(true);
        
        telJTextField.setText("");
        telJTextField.setBackground(Color.white);
        telJTextField.setEditable(true);
        
        direccionJTextField.setText("");
        direccionJTextField.setBackground(Color.white);
        direccionJTextField.setEditable(true);
        
        emailJTextField.setText("");
        emailJTextField.setBackground(Color.white);
        emailJTextField.setEditable(true);
        
        letraJLabel11.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(AltaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AltaCliente dialog = new AltaCliente(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField direccionJTextField;
    private javax.swing.JTextField dniJTextField;
    private javax.swing.JTextField emailJTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel letraJLabel11;
    private javax.swing.JTextField nombreJTextField;
    private javax.swing.JTextField telJTextField;
    // End of variables declaration//GEN-END:variables
}
