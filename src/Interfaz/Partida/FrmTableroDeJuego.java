package Interfaz.Partida;

import Logica.Partida.Barco;
import Logica.Partida.Flota;
import Logica.Partida.Partida;
import Logica.Partida.Posicion;
import Logica.Usuario.Jugador;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 * @author Nico
 */

public class FrmTableroDeJuego extends javax.swing.JFrame implements Observer{
    
    private Partida objP;
    private Jugador objJ;
    private ModeloTabla modeloProp;
    private ModeloTabla modeloOpo;
    private DefaultListModel dlm;
    
    public FrmTableroDeJuego() {
        initComponents();
    }
    
    /*El formulario es inicializado con los datos de una partida y un usuario Jugador
     permitiendo así diferenciar las intancias del mismo que se encuentren abiertas, 
     pudiendo asociarlo con una Partida x y un Jugador x*/
    public FrmTableroDeJuego(Partida objP, Jugador objJ) {
        initComponents();
        this.objP= objP;
        this.objJ= objJ;
        cargarTablero();
        this.setResizable(false);
        TablaJugador.setEnabled(false);
        btnMejorar.setEnabled(false); 
    }
    
    /*cargarTablero carga los modelos de las flotas de la partida obtenida por
     constructor, asociando al primer jugador usuario que se loguea con una
     Flota, y al siguiente Jugador logueado con la otra Flota de la Partida.
     Por defecto habilita al último Jugador logueado a comenzar el Juego, o en
     tal caso, le avisa que el primer Jugador logueado ya se retiró del Juego.*/
    public void cargarTablero(){
        Flota flotaProp;
        Flota flotaOpo;
        if(objP.getObjF1().getObjJ() != null && objP.getObjF1().getObjJ().equals(objJ)){
            flotaProp= objP.getObjF1();
            flotaOpo = objP.getObjF2();
            lblJugador1.setText(objP.getObjF1().getObjJ().getNombre());
            lblOponente.setText("Esperando Oponente...");
            lblInformante.setText("JUEGO EN ESPERA...");
            lblInformante.setForeground(Color.red);    
            TablaOponente.setEnabled(false);
            lblInformante2.setText("TIPOS DE BARCO DE TU FLOTA Y SU UBICACIÓN:");
            lblInformante2.setForeground(Color.blue);
            dlm = new DefaultListModel();
            listarBarcos(objP.getObjF1());
            }
        else{
            flotaProp= objP.getObjF2();
            flotaOpo = objP.getObjF1();
            if (flotaOpo.isRetirada()){
                lblJugador1.setText(objP.getObjF2().getObjJ().getNombre());
                lblOponente.setText(objP.getObjF1().getObjJ().getNombre());
                lblInformante.setText(objP.getObjF1().getObjJ().getNombre() + " se ha retirado.");
                JOptionPane.showMessageDialog(null, "Jugador " + objP.getObjF1().getObjJ().getNombre() + " se ha retirado de este Juego." , "PARTIDA ABANDONADA", JOptionPane.OK_OPTION);
                lblInformante.setForeground(Color.blue);
                this.setLocation(740, 0);
                dlm = new DefaultListModel();
                listarBarcos(objP.getObjF2());
                TablaOponente.setEnabled(false);
                btnAbandonar.setText("Salir");
            }else{
                lblJugador1.setText(objP.getObjF2().getObjJ().getNombre());
                lblOponente.setText(objP.getObjF1().getObjJ().getNombre());
                lblInformante.setText("SU TURNO");
                lblInformante.setForeground(Color.blue);
                lblInformante2.setText("TIPOS DE BARCO DE TU FLOTA Y SU UBICACIÓN:");
                lblInformante2.setForeground(Color.blue);
                this.setLocation(740, 0);
                dlm = new DefaultListModel();
                listarBarcos(objP.getObjF2());
            }
        }
        modeloProp = new ModeloTabla(flotaProp);
        modeloOpo = new ModeloTabla(flotaOpo); 
        objP.getObjF1().addObserver(this);    
        objP.getObjF2().addObserver(this);    
        this.TablaJugador.setModel(modeloProp);
        this.TablaOponente.setModel(modeloOpo);
        mostrarTablero(TablaJugador,flotaProp);        
        mostrarTablero(TablaOponente,flotaOpo);
    }
    
   /*mostrarTablero se encarga de mostrar en el formulario de Juego el modelo 
    de la Flota cargada del Jugador Propietario y el modelo de la Flota del 
    Oponente.*/ 
   public void mostrarTablero(JTable xTable,Flota xFlota){
        xTable.setRowHeight(25);
        xTable.getTableHeader().setReorderingAllowed(false);//no permite mover columnas
        if (xTable == TablaJugador){
            xTable.setDefaultRenderer(Posicion.class, new CellRendererJugador(xFlota));
        }else{
            xTable.setDefaultRenderer(Posicion.class, new CellRendererOponente(xFlota));
        }
        xTable.setDefaultEditor(Posicion.class,new CellEditor(xTable,xFlota));
        cargarLetras(xTable);
        anchoColumna(xTable);
    }
    
   /*cargarLetras carga las letras que identifican a las filas de cada Flota*/
    public void cargarLetras(JTable xTable){
        LetraFila letrasEnJtable= new LetraFila(xTable);
        if (xTable == TablaJugador){
            jScrollPaneJugador.setRowHeaderView(letrasEnJtable);
        }else{
            jScrollPaneOponente.setRowHeaderView(letrasEnJtable);
        }
    }
    
    /*anchoColumna modifica el ancho de las columnas del JTable pasado por 
     parématro. Con esto se logra que las celdas sean cuadradas.*/
    public void anchoColumna(JTable xTable){
        for (int i = 0; i < xTable.getColumnCount(); i++) {
            xTable.getColumnModel().getColumn(i).setMinWidth(25);
            xTable.getColumnModel().getColumn(i).setMaxWidth(25);
        }
    }
    
    /*listarBarcos muestra el toString de los Barcos de la Flota Propietario
     en la jLista del Formulario*/
    public void listarBarcos (Flota objF){
        for (Barco objB : objF.getColBarcos()){ 
            dlm.addElement(objB);
            lstBarcos.setModel(dlm);
            lstBarcos.setEnabled(false);  
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneJugador = new javax.swing.JScrollPane();
        TablaJugador = new javax.swing.JTable();
        jScrollPaneOponente = new javax.swing.JScrollPane();
        TablaOponente = new javax.swing.JTable();
        lblInformante = new javax.swing.JLabel();
        lblOponente = new javax.swing.JLabel();
        btnAbandonar = new javax.swing.JButton();
        lblJugador1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstBarcos = new javax.swing.JList();
        btnMejorar = new javax.swing.JButton();
        lblInformante2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

        TablaJugador.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPaneJugador.setViewportView(TablaJugador);

        TablaOponente.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPaneOponente.setViewportView(TablaOponente);

        lblInformante.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lblOponente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        btnAbandonar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnAbandonar.setText("Abandonar Juego");
        btnAbandonar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbandonarActionPerformed(evt);
            }
        });

        lblJugador1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jScrollPane1.setViewportView(lstBarcos);

        btnMejorar.setText("<< Mejorar Barco");
        btnMejorar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMejorarActionPerformed(evt);
            }
        });

        lblInformante2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblInformante, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(lblOponente, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPaneJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jScrollPaneOponente, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnAbandonar)
                                .addComponent(btnMejorar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(lblInformante2, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblOponente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(lblJugador1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(lblInformante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneOponente, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPaneJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblInformante2, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnMejorar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAbandonar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /*La acción de este botón permite salir del Juego al Jugador y cierra
     el formulario de Juego.*/
    private void btnAbandonarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbandonarActionPerformed
        if (btnAbandonar.getText() == "Abandonar Juego"){
            int confirmado = JOptionPane.showConfirmDialog(null, "Desea abandonar el juego?", "###RETIRARSE###", JOptionPane.YES_NO_OPTION);
            if (confirmado == JOptionPane.YES_OPTION){
                if (objP.getObjF1().getObjJ().equals(objJ)){
                    objP.getObjF1().setRetirada(true);
                    objP.setFinalizada(true);/*****************************************************DEFENSA***/
                    objP.setObjGanador(objP.getObjF2().getObjJ());
                    this.dispose();
                }else if (objP.getObjF2().getObjJ() != null && objP.getObjF2().getObjJ().equals(objJ)){
                    objP.getObjF2().setRetirada(true);
                    objP.setFinalizada(true); /*************************************** DEFENSA*/
                    objP.setObjGanador(objP.getObjF1().getObjJ());
                    this.dispose();
                }else{
                    this.dispose();
                }
            }   
        }else{
            this.dispose();
        }
        
    }//GEN-LAST:event_btnAbandonarActionPerformed
    
    /*Al accionar este botón permite al Jugador modificar un barco de su Flota
     elegido de la Lista, o en tal caso advierte que el barco elegido ya esta
     destruido.*/
    private void btnMejorarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMejorarActionPerformed
        if (lstBarcos.getSelectedIndex() > -1){
            Barco objB = (Barco) lstBarcos.getSelectedValue();
            if (objB.isDestruido()){
                JOptionPane.showMessageDialog(null, "El Barco que desea modificar está Destruido","MODIFICACIÓN INCORRECTA",JOptionPane.ERROR_MESSAGE);
            }else{
                objB.cambiarDeTipo();
                modeloProp.fireTableDataChanged();
                lstBarcos.setEnabled(false);
                btnMejorar.setEnabled(false);
                lblInformante2.setText("TIPOS DE BARCO DE TU FLOTA Y SU UBICACIÓN:");
                lblInformante2.setForeground(Color.blue);
            }
        }else{
            JOptionPane.showMessageDialog(null, "No seleccionó barco a mejorar.","SELECCIONE BARCO",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnMejorarActionPerformed
   
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
            java.util.logging.Logger.getLogger(FrmTableroDeJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTableroDeJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTableroDeJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTableroDeJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmTableroDeJuego().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaJugador;
    private javax.swing.JTable TablaOponente;
    private javax.swing.JButton btnAbandonar;
    private javax.swing.JButton btnMejorar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPaneJugador;
    private javax.swing.JScrollPane jScrollPaneOponente;
    private javax.swing.JLabel lblInformante;
    private javax.swing.JLabel lblInformante2;
    private javax.swing.JLabel lblJugador1;
    private javax.swing.JLabel lblOponente;
    private javax.swing.JList lstBarcos;
    // End of variables declaration//GEN-END:variables

    /*update actualiza los modelos de Flotas en cada disparo de cada Jugador
     según los eventos que se produzcan. Actúa únicamente si ya se encuentran
     logueados los dos Jugadores corresondientes a una misma Partida. Utiliza
     los métodos observablePro y observableOpo.*/
    @Override
    public void update(Observable o, Object arg) { 
        if (modeloProp.getObjF().getObjJ()!= null && modeloOpo.getObjF().getObjJ()!= null){
            if(o.equals(modeloOpo.getObjF()) && modeloOpo.getObjF().equals(objP.getObjF1()) && objP.getObjF1().isRetirada()){
                //Flota del Jugador 1.
                lblInformante.setText("Se retiró " + modeloOpo.getObjF().getObjJ().getNombre());
                btnAbandonar.setText("GANASTE, Salir.");
                JOptionPane.showMessageDialog(null, modeloOpo.getObjF().getObjJ().getNombre() + " se retiró.", "GANASTE " + modeloProp.getObjF().getObjJ().getNombre(),JOptionPane.INFORMATION_MESSAGE);
                TablaOponente.setEnabled(false);
                update(this.getGraphics());
            }else if (modeloOpo.getObjF().equals(objP.getObjF2()) && objP.getObjF2().isRetirada()){
                lblInformante.setText("Se retiró " + modeloOpo.getObjF().getObjJ().getNombre());
                btnAbandonar.setText("GANASTE, Salir.");
                JOptionPane.showMessageDialog(null, modeloOpo.getObjF().getObjJ().getNombre() + "se retiró.", "GANASTE " + modeloProp.getObjF().getObjJ().getNombre(),JOptionPane.INFORMATION_MESSAGE);
                TablaOponente.setEnabled(false);
                update(this.getGraphics());
            }else if (o.equals(modeloProp.getObjF())){
                observableProp();
            }else{
                observableOpo();
            } 
        }      
    }
    
    /*Actualiza el modelo de Flota de los Jugadores que son propietarios del
     Formulario según los eventos que se produzcan en el Formulario del 
     Jugador oponente. Este método es invocado en el update*/
    public void observableProp(){
        modeloProp.fireTableDataChanged();
        if (modeloProp.getObjF().verificarEstoyDestruida()){
            lblInformante.setText("####PERDISTE####");
            TablaOponente.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Has Perdido el Juego", "LO SIENTO " + modeloProp.getObjF().getObjJ().getNombre(),JOptionPane.OK_OPTION);
            objP.setFinalizada(true);/*****************************************************DEFENSA***/
            objP.setObjGanador(objP.getObjF2().getObjJ());/*****************************************************DEFENSA***/
            this.dispose();
        }else if (modeloProp.getObjF().isTocoBarco()){
            if (modeloProp.getObjF().equals(objP.getObjF1())){
                lblInformante.setText("Acertó " + modeloOpo.getObjF().getObjJ().getNombre());
                lblInformante.setForeground(Color.gray);
                TablaOponente.setEnabled(false);
                modeloProp.getObjF().setTocoBarco(false);
            }else{
                lblInformante.setText("Acertó " + modeloOpo.getObjF().getObjJ().getNombre() + ". Espere...");
                lblInformante.setForeground(Color.gray);
                TablaOponente.setEnabled(false);
                modeloProp.fireTableDataChanged();
                modeloOpo.fireTableDataChanged();
            }
        }else{
            lblOponente.setText(modeloOpo.getObjF().getObjJ().getNombre());
            TablaOponente.setEnabled(true);
            lblInformante.setText("SU TURNO");
            lblInformante.setForeground(Color.blue);
        }
    }
    
    /*Actualiza el modelo de Flota de los Jugadores oponentes en el formulario
     donde se realizó el disparó. En caso de haber destruído a la flota del 
     Oponente, informa y cierra el Formulario de Juego. En caso de acierto 
     continúa disparando. Si destruyó un barco del oponente, habila el botón 
     Mejorar Barco y la Lista de Barcos. Si efectuó disparo al agua, brinda 
     el turno al otro Jugador. Este método es invocado en el update.*/
    public void observableOpo(){
        modeloOpo.fireTableDataChanged();
        if (modeloOpo.getObjF().verificarEstoyDestruida()){
            lblInformante.setText("!!!!!GANASTE!!!!!");
            TablaOponente.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Has Ganado el Juego", "FELICITACIONES " + modeloProp.getObjF().getObjJ().getNombre(),JOptionPane.INFORMATION_MESSAGE);
            objP.setFinalizada(true);/*****************************************************DEFENSA***/
            objP.setObjGanador(objP.getObjF1().getObjJ());/*****************************************************DEFENSA***/
            this.dispose();
        }else if (modeloOpo.getObjF().isTocoBarco()){
            if (modeloOpo.getObjF().equals(objP.getObjF1())){
                lblOponente.setText(modeloOpo.getObjF().getObjJ().getNombre());
                TablaOponente.setEnabled(true);
                lblInformante.setText("ACERTÓ! CONTINÚE...");
                lblInformante.setForeground(Color.green);
                if (objP.getObjF1().nuevoBarcoDestruido(objP.getObjF1().getCantBarDestruidos()+1)){
                    lblInformante.setText("Destruyó Barco de " + modeloOpo.getObjF().getObjJ().getNombre());
                    lblInformante2.setText("MUY BIEN!!... Ahora puedes mejorar un barco de tu Flota.");
                    lblInformante2.setForeground(Color.MAGENTA);
                    lstBarcos.setEnabled(true);
                    btnMejorar.setEnabled(true);
                }
            }else{
                lblOponente.setText(modeloOpo.getObjF().getObjJ().getNombre());
                TablaOponente.setEnabled(true);
                lblInformante.setText("ACERTÓ! CONTINÚE...");
                lblInformante.setForeground(Color.green);
                modeloOpo.getObjF().setTocoBarco(false);
                if (objP.getObjF2().nuevoBarcoDestruido(objP.getObjF2().getCantBarDestruidos()+1)){
                    modeloProp.fireTableDataChanged();lblInformante.setText("Destruyó Barco de "+ modeloOpo.getObjF().getObjJ().getNombre());
                    lblInformante2.setText("MUY BIEN!!... Ahora puedes mejorar un barco de tu Flota.");
                    lblInformante2.setForeground(Color.MAGENTA);
                    lstBarcos.setEnabled(true);
                    btnMejorar.setEnabled(true);
                }
            }
        }else{ 
            lblInformante.setText("Turno de " + modeloOpo.getObjF().getObjJ().getNombre());
            lblInformante.setForeground(Color.red);
            TablaOponente.setEnabled(false);  
        }
    }
 
    /*************************************** DEFENSA ********************************/
    
    
    
    
    
    
    
}
