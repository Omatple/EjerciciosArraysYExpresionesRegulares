package org.iesalandalus.programacion.ejerciciostemaarrays.FechasyTiempos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EjemploBasicoDeFechas {
    public static void main(String[] args) {
        System.out.println("------------------------------------------------------------------------------------------");
        mostrarFechaActualEnDiferentesFormatos();
        System.out.println("------------------------------------------------------------------------------------------");
        mostrarFechaAñoNuevoPasado();
        System.out.println("------------------------------------------------------------------------------------------");
        mostrarFechaLiberacionJava8();
        System.out.println("------------------------------------------------------------------------------------------");
    }

    private static void mostrarFechaActualEnDiferentesFormatos() {
        LocalDate hoy = LocalDate.now();
        System.out.println("La fecha de hoy en formato corto es: " + hoy.format(devolverFormatoFechaCorto()));
        System.out.println("La fecha de hoy en formato largo es: " + hoy.format(devolverFormatoFechaLargo()));
        System.out.println("La fecha de hoy en formato de texto corto es: " + hoy.format(devolverFormatoFechaTextoCorto()));
        System.out.println("La fecha de hoy en formato de texto largo es: " + hoy.format(devolverFormatoFechaTextoLargo()));
    }

    private static DateTimeFormatter devolverFormatoFechaCorto() {
        DateTimeFormatter formatoCorto = DateTimeFormatter.ofPattern("d/M/yy");
        return formatoCorto;
    }

    private static DateTimeFormatter devolverFormatoFechaLargo() {
        DateTimeFormatter formatoLargo = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return formatoLargo;
    }

    private static DateTimeFormatter devolverFormatoFechaTextoCorto() {
        DateTimeFormatter formatoTextoCorto = DateTimeFormatter.ofPattern("ccc, d 'de' MMM 'de' yyyy");
        return formatoTextoCorto;
    }

    private static DateTimeFormatter devolverFormatoFechaTextoLargo() {
        DateTimeFormatter formatoTextoLargo = DateTimeFormatter.ofPattern("cccc, d 'de' MMMM 'de' yyyy");
        return formatoTextoLargo;
    }


    private static void mostrarFechaAñoNuevoPasado() {
        LocalDate fechaAñoNuevoPasado = LocalDate.of(2023, 1, 1);
        System.out.println("La fecha del año nuevo pasado en formato corto es: " + fechaAñoNuevoPasado.format(devolverFormatoFechaCorto()));
        System.out.println("La fecha del año nuevo pasado en formato largo es: " + fechaAñoNuevoPasado.format(devolverFormatoFechaLargo()));
        System.out.println("La fecha del año nuevo pasado en formato de texto corto es: " + fechaAñoNuevoPasado.format(devolverFormatoFechaTextoCorto()));
        System.out.println("La fecha del año nuevo pasado en formato de texto largo es: " + fechaAñoNuevoPasado.format(devolverFormatoFechaTextoLargo()));
    }

    private static void mostrarFechaLiberacionJava8() {
        LocalDate fechaLiberacionJava8 = LocalDate.parse("2004-03-18");
        System.out.println("La fecha de liberacion de java 8 en formato corto es: " + fechaLiberacionJava8.format(devolverFormatoFechaCorto()));
        System.out.println("La fecha de liberacion de java 8 en formato largo es: " + fechaLiberacionJava8.format(devolverFormatoFechaLargo()));
        System.out.println("La fecha de liberacion de java 8 en formato de texto corto es: " + fechaLiberacionJava8.format(devolverFormatoFechaTextoCorto()));
        System.out.println("La fecha de liberacion de java 8 en formato de texto largo es: " + fechaLiberacionJava8.format(devolverFormatoFechaTextoLargo()));
    }
}
