package agenda.registro.servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import agenda.registro.modelo.Persona;

public class ClienteHandler extends Thread {

    private Socket clienteSocket;
    private PrintWriter salida;
    private BufferedReader entrada;
    private List<Persona> usuarios;

    public ClienteHandler(Socket clienteSocket, List<Persona> usuarios) {
        this.clienteSocket = clienteSocket;
        this.usuarios = usuarios;
    }

    @Override
    public void run() {
        try {
            entrada = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            salida = new PrintWriter(clienteSocket.getOutputStream(), true);

            String mensaje;

            while ((mensaje = entrada.readLine()) != null) {

                String[] partes = mensaje.split(":");

                String accion = partes[0];
                String datos = partes[1];

                System.out.println("menu servidor iternado");

                switch (accion) {
                    case "AGREGAR":
                        agregarContacto(datos);
                        break;
                    case "ELIMINAR":
                        eliminarContacto(datos);
                        break;
                    case "BUSCAR":
                        buscarContacto(datos);
                        break;
                    case "LISTAR":
                        listarContactos(datos);
                        break;
                    case "INICIAR_SESION":
                        iniciarSesion(datos);
                        break;
                    default:
                        salida.println("Acción inválida");
                        break;
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void agregarContacto(String datos) {

        String[] partes = datos.split(",");

        String nombreUsuario = partes[0];
        String nombre = partes[1];
        String correo = partes[2];
        String telefono = partes[3];

        Persona usuarioEncontrado = usuarios.get(getIndiceUsuario(nombreUsuario));

        Persona persona = new Persona(nombre, correo, telefono);

        if (usuarioEncontrado != null) {
            usuarioEncontrado.agregarContacto(persona);
            salida.println("Contacto agregado exitosamente");
        }
    }

    private void eliminarContacto(String datos) {

        String[] partes = datos.split(",");

        String nombreUsuario = partes[0];
        int indice = Integer.parseInt(partes[1]);

        Persona usuarioEncontrado = usuarios.get(getIndiceUsuario(nombreUsuario));

        if (indice >= 0 && indice < usuarioEncontrado.getContactos().size()) {
            usuarioEncontrado.eliminarContacto(indice);
            salida.println("Contacto eliminado exitosamente");
        } else {
            salida.println("Índice de contacto inválido");
        }
    }

    private void buscarContacto(String datos) {
        String[] partes = datos.split(",");
        String nombreUsuario = partes[0];
        String valor = partes[1];

        Persona contactoEncontrado = null;

        Persona usuarioEncontrado = usuarios.get(getIndiceUsuario(nombreUsuario));

        for (Persona persona : usuarioEncontrado.getContactos()) {
            try {

                if (persona.getNombre().equalsIgnoreCase(valor)
                        || persona.getCorreo().equalsIgnoreCase(valor)
                        || persona.getTelefono().equalsIgnoreCase(valor)
                        || persona.getId() == Integer.parseInt(valor)) {
                    contactoEncontrado = persona;
                    break;
                }

            } catch (NumberFormatException e) {}
        }

        if (contactoEncontrado == null) {
            salida.println("No se encontraron contactos");
        } else {
            salida.println(contactoEncontrado.toString());
        }
    }

    private void listarContactos(String nombreUsuario) {
        if (usuarios.isEmpty()) {
            salida.println("No hay contactos registrados");
        } else {

            int indice = getIndiceUsuario(nombreUsuario);

            for (Persona persona : usuarios.get(indice).getContactos()) {
                salida.println(persona.toString());
                System.out.println("iterando lista clientes servidor");
            }
        }
        salida.println("FIN");
        System.out.println("iterancion de clientes servidor terminado");
    }

    private void iniciarSesion(String nombre) {

        int idUsuario = getIndiceUsuario(nombre);

        if (idUsuario == -1) {

            Persona persona = new Persona(nombre, "usuario", "usuario");
            persona.setId(usuarios.size() + 1);

            usuarios.add(persona);

            salida.println("usuario agregado exitosamente");
        } else {

            salida.println(nombre + " inicio sesion correctamente");
        }
    }

    private int getIndiceUsuario(String nombreUsuario) {
        for (Persona usuario : usuarios) {
            if (usuario.getNombre().equals(nombreUsuario)) {
                return (usuario.getId() - 1);
            }
        }
        return -1;
    }

}
