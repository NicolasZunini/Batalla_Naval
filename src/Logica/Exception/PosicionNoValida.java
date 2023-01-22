package Logica.Exception;

/**
 * @author Nico
 */
public class PosicionNoValida extends Exception{

    public PosicionNoValida() {
    }
    
    public PosicionNoValida(String message) {
        super("Posición no válida.");
    }

}
