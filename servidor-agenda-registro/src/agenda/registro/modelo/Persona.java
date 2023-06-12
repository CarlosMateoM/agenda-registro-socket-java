package agenda.registro.modelo;

import java.util.ArrayList;
import java.util.List;

public class Persona {

    private int id;
    private String nombre;
    private String correo;
    private String telefono;
    private List<Persona> contactos;

    public Persona(String nombre, String correo, String telefono) {
        id = -1;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        contactos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }
    
    public void agregarContacto(Persona contacto){
        contacto.setId(contactos.size() + 1);
        this.contactos.add(contacto);
    }
    
    public void eliminarContacto(int id){
        this.contactos.remove(id);
    }

    public List<Persona> getContactos() {
        return contactos;
    }
    
    @Override
    public String toString() {
        return nombre + "," + correo + "," + telefono + "," + id;
    }
}

