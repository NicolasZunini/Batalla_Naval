/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Partida;

/**
 *
 * @author Nico
 */
public class Galeon implements TipoBarco{
    /*Sobreescribe el método declarado en TipoBarco.
     Se encarga de contabilizar la cantidad de Posiciones golpeadas de un
     Barco pasado por parámetro. Devuelve verdadero si las posiciones que 
     identifican a los extremos del Barco se encuentran golpeadas, sino falso.
     Debido a que la colección de posiciones del Barco estan guardadas en un 
     HashMap, se desconoce internamente cómo están ubicadas en dicha colección.
     por lo cual se implementa la forma de obtener las que nos interesa*/
    @Override
    public boolean verificarEstoyDestruido(Barco objB) {
        int tamaño = objB.getColPosB().size();      
        int fIni=-1,cIni=-1;
        Posicion objPDeArranque=null;
        char ch = 'f';
        for (Posicion objP : objB.getColPosB().values()) {
            if (objPDeArranque != null){
                if (objPDeArranque.getFila() == objP.getFila()){
                    if ( objP.getColumna() < cIni ){
                        cIni = objP.getColumna();
                        ch = 'c';
                    }
                }else{
                    if ( objP.getFila() < fIni ){
                        fIni = objP.getFila();
                    }
                }
            }else{
                objPDeArranque = objP;
                fIni = objP.getFila();
                cIni = objP.getColumna();
                if (objB.getColPosB().size() == 1 && objPDeArranque.isGolpeada()){
                    return true;
                }
            }                
        } 
        if (ch == 'f'){
            if (objB.getColPosB().get(fIni+","+cIni).isGolpeada() && objB.getColPosB().get((fIni+tamaño-1)+","+cIni).isGolpeada()){
                return true;
            }
        }else{
            if (objB.getColPosB().get(fIni+","+cIni).isGolpeada() && objB.getColPosB().get(fIni+","+(cIni+tamaño-1)).isGolpeada()){
                return true;
            } 
        }
        return false;
    }   
    
     @Override
    public String toString() {
        return "Galeon ";
    }
     
}

