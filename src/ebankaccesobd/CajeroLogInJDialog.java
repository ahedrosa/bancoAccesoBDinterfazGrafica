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
import javax.swing.JFrame;

/**
 *
 * @author Alex'sCucumbah
 */
public class CajeroLogInJDialog extends javax.swing.JDialog {

    private Banco eBanco;
    private TarjetaCredito tarjetaEmisora;
    private TarjetaCredito tarjetaReceptora;
    private boolean tipo; //Si es un log in del cajero TRUE || Si es una tarjeta para transferir FALSE
    
    public CajeroLogInJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public CajeroLogInJDialog(java.awt.Frame parent, String title, Banco banco) {
        
        super(parent, title);
        eBanco = banco;
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        if (title.compareTo("Log In Cajero") == 0) {
            tipo=true;
        }else{
            tipo=false;
        }    
        
    }
    public CajeroLogInJDialog(java.awt.Frame parent, String title, Banco banco, TarjetaCredito tar) {
        
        super(parent, title);
        eBanco = banco;
        initComponents();
        
        if (title.compareTo("Log In Cajero") == 0) {
            tipo=true;
        }else{
            tipo=false;
            tarjetaEmisora = tar;
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
        jTextFieldNumTarjeta = new javax.swing.JTextField();
        jButtonAcceder = new javax.swing.JButton();
        jButtonBorrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("N??mero de cuenta");

        jTextFieldNumTarjeta.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jTextFieldNumTarjeta.setText("Introduzca el n??mero de tarjeta");
        jTextFieldNumTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNumTarjetaActionPerformed(evt);
            }
        });
        jTextFieldNumTarjeta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldNumTarjetaKeyPressed(evt);
            }
        });

        jButtonAcceder.setText("Acceder");
        jButtonAcceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAccederActionPerformed(evt);
            }
        });

        jButtonBorrar.setText("Borrar");
        jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel1)
                        .addGap(27, 27, 27)
                        .addComponent(jTextFieldNumTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jButtonAcceder, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNumTarjeta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAcceder)
                    .addComponent(jButtonBorrar))
                .addGap(66, 66, 66))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNumTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumTarjetaActionPerformed
        TarjetaCredito tarjeta = null;
        try {
            tarjeta = eBanco.devuelveTarjeta(jTextFieldNumTarjeta.getText());
        } catch (SQLException ex) {
            Logger.getLogger(CajeroLogInJDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(!TarjetaCredito.esNumTarjetaValido(jTextFieldNumTarjeta.getText())){
           javax.swing.JOptionPane.showMessageDialog(this,"Error el N??mero de la"
                   + " tarjeta esta compuesto unicamente por 16 d??gitos num??ricos");
           
        }else if(tarjeta == null){
                    javax.swing.JOptionPane.showMessageDialog(this,"Error este"
                            + " n??mero de tarjeta no existe");
                }else if (tarjeta.isBloqueada()){
                    javax.swing.JOptionPane.showMessageDialog(this,"Error esta tarjeta"
                            + " est?? bloqueada. Por favor contacte con nuestro banco TLF: 123-132-123");
                    
                }else{

                    if(!tipo){
                        
                        if(tarjeta.getNumTarjeta().compareTo(tarjetaEmisora.getNumTarjeta()) == 0){
                            javax.swing.JOptionPane.showMessageDialog(this, "Error, no puede "
                                    + "realizar una transferencia a la tarjeta emisora");
                        }else{                            
                                jTextFieldNumTarjeta.setBackground(Color.green);
                                jTextFieldNumTarjeta.setEditable(false);
                                tarjetaReceptora = tarjeta;
                            }          

                    }else{
                        
                        jTextFieldNumTarjeta.setBackground(Color.green);
                        jTextFieldNumTarjeta.setEditable(false);
                        tarjetaEmisora = tarjeta;                        
                    }
                

        }
    }//GEN-LAST:event_jTextFieldNumTarjetaActionPerformed

    private void jButtonAccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAccederActionPerformed
        TarjetaCredito tarjeta = null;
        
        try {            
            tarjeta = eBanco.devuelveTarjeta(jTextFieldNumTarjeta.getText());
        } catch (SQLException ex) {
            System.out.println("Error al recuperar tarjeta");
        }
        
        if (tarjeta.isBloqueada()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error, esa tarjeta est?? bloqueada, p??ngase en contacto con su banco");
            super.dispose();
        }else if(tipo){
            JFrame frame = new JFrame();        
            dispose();
            ContadorPINJDialog contador = new ContadorPINJDialog(frame, true, eBanco, tarjetaEmisora);
            contador.setVisible(true);            
        }else{
            double cantidad = 0.0;
            int error = 0;
        
            try{
               cantidad = Double.parseDouble(javax.swing.JOptionPane.showInputDialog("Introduzca la cantidad de dinero que quiere transferir")); 
               error = tarjetaEmisora.transferencia(cantidad,tarjetaReceptora);
            }catch(NumberFormatException e){
                javax.swing.JOptionPane.showMessageDialog(this,"Error, la cantidad a retirar ha de ser un n??mero decimal, separado por un punto (.)");             
            }
            
            switch (error){
            case 0: 
                break;
            case 1:
                javax.swing.JOptionPane.showMessageDialog(this, "Error, la cantidad introducida ha de ser positiva");
                break;
            case 2:
                javax.swing.JOptionPane.showMessageDialog(this, "Error, la cantidad introducida no puede exceder el saldo de la Tarjeta: " + tarjetaEmisora.getSaldo() + "???");
                break;
            case 3:
                javax.swing.JOptionPane.showMessageDialog(this, "Error, la cantidad introducida no puede exceder los " + Banco.LIMITE_REINTEGRO + " ???.");
                break;
            case 4:
                javax.swing.JOptionPane.showMessageDialog(this, "Transferencia realizada con ??xito. Nuevo saldo de la cta final:" + tarjetaReceptora.formateaNumeroTarjeta()
                                                            + " : " + tarjetaReceptora.getSaldo()+"???");
                javax.swing.JOptionPane.showMessageDialog(this, "Nuevo saldo de la cta incial: " + tarjetaEmisora.formateaNumeroTarjeta() 
                                                            + " : " +tarjetaEmisora.getSaldo()+"???");
            {
                try {
                    eBanco.modificacionTarjeta(tarjetaEmisora.getNumTarjeta(), String.valueOf(tarjetaEmisora.getSaldo()), tarjetaEmisora.getPin(), tarjetaEmisora.isBloqueada(), tarjetaEmisora.getDniTitular());
                    eBanco.modificacionTarjeta(tarjetaReceptora.getNumTarjeta(), String.valueOf(tarjetaReceptora.getSaldo()), tarjetaReceptora.getPin(), tarjetaReceptora.isBloqueada(), tarjetaReceptora.getDniTitular());
                } catch (SQLException ex) {
                    Logger.getLogger(CajeroLogInJDialog.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                dispose();
                break;
            }
        }
        
    }//GEN-LAST:event_jButtonAccederActionPerformed

    private void jTextFieldNumTarjetaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldNumTarjetaKeyPressed
        
        if (this.jTextFieldNumTarjeta.getText().compareTo("Introduzca el n??mero de tarjeta") == 0){
            this.jTextFieldNumTarjeta.setText("");
            jTextFieldNumTarjeta.setBackground(Color.red);
            jTextFieldNumTarjeta.setFont(new java.awt.Font("Tahoma", 0, 12));
        }
    }//GEN-LAST:event_jTextFieldNumTarjetaKeyPressed

    private void jButtonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarActionPerformed
        
        jTextFieldNumTarjeta.setFont(new java.awt.Font("Tahoma", 2, 12)); 
        jTextFieldNumTarjeta.setText("Introduzca el n??mero de su tarjeta");
        jTextFieldNumTarjeta.setBackground(Color.white);
        jTextFieldNumTarjeta.setEditable(true);
    }//GEN-LAST:event_jButtonBorrarActionPerformed

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
            java.util.logging.Logger.getLogger(CajeroLogInJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CajeroLogInJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CajeroLogInJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CajeroLogInJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CajeroLogInJDialog dialog = new CajeroLogInJDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButtonAcceder;
    private javax.swing.JButton jButtonBorrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField jTextFieldNumTarjeta;
    // End of variables declaration//GEN-END:variables
}
