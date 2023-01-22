package Logica.Usuario;
/*
 * @author Nico
 */

public class Administrador extends Usuario{
  
    public Administrador(String nombre, String pass, String nombreUsuario) {
        super(nombre,pass,nombreUsuario);
    }

    @Override
    public String toString() {
        return super.toString()+" Administrador.";
    }
    
}