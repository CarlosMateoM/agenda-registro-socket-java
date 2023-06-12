package agenda.registro.cliente;

import agenda.registro.modelo.Persona;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Cliente {

    private Socket socket;
    private BufferedReader entrada;
    private PrintWriter salida;
    private static final String SERVIDOR_IP = "localhost";
    private static final int SERVIDOR_PUERTO = 12345;

    public void iniciar() {
        try {
            socket = new Socket(SERVIDOR_IP, SERVIDOR_PUERTO);

            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            salida = new PrintWriter(socket.getOutputStream(), true);

            System.out.println("Conectado al servidor");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void agregar(String nombreUsuario, Persona persona) {
        try {
            String mensaje = "AGREGAR" + ":" + nombreUsuario + "," + persona.toString();
            salida.println(mensaje);

            System.out.println(entrada.readLine());
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void iniciarSesion(String nombre) {
        try {
            String mensaje = "INICIAR_SESION" + ":" + nombre;
            salida.println(mensaje);
            System.out.println(entrada.readLine());
            System.out.println("sesion iniciada con nombre " + nombre);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Persona> listar(String usuario) {
        List<Persona> contactos = new ArrayList<>();
        try {
            String mensaje = "LISTAR" + ":" + usuario;
            salida.println(mensaje);

            String linea;
            while ((linea = entrada.readLine()) != null) {

                if (linea.equals("FIN")) {
                    break;
                }

                String[] partes = linea.split(",");
                String nombre = partes[0];
                String correo = partes[1];
                String telefono = partes[2];
                Persona persona = new Persona(nombre, correo, telefono);

                int id = Integer.parseInt(partes[3]);
                persona.setId(id);

                contactos.add(persona);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return contactos;
    }

    public void cerrar() {
        try {
            socket.close();
            System.out.println("Desconectado del servidor");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarContacto(String usuario, int id) {
        try {
            String mensaje = "ELIMINAR" + ":" + usuario + "," + id;
            salida.println(mensaje);
            System.out.println(entrada.readLine());
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Persona buscarContacto(String usuario, String valor) {
        try {
            
            String mensaje = "BUSCAR" + ":" + usuario + "," + valor;
            salida.println(mensaje);
            
            String linea = entrada.readLine();
            
            if(linea.equals("No se encontraron contactos")){
                JOptionPane.showMessageDialog(null, "contacto no encontrado");
                return null;
            }
            
            String[] partes = linea.split(",");
            
            String nombre = partes[0];
            String correo = partes[1];
            String telefono = partes[2];
            
            Persona persona = new Persona(nombre, correo, telefono);
            persona.setId(Integer.parseInt(partes[3]));
            
            return persona;
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
