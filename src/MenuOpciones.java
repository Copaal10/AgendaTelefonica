import java.util.Scanner;

public class MenuOpciones {
    public static Agenda agenda; // agenda compartida

    public static void crearAgenda(Scanner sc) {
        System.out.print("Ingrese el tamaño de la agenda (5-10): ");
        int size = sc.nextInt();
        sc.nextLine();
        if (size < 5 || size > 10) {
            System.out.println("❌ Tamaño inválido. Debe estar entre 5 y 10.");
        } else {
            System.out.print("Ingrese el nombre de la agenda: ");
            String nombreAgenda = sc.nextLine();
            agenda = new Agenda(size);
            System.out.println("✅ Agenda '" + nombreAgenda + "' creada con capacidad de " + size + " contactos.");
        }
    }

    public static void añadirContacto(Scanner sc) {
        if (agenda == null) {
            System.out.println("⚠️ Primero debes crear una agenda.");
            return;
        }
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();
        try {
            Contacto c = new Contacto(nombre, apellido, telefono);
            agenda.añadirContacto(c);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Métodos



    public static void verificarContacto(Scanner sc) { /* ... */ }










    public static void listarContactos() { /* ... */ }














    public static void buscarContacto(Scanner sc) { /* ... */ }










    public static void eliminarContacto(Scanner sc) { /* ... */ }









    public static void modificarTelefono(Scanner sc) {
        if (agenda == null) {
            System.out.println("⚠️ Primero debes crear una agenda.");
            return;
        }
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Apellido: ");
        String apellido = sc.nextLine();
        System.out.print("Nuevo teléfono: ");
        String nuevoTelefono = sc.nextLine();
        if (agenda.modificarTelefonoUsuario(nombre, apellido, nuevoTelefono)) {
            System.out.println("✅ Teléfono modificado correctamente.");
        } else {
            System.out.println("❌ Contacto no existe.");
        }
    }

    public static boolean agendaLlena() {
        if (agenda == null) return false;

        boolean llena = agenda.getContador() >= agenda.getCapacidad();

        if (llena) {
            System.out.println("❌ La agenda está llena. No puedes agregar más contactos.");
        } else {
            System.out.println("✅ Hay espacio disponible en la agenda.");
        }
        return llena;
    }

    public static int espaciosLibres() {
        if (agenda == null) {
            System.out.println("⚠️ No hay una agenda creada.");
            return 0;
        }
        int libres = agenda.getCapacidad() - agenda.getContador();
        if (libres > 0) {
            System.out.println("✅ Espacios libres en la agenda: " + libres);
        } else {
            System.out.println("❌ No hay espacios libres en la agenda.");
        }
        return libres;
    }
}











