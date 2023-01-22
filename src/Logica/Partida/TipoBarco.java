package Logica.Partida;

/**
 * @author Nico
 */
//Clase creada para que cumpla el patrón de diseño STRATEGY
public interface TipoBarco {
    //recibe un Barco por parámetro y hace que las clases las clases adheridas
    //a ésta deban sobreescribir este método para hacer la verificación.
    public boolean verificarEstoyDestruido(Barco objB);
    
}
