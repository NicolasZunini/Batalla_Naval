package Logica.Usuario;
/*
 * @author Nico
 */

public class Jugador extends Usuario{

    public Jugador(String nombre, String nombreUsuario, String pass) {
        super(nombre,nombreUsuario,pass);
    }

    @Override
    public String toString() {
        return super.toString()+" Jugador.";
    }
}