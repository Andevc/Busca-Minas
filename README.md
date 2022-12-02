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


### Contar la minas que hay al rededor de la posicion dada

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
