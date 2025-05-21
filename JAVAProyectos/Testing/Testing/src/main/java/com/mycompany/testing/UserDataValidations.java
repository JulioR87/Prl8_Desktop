/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testing;

/**
 *
 * @author julioarrtor
 */
public class UserDataValidations {
    
    /**
     * Debe validar si el documento idneficativo recibido es correcto o no. 
     * @param typeDoc indica el tipo de documento identidicativo (NIF - 1,....)
     * @param id  contiene el documento identificativo a validar
     * @return devuelve true si el formato del documento es correcto y false en caso contrario
     */
    public static boolean checkId (int typeDoc, String id){//el boolean sirve para devolver true o false
       
        //Verificamos que el número de documento sea 1(NIF)
        
        if(typeDoc !=1){//Si(if) el tipo no(!) es igual a 1 retorna falso
        return false;    
        }
        
        //Validamos si el NIF contiene 9 caracteres
        if(id == null || id.length() !=9 ){ //si el NIF no contiene lo 9 digitos es falso → ||→(ò) legnht()→es la longitud total del NIF
            return false;
        }
        
        //Se separa los 8 primeros caracteres (que son numeros) y el ultimo (que es letra)
        String numbersPart = id.substring(0,8);
        char letterPart = id.charAt(8);
        
        //Validacion de los 8 primeros caracteres sean digitos
        //\d{8}=8 numeros seguidos
        
        if(!numbersPart.matches("\\d{8}")){
            return false;
        }
        // Se calcula la letra correcta
        String validLetters = "TRWAGMYFPDXBNJZSQVHLCKE";
        int number = Integer.parseInt(numbersPart);//Integer.parseInt sirve para convertir el texto en numeros
        char correctLetter = validLetters.charAt(number % 23);
 
        // Comprobar si la letra proporcionada es la correcta y coincide con la calculada
        return letterPart == correctLetter;
        
        
    }
    /**
     * Debe validar que el formato de la fecha y su valor es correcto
     * @param date Ingrese la fecha a validar
     * @return devolver true si los datos son correctos y false sin son incorrectos
     */
    public static boolean checkFormatDate(String date){
       
        // Usamos split para separar la fecha en día, mes y año
        String[] parts = date.split("/");

        // Verificamos si hay exactamente 3 partes (día, mes, año)
        if (parts.length != 3) {
            return false;
        }

        try {//sirve para encerrar el codigo que pueda generar un error
            // Convertimos día, mes y año a enteros
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);

            // Verificamos que el mes esté entre 1 y 12
            if (month < 1 || month > 12) {
                return false;
            }

            // Verificamos que el día sea válido para el mes y año dados
            int maxDay = getMaxDayForMonth(month, year);
            if (day < 1 || day > maxDay) {
                return false;
            }

        } catch (NumberFormatException e) {//el catch ejecuta en caso ocurra una excepcion o error en el bloque try, captura el error y evita que el programa se detenga 
            // Si alguna parte no es un número, retorna false //el "e" es una variable que contiene informacion sobre el error capturado.
            return false;
        }

        return true;
    }
    

    // Función auxiliar para obtener el número máximo de días de un mes
    private static int getMaxDayForMonth(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                // Año bisiesto
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return 0;
        }
    }

    // Método principal para probar la función
    public static void main(String[] args) {
        System.out.println(checkFormatDate("29/02/2020")); // true (año bisiesto)
        System.out.println(checkFormatDate("31/04/2021")); // false (abril tiene 30 días)
        System.out.println(checkFormatDate("12/12/2021")); // true (fecha válida)
    }
    
    /**
     * Debe calcular la edad en base a la fecha de nacimiento
     * @param birthDate
     * @return Devolver la edad calculada en caso los datos sean correctos, caso contrario retornara invalid date
     */
     // 3. Calcular la edad
    public static int calculateAge(String birthDate) {
        if (!checkFormatDate(birthDate)) {
            return -1; // Fecha inválida
        }

        String[] parts = birthDate.split("/"); // Dividimos la fecha
        int birthYear = Integer.parseInt(parts[2]);
        int birthMonth = Integer.parseInt(parts[1]);
        int birthDay = Integer.parseInt(parts[0]);

        int currentYear = 2025; // Año actual (simulado)
        int currentMonth = 1;  // Mes actual
        int currentDay = 27;   // Día actual

        int age = currentYear - birthYear;

        // Ajustar la edad si no ha pasado el cumpleaños este año
        if (birthMonth > currentMonth || (birthMonth == currentMonth && birthDay > currentDay)) {
            age--;
        }

        return age;
    }
    
    /**
     * Validad que el formato del codigo postal sea el correcto
     * @param zip
     * @return  Si los datos son correctos retornara true, caso contario contrario es false
     */

    // 4. Validar código postal
    public static boolean checkPostalCode(String zip) {
        // Validamos que tenga 5 caracteres y que sean números
        return zip.length() == 5 && isNumeric(zip);
    }
    
    /**
     * Validar que el contenido del String es numerico
     * @param str
     * @return si los datos son correctos devolvera true, caso contrario false
     */

    // 5. Verificar si un String es numérico
    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false; // No puede ser nulo o vacío
        }

        for (char c : str.toCharArray()) { // Recorremos cada carácter
            if (!Character.isDigit(c)) { // Si no es un dígito, no es numérico
                return false;
            }
        }

        return true; // Todos los caracteres son dígitos
    }
    
    /**
     * Validar que el contenido del String solo contenga letras
     * @param str
     * @return Si es correcto devolvera true, caso contrario false
     */

    // 6. Verificar si un String solo tiene letras
    public static boolean isAlphabetic(String str) {
        if (str == null || str.isEmpty()) {
            return false; // No puede ser nulo o vacío
        }

        for (char c : str.toCharArray()) { // Recorremos cada carácter
            if (!Character.isLetter(c)) { // Si no es una letra, no es alfabético
                return false;
            }
        }

        return true; // Todos los caracteres son letras
    }
    
    /**
     * Validar que el formato del correo se corresponde a un correo electronico
     * @param email
     * @return si es correcto devolvera true, caso contrario false
     */
    public static boolean checkEmail(String email) {
        if (email == null || !email.contains("@")) {
            return false;
        }

        String[] parts = email.split("@");
        if (parts.length != 2) {
            return false;
        }

        String domain = parts[1];
        if (!domain.contains(".")) {
            return false;
        }

        String[] domainParts = domain.split("\\.");
        String extension = domainParts[domainParts.length - 1];
        if (extension.length() < 2 || extension.length() > 3) {
            return false;
        }

        return true;
    }
    
    /**
     * Validar que el nombre tiene una longitud logica que contenga numeros
     * @param name
     * @return Si es correcto devolvera true, caso contario false
     */

    public static boolean checkName(String name) {
        if (name == null || name.isEmpty()) {
            return false;
        }

        if (name.length() < 2 || name.length() > 50) {
            return false;
        }

        for (char c : name.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }

        return true;
    }

}

    

