package Interfaz.Partida;

import Logica.Exception.PosicionYaGolpeada;
import Logica.Partida.Barco;
import Logica.Partida.Flota;
import Logica.Partida.Posicion;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 * @author Nico
 */
public class CellEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
    
    JTable table;
    JButton button = new JButton();
    Flota objFlota;
    Posicion objP; 

    public CellEditor(JTable table, Flota objF) {
        this.table = table;
        this.objFlota = objF;
        button.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            objP.golpearme();
            Barco objBarco = objFlota.devolverBarco(objP);
        if(objP.isOcupada()){
            if (objBarco.estoyDestruido()){
                objBarco.golpearPosiciones();
                button.setBackground(Color.red);             
            }else{
                button.setBackground(Color.yellow);
            }
        }else{
            button.setBackground(Color.blue);
        }
        objFlota.disparo(); /************************* DESFENSA *******/
        } catch (PosicionYaGolpeada ex) {
            JOptionPane.showMessageDialog(null, "Ya disparó en esta posición.","REPITIÓ DISPARO:",JOptionPane.ERROR_MESSAGE);
        }        
    } 
    
    @Override
    public Object getCellEditorValue() {
        return button;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        objP = (Posicion)value;
        return button;
    }
    
    @Override
    public boolean shouldSelectCell(EventObject anEvent) {
        return true;
    }

    @Override
    public boolean stopCellEditing() {
        return super.stopCellEditing();
    }
 
    @Override
    public void cancelCellEditing() {
        super.cancelCellEditing();
    }
    
    @Override
    public boolean isCellEditable(EventObject anEvent) {
        return true;
    }
    
    
    
}
