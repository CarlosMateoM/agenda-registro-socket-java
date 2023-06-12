package agenda.registro.servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import agenda.registro.modelo.Persona;

public class Servidor {
    
     private static final int PUERTO = 12345;

    private final List<Persona> usuarios;

    public Servidor() {
        usuarios = new ArrayList<>();
    }

    public void iniciar() {
        try {
            ServerSocket serverSocket = new ServerSocket(PUERTO);
            
            System.out.println("Servidor iniciado en el puerto " + PUERTO);

            while (true) {
                Socket clienteSocket = serverSocket.accept();
                System.out.println("Cliente conectado: " + clienteSocket);

                ClienteHandler clienteHandler = new ClienteHandler(clienteSocket, usuarios);
                clienteHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
