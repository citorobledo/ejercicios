/*
Ejercicios complejidad algorítmica
Calcule, indicando en cada paso la cantidad de operaciones, la complejidad de los
siguientes algoritmos:

1)
j=j-2;              // 1
i=j*12;             // 1
printf("%d\n",i);   // 1

operaciones totales = 1 + 1 + 1 = 3
la complejidad algoritmica es O(1) orden constante

2)
Scanner leer = new Scanner(System. in); // 1
int n = leer.nextInt(), c = 0;          // 2
while (n-- > 0)                         // n
{                                       // n
  c++;                                    // n
  int res = 0; //leemos rangos            // n
  int b = leer.nextInt();                 // n
  for (int i = 0; i <= b; i++)            // n * n = (n^2) --el for multiplica al n que ya esta en el while (n) cantidad de operaciones de leer.nextInt()--
    if (i % 2 == 1)                       // n^2
      res = res + i;                      // n * n/2 = n^2/2
  System. out .printf( "Case %d: %d\n" , c, res); // n
}

operaciones totales = 1 + 2 + n + n + n + n + n^2 + n^2 + n^2/2 + n = 3n^2 + 5n + 3 = O(n^2)
La complejidad algoritmica es O(n^2) orden cuadrático


3)
for (i = 0; i < n; i++) // n
  printf("%d\n",i);       // n
  i=0;                   // n
  while (i<n)           // n * n = n^2
  {                       
    printf("%d\n",i);     // n^2 
    i++;                  // n^2
  }                     

operaciones totales = n + n + n + n^2 + n^2 + n^2 = 3n^2 + 3n = O(n^2)
La complejidad algoritmica es O(n^2) orden cuadrático

4)
for (i = 0; i < n; i++) {   // n
  for (j = 0; j < n; j++)   // n * n = n^2
    printf("%d\n",i+j);     // n^2
  }
  i=0;                    // n^2
  while (i<10) {          // n^2 * 10 = 10n^2
    // begin B
    j=0;                  // 10n^2
    while (j<n) {         // 10n^2 * n = 10n^3
      printf("%d\n",i+j); // 10n^3
      j++;                // 10n^3
    }
    i++;                  // 10n^2
  }
}

operaciones totales = n + n^2 + n^2 + n^2 + 10n^2 + 10n^2 + 10n^3 + 10n^3 + 10n^3 + 10n^2 = 21n^3 + 22n^2 + n = O(n^3)
La complejidad algoritmica es O(n^3) orden cubico


5) Desarrollar un algoritmo para calcular el promedio de un vector de n elementos.
Calcular luego, su tiempo de ejecución.

int promedio(int v[], int n)
{
  int suma = 0; // 1
  for (int i = 0; i < n; i++) // n
    suma += v[i]; // n

  return suma / n; // 1
}

operaciones totales = 1 + n + n + 1 = 2n + 2 = O(n)
La complejidad algoritmica es O(n) orden lineal

6) Desarrollar un algoritmo para calcular el elemento máximo de un vector y luego
calcular su tiempo de ejecución.

int maximo(int v[], int n)
{
  int max = v[0]; // 1
  for (int i = 1; i < n; i++) // n
    if (v[i] > max) // n
      max = v[i]; // n

  return max; // 1
}

operaciones totales = 1 + n + n + n + 1 = 3n + 2 = O(n)
La complejidad algoritmica es O(n) orden lineal


7) Dadas las clases NodoInt y ListaInt cuyas variables de instancia son las siguientes:

public class NodoInt
{
int elemento;
NodoInt siguiente;
}

public class ListaInt
{
NodoInt primero;
...
}

Dada una ListaInt, decimos que un par de números (a; b) son contiguos divisibles en la
lista si a aparece justo antes que b y a es divisible por b. Dada esta definición, se pide
escribir el método de instancia void separarContiguosDivisibles() de orden lineal, es
decir, O(n) donde n es la cantidad de elementos de la lista, que por cada par (a; b) de
contiguos divisibles de la lista, agrega entre ellos el número a/b.

Por ejemplo:
Si la lista es [20, 10, 6, 3], los pares de contiguos divisibles son (20,10) y (6,3), y por lo
tanto la lista deberá quedar como [20, 2, 10, 6, 2, 3].
Si la lista es [20, 10, 2, 3], los pares de contiguos divisibles son (20,10) y (10,2), y por lo
tanto la lista deberá quedar como [20, 2, 10, 5, 2, 3].
Si la lista es [7, 6, 2, 7, 6], el único par de contiguos divisibles es (6,2) con lo cual la lista
deberá quedar como [7, 6, 3, 2, 7, 6].
Si la lista es [1, 1], el par (1,1) es de contiguos divisibles y por lo tanto la lista deberá
quedar como [1, 1, 1].
Si la lista es [50, 5], el par (50,5) es de contiguos divisibles y por lo tanto la lista deberá
quedar como [50, 10, 5]. 
Notar que la nueva lista contiene el par de contiguos consecutivos (10,5), sin embargo, este par 
no se separa por no ser parte de la lista original.
operaciones totales = 1 + n + n + n + n + n + n + n = 7n + 1 = O(n)
La complejidad algoritmica es O(n) orden lineal
*/
public class NodoInt {
  int elemento;
  NodoInt siguiente;
}

public class ListaInt {
    NodoInt primero;

    public void separarContiguosDivisibles() {
        NodoInt actual = primero; //  inicializa el nodo actual al primer nodo de la lista.

        while (actual != null && actual.siguiente != null) {//recorre la lista mientras haya al menos dos nodos consecutivos.
            int a = actual.elemento;
            int b = actual.siguiente.elemento;

            if (a % b == 0) {
                NodoInt nuevoNodo = new NodoInt();
                nuevoNodo.elemento = a / b;// crea un nuevo nodo con el valor de a/b.
                nuevoNodo.siguiente = actual.siguiente; // enlaza el nuevo nodo con el nodo siguiente al actual.
                actual.siguiente = nuevoNodo;// enlaza el nodo actual con el nuevo nodo.
                actual = nuevoNodo.siguiente; // Avanzar dos nodos para seguir con la verificación.
            } else {
                actual = actual.siguiente; // Avanzar un nodo y seguir con la verificación.
            }
        }
    }
}
