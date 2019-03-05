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
        int contador=0;
        try {
            
            System.out.println("Creando socket servidor");
            int puerto=Integer.parseInt(JOptionPane.showInputDialog("Dime el puerto"));
            ServerSocket serverSocket = new ServerSocket();

            System.out.println("Realizando el bind");
            
            InetSocketAddress addr = new InetSocketAddress("localhost", puerto);
            serverSocket.bind(addr);
            
            
            
            while (con<=10) {
                if(contador!=0){
                    
                    System.out.println("Actualmente hai "+contador+" clientes");
                    
                }else{
                    
                System.out.println("Ningún cliente conectado.");
                
                }
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
            
            String men=new String(mensaje);
            
            if(men.contains("/conn")){
                String[]mensx=men.split("/");
                String id=mensx[0];
                System.out.println(id);
                   new Clientes(socket,mensx[0]);    
                   System.out.println("Nuevo cliente: "+mensx[0]+" / "+mensx[2]+" / "+mensx[3]+" / "+mensx[4]);
                   for (Clientes cli : Clientes.clientes) {
                            
                            
                             String conex=mensx[0]+" se ha conectado";
                            cli.getSocket().getOutputStream().write(conex.trim().getBytes());
                                    
                        
                   
                    
                   }
            }else if(men.contains("/descn")){
                String[]mensx=men.split("/");   
                    
                   for (Clientes cli : Clientes.clientes) {
                            
                            
                             String conexi=mensx[0]+" se ha desconectado";
                            cli.getSocket().getOutputStream().write(conexi.trim().getBytes());

                   }
                              
            }else{       
            System.out.println(men);

            for (Clientes cli : Clientes.clientes) {

                            cli.getSocket().getOutputStream().write(men.trim().getBytes());

                   }
            
            }
                
            }while(true);
            
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                //Cerramos la conexión
                System.out.println("conexion cerrada");
                is.close();
                os.close();
                socket.close();
            } catch (IOException ex) {
                System.out.println("Error al cerrar la conexión");
            }
        }
    }
}