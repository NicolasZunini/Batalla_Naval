package Logica.Partida;

/**
 * @author Nico
 */
public class Goleta implements TipoBarco{
    /*Sobreescribe el método declarado en TipoBarco.
     Se encarga de contabilizar la cantidad de Posiciones golpeadas de un
     Barco pasado por parámetro. Si el barco tiene dos posiciones golpeadas o
     contiene una sola posición y la misma está golpeada devuelve verdadero,
     sino devuelve falso.*/
    @Override
    public boolean verificarEstoyDestruido(Barco objB) {
    int contador = 0;
        for (Posicion objP : objB.getColPosB().values()) {
            if (objP.isGolpeada()){
                contador++;
                if (objB.getColPosB().size() == 1 || contador == 2){
                    return true;
                }
            }            
        }
    return false;
}

    @Override
    public String toString() {
        return "Goleta ";
    }
    
}
