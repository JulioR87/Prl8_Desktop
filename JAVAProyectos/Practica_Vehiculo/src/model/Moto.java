/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author julioarrtor
 */
public class Moto extends Vehiculo {
    private String sidecar;
    static final double MAX_SPEED = 200;
    
    
     // CONSTRUCTOR SIN PARAMETROS
    public Moto(){
        super();
         
    }
    // CONSTRUCTOR CON PARAMETROS
    public Moto(String marca, String matricula, String modelo, double potencia, ColorEnum color, MotorEnum motorEnum, String motor, String tipoRueda, String fechaFabricacion, String sidecar, float velocidad) {
        super(marca, matricula, modelo, potencia, color, motorEnum, motor, tipoRueda, fechaFabricacion, velocidad);
        this.sidecar = sidecar;     
    }

    // GETTERs & SETTERs → click derecho insert code getters and setters y generar

    public String getSidecar() {
        return sidecar;
    }

    public void setSidecar(String sidecar) {
        this.sidecar = sidecar;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\nMoto:");
        sb.append("\nSidecar: ").append((sidecar != null && !sidecar.isEmpty()) ? "Sí" : "No");
        return sb.toString();
    }
}
