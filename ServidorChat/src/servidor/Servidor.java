package servidor;



import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Servidor {

    public static void main(String[] args) {
        try {
           
            System.out.println("Creando socket servidor");

            ServerSocket serverSocket = new ServerSocket();

            System.out.println("Realizando el bind");

            InetSocketAddress addr = new InetSocketAddress("localhost", 1234 );
            serverSocket.bind(addr);
            while (true) {

                System.out.println("Aceptando conexiones");

                Socket newSocket = serverSocket.accept();

                new cliente(newSocket).start();
            }

        } catch (IOException e) {

        }
    }
}


class cliente extends Thread {

    private Socket socket;
    InputStream is;
    OutputStream os;
    
    double resultado = 0;
    String mensajeida;
    public cliente(Socket socket) throws IOException {
        this.socket = socket;
        is = socket.getInputStream();
        os = socket.getOutputStream();

    }

    public void run() {
            

        try {
            
            byte[] mensaje = new byte[100];

            is.read(mensaje);
            System.out.println(new String(mensaje));
           
            
            os.write(mensaje);
            

            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                //Cerramos la conexión
                socket.close();
            } catch (IOException ex) {
                System.out.println("Error al cerrar la conexión");
            }
        }
    }
}