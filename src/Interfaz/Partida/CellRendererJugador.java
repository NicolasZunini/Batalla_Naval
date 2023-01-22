package Interfaz.Partida;

import Logica.Partida.*;
import java.awt.Color;
import java.awt.Component;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * @author Nico
 */
public class CellRendererJugador implements TableCellRenderer{
    JButton boton = new JButton();
    Flota objF;
    
    public CellRendererJugador (Flota flota){
        this.objF = flota;
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Posicion objP = (Posicion)value;  
        HashMap colP = new HashMap();
        colP.put(objP.toString(),objP);
        Barco objBarco = objF.devolverBarco(objP);
        if(objP.isGolpeada()){
            if(objP.isOcupada()){
                if (objBarco.estoyDestruido()){
                    boton.setBackground(Color.blue);
                }else{
                     boton.setBackground(Color.yellow); 
                }            
            }else{
                boton.setBackground(Color.blue);
            }
        }
        else if (objP.isOcupada()){
            if (objBarco.getObjtipo().getClass() == Goleta.class){
                boton.setBackground(Color.gray);
            }else if (objBarco.getObjtipo().getClass() == Galeon.class){
                boton.setBackground(Color.orange);
            }else{
                boton.setBackground(Color.black);
            }           
        }else{
            boton.setBackground(Color.white);
        }
        return boton;
    }
}