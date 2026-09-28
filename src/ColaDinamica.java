import java.util.ArrayList;

public class ColaDinamica {
    // Atributos
    private ArrayList<String> cola;

    // Métodos
    public ColaDinamica() {
        cola = new ArrayList<>();
    }

    // Operaciones
    private boolean estaVacia() {
        return cola.isEmpty();
    }

    public void insertar(String nodo) {
        cola.add(nodo);
    }

    public String eliminar() {
        if (estaVacia()) {
            System.out.println("\nLa cola está vacía.\n");
            return null;
        }
        return cola.remove(0);
    }

    public String verFrente() {
        if (estaVacia()) {
            System.out.println("\nLa cola está vacía.\n");
            return null;
        }
        return cola.get(0);
    }
}
