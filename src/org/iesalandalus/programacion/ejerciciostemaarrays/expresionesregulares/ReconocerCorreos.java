package org.iesalandalus.programacion.ejerciciostemaarrays.expresionesregulares;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReconocerCorreos {
    public static void main(String[] args) {
        String posiblesCorreos;
        String[] correosElectronicos;
        posiblesCorreos = pedirCorreosElectronico();
        correosElectronicos = encontrarCorreos(posiblesCorreos);
        mostrarCorreosElectronicos(correosElectronicos);
    }

    private static String pedirCorreosElectronico() {
        String posiblesCorreos;
        System.out.print("Escriba todos los correos o lo que crea que son correos electronicos y le dire cuales si lo son(debes dejar entre ellos un espacio en blanco para que pueda distinguir los diferentes correos que quieres que te analize): ");
        posiblesCorreos = Entrada.cadena();
        return posiblesCorreos;
    }

    private static String[] encontrarCorreos(String posiblesCorreos) {
        String[] correosElectronicos = new String[1];
        int contador = 0;
        Pattern patron = Pattern.compile("\\w\\w*@\\w\\w*\\.\\w{2,5}\\s?");
        Matcher comparador = patron.matcher(posiblesCorreos);
        while (comparador.find()) {
            correosElectronicos[contador++] = comparador.group();
            correosElectronicos = Arrays.copyOf(correosElectronicos, (contador + 1));
        }
        return Arrays.copyOf(correosElectronicos, (contador));
    }

    private static void mostrarCorreosElectronicos(String[] correosElectronicos) {
        System.out.println("De entre todo los supuestos correos que ha escrito, solo se han identificado " + correosElectronicos.length + " como verdaderos correos electronicos. Son los siguientes: ");
        for (int i = 0; i < correosElectronicos.length; i++) {
            System.out.println(correosElectronicos[i]);
        }
    }
}
