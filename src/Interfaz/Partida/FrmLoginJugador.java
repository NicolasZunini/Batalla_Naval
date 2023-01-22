package Interfaz.Partida;

import Logica.Fachada.ServicioJugador;
import Interfaz.Partida.FrmOrganizaFlota;
import Logica.Exception.JugadorLogin;
import Logica.Exception.UsuarioException;
import Logica.Partida.Partida;
import Logica.Usuario.Jugador;
import Logica.Usuario.Usuario;
import javax.swing.JOptionPane;

/**
 * @author Nico
 */
public class FrmLoginJugador extends javax.swing.JFrame {
    
    Partida objP;
    
    public FrmLoginJugador() {
        initComponents();
    }
    
    public FrmLoginJugador(Partida objP) {
        initComponents();
        this.objP = objP;
        this.getRootPane().setDefaultButton(btnAceptar);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombre = new javax.swing.JTextField();
        lblLoginJugador = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        btnAceptar = new javax.swing.JButton();
        lblPass = new javax.swing.JLabel();
        lblNombreJugador = new javax.swing.JLabel();
        lblImagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lblLoginJugador.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblLoginJugador.setText("Login del Jugador");
        lblLoginJugador.setToolTipText("");

        txtPass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        btnAceptar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAceptar.setText("ACEPTAR");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        lblPass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPass.setText("Contraseña");
        lblPass.setToolTipText("");

        lblNombreJugador.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblNombreJugador.setText("Nombre");
        lblNombreJugador.setToolTipText("");

        lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Partida/loginImagen.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 22, Short.MAX_VALUE)
                        .addComponent(lblImagen)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblNombreJugador)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblLoginJugador)
                                        .addGap(62, 62, 62))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPass)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(btnAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(lblLoginJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombreJugador))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPass)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblImagen)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAceptar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (txtNombre.getText().isEmpty() || txtPass.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Faltan completar los datos para ingresar.", "CAMPOS VACIOS.", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            try {
                Jugador objJ = ServicioJugador.getInstance().loginJugador(txtNombre.getText(), txtPass.getText());
                try {
                    objP.asignarJugadorATablero(objJ);
                    JOptionPane.showMessageDialog(null, "Bienvenido, Jugador: "+objJ.getNombre(), "LOGIN CORRECTO.", JOptionPane.INFORMATION_MESSAGE);
                    this.setVisible(false);
                    this.setLocation(0, 0);
                    FrmOrganizaFlota frm = new FrmOrganizaFlota(objP,(Jugador)objJ);
                    frm.setVisible(true);
                    frm.setTitle(objJ.getNombre());
                } catch (JugadorLogin ex) {
                    JOptionPane.showMessageDialog(null, "Usted ya se logueo a la partida.","LOGIN INCORRECTO", JOptionPane.OK_OPTION);
                }
            } catch (UsuarioException ex) {
                JOptionPane.showMessageDialog(null, "Datos incorrectos.","DATOS ERRONEOS.", JOptionPane.OK_OPTION);
            }
        txtNombre.setText("");
        txtPass.setText("");
        txtNombre.requestFocus();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmLoginJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLoginJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLoginJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLoginJugador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new FrmLoginJugador().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblLoginJugador;
    private javax.swing.JLabel lblNombreJugador;
    private javax.swing.JLabel lblPass;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPass;
    // End of variables declaration//GEN-END:variables
}