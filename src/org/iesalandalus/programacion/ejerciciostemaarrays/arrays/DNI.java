package org.iesalandalus.programacion.ejerciciostemaarrays.arrays;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DNI {
    public static void main(String[] args) {
        int dni;
        dni = recogerDNI();
        System.out.println("Su dni completo incluyendo la letra al final de este es: " + mostrarDNICompleto(dni));
    }

    private static int recogerDNI() {
        String dni;
        Pattern patron = Pattern.compile("\\d{8}");
        Matcher comparador;
        do {
            System.out.print("Escriba unicamente los 8 numeros de su DNI, y le dire que letra le corresponde a su DNI: ");
            dni = Entrada.cadena();
            comparador = patron.matcher(dni);
        } while (!comparador.matches());
        int numDNI = Integer.parseInt(dni);
        return numDNI;
    }

    private static StringBuilder mostrarDNICompleto(int dni) {
        int restoDNI;
        restoDNI = dni % 23;
        StringBuilder dniCompleto = new StringBuilder();
        dniCompleto.append(dni);
        String letrasDNI = "TRWAGMYFPDXBNJZSQVHLCKE";
        dniCompleto.append(letrasDNI.charAt(restoDNI));
        return dniCompleto;
    }
}
