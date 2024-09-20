package org.iesalandalus.programacion.ejerciciostemaarrays.arrays;

public class TableroAjedrez {
    public static void main(String[] args) {
        String[][] tableroAjedrez;
        tableroAjedrez = inicializarTablero();
        mostrarTableroAjedrez(tableroAjedrez);
    }

    private static String[][] inicializarTablero() {
        final int ANCHO_TABLERO = 8;
        final int ALTO_TABLERO = 8;
        String[][] tableroAjedrez = new String[ANCHO_TABLERO][ALTO_TABLERO];
        for (int i = 0; i < tableroAjedrez.length; i++) {
            for (int j = 0; j < tableroAjedrez[0].length; j++) {
                if ((i % 2) == 0) {
                    if ((j % 2) == 0) {
                        tableroAjedrez[i][j] = " ";
                    } else {
                        tableroAjedrez[i][j] = "X";
                    }
                } else {
                    if ((j % 2) == 0) {
                        tableroAjedrez[i][j] = "X";
                    } else {
                        tableroAjedrez[i][j] = " ";
                    }
                }
            }
        }
        return tableroAjedrez;
    }

    private static void mostrarTableroAjedrez(String[][] tableroAjedrez) {
        for (int i = 0; i < tableroAjedrez.length; i++) {
            for (int j = 0; j < tableroAjedrez[0].length; j++) {
                System.out.print(tableroAjedrez[i][j]);
                if (j == tableroAjedrez[0].length-1) {
                    System.out.println("");
                }
            }
        }
    }
}

