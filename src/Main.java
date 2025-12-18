import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Crear agenda (mínimo 5, máximo 10 contactos)");
            System.out.println("2. Añadir contacto");
            System.out.println("3. Verificar contacto");
            System.out.println("4. Listar contactos");
            System.out.println("5. Buscar contacto");
            System.out.println("6. Eliminar contacto");
            System.out.println("7. Modificar teléfono");
            System.out.println("8. Agenda llena?");
            System.out.println("9. Espacios libres");
            System.out.println("10. Salir");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            // Aquí solo llamamos a métodos de otra clase
            switch (opcion) {
                case 1 -> MenuOpciones.crearAgenda(sc);
                case 2 -> MenuOpciones.añadirContacto(sc);
                case 3 -> MenuOpciones.verificarContacto(sc);
                case 4 -> MenuOpciones.listarContactos();
                case 5 -> MenuOpciones.buscarContacto(sc);
                case 6 -> MenuOpciones.eliminarContacto(sc);
                case 7 -> MenuOpciones.modificarTelefono(sc);
                case 8 -> MenuOpciones.agendaLlena();
                case 9 -> MenuOpciones.espaciosLibres();
                case 10 -> System.out.println("👋 Gracias por usar la Agenda Telefónica. ¡Hasta pronto!");
                default -> System.out.println("❌ Opción inválida.");
            }
        } while (opcion != 10);

        sc.close();
    }
}