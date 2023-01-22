package Interfaz.Admin;

import Logica.Fachada.ServicioAdmin;
import Logica.Exception.UsuarioException;
import Logica.Usuario.Usuario;
import javax.swing.JOptionPane;

/**
 * @author Nico
 */
public class FrmLoginAdmin extends javax.swing.JFrame {
    
    private static FrmLoginAdmin objV = null;
    
    private FrmLoginAdmin() {
        initComponents();
        this.setResizable(false);
        this.setBounds(0,0,800,420);
        this.setLocationRelativeTo(null);
        this.getRootPane().setDefaultButton(btnAceptar);//Hago que por defecto al presionar enter se active el ActionPerformed del boton Aceptar.
        this.setTitle("OBLIGATORIO DDA - Batalla Naval");
    }
    
    public static FrmLoginAdmin getInstance(){
        if (objV == null){
            objV = new FrmLoginAdmin();
        }
        return objV;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAceptar = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();
        lblLoginAdmin = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        txtNombre = new javax.swing.JTextField();
        lblImagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btnAceptar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAceptar.setText("ACEPTAR");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAceptar);
        btnAceptar.setBounds(520, 360, 250, 25);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblTitulo.setText("BATALLA NAVAL");
        getContentPane().add(lblTitulo);
        lblTitulo.setBounds(410, 30, 310, 50);

        lblLoginAdmin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblLoginAdmin.setText("LOGIN ADMINISTRADOR");
        getContentPane().add(lblLoginAdmin);
        lblLoginAdmin.setBounds(560, 260, 190, 20);

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblUsuario.setText("Usuario:");
        getContentPane().add(lblUsuario);
        lblUsuario.setBounds(540, 290, 60, 17);

        lblPass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPass.setText("Contraseña:");
        getContentPane().add(lblPass);
        lblPass.setBounds(510, 320, 90, 17);

        txtPass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txtPass);
        txtPass.setBounds(600, 320, 170, 23);

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtNombre);
        txtNombre.setBounds(600, 290, 170, 23);

        lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Partida/Inicio.jpg"))); // NOI18N
        getContentPane().add(lblImagen);
        lblImagen.setBounds(0, 0, 800, 400);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (txtNombre.getText().isEmpty() || txtPass.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Faltan completar los datos para ingresar.", "CAMPOS VACIOS.", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            try {
               Usuario objU = ServicioAdmin.getInstance().loginAdmin(txtNombre.getText(), txtPass.getText());
               JOptionPane.showMessageDialog(null, "Bienvenido, Administrador: "+objU.getNombre(), "LOGIN CORRECTO.", JOptionPane.INFORMATION_MESSAGE);
               this.setVisible(false);
               FrmAdmin frm = new FrmAdmin();
               frm.setVisible(true);
            } catch (UsuarioException ex) {
                JOptionPane.showMessageDialog(null, "El administrador no existe,\n   o hay datos incorrectos.","DATOS ERRONEOS.", JOptionPane.OK_OPTION);
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
            java.util.logging.Logger.getLogger(FrmLoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new FrmLoginAdmin().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblLoginAdmin;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPass;
    // End of variables declaration//GEN-END:variables
}
