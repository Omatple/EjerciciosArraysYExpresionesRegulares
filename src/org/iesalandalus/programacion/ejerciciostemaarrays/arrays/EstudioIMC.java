package org.iesalandalus.programacion.ejerciciostemaarrays.arrays;

import org.iesalandalus.programacion.utilidades.Entrada;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Objects;

public class EstudioIMC {
    public static void main(String[] args) {
        int numeroSujetos;
        String[] nombreSujetos;
        double[][] atributosPesoEstatura;
        double[] IMCSujetos;
        double mediaIMCSujetos;
        double[][] sujetosMayorIMC;
        double[][] sujetosMenorIMC;
        int cantidadPorEncimaIMCPromedio;
        int cantidadPorDebajoIMCPromedio;
        System.out.println("----------------------------------------------------------------");
        while (true) {
            try {
                numeroSujetos = pedirNumerosAGenerar();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(" ERROR. Intentelo de nuevo. ");
            }
        }
        System.out.println("----------------------------------------------------------------");
        while (true) {
            try {
                nombreSujetos = pedirNombreUsuarios(numeroSujetos);
                break;
            } catch (NullPointerException | IllegalArgumentException e) {
                System.out.println(" ERROR. Intentelo de nuevo. ");
            }
        }
        System.out.println("----------------------------------------------------------------");
        while (true) {
            try {
                atributosPesoEstatura = pedirPesoEstatura(numeroSujetos, nombreSujetos);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(" ERROR. Intentelo de nuevo. ");
            }
        }
        System.out.println("----------------------------------------------------------------");
        IMCSujetos = calcularIMC(atributosPesoEstatura);
        mediaIMCSujetos = mediaArrayIMC(IMCSujetos);
        sujetosMayorIMC = sujetosMayorIMC(IMCSujetos);
        sujetosMenorIMC = sujetosMenorIMC(IMCSujetos);
        cantidadPorEncimaIMCPromedio = cantidadPorEncimaIMCPromedio(mediaIMCSujetos, IMCSujetos);
        cantidadPorDebajoIMCPromedio = cantidadPorDebajoIMCPromedio(mediaIMCSujetos, IMCSujetos);
        mostrarResultadoFinal(mediaIMCSujetos, nombreSujetos, sujetosMayorIMC, sujetosMenorIMC, cantidadPorEncimaIMCPromedio, cantidadPorDebajoIMCPromedio);
        System.out.println("----------------------------------------------------------------");
    }

    private static int pedirNumerosAGenerar() {
        System.out.print("Escriba a continuación el numero de sujetos a los que quiera someter al estudo IMC(minimo 3): ");
        int numero = Entrada.entero();
        if (numero < 3) {
            throw new IllegalArgumentException("El numero introducido es invalido, intentelo de nuevo.");
        }
        return numero;
    }

    private static String[] pedirNombreUsuarios(int numeroUsuarios) {
        String[] nombresUsuarios = new String[numeroUsuarios];
        for (int i = 0; i < nombresUsuarios.length; i++) {
            System.out.print("Escriba el nombre del " + (i + 1) + "º usuario: ");
            nombresUsuarios[i] = Entrada.cadena();
            Objects.requireNonNull(nombresUsuarios[i], "El nombre de un usuario no puede ser nulo. ");
            if (nombresUsuarios[i].isBlank()) {
                throw new IllegalArgumentException("El nombre no puede contener solo espacios en blanco");
            }
        }
        return nombresUsuarios;
    }

    private static double[][] pedirPesoEstatura(int numeroUsuarios, String[] nombreUsuarios) {
        double[][] atributosPesoEstatura = new double[numeroUsuarios][2];
        for (int i = 0; i < atributosPesoEstatura.length; i++) {
            System.out.print("Escriba el peso(kg) de " + nombreUsuarios[i] + " el " + (i + 1) + "º usuario: ");
            atributosPesoEstatura[i][0] = Entrada.realDoble();
            if (atributosPesoEstatura[i][0] < 0 || atributosPesoEstatura[i][0] > 600) {
                throw new IllegalArgumentException("Escriba datos mas coherentes no ha existido ninguna persona que haya pesado " + atributosPesoEstatura[i][0] + " Kg");
            }
            System.out.print("Escriba tambien su estatura(cm): ");
            atributosPesoEstatura[i][1] = Entrada.realDoble();
            if (atributosPesoEstatura[i][1] < 0 || atributosPesoEstatura[i][1] > 300) {
                throw new IllegalArgumentException("Escriba datos mas coherentes no ha existido ninguna persona que haya medido " + atributosPesoEstatura[i][0] + " cm de estatura");
            }
        }
        return atributosPesoEstatura;
    }

    private static double[] calcularIMC(double[][] atributosPesoEstatura) {
        double[] calculoIMC = new double[atributosPesoEstatura.length];
        for (int i = 0; i < calculoIMC.length; i++) {
            calculoIMC[i] = (atributosPesoEstatura[i][0]) / ((atributosPesoEstatura[i][1]) * (atributosPesoEstatura[i][1]));
        }
        return calculoIMC;
    }

    private static double mediaArrayIMC(double[] calculoIMC) {
        double sumaTotal = 0;
        for (int i = 0; i < calculoIMC.length; i++) {
            sumaTotal += calculoIMC[i];
        }
        return ((sumaTotal) / (calculoIMC.length));
    }

    private static double[][] sujetosMayorIMC(double[] calculoIMC) {
        double[][] sujetosMayorIMC = new double[calculoIMC.length][2];
        double mayorIMC = 0;
        int contador = 0;
        for (int i = 0; i < calculoIMC.length; i++) {
            if (mayorIMC <= calculoIMC[i]) {
                mayorIMC = calculoIMC[i];
            }
        }
        for (int i = 0; i < calculoIMC.length; i++) {
            if (mayorIMC == calculoIMC[i]) {
                sujetosMayorIMC[contador][0] = mayorIMC;
                sujetosMayorIMC[contador++][1] = i;
            }
        }
        return Arrays.copyOf(sujetosMayorIMC, contador);
    }

    private static double[][] sujetosMenorIMC(double[] calculoIMC) {
        double[][] sujetosMenorIMC = new double[calculoIMC.length][2];
        double menorIMC = 1000;
        int contador = 0;
        for (int i = 0; i < calculoIMC.length; i++) {
            if (menorIMC >= calculoIMC[i]) {
                menorIMC = calculoIMC[i];
            }
        }
        for (int i = 0; i < calculoIMC.length; i++) {
            if (menorIMC == calculoIMC[i]) {
                sujetosMenorIMC[contador][0] = menorIMC;
                sujetosMenorIMC[contador++][1] = i;
            }
        }
        return Arrays.copyOf(sujetosMenorIMC, contador);
    }

    private static int cantidadPorEncimaIMCPromedio(double mediaArrayIMC, double[] calculoIMC) {
        int cantidadTotal = 0;
        for (int i = 0; i < calculoIMC.length; i++) {
            if (calculoIMC[i] > mediaArrayIMC) {
                cantidadTotal++;
            }
        }
        return cantidadTotal;
    }

    private static int cantidadPorDebajoIMCPromedio(double mediaArrayIMC, double[] calculoIMC) {
        int cantidadTotal = 0;
        for (int i = 0; i < calculoIMC.length; i++) {
            if (calculoIMC[i] < mediaArrayIMC) {
                cantidadTotal++;
            }
        }
        return cantidadTotal;
    }

    private static void mostrarResultadoFinal(double mediaArrayIMC, String[] nombreUsuarios, double[][] sujetosMayorIMC, double[][] sujetosMenorIMC, int cantidadPorEncimaIMCPromedio, int cantidadPorDebajoIMCPromedio) {
            System.out.println("El IMC promedio de todos los sujetos es igual a " + String.format("%.3f", mediaArrayIMC));
        System.out.println(cantidadPorEncimaIMCPromedio + " sujetos han tenido un IMC mayor al IMC promedio de los demás sujetos. ");
        System.out.println("El mayor IMC ha sido de " + String.format("%.3f", sujetosMayorIMC[0][0]) + ". Ha sido el IMC del sujeto: ");
        if (sujetosMayorIMC.length - 1 == 0) {
            System.out.println(nombreUsuarios[((int) sujetosMayorIMC[0][1])]);
        } else {
            for (int i = 0; i < sujetosMayorIMC.length; i++) {
                if (i == sujetosMayorIMC.length - 2) {
                    System.out.println(nombreUsuarios[((int) sujetosMayorIMC[i][1])]);
                } else if (i == sujetosMayorIMC.length - 1) {
                    System.out.print(" y " + nombreUsuarios[((int) sujetosMayorIMC[i][1])]);
                } else {
                    System.out.print(nombreUsuarios[((int) sujetosMayorIMC[i][1])] + ", ");
                }
            }
        }
        System.out.println(cantidadPorDebajoIMCPromedio + " sujetos han tenido un IMC menor al IMC promedio de los demás sujetos. ");
        System.out.println("El menor IMC ha sido de " + String.format("%.3f", sujetosMenorIMC[0][0]) + ". Ha sido el IMC del sujeto: ");
        if (sujetosMenorIMC.length - 1 == 0) {
            System.out.println(nombreUsuarios[((int) sujetosMenorIMC[0][1])]);
        } else {
            for (int i = 0; i < sujetosMenorIMC.length; i++) {
                if (i == sujetosMenorIMC.length - 2) {
                    System.out.println(nombreUsuarios[((int) sujetosMenorIMC[i][1])]);
                } else if (i == sujetosMenorIMC.length - 1) {
                    System.out.print(" y " + nombreUsuarios[((int) sujetosMenorIMC[i][1])]);
                } else {
                    System.out.print(nombreUsuarios[((int) sujetosMenorIMC[i][1])] + ", ");
                }
            }
        }
    }
}
