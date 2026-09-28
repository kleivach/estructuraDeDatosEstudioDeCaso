public class ListaTicketsResueltos {
    private NodoLista primero;

    public ListaTicketsResueltos() {
        primero = null;
    }

    public boolean estaVacia() {
        return primero == null;
    }

    public void insertarFin(Ticket ticket) {
        NodoLista nuevo = new NodoLista(ticket);
        if (estaVacia()) {
            primero = nuevo;
            return;
        }

        NodoLista temp = primero;
        while (temp.getSiguiente() != null) {
            temp = temp.getSiguiente();
        }
        temp.setSiguiente(nuevo);
    }

    public Ticket buscarPorId(int id) {
        if (estaVacia()) {
            return null;
        }

        NodoLista temp = primero;
        while (temp != null) {
            if (temp.getTicket().getId() == id) {
                return temp.getTicket();
            }
            temp = temp.getSiguiente();
        }
        return null;
    }

    public void mostrarLista() {
        if (estaVacia()) {
            System.out.println("\nLa lista está vacía.\n");
            return;
        }

        NodoLista temp = primero;
        while (temp != null) {
            System.out.println(temp.getTicket());
            temp = temp.getSiguiente();
        }
    }
}
