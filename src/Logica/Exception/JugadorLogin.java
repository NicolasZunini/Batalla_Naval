package Logica.Exception;

/**
 * @author Nico
 */
public class JugadorLogin extends Exception{

    public JugadorLogin(String message) {
        super("Jugador ya ingreso a partida.");
    }

    public JugadorLogin() {
    }

    
    
}
