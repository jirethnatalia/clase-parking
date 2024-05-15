
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
            throw new ParkingException("Matricula repetida",matricula);
        matriculas.set(posicion,matricula);
        
    }
    
    public int salida(String matricula)throws ParkingException{
        if(matriculas.contains(matricula))
            throw new ParkingException("Matricula no existente",matricula);
        int posicion=matriculas.indexOf(matricula);
        matriculas.set(posicion, null);
        return posicion;
    }
    
    public int getPosicionesTotales(){
        return matriculas.size();
    }
    
    public int getPosicionesLibres(){
        return Collections.frequency(matriculas, null);
    }
    
    public int getPosicionesOcupadas(){
        return getPosicionesTotales() -getPosicionesLibres();
    }

    @Override
    public String toString() {
        String cadena = "Parking " +nombre+"\n";
        cadena +="------------------\n";
        
    }
    
    

    private static class ParkingException extends Exception {

        public ParkingException(String posicion_Inexistente, String matricula) {
        }
    }
    
    
    
}
