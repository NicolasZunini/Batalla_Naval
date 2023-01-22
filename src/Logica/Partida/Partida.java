package Logica.Partida;

import Logica.Exception.JugadorLogin;
import Logica.Usuario.Jugador;
import Logica.Usuario.Usuario;

/**
 * @author Nico
 */
public class Partida {
    
    private int numero;
    private Flota objF1;
    private Flota objF2;
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public Flota getObjF1() {
        return objF1;
    }
    public void setObjF1(Flota objF1) {
        this.objF1 = objF1;
    }

    public Flota getObjF2() {
        return objF2;
    }
    public void setObjF2(Flota objF2) {
        this.objF2 = objF2;
    }

    public Partida(int numero) {
        this.numero = numero;
        this.objF1 = new Flota();
        this.objF2 = new Flota();
    }
    //Se encarga de asignarle un Jugador a la Flota. 
    public void asignarJugadorATablero(Usuario objU) throws JugadorLogin{
        if (objF1.getObjJ() == null){
            objF1.setObjJ((Jugador)(objU));
        }
        else if (!objF1.getObjJ().equals(objU)){
            objF2.setObjJ((Jugador)(objU));
        }
        else{
            throw new JugadorLogin("Ya está logueado en esta partida.");
        }
    }
  
    
/***********************************    DEFENSA   ******************************************/
    
    private boolean finalizada = false;
    private Jugador objGanador = null;
        
    public boolean isFinalizada() {
        return finalizada;
    }
    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    public Jugador getObjGanador() {
        return objGanador;
    }
    public void setObjGanador(Jugador objGanador) {
        this.objGanador = objGanador;
    }

    public int cantidadTotalDisparo(){
        return objF1.getDisparo() + objF2.getDisparo();
    }
    
    
    @Override
    public String toString() {
        return "Partida: " + numero + ".";
    }
    
    
   
    
    
    


}
