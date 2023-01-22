package Interfaz.Partida;

import Logica.Partida.Barco;
import Logica.Partida.Flota;
import Logica.Partida.Posicion;
import java.awt.Color;
import java.awt.Component;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * @author Nico
 */
public class CellRendererOponente implements TableCellRenderer{
    JButton boton = new JButton();
    Flota objF;
    
    public CellRendererOponente (Flota flota){
        this.objF = flota;
    }
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Posicion objP = (Posicion)value;  
//        HashMap colP = new HashMap();
//        colP.put(objP.toString(),objP);
        Barco objBarco = objF.devolverBarco(objP);
        if(objP.isGolpeada()){
            if(objP.isOcupada()){
                if (objBarco.estoyDestruido()){
                    for (Posicion objPos : objBarco.getColPosB().values()){
                        objP = objPos;
                        boton.setBackground(Color.red);
                    }      
                }else{
                     boton.setBackground(Color.yellow); 
                }            
            }else{
                boton.setBackground(Color.blue);
            }
        }else{
            boton.setBackground(Color.white);
        }
        return boton;
    }
}