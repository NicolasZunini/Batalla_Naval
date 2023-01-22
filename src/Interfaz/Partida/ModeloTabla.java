package Interfaz.Partida;

import Logica.Partida.Posicion;
import Logica.Partida.Flota;
import javax.swing.table.AbstractTableModel;

/**
 * @author Nico
 */
public class ModeloTabla extends AbstractTableModel{
    private Flota objF;

    public Flota getObjF() {
        return objF;
    }

    public ModeloTabla(Flota objF) {
        this.objF = objF;
    }
    
    @Override
    public int getRowCount() {
        return (int) Math.sqrt(objF.getTamaño());
    }

    @Override
    public int getColumnCount() {
        return (int) Math.sqrt(objF.getTamaño());
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return objF.obtenerPosicion(rowIndex, columnIndex);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public String getColumnName(int column) {
        return String.valueOf(column+1);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return Posicion.class;
    }
    
}
