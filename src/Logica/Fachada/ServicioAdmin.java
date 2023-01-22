package Logica.Fachada;

import Logica.Exception.UsuarioException;
import Logica.Partida.GestoraConfigJuego;
import Logica.Usuario.Administrador;
import Logica.Usuario.GestoraUsuario;

/**
 * @author Nico
 */

//Se la declara SINGLETON para obtener una instancia única de la misma.
public class ServicioAdmin {
   
    private GestoraUsuario objGU = GestoraUsuario.getInstance();
    
    private static ServicioAdmin objSerAdmin = null;

    public ServicioAdmin() {
    }
    
    public static ServicioAdmin getInstance(){
        if (objSerAdmin == null){
            objSerAdmin = new ServicioAdmin();
        }
            return objSerAdmin;
    }
    
    public Administrador loginAdmin(String nombre, String Pass) throws UsuarioException{
        return objGU.chequearAdmin(nombre, Pass);
    }
    // retorna una configuración de Juego de la SINGLETON GestoraConfigJuego.
    public GestoraConfigJuego devolverConfiguracion(){
        return GestoraConfigJuego.getInstance();
    }
            
}