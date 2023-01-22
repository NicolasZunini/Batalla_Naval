package Logica.Usuario;

import Logica.Exception.UsuarioException;
import java.util.ArrayList;

/*
 * @author Nico
 * Clase con patrón de diseño SINGLETON.
 * El motivo de esta clase es para que se encargue de la administración
 * de los distintos usuarios que se pueden dar de alta en el sistema. 
 * En ella aplicamos un patrón de diseño llamado Singleton, el cual nos
 * permitirá instanciarla una única vez. En ella se privatiza el constructor,
 * se crea una variable del tipo de la clase, también se hace un metodo, el cual
 * va a contener la variable, este será publico y nos retornará la instancia 
 * de la clase; este nos permitira acceder de forma global.
 */

public final class GestoraUsuario {
    
    private static GestoraUsuario objU = null;
    private ArrayList<Usuario> colUsuarios = new ArrayList<>();

    private GestoraUsuario(){
    }

    public static GestoraUsuario getInstance(){
        if (objU == null){
            objU = new GestoraUsuario();
        }
        return objU;
    }

    public ArrayList<Usuario> getColUsu() {
        return colUsuarios;
    }
    public void setColUsu(ArrayList<Usuario> colUsu) {
        this.colUsuarios = colUsu;
    }

    public void agregarUsu(Usuario objU){
        getColUsu().add(objU);
    }
    //Chequea que el String nombre recibido pertenezca a un Usuario Administrador.
    public Administrador chequearAdmin(String nom, String pass) throws UsuarioException{
        for( Usuario objUsu: getColUsu()){
            if(objUsu.getNombreUsuario().equals(nom) && objUsu.getContraseña().equals(pass)){
                if (objUsu instanceof Administrador){
                    return (Administrador) objUsu;
                }
            }
        }
        throw new UsuarioException(); 
    }
    //Chequea que el String nombre recibido pertenezca a un Usuario Jugador. 
    public Jugador chequearJugador(String nom, String pass) throws UsuarioException{
        for( Usuario objUsu: getColUsu()){
            if(objUsu.getNombreUsuario().equals(nom) && objUsu.getContraseña().equals(pass)){
                if (objUsu instanceof Jugador){
                    return (Jugador) objUsu;
                }
            }
        }
        throw new UsuarioException(); 
    }
               
}
