/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package view.console;

import java.util.*;
import java.util.Scanner;
import model.Camion;
import model.Coche;
import model.Moto;
import model.ColorEnum;
import model.MotorEnum;
import model.Vehiculo;


/**
 *
 * @author julioarrtor
 */
public class Main {

    static List<Vehiculo> vehiculos = new ArrayList<>();
    static int totalCoches = 0, totalMotos = 0, totalCamiones = 0;
    static Scanner scanner = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

    
     int opcion;
        do {
            System.out.println("\nMenú de Opciones:");
            System.out.println("1. Crear Coche");
            System.out.println("2. Crear Moto");
            System.out.println("3. Crear Camion");
            System.out.println("4. Mostrar matrículas");
            System.out.println("5. Buscar vehículo por matrícula");
            System.out.println("6. Mostrar total de vehículos");
            System.out.println("7. Mostrar total de coches");
            System.out.println("8. Mostrar total de motos");
            System.out.println("9. Mostrar total de Camiones");
            System.out.println("10. Eliminar vehículo por matrícula");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1: crearCoche(); break;
                case 2: crearMoto(); break;
                case 3: crearCamion(); break;
                case 4: mostrarMatriculas(); break;
                case 5: buscarVehiculo(); break;
                case 6: System.out.println("Total de vehículos: " + vehiculos.size()); break;
                case 7: System.out.println("Total de coches: " + totalCoches); break;
                case 8: System.out.println("Total de motos: " + totalMotos); break;
                case 9: System.out.println("Total de Camiones: " + totalCamiones); break;
                case 10: eliminarVehiculo(); break;
                case 0: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    static void crearCoche() {
        System.out.print("Ingrese marca del coche: ");
        String marca = scanner.nextLine();
        System.out.print("Ingrese matrícula del coche: ");
        String matricula = scanner.nextLine();
        System.out.print("Ingrese modelo del coche: ");
        String modelo = scanner.nextLine();
        System.out.print("Ingrese número de puertas: ");
        int numPuertas = scanner.nextInt();
        scanner.nextLine();
        ColorEnum color = seleccionarColor();
        MotorEnum motor = seleccionarMotor();
        
        //CREAR EL COCHE Y AÑADIRLO A LA LISTA
        vehiculos.add(new Coche(marca, matricula, modelo, 120, color, motor, "Motor", "Rueda", "2023", numPuertas, 180));
        totalCoches++;
        System.out.println("Coche creado exitosamente.");
        
        //IMPRIMIR LOS VEHICULOS GUARDADOS
        System.out.println("Vehículos guardados en la lista:");
        for (Vehiculo v : vehiculos) { 
            System.out.println(v); 
        }
    }

    static void crearMoto() {
        System.out.print("Ingrese marca de la moto: ");
        String marca = scanner.nextLine();
        System.out.print("Ingrese matrícula de la moto: ");
        String matricula = scanner.nextLine();
        System.out.print("Ingrese modelo de la moto: ");
        String modelo = scanner.nextLine();
        System.out.print("¿Tiene sidecar? (Sí/No): ");
        String sidecar = scanner.nextLine();
        ColorEnum color = seleccionarColor();
        MotorEnum motor = seleccionarMotor();
        
        vehiculos.add(new Moto(marca, matricula, modelo, 100, color, motor, "Motor", "Rueda", "2023", sidecar, 150));
        totalMotos++;
        System.out.println("Moto creada exitosamente.");
        
        // Imprimir todos los vehículos guardados
        System.out.println("Vehículos guardados en la lista:");
        for (Vehiculo v : vehiculos) { 
            System.out.println(v); 
        }
    }

    static void crearCamion() {
        System.out.print("Ingrese marca del Camion: ");
        String marca = scanner.nextLine();
        System.out.print("Ingrese matrícula del Camion: ");
        String matricula = scanner.nextLine();
        System.out.print("Ingrese modelo del Camion: ");
        String modelo = scanner.nextLine();
        System.out.print("Ingrese número de puertas: ");
        int numPuertas = scanner.nextInt();
        scanner.nextLine();
        ColorEnum color = seleccionarColor();
        MotorEnum motor = seleccionarMotor();
        
        vehiculos.add(new Camion(marca, matricula, modelo, 300, color, motor, "Motor", "Rueda", "2023", numPuertas, 120));
        totalCamiones++;
        System.out.println("Camion creado exitosamente.");
        
        // Imprimir todos los vehículos guardados
        System.out.println("Vehículos guardados en la lista:");
        for (Vehiculo v : vehiculos) { 
            System.out.println(v); 
        }
    }

    static void mostrarMatriculas() {
        System.out.println("Matrículas de vehículos:");
        for (Vehiculo v : vehiculos) { //recorremos cada objeto de la lista vehiculos 
            System.out.println(v.getMatricula()); //→ accedemos y mostramos la matricula
        }
    }

    static void buscarVehiculo() {
        System.out.print("Ingrese matrícula a buscar: ");
        String matriculaBuscada = scanner.nextLine().trim(); // con el trim eliminamos espacios para la busqueda

        for (Vehiculo v : vehiculos) {
            if (v.getMatricula().trim().equalsIgnoreCase(matriculaBuscada)) {
                System.out.println(v);
                return;
            }
        }
        System.out.println("Vehículo no encontrado.");
    }
    
    static void eliminarVehiculo() { //→ Creamos el metodo estatico, no devuelve ningun valor por lo que es tipo void
        System.out.print("Ingrese matrícula del vehículo a eliminar: "); //→ impresion en pantalla
        String matricula = scanner.nextLine(); //→ Usuario ingresa los datos mediante el scanner.nextLine
        Iterator<Vehiculo> iter = vehiculos.iterator(); //→ creamos la variable iter de tipo iterator<Vehiculo> el cual se recorrera mediante el iterator. Se recorrera uno por uno de la lista vehiculos
        while (iter.hasNext()) { //→ Creamos el bucle while y mediante el iter.hasNext() verificamos si hay mas elementos por recorrer de la coleccion, es decir si aun hay mas vehiculos.
            Vehiculo v = iter.next(); //→ Creamos la variable v que es de tipo vehiculo, donde se guardara el vehiculo despues de la iteracion
            if (v.getMatricula().equals(matricula)) { //→ con este bucle se verifica si la matricula encontrada coincide mediante el equals con la matricula ingresada por el usuario 
                iter.remove(); //→ si en caso coincide se procede a la eliminacion
                if (v instanceof Coche) totalCoches--; //→ mediante el instanceof verificamos el tipo de vehiculo, comprobamos si es de tipo coche, si es correcto se disminuye la cantidad de coches
                else if (v instanceof Moto) totalMotos--; //→ si en caso no es coche, verificamos si es moto, si es moto disminuimos la cantidad de motos
                else if (v instanceof Camion) totalCamiones--;//→ si en caso no es moto, verificamos si es camion, si es moto disminuimos la cantidad de camiones
                System.out.println("Vehículo eliminado."); // → una vez eliminado el vehiculo de la coleccion y se haya actualizado la cantidad, se impreme el mensaje
                return;
            }
        }
        System.out.println("Vehículo no encontrado.");
    }
    
    static ColorEnum seleccionarColor() {
        System.out.println("Seleccione un color:");
        for (ColorEnum color : ColorEnum.values()) {
            System.out.println(color.ordinal() + ". " + color);
        }
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return ColorEnum.values()[opcion];
    }

    static MotorEnum seleccionarMotor() {
        System.out.println("Seleccione un tipo de motor:");
        for (MotorEnum motor : MotorEnum.values()) {
            System.out.println(motor.ordinal() + ". " + motor);
        }
        int opcion = scanner.nextInt();
        scanner.nextLine();
        return MotorEnum.values()[opcion];
    }
    
}
