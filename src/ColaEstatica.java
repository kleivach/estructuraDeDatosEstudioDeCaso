public class ColaEstatica {
    // Atributos
    private String[] cola;
    private int frente;
    private int fin;
    private int cantidad;

    // Métodos
    // Constructor
    public ColaEstatica(int longitud) {
        cola = new String[longitud];
        frente = cantidad = 0;
        fin = -1;
    }

    // Operaciones
    public boolean estaVacia() {
        return cantidad == 0;
    }

    public boolean estaLlena() {
        return cantidad == cola.length;
    }

    public void insertar(String nodo) {
        if (estaLlena()) {
            System.out.println("\nLa cola está llena.\n");
            return;
        }
        if (fin == cola.length - 1) {
            fin = -1;
        }
        cola[++fin] = nodo;
        cantidad++;
    }

    public String eliminar() {
        if (estaVacia()) {
            System.out.println("\nLa cola está vacía.\n");
            return null;
        }
        String nodo = cola[frente++];
        if (frente == cola.length) {
            frente = 0;
        }
        cantidad--;
        return nodo;
    }

    public String verFrente() {
        if (estaVacia()) {
            System.out.println("\nLa cola está vacía.\n");
            return null;
        }
        return cola[frente];
    }
}
