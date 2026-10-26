package JennieID;

class Inventario {
    private Registro[] arregloRegistros; // Arreglo para almacenar los registros (Sección 2)
    private int contador;

    public Inventario(int capacidadMax) {
        this.arregloRegistros = new Registro[capacidadMax];
        this.contador = 0;
    }


    public boolean agregarRegistro(Registro r) {
        if (contador < arregloRegistros.length) {
            arregloRegistros[contador] = r;
            contador++;
            return true;
        }
        return false; // Arreglo lleno
    }

    public Registro buscarPorCodigo(String codigo) {
        for (int i = 0; i < contador; i++) {
            if (arregloRegistros[i].getCodigo().equalsIgnoreCase(codigo)) {
                return arregloRegistros[i];
            }
        }
        return null;
    }

    public void mostrarRegistros() {
        if (contador == 0) {
            System.out.println("El inventario está vacío.");
            return;
        }
        for (int i = 0; i < contador; i++) {
            System.out.println((i + 1) + ". " + arregloRegistros[i]);
        }
    }

    public void reportarEspacios() {
        System.out.println("Espacios ocupados: " + contador);
        System.out.println("Espacios disponibles: " + (arregloRegistros.length - contador));
    }

    public Registro[] getArregloRegistros() {
        return arregloRegistros;
    }

    public int getContador() {
        return contador;
    }
}