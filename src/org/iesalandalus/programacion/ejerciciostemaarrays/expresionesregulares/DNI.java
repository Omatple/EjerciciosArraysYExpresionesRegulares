package org.iesalandalus.programacion.ejerciciostemaarrays.expresionesregulares;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DNI {
    public static void main(String[] args) {
        String DNI = " ERROR. Si se esta mostrando este mensaje, algo ha salido mal en el codigo. ";
        boolean valido = false;
        System.out.println("-----------------------------------------------------------");
        while (!valido) {
            try {
                DNI = pedirDNI();
                validadorDNI(DNI);
                valido = true;
            } catch (IllegalArgumentException e) {
                System.out.println(" ERROR. Intentelo de nuevo. ");
            }
        }
        System.out.println("-----------------------------------------------------------");
        mostrarDigitosDNIyLetra(DNI);
        System.out.println("-----------------------------------------------------------");
    }

    private static String pedirDNI() {
        String DNI;
        System.out.print("Escriba su DNI incluyendo los numero y la letra final: ");
        DNI = Entrada.cadena();
        return DNI;
    }

    private static void validadorDNI(String DNI) {
        Pattern patron = Pattern.compile("^\\d{8}[A-Z]$");
        Matcher comparador = patron.matcher(DNI);
        if (!comparador.matches()) {
            throw new IllegalArgumentException("El patron del DNI es incorrecto.\nRecuerde que debe estar formado por 8 digitos iniciales y termina en una letra mayuscula");
        }
    }

    private static void mostrarDigitosDNIyLetra(String DNI) {
        System.out.println("Los 8 digitos de su DNI son: " + String.format(DNI.substring(0, 8)));
        System.out.println("La letra de su DNI es: " + String.format(DNI.substring(DNI.length() - 1)));
    }
}
