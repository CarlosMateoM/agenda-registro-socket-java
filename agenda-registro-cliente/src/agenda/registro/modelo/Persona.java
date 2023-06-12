package agenda.registro.modelo;

public class Persona {

    private int id;
    private String nombre;
    private String correo;
    private String telefono;

    public Persona(String nombre, String correo, String telefono) {
        id = -1;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
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

    @Override
    public String toString() {
        return nombre + "," + correo + "," + telefono;
    }
}

