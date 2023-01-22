package Logica.Partida;

import java.util.ArrayList;

/**
 * @author Nico
 */
public class GestoraPartida{
    
    private int numP = 1;
    private ArrayList<Partida> colPartidas = new ArrayList<>();
    private static GestoraPartida objGP = null;
    
    public static GestoraPartida getInstance(){
        if (objGP == null){
            objGP = new GestoraPartida();
        }
        return objGP;
    }
    
    public int getNumP() {
        return numP;
    }
    public void setNumP(int numP) {
        this.numP = numP;
    }

    public void setColPartidas(ArrayList<Partida> colPartidas) {
        this.colPartidas = colPartidas;
    }
    public ArrayList <Partida> getColPartidas(){
        return (ArrayList<Partida>)(colPartidas.clone());
    }
    
    private GestoraPartida(){
    }
    
    public Partida agregaPartida (){
        Partida objP = new Partida(numP);
        colPartidas.add(objP);
        numP++;
        return objP;
    }
    
}
