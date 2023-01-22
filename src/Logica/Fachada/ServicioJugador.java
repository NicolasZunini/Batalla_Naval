package Logica.Fachada;

import Logica.Exception.UsuarioException;
import Logica.Usuario.GestoraUsuario;
import Logica.Usuario.Jugador;
import Logica.Usuario.Usuario;

/**
 * @author Nico
 */
// Se la declara SINGLETON para obtener una instancia única del Jugador.
//lo que permite chequear si el mismo Jugador ya se logueó en una Partida.
public class ServicioJugador {

    private GestoraUsuario objGU = GestoraUsuario.getInstance();
    
    private static ServicioJugador objSerJug = null;

    public ServicioJugador() {
    }
    
    public static ServicioJugador getInstance(){
        if (objSerJug == null){
            objSerJug = new ServicioJugador();
        }
            return objSerJug;
    }
    
    public Jugador loginJugador(String nombre, String Pass) throws UsuarioException{
        return objGU.chequearJugador(nombre, Pass);
    }
}