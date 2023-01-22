package Logica.Exception;

/**
 * @author Nico
 */
public class UsuarioException extends Exception{

    public UsuarioException(String message) {
        super("No existe el Usuario");
    }

    public UsuarioException() {
    }
       
}
