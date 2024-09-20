package org.iesalandalus.programacion.ejerciciostemaarrays.expresionesregulares;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// COSAS A RESALTAR, SE PUEDE HACER USO DEL MATCHER.GROUP() Y QUE NO HE LLEGADO A COMPRENDER DEL TODO EL USO  DE CORCHETES [ ]
// Y EL USO DE PARENTESIS ( ) PORQUE AL INICIO DEL EJERCICIO LOS PREFIJOS PROVINCIALE SLOS ESTABA GUARDANDO ENTRE CORCHETES Y
// CUANDO QUERIA COMPROBAR SI EL PATRON ESTABA CORRECTO NADA CUMPLIA CON LO QUE PENSABA QUE HABIA PUESTO, HASTA QUE HE PROBADO
// A PONER LOS PARENTESIS DESPUES DE UN BUEN RATO, Y AHI SI ME HA FUNCIONADO CORRECTAMENTE EL PATRON DE LOS PREFIJOS
public class PrefijoTelefonico {
    public static void main(String[] args) {
        String telefono = " ERROR. Si se esta mostrando este mensaje, algo ha salido mal en el codigo. ";
        String[] telefonoPrefijos = null;
        boolean validador = false;
        System.out.println("--------------------------------------------------------------");
        while (!validador) {
            try {
                telefono = pedirTelefono();
                telefonoPrefijos = validaryDevolverPrefijoyTelefono(telefono);
                validador = true;
            } catch (IllegalArgumentException e) {
                System.out.println(" ERROR. Intentelo de nuevo. ");
            }
        }
        System.out.println("--------------------------------------------------------------");
        mostrarResultados(telefonoPrefijos);
        System.out.println("--------------------------------------------------------------");
    }

    private static String pedirTelefono() {
        String telefono;
        System.out.print("Escriba a continuacion su numero de telefono y si es necesario tambien el prefijo internacional que le antecede: ");
        telefono = Entrada.cadena();
        return telefono;
    }

    private static String[] validaryDevolverPrefijoyTelefono(String telefono) {
        String[] telefonoPrefijos;
        Pattern patron = Pattern.compile("(^(\\+34 )?(945|845|967|867|965|865|966|950|850|984|884|985|920|820|924|824|947|847|927|827|956|856|942|842|964|864|926|826|957|857|981|881|969|869|972|872|958|858|949|849|943|843|959|859|974|874|971|871|953|853|987|887|973|873|982|882|951|851|952|968|868|948|848|988|888|979|879|928|828|986|886|941|841|923|823|921|821|954|854|955|975|875|977|877|922|822|978|878|925|825|960|860|961|962|963|983|883|944|946|846|980|880|976|876) \\d{3} \\d{3}$)|(^(\\+34 )?(93|83|91|81) \\d{3} \\d{2} \\d{2}$)");
        Matcher comparador = patron.matcher(telefono);
        if (!comparador.matches()) {
            throw new IllegalArgumentException("El formato de numero de telefono que esta utilizando no es valido.");
        }
        if (comparador.group(2) == null && comparador.group(5) == null) {
            telefonoPrefijos = new String[2];
            if (comparador.group(1) == null) {
                telefonoPrefijos[0] = comparador.group(4);
                telefonoPrefijos[1] = comparador.group(6);
            } else {
                telefonoPrefijos[0] = comparador.group(1);
                telefonoPrefijos[1] = comparador.group(3);
            }
        } else {
            telefonoPrefijos = new String[3];
            if (comparador.group(1) == null) {
                telefonoPrefijos[0] = comparador.group(4);
                telefonoPrefijos[1] = comparador.group(5);
                telefonoPrefijos[2] = comparador.group(6);
            } else {
                telefonoPrefijos[0] = comparador.group(1);
                telefonoPrefijos[1] = comparador.group(2);
                telefonoPrefijos[2] = comparador.group(3);
            }
        }
        return telefonoPrefijos;
    }

    private static void mostrarResultados(String[] telefonoPrefijo) {
        System.out.println("El telefono '" + telefonoPrefijo[0] + "' tiene un formato valido. ");
        if (telefonoPrefijo.length == 2) {
            System.out.println("El prefijo provincial del telefono ingresado es: " + telefonoPrefijo[1]);
        } else {
            System.out.println("El prefijo internacional del telefono ingresado es: " + telefonoPrefijo[1]);
            System.out.println("El prefijo provincial del telefono ingresado es: " + telefonoPrefijo[2]);
        }
    }
}
