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


    public static void buscarContacto(Scanner sc) {
        if (agenda == null) {
            System.out.println("⚠️ Primero debes crear una agenda.");
            return;
        }
        System.out.print("Ingrese el nombre a buscar: ");
        String buscarNombre = sc.nextLine();
        boolean encontrado = false;
        System.out.print("Ingrese el apellido: ");
        String buscarApellido = sc.nextLine();
        Contacto[] contactos = agenda.getContactos();
        int total = agenda.getContador();
        for (int i = 0; i < total; i++) {
            Contacto contacto = contactos[i];
            if (contacto.getNombre().equalsIgnoreCase(buscarNombre) && contacto.getApellido().equalsIgnoreCase(buscarApellido)) {
                System.out.println("Contacto encontrado: ");
                System.out.println("Nombre : " + contacto.getNombre());
                System.out.println("Apellido : " + contacto.getApellido());
                System.out.println("Telefono : " + contacto.getTelefono());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("❌ Contacto no encontrado.");
        }
    }



    public static void eliminarContacto(Scanner sc) {
        if (agenda == null) {
            System.out.println("⚠️ Primero debes crear una agenda.");
            return;
        }

        System.out.print("Ingrese el nombre a eliminar: ");
        String buscarNombre = sc.nextLine();

        System.out.print("Ingrese el apellido: ");
        String buscarApellido = sc.nextLine();

        Contacto[] contactos = agenda.getContactos();
        int total = agenda.getContador();

        int indice = -1;

        for (int i = 0; i < total; i++) {
            if (contactos[i].getNombre().equalsIgnoreCase(buscarNombre)
                    && contactos[i].getApellido().equalsIgnoreCase(buscarApellido)) {
                indice = i;
                break;
            }
        }

        if (indice == -1) {
            System.out.println("❌ Contacto no encontrado.");
            return;
        }

        for (int i = indice; i < total - 1; i++) {
            contactos[i] = contactos[i + 1];
        }

        contactos[total - 1] = null;

        agenda.setContador(total - 1);

        System.out.println("✅ Contacto eliminado correctamente.");
    }


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

    public static void mostrarAgenda(Scanner sc) {
        if (agenda == null) {
            System.out.println("⚠️ Primero debes crear una agenda.");
            return;
        }
        Contacto[] contactos = agenda.getContactos();

        for (int i = 0; i < contactos.length; i++) {
            System.out.println("----Tus contactos guardados son----");
            System.out.println("Contacto " + i + ": " + contactos[i]);
        }
    }
}