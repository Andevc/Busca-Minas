//@Cristhian Escobar - Andev
package com.mycompany.lab111.matrices;
import java.util.Scanner;
public class buscaMinas {

    static public String v[][] = new String[20][20];
    static public String w[][] = new String[20][20];

    // Mostrar matriz con las minas
    static public void mostrar(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println("");
            System.out.print("\t| ");
            for (int j = 1; j <= n; j++) {
                System.out.print(v[i][j] + " | ");                
            }
        }
        System.out.println("\n");
    }

    // Mostrar la matriz con las minas escondidas
    static public void mostrarw(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.println("");
            System.out.print("\t| ");
            for (int j = 1; j <= n; j++) {
                System.out.print(w[i][j] + " | ");
            }
        }
        System.out.println("\n");
    }

    // Llenar minas aleatoriamente
    static public void tnt(int n) {
        int c = 0;
        while (n * 2 >= c) {
            double x = Math.random() * n+1;
            double y = Math.random() * n+1;
            if (x != 0 && y != 0 && x != n && y != n) {
                v[(int) x][(int) y] = "<*>";
                c = c + 1;
            }
        }
    }
    // Conteo de minas al rededor de la coordenada

    static public int conteo_tnt(int x, int y) {
        int c = 0;
        if (v[x - 1][y - 1].equals("<*>")) { c = c + 1;}
        if (v[x - 1][y + 1].equals("<*>")) { c = c + 1;}
        if (v[x + 1][y - 1].equals("<*>")) { c = c + 1;}
        if (v[x + 1][y + 1].equals("<*>")) { c = c + 1;}
        if (v[x - 1][y].equals("<*>")) { c = c + 1;}
        if (v[x + 1][y].equals("<*>")) { c = c + 1;}
        if (v[x][y - 1].equals("<*>")) { c = c + 1;}
        if (v[x][y + 1].equals("<*>")) { c = c + 1;}
        return c;
    }
    static public void llenar(int n) {
        for (int i = 0; i <= n + 1; i++) {
            for (int j = 0; j <= n + 1; j++) {
                v[i][j] = "---";
                w[i][j] = "---";
            }
        }
    }
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n=0, x, y, c, z, i, tam, k = 0, s,t = 1;
            do {
                System.out.println("\n-x---------- Tamaño del juego ----------x-\n");
                System.out.println(" 1.  8 x 8");
                System.out.println(" 2. 10 x 10");
                System.out.println(" 3. 12 x 12");
                System.out.println(" 4. 16 x 16");
                System.out.println(" 5. Salir\n");
                System.out.print("Opcion: ");
                tam = sc.nextInt();
                switch (tam) {
                    case 1:
                        n = 8;
                        k = 1;
                        break;
                    case 2:
                        n = 10;
                        k = 1;
                        break;
                    case 3:
                        n = 12;
                        k = 1;
                        break;
                    case 4:
                        n = 16;
                        k = 1;
                        break;
                    case 5:
                        k = 0;
                        break;
                }
                z = 0;
                c = 0;
                i = (n * n)/3;
                if (k == 1) {
                    llenar(n);
                    tnt(n);
                    mostrar(n);
                    System.out.println("\n-x--------------------------------------------------x-");
                    System.out.println("\t\tBUSCA MINAS");
                    System.out.println("-x--------------------------------------------------x-");
                    System.out.println("\n\tIngresa las coordenadas en rango del 1 al " + n + "\n");
                    System.out.println("\n\tTienes " + i + " intentos");
                    while (z != 1) {
                        System.out.println("\n-x--------------------------------------------------x-");
                        System.out.print("\tFila: ");
                        x = sc.nextInt();
                        System.out.println("");
                        System.out.print("\tColumna: ");
                        y = sc.nextInt();
                        if (x == 0 || y == 0 || x > n || y > n) {
                            System.out.println("\n\t-x----- Coordenadas Fuera de Rango -----x-\n");
                        } else {
                            if (v[x][y].equals("<*>")) { 
                                z = 1;
                                System.out.println("\n-x--------------------------------------------x-");
                                System.out.println("-x-------- TODAS LAS MINAS EXPLOTARON --------x-");
                                System.out.println("-x--------------------------------------------x-");
                                mostrar(n);
                                System.out.println("\n-x------------------------------x-");
                                System.out.println("-x--------- GAME OVER ----------x-");
                                System.out.println("-x------------------------------x-\n");
                                do{
                                    System.out.println("\n-x--------- REITENTAR ---------x-\n");
                                    System.out.println("\t1. Si\t2. No");
                                    System.out.print("\tOpcion: ");
                                    s = sc.nextInt();
                                    if (s == 1) {t = 0;}
                                    if (s == 2) { tam = 5; t = 0;}
                                    if (s > 2 || s == 0) {System.out.println("\n-x-----Opcion fuera de rango-----x-"); t = 1;}
                                }while(t == 1);                                
                            } else {
                                c = conteo_tnt(x, y);
                                w[x][y] = "(+)";
                                v[x][y] = "(+)";
                                mostrarw(n);
                                i = i - 1;
                                System.out.println("\tHAY -> " + c + " <- MINAS AL REDEDOR");
                                System.out.println("\n\tINTENTOS RESTANTES: | " + i+" |");
                            }
                            if (i == 0) {
                                System.out.println("\n-x---------------------------------x-");
                                System.out.println("-x--------- GANASTE!!! -----------x-");
                                System.out.println("-x---------------------------------x-\n");
                                z = 1;
                                do{
                                    System.out.println("\n-x--------- VOLVER A JUGAR ---------x-\n");
                                    System.out.println("\t1. Si\t2. No");
                                    System.out.print("\tOpcion: ");
                                    s = sc.nextInt();
                                    if (s == 1) {t = 0;}
                                    if (s == 2) { tam = 5; t = 0;}
                                    if (s > 2 || s == 0) {System.out.println("\n-x-----Opcion fuera de rango-----x-"); t = 1;}
                                }while(t == 1);
                            }
                        }
                    }
                }
            } while (tam != 5);
            System.out.println("\n-x------------------------- ADIOS ---------------------------x-\n");
        }
    }

}
