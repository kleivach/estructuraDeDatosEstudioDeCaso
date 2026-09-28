import java.time.LocalDateTime;
import java.util.Scanner;

public class MenuTickets {
    private ColaPrioridad colaPendientes;
    private ListaTicketsResueltos listaResueltos;
    private Scanner scanner;

    public MenuTickets() {
        colaPendientes = new ColaPrioridad();
        listaResueltos = new ListaTicketsResueltos();
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion;

        do {
            System.out.println("\n=== Sistema de Tickets ===");
            System.out.println("1. Menú de usuario");
            System.out.println("2. Menú de administrador");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    menuUsuario();
                    break;
                case 2:
                    menuAdministrador();
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
    }

    public void menuUsuario() {
        int opcion;

        do {
            System.out.println("\n=== Menú de Usuario ===");
            System.out.println("1. Crear ticket");
            System.out.println("2. Buscar ticket resuelto");
            System.out.println("3. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearTicket();
                    break;
                case 2:
                    buscarTicketResuelto();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
    }

    public void menuAdministrador() {
        int opcion;

        do {
            System.out.println("\n=== Menú de Administrador ===");
            System.out.println("1. Ver ticket al frente");
            System.out.println("2. Resolver ticket al frente");
            System.out.println("3. Volver");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    Ticket frente = colaPendientes.verFrente();
                    if (frente != null) {
                        System.out.println("Ticket al frente: " + frente);
                    }
                    break;
                case 2:
                    resolverTicket();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
    }

    public void crearTicket() {
        System.out.print("Ingrese el nombre completo: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la descripción del ticket: ");
        String descripcion = scanner.nextLine();

        Ticket ticket = new Ticket(descripcion, nombre);
        colaPendientes.insertar(ticket);
        System.out.println("Ticket creado correctamente: " + ticket);
    }

    public void buscarTicketResuelto() {
        System.out.print("Ingrese el id del ticket: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Ticket ticket = listaResueltos.buscarPorId(id);
        if (ticket == null) {
            System.out.println("El ticket está pendiente.");
        } else {
            System.out.println("Ticket resuelto encontrado: " + ticket);
        }
    }

    public void resolverTicket() {
        Ticket ticket = colaPendientes.eliminar();
        if (ticket == null) {
            return;
        }

        ticket.setFechaResolucion(LocalDateTime.now());
        listaResueltos.insertarFin(ticket);
        System.out.println("Ticket resuelto: " + ticket);
    }
}
