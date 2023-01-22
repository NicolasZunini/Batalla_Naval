package Main;

import Interfaz.Admin.FrmLoginAdmin;
import Logica.Usuario.Administrador;
import Logica.Usuario.GestoraUsuario;
import Logica.Usuario.Jugador;

public class BatallaNaval {

    public static void main(String[] args) {
        
        Administrador objAA = new Administrador("Nicolás Zunini","Niko","123");
        Administrador objAB = new Administrador("Tony Vivas","Tony","456");
        Jugador objJG = new Jugador("Jonathan Díaz", "Jona", "111");
        Jugador objJH = new Jugador("Martin Gonzalez", "Martin", "222");
        Jugador objJI = new Jugador("Angela Nuñez", "Ange", "222");
        Jugador objJJ = new Jugador("Cecilia Martinez", "Ceci", "111");
        Jugador objJK = new Jugador("Marcos Vidal", "Marcos", "222");
        Jugador objJL = new Jugador("Gastón Ramírez", "Gaston", "222");
        Jugador objJM = new Jugador("Julio Ledesma", "Julio", "222");
       
        
        GestoraUsuario.getInstance().agregarUsu(objAA);
        GestoraUsuario.getInstance().agregarUsu(objAB);
        GestoraUsuario.getInstance().agregarUsu(objJG);
        GestoraUsuario.getInstance().agregarUsu(objJH);
        GestoraUsuario.getInstance().agregarUsu(objJI);
        GestoraUsuario.getInstance().agregarUsu(objJJ);
        GestoraUsuario.getInstance().agregarUsu(objJK);
        GestoraUsuario.getInstance().agregarUsu(objJL);
        GestoraUsuario.getInstance().agregarUsu(objJM);
        
        System.out.println(objAA);
        System.out.println(objAB);
        System.out.println(objJG);
        System.out.println(objJH);
        System.out.println(objJI);
        System.out.println(objJJ);
        System.out.println(objJK);
        System.out.println(objJL);
        System.out.println(objJM);
        
        FrmLoginAdmin frm = FrmLoginAdmin.getInstance();
        frm.setVisible(true);
        
        Jugador objA = new Jugador("a","a","a");
        Jugador objB= new Jugador("b","b","b");
        GestoraUsuario.getInstance().agregarUsu(objA);
        GestoraUsuario.getInstance().agregarUsu(objB);
    }
    
}
