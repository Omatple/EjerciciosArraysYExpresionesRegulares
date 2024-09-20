package org.iesalandalus.programacion.ejerciciostemaarrays.particularesjoseramon;

import org.iesalandalus.programacion.utilidades.Entrada;

public class Subrayado {

    private static void subrayar(String texto) {
        System.out.println(texto);
        String subrayado = String.format(String.format("%%0%dd", texto.length()), 0).replace('0', '-');
        //String subrayado = String.format(String.format("%%%ds", texto.length()), "").replace(' ', '-');
        System.out.println(subrayado);
    }

    public static void main(String[] args) {
        System.out.print("Introduce una cadena: ");
        String texto = Entrada.cadena();
        subrayar(texto);
    }
}
