package JennieID;

import java.util.Scanner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventario miInventario = new Inventario(5); // Capacidad para 5 registros

        // Precargamos un par de registros para pruebas
        miInventario.agregarRegistro(new Registro("P01", "Laptop Gamer", 1200.0, 5));
        miInventario.agregarRegistro(new Registro("P02", "Mouse Inalámbrico", 25.5, 15));

        int opcion = 0;
        do {
            System.out.println("\n------------SISTEMA DE GESTIÓN: TIENDA TECNOLÓGICA -----------");
            System.out.println("1. Mostrar registros y estado del arreglo");
            System.out.println("2. Agregar nuevo registro tecnológico");
            System.out.println("3. Buscar registro por código (Normal)");
            System.out.println("4. Calcular valor total del inventario (RECURSIVO)");
            System.out.println("5. Buscar registro por código (RECURSIVO)");
            System.out.println("6. Probar Repositorio (Clase Parametrizada)");
            System.out.println("7. Probar Métodos Genéricos (Imprimir, Intercambiar)");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    miInventario.mostrarRegistros();
                    miInventario.reportarEspacios();
                    break;

                case 2:
                    System.out.print("Ingrese código del registro (ej: P03): ");
                    String cod = scanner.nextLine();
                    System.out.print("Ingrese nombre del producto: ");
                    String nom = scanner.nextLine();
                    System.out.print("Ingrese precio: ");
                    double pre = scanner.nextDouble();
                    System.out.print("Ingrese cantidad disponible: ");
                    int cant = scanner.nextInt();

                    boolean exito = miInventario.agregarRegistro(new Registro(cod, nom, pre, cant));
                    if (exito) {
                        System.out.println("¡Registro agregado con éxito!");
                    } else {
                        System.out.println("Error: El inventario/arreglo está lleno.");
                    }
                    break;

                case 3:
                    System.out.print("Ingrese el código a buscar: ");
                    String busq = scanner.nextLine();
                    Registro encontrado = miInventario.buscarPorCodigo(busq);
                    if (encontrado != null) {
                        System.out.println("Encontrado: " + encontrado);
                    } else {
                        System.out.println("Registro no encontrado.");
                    }
                    break;

                case 4:
                    double valorTotal = OperacionesRecursivas.calcularValorTotalRecursivo(
                            miInventario.getArregloRegistros(), 0, miInventario.getContador()
                    );
                    System.out.println(">>> Valor total del inventario (Recursivo): $" + valorTotal);
                    break;

                case 5:
                    System.out.print("Ingrese el código para la búsqueda recursiva: ");
                    String codRec = scanner.nextLine();
                    Registro regRec = OperacionesRecursivas.buscarRecursivo(
                            miInventario.getArregloRegistros(), codRec, 0
                    );
                    if (regRec != null) {
                        System.out.println("¡Encontrado recursivamente!: " + regRec);
                    } else {
                        System.out.println("No se encontró el registro mediante búsqueda recursiva.");
                    }
                    break;

                case 6:
                    System.out.println("\n--- Probando Repositorio Parametrizado con Registros ---");
                    Repositorio<Registro> repoRegistros = new Repositorio<>(3);
                    repoRegistros.agregar(new Registro("T99", "Tablet Pro", 450.0, 8));
                    repoRegistros.mostrarTodos();
                    break;

                case 7:
                    System.out.println("\n--- 1. Probando con Cadenas de Texto (Strings) ---");
                    String[] marcasTech = {"Apple", "Samsung", "Sony", "Xiaomi"};
                    UtilidadesGenericas.imprimirColeccion(marcasTech);

                    System.out.println("\nIntercambiando posición 0 (Apple) con posición 2 (Sony)...");
                    UtilidadesGenericas.intercambiarElementos(marcasTech, 0, 2);
                    UtilidadesGenericas.imprimirColeccion(marcasTech);

                    System.out.println("\n--- 2. Probando con Números Enteros ---");
                    Integer[] codigosDescuento = {10, 20, 50, 100};
                    UtilidadesGenericas.imprimirColeccion(codigosDescuento);
                    break;

                case 8:
                    System.out.println("Saliendo del programa. ¡Mucho éxito con tu tarea!");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 8);

        scanner.close();
    }
}