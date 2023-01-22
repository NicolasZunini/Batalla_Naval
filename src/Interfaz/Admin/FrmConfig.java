package Interfaz.Admin;

import Logica.Fachada.ServicioAdmin;
import Logica.Partida.GestoraConfigJuego;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 * @author Nico
 */
public class FrmConfig extends javax.swing.JFrame {

    GestoraConfigJuego objCJ = ServicioAdmin.getInstance().devolverConfiguracion();
    
    private int tamTablero = objCJ.getTamFlota();
    private int tamBarco = objCJ.getTamBarco();
    private int cantBarcos = objCJ.getCantBarcos();
    
    public FrmConfig() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getRootPane().setDefaultButton(btnGuardar);
        this.setTitle("Configuracion de Parametros.");
        cboxTamBarco.setEnabled(false);
        cboxCantBarco.setEnabled(false);
    }
    
    /* Aumenta en uno los item a ser mostrados en el combobox que llame a este
     método, comenzando por el String "1" */
    public void aumentarItem (JComboBox xCombo, int item){
        if (xCombo == cboxCantBarco){
            if (item > 5){
                item = 5;
            }
        }
        for (int i = 1; i <= item; i++){
            xCombo.addItem((String) (""+i+"")); 
        }
    }

    /*Calcula la cantidad máxima de posiciones a ser ocupadas por barcos según
    el tamaño del tablero, por defecto es 4/9 de total de posiciones*/
    public float tamMaxParaOcupar (int tamTablero){
        return tamTablero * 4/9;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        LblCantBarco = new javax.swing.JLabel();
        LblTamBarco = new javax.swing.JLabel();
        cboxTamTablero = new javax.swing.JComboBox();
        LblTitulo = new javax.swing.JLabel();
        LblLargoTablero = new javax.swing.JLabel();
        lblImagen = new javax.swing.JLabel();
        cboxTamBarco = new javax.swing.JComboBox();
        cboxCantBarco = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnGuardar.setText("Guardar Configuración");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        LblCantBarco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LblCantBarco.setText("Cantidad de Barcos:");

        LblTamBarco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LblTamBarco.setText("Tamaño de los Barcos:");

        cboxTamTablero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboxTamTablero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "3x3", "4x4", "5x5", "6x6", "7x7", "8x8", "9x9", "10x10" }));
        cboxTamTablero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxTamTableroActionPerformed(evt);
            }
        });

        LblTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LblTitulo.setText("CONFIGURACION DE LA PARTIDA");

        LblLargoTablero.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        LblLargoTablero.setText("Tamaño del tablero:");

        lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/Partida/BatallaNaval.jpg"))); // NOI18N

        cboxTamBarco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboxTamBarco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxTamBarcoActionPerformed(evt);
            }
        });

        cboxCantBarco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboxCantBarco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboxCantBarcoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LblTitulo)
                                .addGroup(jPanelLayout.createSequentialGroup()
                                    .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(LblLargoTablero, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(LblTamBarco, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(LblCantBarco, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cboxTamTablero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cboxTamBarco, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cboxCantBarco, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(82, 82, 82))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addComponent(lblImagen)
                        .addGap(43, 43, 43))))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblImagen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LblTitulo)
                .addGap(18, 18, 18)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblLargoTablero)
                    .addComponent(cboxTamTablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblTamBarco)
                    .addComponent(cboxTamBarco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LblCantBarco)
                    .addComponent(cboxCantBarco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (cboxTamBarco.getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Debe seleccionar el tamaño de Barcos.");
        }else if (cboxCantBarco.getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Debe seleccionar la cantidad de Barcos.");
        }else{
            FrmAdmin frm = new FrmAdmin();
            frm.setVisible(true);
            this.dispose();
            objCJ.setTamFlota(tamTablero);
            objCJ.setTamBarco(tamBarco);
            objCJ.setCantBarcos(cantBarcos);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        
    }//GEN-LAST:event_formMouseClicked

    private void cboxTamTableroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxTamTableroActionPerformed
        cboxTamBarco.setEnabled(true);
        cboxTamBarco.removeAllItems();
        switch (cboxTamTablero.getSelectedIndex()){
            case 0: 
                tamTablero = 9;
                aumentarItem(cboxTamBarco, 2);          
                break;
            case 1: 
                tamTablero = 16;
                aumentarItem(cboxTamBarco, 3);
                break;
            case 2: 
                tamTablero = 25;
                aumentarItem(cboxTamBarco, 4);
                break;
            case 3:
                tamTablero = 36;
                aumentarItem(cboxTamBarco, 5);
                break;
            case 4: 
                tamTablero = 49;
                aumentarItem(cboxTamBarco, 6); 
               // int num = (int) tamMaxParaOcupar(tamTablero);               
                break;
            case 5: 
                tamTablero = 64;
                aumentarItem(cboxTamBarco, 6);
                break;
            case 6:
                tamTablero = 81;
                aumentarItem(cboxTamBarco, 6);
                break;
            case 7: 
                tamTablero = 100;
                aumentarItem(cboxTamBarco, 6);
                break;
        }    
    }//GEN-LAST:event_cboxTamTableroActionPerformed

    private void cboxTamBarcoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxTamBarcoActionPerformed
        cboxCantBarco.removeAllItems();
        cantBarcos = (int)(tamMaxParaOcupar(tamTablero));
        switch (cboxTamBarco.getSelectedIndex()){
            case 0: 
                tamBarco = 1;        
                break;
            case 1: 
                tamBarco = 2;
                cantBarcos= cantBarcos/2;
                break;
            case 2:
                tamBarco = 3;
                cantBarcos= cantBarcos/3;
                break;
            case 3: 
                tamBarco = 4;
                cantBarcos= cantBarcos/4;
                break;
            case 4: 
                tamBarco = 5;
                cantBarcos= cantBarcos/5;
                break;
            case 5: 
                tamBarco = 6;
                cantBarcos= cantBarcos/6;
                break;
        }
        aumentarItem(cboxCantBarco,cantBarcos);       
        cboxCantBarco.setEnabled(true);
    }//GEN-LAST:event_cboxTamBarcoActionPerformed

    private void cboxCantBarcoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboxCantBarcoActionPerformed
                switch (cboxCantBarco.getSelectedIndex()){
            case 0: 
                cantBarcos = 1;        
                break;
            case 1: 
                cantBarcos = 2;
                break;
            case 2:
                cantBarcos = 3;
                break;
            case 3: 
                cantBarcos = 4;
                break;
            case 4: 
                cantBarcos = 5;
                break;
        }

    }//GEN-LAST:event_cboxCantBarcoActionPerformed

    public static void main(String args[]){
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
            java.util.logging.Logger.getLogger(FrmConfig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmConfig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmConfig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmConfig.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new FrmConfig().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LblCantBarco;
    private javax.swing.JLabel LblLargoTablero;
    private javax.swing.JLabel LblTamBarco;
    private javax.swing.JLabel LblTitulo;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cboxCantBarco;
    private javax.swing.JComboBox cboxTamBarco;
    private javax.swing.JComboBox cboxTamTablero;
    private javax.swing.JPanel jPanel;
    private javax.swing.JLabel lblImagen;
    // End of variables declaration//GEN-END:variables
}