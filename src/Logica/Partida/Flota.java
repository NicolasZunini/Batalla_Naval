package Logica.Partida;

import Logica.Exception.PosicionNoValida;
import Logica.Usuario.Jugador;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

/**
 * @author Nico
 */
//Observa y es observada a la vez.
public class Flota extends Observable implements Observer{
    
    private int tamaño;
    private int tamBarcos;
    private int cantBarcos;
    private int cantBarDestruidos;
    private boolean retirada = false;
    private boolean tocoBarco = false;
    private Jugador objJ;
    private HashMap <String,Posicion> colPosiciones = new HashMap<String,Posicion>();
    private ArrayList <Barco> colBarcos = new ArrayList <Barco>();
    
   
    public int getCantBarDestruidos() {
        return cantBarDestruidos;
    }

    public void setCantBarDestruidos(int cantBarDestruidos) {
        this.cantBarDestruidos = cantBarDestruidos;
    }
    
    public boolean isTocoBarco() {
        return tocoBarco;
    }

    public void setTocoBarco(boolean tocoBarco) {
        this.tocoBarco = tocoBarco;
    }

    public boolean isRetirada() {
        return retirada;
    }

    public void setRetirada(boolean retirada) {
        this.retirada = retirada;
        setChanged();
        notifyObservers();
    }
    
    public int getCantBarcos() {
        return cantBarcos;
    }
    
    public void setCantBarcos(int cantBarcos) {
        this.cantBarcos = cantBarcos;
    }

    public ArrayList<Barco> getColBarcos() {
        return colBarcos;
    }
    public void setColBarcos(ArrayList<Barco> colBarcos) {
        this.colBarcos = colBarcos;
    }

    public HashMap<String, Posicion> getColPosiciones() {
        return colPosiciones;
    }
    public void setColPosiciones(HashMap<String, Posicion> colPosiciones) {
        this.colPosiciones = colPosiciones;
    }

    public Jugador getObjJ() {
        return objJ;
    }
    public void setObjJ(Jugador objJ) {
        this.objJ = objJ;
    }

    public int getTamBarcos() {
        return tamBarcos;
    }
    public void setTamBarcos(int tamBarcos) {
        this.tamBarcos = tamBarcos;
    }

    public int getTamaño() {
        return tamaño;
    }
    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }
    
    public Flota(){
        this.tamaño = GestoraConfigJuego.getInstance().getTamFlota();
        this.tamBarcos = GestoraConfigJuego.getInstance().getTamBarco();
        this.cantBarcos = GestoraConfigJuego.getInstance().getCantBarcos();
        generar();
    }
    
    /*Genera las posiciones y las guarda en su colección.*/
    public void  generar(){
        for (int f = 0 ; f < (int) Math.sqrt(getTamaño()) ; f++){
            for ( int c= 0 ; c <(int) Math.sqrt(getTamaño()) ; c++){
                Posicion objP = new Posicion(f, c);
                String coordenada = (String) (f + "," + c);
                colPosiciones.put(coordenada, objP);
                objP.addObserver(this);
            }
        }
    }
    
    /*Dada una fila y columna obtiene la Posición correspondiente.*/
    public Posicion obtenerPosicion(int fila , int col){
        String llave = (String) (fila + "," + col);
        Posicion objP = colPosiciones.get(llave);
        return objP;    
    }
    
    //update actualiza la flota según los cambios surgidos en las posiciones
    //y notifica a los observadores.
    @Override
    public void update(Observable o, Object arg) {
        if (barcoAlcanzado((Posicion)o)){
            this.setTocoBarco(true);
        }
        setChanged();
        notifyObservers();
    }
    //enum: clase interna que enumera constantes correspondientes a la orientación
    //sobre la ubicación de un barco.
    public enum Sentido{
        HORIZ_IZQ, HORIZ_DER, VERT_ARR, VERT_ABA;
    }
    
    /*agregarBarco recibe las coordenadas de fila y columna y un sentido para 
     crea y agregar un barco a su colección, chequeando en cada caso si la 
     ubicación elegida es válida.*/
     public void agregarBarco (int filaIni, int colIni, Sentido sentido) throws PosicionNoValida {
         int fIni = filaIni -1;
         int cIni = colIni -1;
         HashMap colTempPosBarco = new HashMap();
         Posicion objP = new Posicion(fIni,cIni);
         Barco objB = null;
         if (!objP.isOcupada()) {
                switch (sentido){
                    case HORIZ_IZQ: 
                        int cFin = cIni - tamBarcos + 1;
                        if (cFin>=0){
                            for (int c = cIni; c >= cFin; c--){
                                String key = (String)(fIni+","+c);
                                objP = colPosiciones.get(key);
                                if (!objP.isOcupada()){                    
                                    colTempPosBarco.put(key, objP);
                                }else{
                                    throw new PosicionNoValida ("Posición no válida.");
                                }
                            }
                        }else{
                            throw new PosicionNoValida ("Posición no válida.");
                        }
                        break;
                    case HORIZ_DER: 
                        int colFin = cIni + tamBarcos - 1;
                        if (colFin<(int) Math.sqrt(getTamaño())){
                            for (int c = cIni; c <= colFin; c++){
                                String key = (String)(fIni+","+c);
                                objP = colPosiciones.get(key);
                                if (!objP.isOcupada()){                             
                                    colTempPosBarco.put(key, objP);
                                }else{
                                     throw new PosicionNoValida ("Posición no válida.");
                                }
                            }
                        }else{
                            throw new PosicionNoValida ("Posición no válida.");
                        }
                        break;
                    case VERT_ARR: 
                        int fFin = fIni - tamBarcos + 1;
                        if (fFin>=0){
                            for (int f = fIni; f >= fFin; f--){
                                String key = (String)(f+","+cIni);
                                objP = colPosiciones.get(key);
                                if (!objP.isOcupada()){                                                          
                                    colTempPosBarco.put(key, objP);
                                }else{
                                    throw new PosicionNoValida ("Posición no válida.");
                                }
                            }
                        }else{
                            throw new PosicionNoValida ("Posición no válida.");
                        }
                        break;
                    case VERT_ABA: 
                        int filaFin = fIni + tamBarcos - 1;
                        if (filaFin<(int) Math.sqrt(getTamaño())){
                            for (int f = fIni; f <= filaFin; f++){
                                String key = (String)(f+","+cIni);
                                objP = colPosiciones.get(key);
                                if (!objP.isOcupada()){
                                    colTempPosBarco.put(key, objP);
                                }else{
                                    throw new PosicionNoValida ("Posición no válida.");
                                }
                            }
                        }else{
                            throw new PosicionNoValida ("Posición no válida.");
                        }
                        break;
                }
                objB = new Barco(colTempPosBarco);
                colBarcos.add(objB); 
                posicionesOcupadas(colTempPosBarco);
         }
         else{
            throw new PosicionNoValida ("Posición no válida.");
         }
    }
    
    /*posicionesOcupadas recibe una colección de posiciones y les pone el 
     setOcupadas a verdadero*/
    public void posicionesOcupadas(HashMap colPosBarco){
        for (Object oKey : colPosBarco.keySet()) {
            String key = (String) oKey;
            colPosiciones.get(key).setOcupada(true);
        }  
    }
    
    /*devolverBarco recibe una Posición, recorre la colección de Barcos de la 
     Flota y devuelve el Barco que contenga dicha Posición.*/
     public Barco devolverBarco (Posicion objP){
         for (Barco objB : colBarcos){
             for (Posicion objPB : objB.getColPosB().values()){
                 if (objPB == objP){
                    return objB;
                }
             }
         }
         return null;
    }
    
    /*Recorre su colección de Barcos y si todos están destruidos devuelve 
     verdadero, sino falso.*/
    public boolean verificarEstoyDestruida(){
        int contador = 0;
        for (Barco objB : colBarcos){
            if (objB.estoyDestruido()){
                contador++;
            }
        }
        if (contador == colBarcos.size()){
            return true;
        }
        return false;
    } 
    
    /*barcoAlcanzado recibe una Posición y recorre la colección de Barcos de
     la Flota devolviendo verdadero si conicide con alguna de las posiciones
     del Barco, sino devuelve falso.*/
    public boolean barcoAlcanzado (Posicion xobjP){
        for (Barco objB : colBarcos){
            for (Posicion objPB : objB.getColPosB().values()){
                if (objPB == xobjP){
                    return true;
                }
            }
        }
        return false;
    }
    
    /*nuevoBarcoDestruido recibe un entero, recorre la colección de Barcos
     preguntando si están destruidos, guarando el resultado en un contador.
     luego pregunta si esa cantidad es igual al valor pasado por parámetro,
     si lo es, aumenta en uno su atributo cantBarDestruidos, que se inicializó
     en cero al generarse la Flota, y devuelve verdadero, sino falso. */
    public boolean nuevoBarcoDestruido(int cant){
        int contador = 0;
        for (Barco objB : colBarcos){
            if (objB.isDestruido()){
                contador++;
            }
        }
        if (contador == cant){
            cantBarDestruidos++;
            return true;
        }
        return false;
    }
    
    /*******************************************  DEFENSA **************************/
    
    private int disparo = 0;

    public int getDisparo() {
        return disparo;
    }
    public void setDisparo(int disparo) {
        this.disparo = disparo;
    }
    
    public void disparo(){
        this.disparo++;
    }
    
    
    
    
    
    
    
}