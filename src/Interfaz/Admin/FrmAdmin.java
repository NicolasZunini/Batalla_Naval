package Interfaz.Admin;

import Interfaz.Partida.FrmLoginJugador;
import Logica.Partida.GestoraPartida;
import Logica.Partida.Partida;

/**
 * @author Nico
 */
public class FrmAdmin extends javax.swing.JFrame {

    public FrmAdmin() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setTitle("Opciones de Partida.");
    }
    
   @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        lblImagen = new javax.swing.JLabel();
        BtnParametros = new javax.swing.JButton();
        BtnIniciarPrueba = new javax.swing.JButton();
        BtnAtras = new javax.swing.JButton();
        BtnDatosPartida = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Partida/BatallaNaval.jpg"))); // NOI18N

        BtnParametros.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnParametros.setText("CONFIGURACION DE PARAMETROS");
        BtnParametros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnParametrosActionPerformed(evt);
            }
        });

        BtnIniciarPrueba.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnIniciarPrueba.setText("INICIAR PRUEBA");
        BtnIniciarPrueba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnIniciarPruebaActionPerformed(evt);
            }
        });

        BtnAtras.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BtnAtras.setText("Atrás");
        BtnAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAtrasActionPerformed(evt);
            }
        });

        BtnDatosPartida.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnDatosPartida.setText("DATOS DE PARTIDAS");
        BtnDatosPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDatosPartidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(lblImagen)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnParametros, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnDatosPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(BtnAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnIniciarPrueba, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImagen)
                .addGap(35, 35, 35)
                .addComponent(BtnParametros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnDatosPartida)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnIniciarPrueba)
                .addGap(18, 18, 18)
                .addComponent(BtnAtras)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void BtnAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAtrasActionPerformed
        FrmLoginAdmin frm = FrmLoginAdmin.getInstance();
        this.dispose();
        frm.setVisible(true);
    }//GEN-LAST:event_BtnAtrasActionPerformed

    private void BtnParametrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnParametrosActionPerformed
        FrmConfig frm = new FrmConfig();
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_BtnParametrosActionPerformed

    private void BtnIniciarPruebaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnIniciarPruebaActionPerformed
        Partida objP = GestoraPartida.getInstance().agregaPartida();
        this.setLocation(460, 440);
        this.setState(1);
        FrmLoginJugador frmOpo = new FrmLoginJugador(objP);
        frmOpo.setLocation(900, 0);
        frmOpo.setVisible(true);
        frmOpo.setTitle("Jugador 2");
        FrmLoginJugador frmJug = new FrmLoginJugador(objP);
        frmJug.setVisible(true);
        frmJug.setTitle("Jugador 1");
    }//GEN-LAST:event_BtnIniciarPruebaActionPerformed

    private void BtnDatosPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDatosPartidaActionPerformed
        this.dispose();
        FrmDatosPartida frm = new FrmDatosPartida();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_BtnDatosPartidaActionPerformed

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
            java.util.logging.Logger.getLogger(FrmAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new FrmAdmin().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAtras;
    private javax.swing.JButton BtnDatosPartida;
    private javax.swing.JButton BtnIniciarPrueba;
    private javax.swing.JButton BtnParametros;
    private javax.swing.JPanel jPanel;
    private javax.swing.JLabel lblImagen;
    // End of variables declaration//GEN-END:variables
}