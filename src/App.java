import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
    /// Listas de datos para usar en los ejercicios
    private static final List<Integer> numeros = List.of(8, 3, 5, 1, 9, 6, 12, 3, 7, 4, 2, 10, 15, 20);
    private static final List<String> nombres = List.of("Juan", "Ana", "Pedro", "Carla", "Miguel");
    private static final List<String> palabras = List.of("Java", "Stream", "Lambda", "Funcional", "API");

    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            /// Menú de opciones
            System.out.println("\n===== MENÚ DE EJERCICIOS STREAMS Y LAMBDAS =====");
            System.out.println("1. Filtrar números pares");
            System.out.println("2. Transformar una lista de nombres a mayúsculas");
            System.out.println("3. Ordenar una lista de números");
            System.out.println("4. Contar elementos mayores a un valor dado");
            System.out.println("5. Obtener los primeros 5 elementos de una lista");
            System.out.println("6. Convertir una lista de palabras en su longitud");
            System.out.println("7. Concatenar nombres con una separación");
            System.out.println("8. Eliminar duplicados de una lista");
            System.out.println("9. Obtener los 3 números más grandes de una lista");
            System.out.println("10. Agrupar palabras por su longitud");
            System.out.println("11. Encontrar el producto de todos los números de una lista");
            System.out.println("12. Obtener el nombre más largo de una lista");
            System.out.println("13. Convertir una lista de enteros en una cadena separada por guiones");
            System.out.println("14. Agrupar una lista de números en pares e impares");
            System.out.println("15. Obtener la suma de los cuadrados de los números impares");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opcion) {
                case 1 -> filtrarNumerosPares();
                case 2 -> transformarNombresAMayusculas();
                case 3 -> ordenarListaNumeros();
                case 4 -> contarMayoresQue(5);
                case 5 -> obtenerPrimeros5Elementos();
                case 6 -> convertirPalabrasALongitud();
                case 7 -> concatenarNombres();
                //case 8 -> eliminarDuplicados();
                //case 9 -> obtenerTop3Numeros();
                //case 10 -> agruparPalabrasPorLongitud();
                //case 11 -> productoDeNumeros();
                //case 12 -> nombreMasLargo();
                //case 13 -> listaEnterosComoString();
                //case 14 -> agruparParesEImpares();
                //case 15 -> sumaDeCuadradosImpares();
                //case 0 -> System.out.println("Saliendo del programa...");
                //default -> System.out.println("Opción no válida, intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    //Resolucion de los ejercicios

    /// Ejercicio 1
    public static void filtrarNumerosPares() {
        List<Integer> numerosPares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .toList();

        System.out.println(numerosPares);
    }

    /// Ejercicio 2
    public static void transformarNombresAMayusculas() {
        List<String> nombresMayuscula = nombres.stream()
                .map((n -> n.toUpperCase()))
                .toList();

        System.out.println(nombresMayuscula);
    }

    ///  Ejercicio 3
    public static void ordenarListaNumeros() {
        List<Integer> numerosOrdenados = numeros.stream()
                .sorted()
                .toList();

        System.out.println(numerosOrdenados);
    }

    /// Ejercicio 4

    public static void contarMayoresQue(Integer numero) {
        Long contar = numeros.stream()
                .filter(n -> n > numero)
                .count();

        System.out.println(contar);
    }

    ///  Ejercicio 5
    public static void obtenerPrimeros5Elementos() {
        List<Integer> primerosNumeros = numeros.stream()
                .limit(5)
                .toList();

        System.out.println(primerosNumeros);
    }

    /// Ejercicio 6
    public static void convertirPalabrasALongitud() {
        Map<String, Integer> longitud = palabras.stream()
                .collect(Collectors.toMap(
                        palabra -> palabra,
                        palabra -> palabra.length()
                ));

        System.out.println(longitud);
    }

    /// Ejercicio 7
    public static void concatenarNombres() {
        Optional<String> concatenar = nombres.stream()
                .reduce((n1, n2) -> n1 + ", " + n2);

        if(concatenar.isPresent()) {
            System.out.println(concatenar);
        }else {
            System.out.println("La lista de nombres está vacía.");
        }
    }
}
