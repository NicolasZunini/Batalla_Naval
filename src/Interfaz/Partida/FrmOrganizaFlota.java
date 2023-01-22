package Interfaz.Partida;

import Logica.Exception.PosicionNoValida;
import Logica.Partida.Flota;
import Logica.Partida.Partida;
import Logica.Partida.Posicion;
import Logica.Usuario.Jugador;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;

/**
 * @author Nico
 */
public class FrmOrganizaFlota extends javax.swing.JFrame {
    
    Partida objP;
    Jugador objJ;
    ModeloTabla modeloTabla;
    int cantBarDeEtiqueta;
    
    public FrmOrganizaFlota() {
        initComponents();
    }
    
    public FrmOrganizaFlota(Partida objP, Jugador objJ){
        initComponents();
        this.objP = objP;
        this.objJ = objJ;
        tabla.setEnabled(false);
        cargarFlota(tabla, objJ);
        lblCantBarcos.setText(Integer.toString(objP.getObjF1().getCantBarcos()));
        btnJugar.setEnabled(false);
        this.setResizable(false);
    }
    
    public void cargarFlota(JTable xTable,Jugador objJ){
        Flota flotaProp;
        if(objP.getObjF1().getObjJ().equals(objJ)){
            flotaProp= objP.getObjF1();
        }else{
            flotaProp = objP.getObjF2();   
            this.setLocation(790, 0);
        }
        modeloTabla = new ModeloTabla(flotaProp);
        lblJugador.setText(objJ.getNombre());
        xTable.setRowHeight(25);
        xTable.getTableHeader().setReorderingAllowed(false);//no permite mover columnas
        xTable.setDefaultRenderer(Posicion.class, new CellRendererJugador(flotaProp));
        xTable.setDefaultEditor(Posicion.class,new CellEditor(xTable,flotaProp));
        xTable.setModel(modeloTabla);
        cargarLetras(xTable);
        anchoColumna(xTable);
        SpnColumnaInicial.setModel(new SpinnerNumberModel(1, 1, (int) Math.sqrt(objP.getObjF1().getTamaño()), 1));
        SpnFilaInicial.setModel(new SpinnerNumberModel (1,1,(int) Math.sqrt(objP.getObjF1().getTamaño()),1));
        cantBarDeEtiqueta = objP.getObjF1().getCantBarcos();
    }
    //carga las letras correspondientes a las filas del jTable.
    public void cargarLetras(JTable xTable){
        LetraFila letrasEnJtable= new LetraFila(xTable);
        jScrollPane.setRowHeaderView(letrasEnJtable);
    } 
     /*Modifica el ancho de las columnas del JTable pasado por 
     parématro, dejando las celdas cuadradas.*/
    public void anchoColumna(JTable xTable){
        for (int i = 0; i < xTable.getColumnCount(); i++) {
            xTable.getColumnModel().getColumn(i).setMinWidth(25);
            xTable.getColumnModel().getColumn(i).setMaxWidth(25);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnPosicionar = new javax.swing.JButton();
        SpnColumnaInicial = new javax.swing.JSpinner();
        SpnFilaInicial = new javax.swing.JSpinner();
        lblPosicionDelBarco = new javax.swing.JLabel();
        lblColInicial = new javax.swing.JLabel();
        lblFilaInicial = new javax.swing.JLabel();
        cboxSentido = new javax.swing.JComboBox();
        lblPosicion = new javax.swing.JLabel();
        btnJugar = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        lblJugador = new javax.swing.JLabel();
        lblCBarcos = new javax.swing.JLabel();
        lblCantBarcos = new javax.swing.JLabel();
        lblTituloJugador = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        BtnPosicionar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BtnPosicionar.setText("Posicionar Barco");
        BtnPosicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPosicionarActionPerformed(evt);
            }
        });

        SpnColumnaInicial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        SpnFilaInicial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        SpnFilaInicial.setDoubleBuffered(true);

        lblPosicionDelBarco.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblPosicionDelBarco.setText("Posición del Barco");

        lblColInicial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblColInicial.setText("Columna Inicial:");

        lblFilaInicial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFilaInicial.setText("Fila Inicial:");

        cboxSentido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cboxSentido.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Horizontal Derecha", "Horizontal Izquierda", "Vertical Abajo", "Vertical Arriba" }));

        lblPosicion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPosicion.setText("Posición:");

        btnJugar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnJugar.setText("Jugar");
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane.setViewportView(tabla);

        lblJugador.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N

        lblCBarcos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCBarcos.setText("Cantidad Barcos:");

        lblCantBarcos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lblTituloJugador.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblTituloJugador.setText("Jugador");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(lblColInicial)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SpnColumnaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(lblCBarcos)
                                .addGap(10, 10, 10)
                                .addComponent(lblCantBarcos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(lblFilaInicial)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SpnFilaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(lblPosicion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboxSentido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 27, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnJugar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnPosicionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPosicionDelBarco)
                                    .addComponent(lblJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(19, 19, 19))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblTituloJugador)
                                .addGap(90, 90, 90))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTituloJugador)
                        .addGap(10, 10, 10)
                        .addComponent(lblJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(lblPosicionDelBarco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SpnColumnaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblColInicial))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SpnFilaInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblFilaInicial))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboxSentido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPosicion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCantBarcos, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCBarcos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnPosicionar)
                        .addGap(5, 5, 5)
                        .addComponent(btnJugar))
                    .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Al accionar muestra el barco ubicado en el modelo de tabla. 
    private void BtnPosicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPosicionarActionPerformed
        if (Integer.parseInt(lblCantBarcos.getText()) > 0){
            try {
                Flota.Sentido sentido;
                if (cboxSentido.getSelectedIndex() == 0){
                    sentido = Flota.Sentido.HORIZ_DER;
                }
                else if (cboxSentido.getSelectedIndex() == 1){
                    sentido = Flota.Sentido.HORIZ_IZQ;
                }
                else if (cboxSentido.getSelectedIndex() == 2){
                    sentido = Flota.Sentido.VERT_ABA;
                }
                else{
                    sentido = Flota.Sentido.VERT_ARR;
                }
                if(objP.getObjF1().getObjJ().equals(objJ)){
                    objP.getObjF1().agregarBarco(Integer.parseInt(SpnFilaInicial.getValue().toString()), Integer.parseInt(SpnColumnaInicial.getValue().toString()), sentido);              
                }else{
                    objP.getObjF2().agregarBarco(Integer.parseInt(SpnFilaInicial.getValue().toString()), Integer.parseInt(SpnColumnaInicial.getValue().toString()), sentido);              
                }
                cantBarDeEtiqueta--;
                modeloTabla.fireTableDataChanged();
                lblCantBarcos.setText(Integer.toString(cantBarDeEtiqueta));
            } catch (PosicionNoValida ex) {
                JOptionPane.showMessageDialog(null,"No se puede agregar el barco, posición incorrecta");
            }
            
            if (Integer.parseInt(lblCantBarcos.getText()) == 0){
                btnJugar.setEnabled(true);
                BtnPosicionar.setEnabled(false);
            }
        }
        
    }//GEN-LAST:event_BtnPosicionarActionPerformed

    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed
        FrmTableroDeJuego frm = new FrmTableroDeJuego(objP, objJ);
        frm.setTitle("PARTIDA: "+objP.getNumero()+", JUGADOR: "+objJ.getNombre());
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnJugarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmOrganizaFlota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmOrganizaFlota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmOrganizaFlota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmOrganizaFlota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new FrmOrganizaFlota().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnPosicionar;
    private javax.swing.JSpinner SpnColumnaInicial;
    private javax.swing.JSpinner SpnFilaInicial;
    private javax.swing.JButton btnJugar;
    private javax.swing.JComboBox cboxSentido;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel lblCBarcos;
    private javax.swing.JLabel lblCantBarcos;
    private javax.swing.JLabel lblColInicial;
    private javax.swing.JLabel lblFilaInicial;
    private javax.swing.JLabel lblJugador;
    private javax.swing.JLabel lblPosicion;
    private javax.swing.JLabel lblPosicionDelBarco;
    private javax.swing.JLabel lblTituloJugador;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}