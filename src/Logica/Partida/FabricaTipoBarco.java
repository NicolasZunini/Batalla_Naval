/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Partida;

/**
 *
 * @author Usuario
 */
/*Esta clase se utiliza aplicando el método Fábrica, es la encargada de
 crear tipos de Barcos.*/
public class FabricaTipoBarco {
    /*retornaNuevoTipoBarco recibe un tipo de Barco y según sea el caso
     crea y retorna un nuevo Tipo de Barco.*/
    public static TipoBarco retornaNuevoTipoBarco(TipoBarco tb){
        if (tb == null){
            return new Goleta();
        }else if ( tb.getClass() == Goleta.class){
            return new Galeon();
        }else if (tb.getClass() == Galeon.class){
            return new Acorazado();
        }else{
            return tb;
        }
    }
}
