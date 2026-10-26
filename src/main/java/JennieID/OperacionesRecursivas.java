package JennieID;

class OperacionesRecursivas {


    public static double calcularValorTotalRecursivo(Registro[] arr, int indice, int limite) {
        if (indice >= limite) {
            return 0.0;
        }
        double valorActual = arr[indice].getPrecio() * arr[indice].getCantidad();
        return valorActual + calcularValorTotalRecursivo(arr, indice + 1, limite);
    }

    public static Registro buscarRecursivo(Registro[] arr, String codigoBusqueda, int indice) {
        if (indice >= arr.length || arr[indice] == null) {
            return null;
        }

        if (arr[indice].getCodigo().equalsIgnoreCase(codigoBusqueda)) {
            return arr[indice];
        }
        return buscarRecursivo(arr, codigoBusqueda, indice + 1);
    }
}
