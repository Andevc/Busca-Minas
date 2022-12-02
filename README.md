#  Juego del Busca Minas

## Juego del Busca Minas con Cadenas - INF-111-Matrices
#### Univ. Cristhian Andres Escobar Herrera  // @Andev

### 1. Se define las matrices A y B
```Java

    static public String v[][] = new String[20][20];
    static public String w[][] = new String[20][20];

```

### 2. Llenar la Matriz A y B
Se llena la matrix con "---" para que no este vacia y no de errores.
``` Java
    static public void llenar(int n) {
        for (int i = 0; i <= n + 1; i++) {
            for (int j = 0; j <= n + 1; j++) {
                v[i][j] = "---";
                w[i][j] = "---";
            }
        }
    }
```

### 3. Llenar la matriz con las Minas
Llenar las minas aleatoriamente con la funcion **ramdom** multiplicandolo por n y haci obtener una posicion aleatoria y agregarla a la matriz **A**.
```Java

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

```
### 4. Mostrar las Matrices 
Matriz **A** con las minas visibles
``` Java

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

```
Matriz **B** con las minas visibles
```Java 

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

```


### 5. Contar Minas
Esta funcion cuenta las minas que hay alrededor de la posición dada

``` Java

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

```

### 6. Programa Principal

#### 6.1 Definir Las varibles
``` Java    
    int n=0, x, y, c, z, i, tam, k = 0, s,t = 1;
```    
-    n = tamaño de la matriz     
-   tam = opciones de tamaño de la matriz    
-   x = pocición x    
-   y = pocición y    
-   i = numero de  intentos que se dara según el tamaño de la matriz    
-   c = contador de minas que hay alrededor de **X** y **Y**    

- ##### Swicths
    - k = muestra el juego    
    - z = comienza el juego     
    - s = opciones **Si** y **No**    
    - t = va junto con **s** para romper el **do while**

    
#### 6.2 Definir el Tamaño del juego 
``` Java
    System.out.println("\n-x---------- Tamaño del juego ----------x-\n");
    System.out.println(" 1.  8 x 8");
    System.out.println(" 2. 10 x 10");
    System.out.println(" 3. 12 x 12");
    System.out.println(" 4. 16 x 16");
    System.out.println(" 5. Salir\n");
    System.out.print("Opcion: ");
    tam = sc.nextInt(); // Entrada de datos
    switch (tam) {
        case 1:
            n = 8; k = 1; break;
        case 2:
            n = 10; k = 1; break;
        case 3:
            n = 12; k = 1; break;
        case 4:
            n = 16; k = 1; break;
        case 5:
            k = 0; break;
    }

```
-----------------------------------------------------------------------------------------------------------------------------
**Si** la opcion es 5 el juego acaba
``` Java
    System.out.println("\n-x------------------------- ADIOS T-T ---------------------------x-\n");
```
-----------------------------------------------------------------------------------------------------------------------------
#### 6.3 Mostrando el Juego

``` Java

    z = 0; c = 0; i = (n * n)/3;

    llenar(n);
    tnt(n);
    mostrar(n);
    System.out.println("\n-x--------------------------------------------------x-");
    System.out.println("\t\tBUSCA MINAS");
    System.out.println("-x--------------------------------------------------x-");
    System.out.println("\n\tIngresa las coordenadas en rango del 1 al " + n + "\n");
    System.out.println("\n\tTienes " + i + " intentos");
        
```
 - Comienzo del juego
Entrada de **x** & **y**
```Java

    System.out.println("\n-x--------------------------------------------------x-");
    System.out.print("\tFila: ");
    x = sc.nextInt();
    System.out.println("");
    System.out.print("\tColumna: ");
    y = sc.nextInt();
        
```
-----------------------------------------------------------------------------------------------------------------------------
- Si las coordenadas dadas son fuera de rango:
```Java

    if (x == 0 || y == 0 || x > n || y > n) { System.out.println("\n\t-x----- Coordenadas Fuera de Rango -----x-\n"); }
    
```
-----------------------------------------------------------------------------------------------------------------------------
- Si las coordenadas dadas estan en la posición de una Mina: 
```Java

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
    }
    
```
-----------------------------------------------------------------------------------------------------------------------------
- Si las coordenadas dadas esta en una posición donde no hay una Mina:
``` Java

    else {
        c = conteo_tnt(x, y);
        w[x][y] = "(+)";
        v[x][y] = "(+)";
        mostrarw(n);
        i = i - 1;
        System.out.println("\tHAY -> " + c + " <- MINAS AL REDEDOR");
        System.out.println("\n\tINTENTOS RESTANTES: | " + i+" |");
    }

```
-----------------------------------------------------------------------------------------------------------------------------
- **Si** los intentos se acaban Ganas! 

``` Java                        
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
   
```
-----------------------------------------------------------------------------------------------------------------------------
### Codigo Completo del programa principal del juego:
``` Java

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



```
