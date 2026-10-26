package JennieID;

class OperacionesRecursivas {

    // 1. Método recursivo para calcular el valor total del inventario (Precio * Cantidad)
    public static double calcularValorTotalRecursivo(Registro[] arr, int indice, int limite) {
        // Caso Base: si llegamos al final del arreglo con elementos válidos
        if (indice >= limite) {
            return 0.0;
        }
        // Sub-problema: (Precio * Cantidad del producto actual) + valor del resto del arreglo
        double valorActual = arr[indice].getPrecio() * arr[indice].getCantidad();
        return valorActual + calcularValorTotalRecursivo(arr, indice + 1, limite);
    }

    // 2. Método recursivo para buscar un producto dentro del arreglo por su código
    public static Registro buscarRecursivo(Registro[] arr, String codigoBusqueda, int indice) {
        // Caso Base 1: Llegamos al final o encontramos un espacio vacío
        if (indice >= arr.length || arr[indice] == null) {
            return null;
        }
        // Caso Base 2: Encontramos el código
        if (arr[indice].getCodigo().equalsIgnoreCase(codigoBusqueda)) {
            return arr[indice];
        }
        // Caso Recursivo: Avanzar al siguiente índice
        return buscarRecursivo(arr, codigoBusqueda, indice + 1);
    }
}
