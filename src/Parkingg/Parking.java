
package Parkingg;

import java.util.ArrayList;
import java.util.Collections;


public class Parking {
    
    private ArrayList<String> matriculas;
    private String nombre;

    public Parking(String nombre,int posicion) {
        this.nombre = nombre;
        matriculas = new ArrayList<>(Collections.nCopies(posicion, null));
    }

    public String getNombre() {
        return nombre;
    }
    
    public void entrada(String matricula,int posicion) throws ParkingException{
        if(posicion>=matriculas.size() || posicion <0)
            throw new ParkingException("Posicion Inexistente",matricula);
        if(matricula==null || matricula.length()<4)
            throw new ParkingException("Matricula Incorrecta", matricula);
        if(matriculas.get(posicion)!=null)
            throw new ParkingException("Posicion ocupada",matricula);
        if(matriculas.contains(matricula))
        matriculas.set(posicion,matricula);
        
    }

    private static class ParkingException extends Exception {

        public ParkingException(String posicion_Inexistente, String matricula) {
        }
    }
    
    
    
}
