package org.iesalandalus.programacion.ejerciciostemaarrays.expresionesregulares;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// PREGUNTAR AL PROFESOR SI EL USO DE \\b PARA PATRONES ES VALIDO
public class CuentaPalabras {
    public static void main(String[] args) {
        String frase;
        String[] arrayPalabras;
        frase = pedirFrase();
        arrayPalabras = calcularCantidadPalabrasFrase(frase);
        mostrarResultados(arrayPalabras);
    }

    private static String pedirFrase() {
        String frase;
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
        do {
            System.out.print("Escriba una frase y le dire cuantas palabras componen la frase escrita(una palabra se distingue por espacios en blanco que la separan de otras palabras): ");
            frase = Entrada.cadena();
        } while (frase.equals(""));
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------");
        return frase;
    }

    private static String[] calcularCantidadPalabrasFrase(String frase) {
        String[] arrayPalabras = new String[1];
        Pattern patron = Pattern.compile("\\b[a-zA-z]+\\b");
        Matcher comparador = patron.matcher(frase);
        int contador = 0;
        while (comparador.find()) {
            arrayPalabras[contador++] = comparador.group();
            arrayPalabras = Arrays.copyOf(arrayPalabras, (contador + 1));
        }
        if (arrayPalabras.length != 1) {
            arrayPalabras = Arrays.copyOf(arrayPalabras, (contador));
        }

        return arrayPalabras;
    }

    private static void mostrarResultados(String[] arrayPalabras) {
        if (arrayPalabras.length == 1) {
            System.out.println("No se ha encontrado ninguna palabra en la frase escrita. ");
        } else {
            System.out.println("Se han encontrado un total de " + arrayPalabras.length + " palabras dentro de la frase escrita. Esas palabras son las siguientes: ");
            for (int i = 0; i < arrayPalabras.length; i++) {
                if (i == (arrayPalabras.length - 1)) {
                    System.out.print("'" + arrayPalabras[i] + "'" + ".");
                } else {
                    System.out.print("'" + arrayPalabras[i] + "'" + ", ");
                }
            }
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
}
