package org.iesalandalus.programacion.ejerciciostemaarrays.FechasyTiempos;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class EjemploBasicoDeTiempo {
    public static void main(String[] args) {
        System.out.println("------------------------------------------------------------------------------------------");
        mostrarTiempoActualEnDiferentesFormatos();
        System.out.println("------------------------------------------------------------------------------------------");
        mostrarTiempoMedioDia();
        System.out.println("------------------------------------------------------------------------------------------");
        mostrarTiempoMediaNoche();
        System.out.println("------------------------------------------------------------------------------------------");
    }

    private static void mostrarTiempoActualEnDiferentesFormatos() {
        LocalTime ahora = LocalTime.now();
        System.out.println("El tiempo de ahora en formato corto AM-PM es: " + ahora.format(devolverFormatoTiempoCortoAMPM()));
        System.out.println("El tiempo de ahora en formato largo AM-PM es: " + ahora.format(devolverFormatoTiempoLargoAMPM()));
        System.out.println("El tiempo de ahora en formato corto 24h es: " + ahora.format(devolverFormatoTiempoCorto24h()));
        System.out.println("El tiempo de ahora en formato largo 24h es: " + ahora.format(devolverFormatoTiempoLargo24h()));
        System.out.println("El tiempo de ahora en formato de texto es: " + ahora.format(devolverFormatoTiempoTexto()));
    }

    private static DateTimeFormatter devolverFormatoTiempoCortoAMPM() {
        DateTimeFormatter formatoCortoAMPM = DateTimeFormatter.ofPattern("h:m:s a");
        return formatoCortoAMPM;
    }

    private static DateTimeFormatter devolverFormatoTiempoLargoAMPM() {
        DateTimeFormatter formatoLargoAMPM = DateTimeFormatter.ofPattern("hh:mm:ss a");
        return formatoLargoAMPM;
    }

    private static DateTimeFormatter devolverFormatoTiempoCorto24h() {
        DateTimeFormatter formatoCorto24h = DateTimeFormatter.ofPattern("H:m:s");
        return formatoCorto24h;
    }

    private static DateTimeFormatter devolverFormatoTiempoLargo24h() {
        DateTimeFormatter formatoLargo24h = DateTimeFormatter.ofPattern("HH:mm:ss");
        return formatoLargo24h;
    }

    private static DateTimeFormatter devolverFormatoTiempoTexto() {
        DateTimeFormatter formatoTextoTiempo = DateTimeFormatter.ofPattern("h 'horas' m 'minutos' s 'segundos' a");
        return formatoTextoTiempo;
    }

    private static void mostrarTiempoMedioDia() {
        LocalTime medioDia = LocalTime.of(12, 0, 0);
        System.out.println("El tiempo del medio dia en formato corto AM-PM es: " + medioDia.format(devolverFormatoTiempoCortoAMPM()));
        System.out.println("El tiempo del media dia en formato largo AM-PM es: " + medioDia.format(devolverFormatoTiempoLargoAMPM()));
        System.out.println("El tiempo del media dia en formato corto 24h es: " + medioDia.format(devolverFormatoTiempoCorto24h()));
        System.out.println("El tiempo del media dia en formato largo 24h es: " + medioDia.format(devolverFormatoTiempoLargo24h()));
        System.out.println("El tiempo del media dia en formato de texto es: " + medioDia.format(devolverFormatoTiempoTexto()));
    }

    private static void mostrarTiempoMediaNoche() {
        LocalTime medioNoche = LocalTime.parse("00:00:00");
        System.out.println("El tiempo de la media noche en formato corto AM-PM es: " + medioNoche.format(devolverFormatoTiempoCortoAMPM()));
        System.out.println("El tiempo de la media noche en formato largo AM-PM es: " + medioNoche.format(devolverFormatoTiempoLargoAMPM()));
        System.out.println("El tiempo de la media noche en formato corto 24h es: " + medioNoche.format(devolverFormatoTiempoCorto24h()));
        System.out.println("El tiempo de la media noche en formato largo 24h es: " + medioNoche.format(devolverFormatoTiempoLargo24h()));
        System.out.println("El tiempo de la media noche en formato de texto es: " + medioNoche.format(devolverFormatoTiempoTexto()));
    }
}
