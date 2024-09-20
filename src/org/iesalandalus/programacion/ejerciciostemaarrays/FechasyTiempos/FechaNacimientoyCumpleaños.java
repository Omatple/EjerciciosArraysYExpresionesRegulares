package org.iesalandalus.programacion.ejerciciostemaarrays.FechasyTiempos;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.regex.Pattern;

public class FechaNacimientoyCumpleaños {
    public static void main(String[] args) {
        String stringFechaNacimiento;
        LocalDate fechaNacimiento = null;
        boolean validador = false;
        System.out.println("------------------------------------------------------------------------------------------");
        do {
            try {
                stringFechaNacimiento = pedirFechaNacimiento();
                fechaNacimiento = validarFormatoFecha(stringFechaNacimiento);
                validador = true;
            } catch (DateTimeException e) {
                System.out.println(" ERROR: Formato de fecha incorrecto.");
            }
        } while (!validador);
        System.out.println("------------------------------------------------------------------------------------------");
        mostrarFechaNacimiento(fechaNacimiento);
        System.out.println("------------------------------------------------------------------------------------------");
        mostrarDiaSemanaFechaNacimiento(fechaNacimiento);
        System.out.println("------------------------------------------------------------------------------------------");
        //NO CALCULA DIAS RESTANTES CORRECTAMENTE INTENTAR ARREGLARLO, Y PROBAR EL METODO PERIOD
        mostrarDiasRestantesCumpleaños(fechaNacimiento);
        System.out.println("------------------------------------------------------------------------------------------");
        mostrarEdadCompleta(fechaNacimiento);
        System.out.println("------------------------------------------------------------------------------------------");
    }

    private static String pedirFechaNacimiento() {
        String fechaNacimiento;
        System.out.print("Escriba su fecha de nacimiento en un formato valido(año(aaaa)-mes(mm)-dia(dd)): ");
        fechaNacimiento = Entrada.cadena();
        return fechaNacimiento;
    }

    private static LocalDate validarFormatoFecha(String fechaNacimiento) {
        // Pattern patron = Pattern.compile("^(1[0-9]{3}|20[0-1][0-9]|202[0-4])-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$");
        // EL PATTERN DE ARRIBA LO HABIA HECHO PARA VALIDARLO CON UN PATRON CREADO
        // POR MI, PERO LUEGO ME SURGIEROM MUCHOS PRROBLEMAS COMO LOS MESES CON 30
        // DIAS O AÑOS BISIESTOS, POR LO QUE ME VI OBLIGADO A BUSCARINFORMACION EN
        // INTERNET DADO QUE EN LOS DOCUMENTOS DE RAMON NO HAY NINGUUNA SECCION DONDE
        // TE DIGA O TE INDIQUE LOS COMANDO PARA VERIFICAR LA FECHA ESCRITA EN UN STRING
        // ¿PREGUNTAR SI EL USO ES EL ADECUADO Y SI SE PUEDEHACER USO DE EL?
        Pattern patron = Pattern.compile("yyyy-MM-dd");
        DateTimeFormatter comparador = DateTimeFormatter.ofPattern(String.valueOf(patron));
        LocalDate fechaNacimientoValidada = LocalDate.parse(fechaNacimiento, comparador);
        if (fechaNacimientoValidada.isAfter(LocalDate.now())) {
            throw new DateTimeException("Fecha no valida, no se puede viajar al futuro(hasta el momento).");
        }
        return fechaNacimientoValidada;
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

    private static DateTimeFormatter devolverFormatoDiaSemanaTexto() {
        DateTimeFormatter formatoDiaSemanaTexto = DateTimeFormatter.ofPattern("cccc");
        return formatoDiaSemanaTexto;
    }

    private static void mostrarFechaNacimiento(LocalDate fechaNacimiento) {
        System.out.println("La fecha de su nacimiento es: " + fechaNacimiento.format(devolverFormatoFechaCorto()));
    }

    private static void mostrarDiaSemanaFechaNacimiento(LocalDate fechaNacimiento) {
        System.out.println("Nacistes un " + fechaNacimiento.format(devolverFormatoDiaSemanaTexto()));
    }

    private static void mostrarDiasRestantesCumpleaños(LocalDate fechaNacimiento) {
        LocalDate hoy = LocalDate.now();
        int diasRestantes;
        fechaNacimiento = fechaNacimiento.withYear(hoy.getYear());
        diasRestantes = (int) (ChronoUnit.DAYS.between(hoy, fechaNacimiento));
        if (diasRestantes > 0) {
            System.out.println("Solo quedan " + diasRestantes + " dias para celebrar tu cumpleaños. ");
        } else if (diasRestantes == 0) {
            System.out.println("¡¡¡MUCHAS FELICIDADES HOY ES TU CUMPLEAÑOS!!!");
        } else {
            fechaNacimiento = fechaNacimiento.withYear(hoy.getYear() + 1);
            diasRestantes = (int) (ChronoUnit.DAYS.between(hoy, fechaNacimiento));
            System.out.println("Este año tu cumpleaños ya ha pasado pero quedan " + diasRestantes + " dias para que celebres tu proximmo cumpleaños. ");
        }
    }

    private static void mostrarEdadCompleta(LocalDate fechaNacimiento) {
        LocalDate hoy = LocalDate.now();
        Period edad = Period.between(fechaNacimiento, hoy);
        if (edad.getYears() == 0 && edad.getMonths() == 0){
            System.out.println("Tu edad exacta actual es de: " + edad.getDays() + " dias.");
        }else if(edad.getMonths()==0 && edad.getDays() == 0){
            System.out.println("Tu edad exacta actual es de: " + edad.getYears() + " años. ");
        } else if (edad.getYears()==0 && edad.getDays() == 0) {
            System.out.println("Tu edad exacta actual es de: " + edad.getMonths() + " meses.");
        }else if(edad.getDays()==0){
            System.out.println("Tu edad exacta actual es de: " + edad.getYears() + " años y" + edad.getMonths() + " meses.");
        }else if(edad.getYears()==0){
            System.out.println("Tu edad exacta actual es de: " + edad.getMonths() + " meses y " + edad.getDays() + " dias.");
        }else if(edad.getMonths()==0){
            System.out.println("Tu edad exacta actual es de: " + edad.getYears() + " años y " + edad.getDays() + " dias.");
        }else{
            System.out.println("Tu edad exacta actual es de: " + edad.getYears() + " años, " + edad.getMonths() + " meses y " + edad.getDays() + " dias.");
        }
    }
}
