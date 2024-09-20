package org.iesalandalus.programacion.ejerciciostemaarrays.expresionesregulares;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CuentaVocales {
    public static void main(String[] args) {
        String frase;
        int cantidadVocales;
        frase = pedirFrase();
        cantidadVocales = calcularCantidadVocalesFrase(frase);
        mostrarResultados(cantidadVocales);
    }

    private static String pedirFrase() {
        String frase;
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
        do {
            System.out.print("Escriba una frase y le dire cuantas vocales contiene la frase escrita: ");
            frase = Entrada.cadena();
        } while (frase.equals(""));
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
        return frase;
    }

    private static int calcularCantidadVocalesFrase(String frase) {
        Pattern patron = Pattern.compile("(a|e|i|o|u|á|é|í|ó|ú)");
        Matcher comparador = patron.matcher(frase.toLowerCase(Locale.ROOT));
        int numVocales = 0;
        while (comparador.find()) {
            numVocales++;
        }
        return numVocales;
    }

    private static void mostrarResultados(int numVocales) {
        if (numVocales == 0) {
            System.out.println("No se ha encontrado ninguna vocal en la frase escrita. ");
        } else {
            System.out.println("Se han encontrado un total de " + numVocales + " vocales contenidas en la frase escrita. ");
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
