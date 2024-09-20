package org.iesalandalus.programacion.ejerciciostemaarrays.arrays;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.util.Arrays;
import java.util.Random;

public class Media {
    public static void main(String[] args) {
        int numeroCreacion;
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
        System.out.print("Escriba a continuación el numero de enteros a generar(minimo 3): ");
        int numero = Entrada.entero();
        if (numero < 3) {
            throw new IllegalArgumentException("El numero introducido es invalido, intentelo de nuevo.");
        }
        return numero;
    }

    private static int[] crearArrayNumeros(int tamañoArray) {
        Random generador = new Random();
        int[] arrayNumeros = new int[tamañoArray];
        for (int i = 0; i < arrayNumeros.length; i++) {
            arrayNumeros[i] = generador.nextInt(100);
        }
        return arrayNumeros;
    }

    //En el metodo mostrarMediaIgualesMayorMenorYPosicion() he cometido el error de meter en el mismo metodo
    //sacar la media, mostrar iguales, mostrar mayores, menores y posicion. Cuando deberia haberlo aislado en
    //varios metodos, por el simple hecho de que el que lea el codigo lo vea mas nitido todo ademas de que si
    // se debe arreglar algo del codigo se haga mas sencillo al tenerlo todo particionado o si quisiese coger
    // una parte del codigo tambien es malo ya que lo tengo todo mezclado y tendria que hacer si o si cambios
    // debo acostumbrarme a hacerlo ya que es un buen habito y que a futuros seguro que me beneficia a mi y al
    // los que lean mi codigo y trabajen con el. Este de todas formas ya lo dejare asi, por no molestarme.
    private static void mostrarMayorMenorYPosicion(int[] arrayNumerosAleatorios) {
        int[][] numeroPorEncima = new int[arrayNumerosAleatorios.length][arrayNumerosAleatorios.length];
        int[][] numeroIguales = new int[arrayNumerosAleatorios.length][arrayNumerosAleatorios.length];
        int[][] numeroPorDebajo = new int[arrayNumerosAleatorios.length][arrayNumerosAleatorios.length];
        int sumaTotal = 0;
        int mediaArray;
        int contador = 0;
        for (int i = 0; i < arrayNumerosAleatorios.length; i++) {
            sumaTotal += arrayNumerosAleatorios[i];
        }
        mediaArray = Math.round(sumaTotal / arrayNumerosAleatorios.length);
        System.out.println(" La media de todos los numeros del array es: " + mediaArray);
        for (int i = 0; i < arrayNumerosAleatorios.length; i++) {
            if (mediaArray == arrayNumerosAleatorios[i]) {
                numeroIguales[0][contador] = arrayNumerosAleatorios[i];
                numeroIguales[1][contador] = i;
                contador++;
            }
        }
        Arrays.copyOf(numeroIguales, contador);
        StringBuffer strngNumerosIguales = new StringBuffer();
        if (contador == 0) {
            System.out.println("No exite ningun numeros igual a la media en todo el array. ");
        } else if (contador == 1) {
            System.out.println("Solo hay un numero en el array igual a la media de todos ese numero es el " + numeroPorEncima[0][0] + " y su posicion dentro del array es la posición " + numeroPorEncima[1][0]);
        } else if (contador > 1) {
            for (int i = 0; i < contador; i++) {
                if (i == (contador - 2)) {
                    strngNumerosIguales.append(numeroIguales[1][i] + " y ");
                } else if (i == (contador - 1)) {
                    strngNumerosIguales.append(numeroIguales[1][i]);
                } else {
                    strngNumerosIguales.append(numeroIguales[1][i] + ", ");
                }
            }
            System.out.println("Hay un total de " + contador + " numeros iguales a la media de todo el array y se repite en varias posiciones del array. Las posiciones de estos numeros son las siguientes posiciones: ");
            System.out.println("En la posición " + strngNumerosIguales);
        }
        contador = 0;
        for (int i = 0; i < arrayNumerosAleatorios.length; i++) {
            if (mediaArray < arrayNumerosAleatorios[i]) {
                numeroPorEncima[0][contador] = arrayNumerosAleatorios[i];
                numeroPorEncima[1][contador] = i;
                contador++;
            }
        }
        Arrays.copyOf(numeroPorEncima, contador);
        StringBuffer stringNumerosPorEncima = new StringBuffer();
        if (contador == 0) {
            System.out.println("No exite ningun numeros por encima de la media en todo el array. ");
        } else if (contador == 1) {
            System.out.println("Solo hay un numero en el array por encima de la media de todos ese numero es el " + numeroPorEncima[0][0] + " y su posicion dentro del array es la posición " + numeroPorEncima[1][0]);
        } else if (contador > 1) {
            for (int i = 0; i < contador; i++) {
                if (i == (contador - 2)) {
                    stringNumerosPorEncima.append(numeroPorEncima[1][i] + " y ");
                } else if (i == (contador - 1)) {
                    stringNumerosPorEncima.append(numeroPorEncima[1][i]);
                } else {
                    stringNumerosPorEncima.append(numeroPorEncima[1][i] + ", ");
                }
            }
            System.out.println("Hay un total de " + contador + " numeros por encima de la media de todo el array y se repite en varias posiciones del array. Las posiciones de estos numeros son las siguientes posiciones: ");
            System.out.println("En la posición " + stringNumerosPorEncima);
        }
        contador = 0;
        for (int i = 0; i < arrayNumerosAleatorios.length; i++) {
            if (mediaArray > arrayNumerosAleatorios[i]) {
                numeroPorDebajo[0][contador] = arrayNumerosAleatorios[i];
                numeroPorDebajo[1][contador] = i;
                contador++;
            }
        }
        Arrays.copyOf(numeroPorDebajo, contador);
        StringBuffer stringNumerosPorDebajo = new StringBuffer();
        if (contador == 0) {
            System.out.println("No exite ningun numeros por debajo de la media en todo el array. ");
        } else if (contador == 1) {
            System.out.println("Solo hay un numero en el array por debajo de la media de todos ese numero es el " + numeroPorEncima[0][0] + " y su posicion dentro del array es la posición " + numeroPorEncima[1][0]);
        } else if (contador > 1) {
            for (int i = 0; i < contador; i++) {
                if (i == (contador - 2)) {
                    stringNumerosPorDebajo.append(numeroPorDebajo[1][i] + " y ");
                } else if (i == (contador - 1)) {
                    stringNumerosPorDebajo.append(numeroPorDebajo[1][i]);
                } else {
                    stringNumerosPorDebajo.append(numeroPorDebajo[1][i] + ", ");
                }
            }
            System.out.println("Hay un total de " + contador + " numeros por debajo de la media de todo el array y se repite en varias posiciones del array. Las posiciones de estos numeros son las siguientes posiciones: ");
            System.out.println("En la posición " + stringNumerosPorDebajo);
        }
    }
}
