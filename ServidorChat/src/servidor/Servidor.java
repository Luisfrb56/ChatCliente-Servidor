package servidor;



import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Servidor {

    public static void main(String[] args) {
        int con=0;
        try {
            
            System.out.println("Creando socket servidor");
            int puerto=Integer.parseInt(JOptionPane.showInputDialog("Dime el puerto"));
            ServerSocket serverSocket = new ServerSocket();

            System.out.println("Realizando el bind");
            
            InetSocketAddress addr = new InetSocketAddress("localhost", puerto);
            serverSocket.bind(addr);
            
            
            
            while (con<=10) {

                System.out.println("Ningún cliente conectado.");
                
                Socket newSocket = serverSocket.accept();
                
               
                new cliente(newSocket).start();
                con+=1;
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
            do{
            byte[] mensaje = new byte[100];
           
            is.read(mensaje);
            System.out.println(new String(mensaje));
            String men=new String(mensaje);
            
            if(men.contains("/conn")){
                String[]mensx=men.split("/");
                
                       
                   
                    String conex=mensx[0]+" se ha conectado";
                    os.write(conex.getBytes());
                   
            }else if(men.contains("/descn")){
                String[]mensx=men.split("/");   
                    
                   
                    String conexi=mensx[0]+" se ha desconectado";
                    os.write(conexi.getBytes());          
            }else{            
            os.write(mensaje);
            
            
            }
                
            }while(true); 
            
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