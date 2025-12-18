public class Agenda {
    private Contacto[] contactos;
    private int capacidad;
    private int contador;

    public Agenda(int capacidad) {
        this.capacidad = capacidad;
        this.contactos = new Contacto[capacidad];
        this.contador = 0;
    }

    public void añadirContacto(Contacto c) throws Exception {
        if (contador >= capacidad) {
            throw new Exception("La agenda está llena.");
        }
        contactos[contador++] = c;
        System.out.println("✅ Contacto añadido: " + c);
    }

    public void listarContactos() {
        if (contador == 0) {
            System.out.println("⚠️ No hay contactos en la agenda.");
        } else {
            for (int i = 0; i < contador; i++) {
                System.out.println(contactos[i]);
            }
        }
    }

    public boolean modificarTelefonoUsuario(String nombre, String apellido, String nuevoTelefono) {
        Contacto c = buscarContacto(nombre, apellido);
        if (c != null) {
            c.setTelefono(nuevoTelefono);
            return true;
        }
        return false;
    }

    public Contacto buscarContacto(String nombre, String apellido) {
        for (int i = 0; i < contador; i++) {
            Contacto c = contactos[i];
            if (c.getNombre().equalsIgnoreCase(nombre) &&
                    c.getApellido().equalsIgnoreCase(apellido)) {
                return c; // Contacto encontrado
            }
        }
        return null; // No se encontró
    }

    public int getContador() {
        return contador;
    }

    public int getCapacidad() {
        return capacidad;
    }
}