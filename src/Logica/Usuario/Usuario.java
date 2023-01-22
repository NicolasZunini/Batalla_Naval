package Logica.Usuario;
/*
 * @author Nico
 */

public abstract class Usuario {
    
    private String nombre;
    private String nombreUsuario ;
    private String contraseña;

    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Usuario(String nombre, String nombreUsuario, String contraseña) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Nombre: "+nombre+", Usuario: "+nombreUsuario+", Pass:"+contraseña+".";
    }

    
    
}
