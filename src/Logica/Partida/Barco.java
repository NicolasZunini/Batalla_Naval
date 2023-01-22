package Logica.Partida;

import java.util.HashMap;

/**
 * @author Nico
 */
public class Barco {
    
    private HashMap<String,Posicion> colPosB = new HashMap<String,Posicion>();
    private TipoBarco objtipo;
    private boolean destruido = false;

    public boolean isDestruido() {
        return destruido;
    }

    public void setDestruido(boolean destruido) {
        this.destruido = destruido;
    }
      
    public HashMap<String, Posicion> getColPosB() {
        return colPosB;
    }

    public void setColPosB(HashMap<String, Posicion> colPosB) {
        this.colPosB = colPosB;
    }
    
    public TipoBarco getObjtipo() {
        return objtipo;
    }

    public void setObjtipo(TipoBarco objtipo) {
        this.objtipo = objtipo;
    }
    
    /*El constructor de Barco recibe una colección de posicones por parámetro 
     para inicializarse con ésta y un determinado tipo de Barco.*/
    public Barco(HashMap colPosB){
        this.colPosB = colPosB;
        cambiarDeTipo();
    }
    
    //Brinda información del Barco.
    @Override
    public String toString() {
        return objtipo.toString() + " ubicado en: " + colPosB;      
    }
    
    /*Pregunta si el tipo de Barco que posee se encuentra destruido utilizando
     al método verificarEstoyDestruido, si éste es verdadero, entonces cambia 
     su atributo destruido a verdadero y devuelve verdadero, sino devuelve 
     falso.*/
    public boolean estoyDestruido() {
        if (objtipo.verificarEstoyDestruido(this)){
            this.destruido = true;
            return true;
        }
        return false;
    }
    
    /*golpearPosiciones recorre la colección de posiciones del Barco y a cada
     una le cambia el estado golpeada a verdadero.*/
    public void golpearPosiciones (){
        for (Posicion objP : colPosB.values()) {
            objP.setGolpeada(true);
        }
    }
    
    /*cambiarDeTipo se basa en el patrón de Diseño Método Fábrica, para ello
     utiliza el método retornaNuevoTipoBarco de la clase FabricaTipoBarco, 
     pasándole por parámetro el tipo de Barco y ésta le regresa otro tipo de
     Barco, el cual es seteado.*/
    public void cambiarDeTipo(){
        this.setObjtipo(FabricaTipoBarco.retornaNuevoTipoBarco(this.getObjtipo()));
    }
}
