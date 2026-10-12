import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pila pila = new Pila();
        int opc = 0;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Ingresar expresion");
            System.out.println("2. Desapilar");
            System.out.println("3. Mostrar pila");
            System.out.println("4. Limpiar");
            System.out.println("5. Salir");
            System.out.print("Opcion: ");
            
            try {
                opc = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                opc = 0; 
            }

            switch (opc) {
                case 1:
                    System.out.println("Digite la expresion (con espacios, ej: 3 + x ):");
                    String exp = scanner.nextLine();
                    procesar(exp, pila);
                    break;
                case 2:
                    pila.desapilar();
                    break;
                case 3:
                    pila.mostrar();
                    break;
                case 4:
                    pila.limpiar();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opc != 5);
        
        scanner.close();
    }

    // separa y clasifica los tokens
    private static void procesar(String exp, Pila pila) {
        String[] partes = exp.split(" ");
        
        for (String p : partes) {
            if (p.trim().isEmpty()) continue;
            
            String tipo = clasificar(p);
            pila.apilar(new Token(p, tipo));
        }
    }

    // define que tipo de caracter es
    private static String clasificar(String p) {
        if (p.matches("-?\\d+(\\.\\d+)?")) {
            return "NUMERO";
        } else if (p.matches("[a-zA-Z]+")) {
            return "VARIABLE";
        } else if (p.equals("+") || p.equals("-") || p.equals("*") || p.equals("/")) {
            return "OPERADOR";
        } else if (p.equals("(") || p.equals(")")) {
            return "PARENTESIS";
        } else {
            return "OTRO";
        }
    }
}
