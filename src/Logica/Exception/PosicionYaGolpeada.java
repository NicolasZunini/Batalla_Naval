/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Exception;

/**
 *
 * @author Usuario
 */
public class PosicionYaGolpeada extends Exception{
    public PosicionYaGolpeada() {
    }
    
    public PosicionYaGolpeada(String message) {
        super("La Posición ya fue golpeada.");
    }
}
