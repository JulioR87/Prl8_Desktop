/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author julioarrtor
 */
public class Camion extends Vehiculo{
    
    //CREAMOS LOS 2 ATRIBUTOS 
    private int numPuertas;
    static final double MAX_SPEED = 200;
    
    //CONSTRUCTOR SIN PARAMETROS
    public Camion(){
        super();
    }
    
    // CONSTRUCTOR CON PARAMETROS
    public Camion(String marca, String matricula, String modelo, double potencia, ColorEnum color, MotorEnum motorEnum, String motor, String tipoRueda, String fechaFabricacion, int numeroPuertas, float velocidad) {
        super(marca, matricula, modelo, potencia, color, motorEnum, motor, tipoRueda, fechaFabricacion, velocidad);
        this.numPuertas = numeroPuertas;     
    }

    // CREAMOS LOS GETTERs Y SETTERs 
    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\nTipo: Camión");
        sb.append("\nNúmero de puertas: ").append(numPuertas);
        return sb.toString();
    }  
}
