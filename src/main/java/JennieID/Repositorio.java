package JennieID;

class Repositorio<T> {
    private Object[] elementos;
    private int tamaño;

    public Repositorio(int capacidad) {
        this.elementos = new Object[capacidad];
        this.tamaño = 0;
    }

    public void agregar(T elemento) {
        if (tamaño < elementos.length) {
            elementos[tamaño++] = elemento;
            System.out.println("Elemento agregado exitosamente al Repositorio<T>.");
        } else {
            System.out.println("Repositorio lleno.");
        }
    }

    @SuppressWarnings("unchecked")
    public T obtenerPorPosicion(int posicion) {
        if (posicion >= 0 && posicion < tamaño) {
            return (T) elementos[posicion];
        }
        return null;
    }

    public void mostrarTodos() {
        System.out.println("--- Contenido del Repositorio ---");
        for (int i = 0; i < tamaño; i++) {
            System.out.println("[" + i + "] " + elementos[i]);
        }
    }
}