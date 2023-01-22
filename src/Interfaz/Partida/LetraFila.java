package Interfaz.Partida;

import java.awt.Component;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/**
 * @author Nico
 */
public class LetraFila  extends JTable implements ChangeListener, PropertyChangeListener {
    private JTable main;
    
    public LetraFila(JTable table){
	main = table;
        main.addPropertyChangeListener( this );
        setFocusable( false );
        setAutoCreateColumnsFromModel( false );
	setModel( main.getModel() );
	setSelectionModel( main.getSelectionModel() );
	TableColumn column = new TableColumn();
	column.setHeaderValue(" ");
	addColumn( column );
	column.setCellRenderer(new LetraFilaRenderer());
	getColumnModel().getColumn(0).setPreferredWidth(25);
	setPreferredScrollableViewportSize(getPreferredSize());
    }

    @Override
    public void addNotify(){
        super.addNotify();
        Component c = getParent();
        // Mantiene el desplazamiento de la fila de la tabla en sincronización
        //con la tabla principal
        if (c instanceof JViewport){
            JViewport viewport = (JViewport)c;
            viewport.addChangeListener( this );
        }
    }

    /*
    *  Delego el método a la tabla principal
    */
    @Override
    public int getRowCount(){
        return main.getRowCount();
    }

    @Override
    public int getRowHeight(int row){
        return main.getRowHeight(row);
    }     

    /*
    *  Devuelvo la letra a mostrar
    */
    @Override
    public Object getValueAt(int row, int column){
        String result = "";
        for (; row >= 0; row = row / 26 - 1) {
                result = (char)((char)(row%26)+'A') + result;
        }
    return result;
    }
    @Override
    public boolean isCellEditable(int row, int column){
        return false;
    }
    public void stateChanged(ChangeEvent e){
        //  Mantiene el desplazamiento de la fila de la tabla en sincronía con la tabla principal.
        JViewport viewport = (JViewport) e.getSource();
        JScrollPane scrollPane = (JScrollPane)viewport.getParent();
        scrollPane.getVerticalScrollBar().setValue(viewport.getViewPosition().y);
    }

    public void propertyChange(PropertyChangeEvent e){		
        //  Mantiene la fila de la tabla en sincronía con la tabla principal.
        if ("selectionModel".equals(e.getPropertyName())){
            setSelectionModel( main.getSelectionModel() );
        }
        if ("model".equals(e.getPropertyName())){
            setModel( main.getModel() );
        }
    }

    private static class LetraFilaRenderer extends DefaultTableCellRenderer{

        public LetraFilaRenderer(){
            setHorizontalAlignment(JLabel.CENTER);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
            if (table != null){
                JTableHeader header = table.getTableHeader();
                if (header != null){
                    setForeground(header.getForeground());
                    setBackground(header.getBackground());
                    setFont(header.getFont());
                }
            }
            if (isSelected){
                setFont( getFont().deriveFont(Font.BOLD));
            }	
            setText((value == null) ? "" : value.toString());
            setBorder(UIManager.getBorder("TableHeader.cellBorder"));
            return this;
        }
    }
}
