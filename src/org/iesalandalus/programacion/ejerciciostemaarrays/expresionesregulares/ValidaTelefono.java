package org.iesalandalus.programacion.ejerciciostemaarrays.expresionesregulares;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidaTelefono {
    public static void main(String[] args) {
        String telefono = " ERROR. Si se esta mostrando este mensaje, algo ha salido mal en el codigo. ";
        boolean validador = false;
        System.out.println("--------------------------------------------------------------");
        while (!validador) {
            try {
                telefono = pedirTelefono();
                validarTelefono(telefono);
                validador = true;
            } catch (IllegalArgumentException e) {
                System.out.println(" ERROR. Intentelo de nuevo. ");
            }
        }
        System.out.println("--------------------------------------------------------------");
        System.out.println("El telefono " + telefono + " tiene un formato valido. ");
        System.out.println("--------------------------------------------------------------");
    }

    private static String pedirTelefono() {
        String telefono;
        System.out.print("Escriba a continuacion su numero de telefono: ");
        telefono = Entrada.cadena();
        return telefono;
    }

    private static void validarTelefono(String telefono) {
        Pattern patron = Pattern.compile("^[6|9]\\d{8}$");
        Matcher comparador = patron.matcher(telefono);
        if (!comparador.matches()) {
            throw new IllegalArgumentException("El formato de numero de telefono que esta utilizando no es valido. Debe empezar por 6 o 9 y contener un total de 9 digitos.");
        }
    }
}
