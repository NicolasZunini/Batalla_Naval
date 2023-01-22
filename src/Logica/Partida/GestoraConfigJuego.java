/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Partida;

/**
 *
 * @author Nico
 */
/*Esta Clase se crea con el solo fin de mantener los datos de configuración del 
 Juego y que podrán ser modificados por el usuario Administrador cuando lo desee,
 Se aplica el patrón de diseño SINGLETON para que permanezca solo una
 instancia de la misma.*/
public class GestoraConfigJuego {
    
    private int tamFlota = 100;
    private int tamBarco = 4;
    private int cantBarcos = 1;
    
    private static GestoraConfigJuego objCJ = null;
    
    public static GestoraConfigJuego getInstance(){
        if (objCJ == null){
            objCJ = new GestoraConfigJuego();
        }
        return objCJ;
    }
    public int getCantBarcos() {
        return cantBarcos;
    }
    public void setCantBarcos(int cantBarcos) {
        this.cantBarcos = cantBarcos;
    }

    public int getTamBarco() {
        return tamBarco;
    }
    public void setTamBarco(int tamBarco) {
        this.tamBarco = tamBarco;
    }

    public int getTamFlota() {
        return tamFlota;
    }
    public void setTamFlota (int tamFlota) {
        this.tamFlota = tamFlota;
    }
}
