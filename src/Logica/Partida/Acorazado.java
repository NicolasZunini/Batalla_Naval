package Logica.Partida;

/**
 * @author Nico
 */
public class Acorazado implements TipoBarco{
    /*Sobreescribe el método declarado en TipoBarco.
     Se encarga de contabilizar la cantidad de Posiciones golpeadas de un
     Barco pasado por parámetro. Si todas sus posociones se encuentran 
     golpeadas devuelve verdadero, sino falso.*/
    @Override
    public boolean verificarEstoyDestruido(Barco objB) {
        int contador = 0;
        for (Posicion objP : objB.getColPosB().values()) {
            if (objP.isGolpeada()){
                contador++;
                if (contador == objB.getColPosB().size()){
                    return true;
                }   
            } 
        } 
        return false;
    }
    
    
     @Override
    public String toString() {
        return "Acorazado ";
    }
     
}
