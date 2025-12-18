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











    public static void modificarTelefono(Scanner sc) { /* ... */ }








    public static void agendaLlena() { /* ... */ }







    public static void espaciosLibres() { /* ... */ }









}