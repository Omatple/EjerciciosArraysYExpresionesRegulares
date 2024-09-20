package org.iesalandalus.programacion.ejerciciostemaarrays.arrays;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;

public class MayoryMenor {
    public static void main(String[] args) {
        int numeroCreacion = 0;
        int[] arrayNumeroAleatorios;
        System.out.println("---------------------------------------------------------------------");
        while (true) {
            try {
                numeroCreacion = pedirNumerosAGenerar();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR. Intentelo de nuevo: ");
            }
        }
        System.out.println("---------------------------------------------------------------------");
        arrayNumeroAleatorios = crearArrayNumeros(numeroCreacion);
        mostrarMayorMenorYPosicion(arrayNumeroAleatorios);
        System.out.println("---------------------------------------------------------------------");
    }

    private static int pedirNumerosAGenerar() {
        System.out.print("Escriba a continuación el numero de enteros a generar(minimo 2): ");
        int numero = Entrada.entero();
        if (numero < 2) {
            throw new IllegalArgumentException("El numero introducido es invalido, intentelo de nuevo.");
        }
        return numero;
    }

    private static int[] crearArrayNumeros(int tamañoArray) {
        Random generador = new Random();
        int[] arrayNumeros = new int[tamañoArray];
        for (int i = 0; i < arrayNumeros.length; i++) {
            arrayNumeros[i] = generador.nextInt(1000);
        }
        return arrayNumeros;
    }

    private static void mostrarMayorMenorYPosicion(int[] arrayNumerosAleatorios) {
        int[][] numeroMayor = new int[arrayNumerosAleatorios.length][arrayNumerosAleatorios.length];
        int[][] numeroMenor = new int[arrayNumerosAleatorios.length][arrayNumerosAleatorios.length];
        int auxiliar = 0;
        int contador = 0;
        for (int i = 0; i < arrayNumerosAleatorios.length; i++) {
            if (auxiliar <= arrayNumerosAleatorios[i]) {
                auxiliar = arrayNumerosAleatorios[i];
            }
        }
        for (int i = 0; i < arrayNumerosAleatorios.length; i++) {
            if (auxiliar == arrayNumerosAleatorios[i]) {
                numeroMayor[0][contador] = arrayNumerosAleatorios[i];
                numeroMayor[1][contador] = i;
                contador++;
            }
        }
        Arrays.copyOf(numeroMayor, contador);
        StringBuffer stringNumerosMayores = new StringBuffer();
        if (contador == 1) {
            System.out.println("El numero mayor de todos los aleatorios dentro del array es el " + numeroMayor[0][0] + " y su posicion dentro del array es la posición " + numeroMayor[1][0]);
        } else {
            for (int i = 0; i < contador; i++) {
                if (i == (contador - 2)) {
                    stringNumerosMayores.append(numeroMayor[1][i] + " y ");
                } else if (i == (contador - 1)) {
                    stringNumerosMayores.append(numeroMayor[1][i]);
                } else {
                    stringNumerosMayores.append(numeroMayor[1][i] + ", ");
                }
            }
            System.out.println("El numero mayor de todos los aleatorios dentro del array es el " + numeroMayor[0][0] + " y se repite en varias posiciones del array. Se repite en las siguientes posiciones: ");
            System.out.println("En la posición " + stringNumerosMayores);
        }
        auxiliar = 1000;
        contador = 0;
        for (int i = 0; i < arrayNumerosAleatorios.length; i++) {
            if (auxiliar >= arrayNumerosAleatorios[i]) {
                auxiliar = arrayNumerosAleatorios[i];
            }
        }
        for (int i = 0; i < arrayNumerosAleatorios.length; i++) {
            if (auxiliar == arrayNumerosAleatorios[i]) {
                numeroMenor[0][contador] = arrayNumerosAleatorios[i];
                numeroMenor[1][contador] = i;
                contador++;
            }
        }
        Arrays.copyOf(numeroMenor, contador);
        StringBuffer stringNumerosMenores = new StringBuffer();
        if (contador == 1) {
            System.out.println("El numero menor de todos los aleatorios dentro del array es el " + numeroMenor[0][0] + " y su posicion dentro del array es la posición " + numeroMenor[1][0]);
        } else {
            for (int i = 0; i < contador; i++) {
                if (i == (contador - 2)) {
                    stringNumerosMenores.append(numeroMenor[1][i] + " y ");
                } else if (i == (contador - 1)) {
                    stringNumerosMenores.append(numeroMenor[1][i]);
                } else {
                    stringNumerosMenores.append(numeroMenor[1][i] + ", ");
                }
            }
            System.out.println("El numero menor de todos los aleatorios dentro del array es el " + numeroMenor[0][0] + " y se repite en varias posiciones del array. Se repite en las siguientes posiciones: ");
            System.out.println("En la posición " + stringNumerosMenores);
        }
    }
}
