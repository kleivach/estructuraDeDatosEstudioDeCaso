import java.util.ArrayList;

public class ColaPrioridad {
    private ArrayList<Ticket> cola;

    public ColaPrioridad() {
        cola = new ArrayList<>();
    }

    public boolean estaVacia() {
        return cola.isEmpty();
    }

    public void insertar(Ticket ticket) {
        cola.add(ticket);
    }

    public Ticket eliminar() {
        if (estaVacia()) {
            System.out.println("\nLa cola está vacía.\n");
            return null;
        }
        return cola.remove(0);
    }

    public Ticket verFrente() {
        if (estaVacia()) {
            System.out.println("\nLa cola está vacía.\n");
            return null;
        }
        return cola.get(0);
    }
}
