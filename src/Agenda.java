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

    public Contacto[] getContactos() {
        return contactos;
    }

    public int getContador() {
        return contador;
    }

    public int setContador(int contador){
        return contador;
    }
// Aquí puedes ir agregando buscar, eliminar, modificar, etc.
}