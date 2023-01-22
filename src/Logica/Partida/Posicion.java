package Logica.Partida;

//import Logica.Exception.GolpeadaException;

import Logica.Exception.PosicionYaGolpeada;
import java.util.Observable;


/**
 * @author Nico
 */

//Se emplea el patrón observable para que cada posición sea vista por Flota.
public class Posicion extends Observable{

    private int fila;
    private int columna;
    private boolean golpeada=false;
    private boolean ocupada=false;

    public boolean isOcupada() {
        return ocupada;
    }
    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
    
    public int getColumna() {
        return columna;
    }
    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }
    public void setFila(int fila) {
        this.fila = fila;
    }
    
    public Posicion(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }
    
    public boolean isGolpeada(){
        return golpeada;
    }
    public void setGolpeada(boolean golpeada) {
        this.golpeada = golpeada;
    }
         
    @Override
    public String toString() {
        return fila + ","+ columna;
    }
    //golpearme chequea si esta posición ya está golpeada, devuelve verdadero
    //si no lo está, falso si no, y notifica a sus observadores.
    public void golpearme() throws PosicionYaGolpeada{
        if (golpeada){
            throw new PosicionYaGolpeada();
        }
        this.golpeada = true;
        setChanged();
        notifyObservers();
    }
   

}