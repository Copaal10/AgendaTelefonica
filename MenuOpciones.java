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


    public static void verificarContacto(Scanner sc) {

        if (agenda == null) {
            System.out.println("⚠️ Primero debes crear una agenda.");
            return;
        }

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Apellido: ");
        String apellido = sc.nextLine();

        boolean encontrado = false;

        for (int i = 0; i < agenda.getContador(); i++) {
            Contacto contacto = agenda.getContactos()[i];

            if (contacto.getNombre().equalsIgnoreCase(nombre) &&
                    contacto.getApellido().equalsIgnoreCase(apellido)) {

                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            System.out.println("✅ El contacto ya existe.");
        } else {
            System.out.println("❌ El contacto no existe.");
        }
    }


    public static void listarContactos() {

        if (agenda == null) {
            System.out.println("⚠️ Primero debes crear una agenda.");
            return;
        }

        if (agenda.getContador() == 0) {
            System.out.println("⚠️ No hay contactos.");
            return;
        }

        Contacto[] contactos = agenda.getContactos();
        int contador = agenda.getContador();

        for (int i = 0; i < contador - 1; i++) {
            for (int j = 0; j < contador - i - 1; j++) {

                Contacto c1 = contactos[j];
                Contacto c2 = contactos[j + 1];

                int cmpNombre = c1.getNombre()
                        .compareToIgnoreCase(c2.getNombre());

                if (cmpNombre > 0 ||
                        (cmpNombre == 0 &&
                                c1.getApellido().compareToIgnoreCase(c2.getApellido()) > 0)) {

                    Contacto temp = contactos[j];
                    contactos[j] = contactos[j + 1];
                    contactos[j + 1] = temp;
                }
            }
        }

        // Mostrar
        for (int i = 0; i < contador; i++) {
            System.out.println(contactos[i]);
        }
    }







    public static void buscarContacto(Scanner sc) { /* ... */ }










    public static void eliminarContacto(Scanner sc) { /* ... */ }











    public static void modificarTelefono(Scanner sc) { /* ... */ }








    public static void agendaLlena() { /* ... */ }







    public static void espaciosLibres() { /* ... */ }









}