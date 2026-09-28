public class ListaEnlazadaSimple {
    private NodoLista primero;

    public ListaEnlazadaSimple() {
        primero = null;
    }

    private NodoLista getPrimero() {
        return primero;
    }

    private void setPrimero(NodoLista primero) {
        this.primero = primero;
    }

    private boolean estaVacia() {
        return primero == null;
    }

    public void insertarInicio(String nombre, String tipo, String ubicacion) {
        NodoLista nodo = new NodoLista(nombre, tipo, ubicacion);
        nodo.setSiguiente(primero);
        primero = nodo;
    }

    public void insertarFin(String nombre, String tipo, String ubicacion) {
        NodoLista nodo = new NodoLista(nombre, tipo, ubicacion);
        if (estaVacia()) {
            setPrimero(nodo);
            return;
        }

        NodoLista temp = primero;
        while (temp.getSiguiente() != null) {
            temp = temp.getSiguiente();
        }
        temp.setSiguiente(nodo);
    }

    public NodoLista buscar(String nombre) {
        if (estaVacia()) {
            System.out.println("La lista está vacía.");
            return null;
        }

        NodoLista temp = primero;
        while (temp != null) {
            if (nombre.equals(temp.getNombre())) {
                return temp;
            }
            temp = temp.getSiguiente();
        }

        System.out.println("El nombre no está en la lista.");
        return null;
    }

  public NodoLista eliminar(String nombre) {
    if (estaVacia()) {
        System.out.println("\nLa lista está vacía.\n");
        return null;
    }

    NodoLista anterior = primero;
    NodoLista temp = anterior;

    while (temp != null) {
        if (nombre.equals(temp.getNombre())) break;
        anterior = temp;
        temp = temp.getSiguiente();
    }

    if (temp == null) {
        System.out.println("\nEl nombre no está en la lista.\n");
        return null;
    }

    if (temp == primero) {
        setPrimero(temp.getSiguiente());
    } else {
        anterior.setSiguiente(temp.getSiguiente());
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
        System.out.println(temp);
        temp = temp.getSiguiente();
    }
}
    private class NodoLista {
        private String nombre;
        private String tipo;
        private String ubicacion;
        private NodoLista siguiente;

        public NodoLista(String nombre, String tipo, String ubicacion) {
            this.nombre = nombre;
            this.tipo = tipo;
            this.ubicacion = ubicacion;
            this.siguiente = null;
        }

        public String getNombre() {
            return nombre;
        }

        public String getTipo() {
            return tipo;
        }

        public String getUbicacion() {
            return ubicacion;
        }

        public NodoLista getSiguiente() {
            return siguiente;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

        public void setUbicacion(String ubicacion) {
            this.ubicacion = ubicacion;
        }

        public void setSiguiente(NodoLista siguiente) {
            this.siguiente = siguiente;
        }

        @Override
        public String toString() {
            return "NodoLista{" +
                    "nombre='" + nombre + '\'' +
                    ", tipo='" + tipo + '\'' +
                    ", ubicacion='" + ubicacion + '\'' +
                    ", siguiente=" + siguiente +
                    '}';
        }
    }
}
