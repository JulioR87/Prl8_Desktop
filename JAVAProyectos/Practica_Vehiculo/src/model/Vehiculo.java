/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;

/**
 *
 * @author julioarrtor
 */
public class Vehiculo {
    
   
    //CREAMOS LOS ATRIBUTOS DE LOS VEHICULOS
    private String marca;
    private String matricula;
    private String modelo;
    private double potencia;
    private ColorEnum color;
    private MotorEnum motorEnum;
    private String motor;
    private String tipoRueda;
    private String fechaFabricacion; 
    private float velocidadActual = 0;
    
    
    //Constructor sin parametros
    public Vehiculo(){
        
    }
    
    public Vehiculo(String marca, String matricula, String modelo, double potencia, ColorEnum color, MotorEnum motorEnum, String motor, String tipoRueda, String fechaFabricacion, float velocidadActual) {
        this.marca = marca;
        this.matricula = matricula;
        this.modelo = modelo;
        this.potencia = potencia;
        this.color = color;
        this.motorEnum = motorEnum;
        this.motor = motor;
        this.tipoRueda = tipoRueda;
        this.fechaFabricacion = fechaFabricacion;
        this.velocidadActual = velocidadActual;

    }
    
    public Vehiculo(String marca, String modelo, double potencia, String motor, String tipoRueda) {
        this.marca = marca;
        this.modelo = modelo;
        this.potencia = potencia;
        this.motor = motor;
        this.tipoRueda = tipoRueda;

    }
    
    //CREAMOS LOS SETTERs Y GETTERs

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPotencia() {
        return potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public ColorEnum getColor() {
        return color;
    }

    public void setColor(ColorEnum color) {
        this.color = color;
    }

    public MotorEnum getMotorEnum() {
        return motorEnum;
    }

    public void setMotorEnum(MotorEnum motorEnum) {
        this.motorEnum = motorEnum;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getTipoRueda() {
        return tipoRueda;
    }

    public void setTipoRueda(String tipoRueda) {
        this.tipoRueda = tipoRueda;
    }

    public String getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(String fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public float getVelocidadActual() {
        return velocidadActual;
    }

    public void setVelocidadActual(float velocidadActual) {
        this.velocidadActual = velocidadActual;
    }
    
    //METODOS AUXILIARES PARA LAS FORMULAS
    
    //METODO PARA CALCULAR LA ANTIGUEDAD
    public int calcularAntiguedad() {
        if (fechaFabricacion == null || fechaFabricacion.isEmpty()) {
            return 0; // Si no hay fecha, devuelve 0
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fecha = LocalDate.parse(fechaFabricacion, formatter);
            return Period.between(fecha, LocalDate.now()).getYears();
        } catch (Exception e) {
            System.out.println("Error: Formato de fecha inválido. Debe ser dd/MM/yyyy");
            return -1;
        }
    }
        
    public void acelerar() {
        velocidadActual += 10;
        System.out.println("El coche ha acelerado. Velocidad actual: " + velocidadActual + " km/h");
    }

    public void frenar() {
        if (velocidadActual > 0) {
            velocidadActual -= 10;
            System.out.println("El coche ha frenado. Velocidad actual: " + velocidadActual + " km/h");
        } else {
            System.out.println("El coche ya está detenido.");
        }
    }
    
    //METODO PARA ACELERAR CON UNA CANTIDAD ESPECIFICA
    public void acelerar(float cantidad) {
        if (cantidad > 0) {
            velocidadActual += cantidad;
            System.out.println("El coche ha acelerado " + cantidad + " km/h. Velocidad actual: " + velocidadActual + " km/h");
        } else {
            System.out.println("Ingrese una cantidad válida para acelerar.");
        }
    }
    
    //METODO PARA FRENAR CON UNA CANTIDAD ESPECIFICA
        public void frenar(float cantidad) {
        if (cantidad > 0 && velocidadActual - cantidad >= 0) {
            velocidadActual -= cantidad;
            System.out.println("El coche ha frenado " + cantidad + " km/h. Velocidad actual: " + velocidadActual + " km/h");
        } else if (velocidadActual - cantidad < 0) {
            velocidadActual = 0;
            System.out.println("El coche se ha detenido por completo.");
        } else {
            System.out.println("Ingrese una cantidad válida para frenar.");
        }
    }
        
    //TOSTRING
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Coche{");
        sb.append("marca=").append(marca);
        sb.append(", matricula=").append(matricula);
        sb.append(", modelo=").append(modelo);
        sb.append(", potencia=").append(potencia);
        sb.append(", color=").append(color);
        sb.append(", motorEnum=").append(motorEnum);
        sb.append(", motor=").append(motor);
        sb.append(", tipoRueda=").append(tipoRueda);
        sb.append(", fechaFabricacion=").append(fechaFabricacion);
        sb.append(", velcoidadActual=").append(velocidadActual);

        sb.append('}');
        return sb.toString();
    }

}
