public class Pila {
    private Nodo cima;

    public Pila() {
        this.cima = null;
    }

    // revisa si no hay elementos
    public boolean estaVacia() {
        return cima == null;
    }

    // agrega a la pila
    public void apilar(Token dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.siguiente = cima;
        cima = nuevo;
        System.out.println("Apilado: " + dato);
    }

    // saca el elemento de arriba
    public Token desapilar() {
        if (estaVacia()) {
            System.out.println("La pila ya esta vacia");
            return null;
        }
        Token quitado = cima.dato;
        cima = cima.siguiente;
        System.out.println("Desapilado: " + quitado);
        return quitado;
    }

    // imprime los datos
    public void mostrar() {
        if (estaVacia()) {
            System.out.println("Pila vacia");
            return;
        }
        Nodo aux = cima;
        while (aux != null) {
            System.out.println(aux.dato);
            aux = aux.siguiente;
        }
    }
    
    // borra todo
    public void limpiar() {
        cima = null;
        System.out.println("Pila limpia");
    }
}