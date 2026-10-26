package JennieID;

class UtilidadesGenericas {

    // 1. Método genérico para imprimir cualquier colección u objeto
    public static <T> void imprimirColeccion(T[] arreglo) {
        System.out.println("--> Imprimiendo elementos de la colección genérica:");
        for (T elemento : arreglo) {
            if (elemento != null) {
                System.out.println("   * " + elemento);
            }
        }
    }

    // 2. Método genérico para intercambiar dos elementos de lugar (Swap)
    public static <T> void intercambiarElementos(T[] arreglo, int pos1, int pos2) {
        if (pos1 >= 0 && pos1 < arreglo.length && pos2 >= 0 && pos2 < arreglo.length) {
            T temp = arreglo[pos1];
            arreglo[pos1] = arreglo[pos2];
            arreglo[pos2] = temp;
            System.out.println("¡Elementos intercambiados correctamente!");
        } else {
            System.out.println("Posiciones inválidas para el intercambio.");
        }
    }

    // 3. Método genérico para buscar un elemento dentro de un arreglo genérico
    public static <T> boolean buscarEnArreglo(T[] arreglo, T elementoBuscado) {
        for (T elemento : arreglo) {
            if (elemento != null && elemento.equals(elementoBuscado)) {
                return true;
            }
        }
        return false;
    }
}
