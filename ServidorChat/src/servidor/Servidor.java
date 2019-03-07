package servidor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Servidor {

    public static void main(String[] args) {
        
        try {
            /*
            Pedimos el puerto que vamos a usar por pantalla
            y creamos el socket del sevidor.
            */
            System.out.println("Creando socket servidor");
            int puerto = Integer.parseInt(JOptionPane.showInputDialog("Dime el puerto"));
            ServerSocket serverSocket = new ServerSocket();
            /*
            Guardamos en un objeto de tipo InetSocketAddress nuestra direccion IP, en esta caso localhost y 
            el puerto anteriormente pedido y lo metemos dentro del bind de nuestro socket.
            
            */
            System.out.println("Realizando el bind");

            InetSocketAddress addr = new InetSocketAddress("localhost", puerto);
            serverSocket.bind(addr);
            /*
            Iniciamos un bucle para que se puedan conectar hasta 10 clientes,
            esto lo sabremos gracias a nuestro arraylist para saber cuando sale un cliente o entra,
            en el momento que sean mas de 10 deja de conectarse y quedan esperando.
            */
            while (Clientes.clientes.size() <= 10) {
                /*
                Dentro creamos un nuevo socket para cada cliente y iniciamos la clase cliente que extiende de un hilo.
                */
                Socket newSocket = serverSocket.accept();

                new cliente(newSocket).start();
                
            }

        } catch (IOException e) {

        }

    }

}
/*
La clase cliente extiende de un hilo para que lea todos los mensajes y se conecten todos los clientes a ella simultaneamente.
*/
class cliente extends Thread {
    /*
    Creamos un socket que sera el del cliente, declaramos un InputStream y Output para la entrada y salida de mensajes.
    */
    private Socket socket;
    InputStream is;
    OutputStream os;


    public cliente(Socket socket) throws IOException {
        this.socket = socket;
        is = socket.getInputStream();
        os = socket.getOutputStream();

    }

    public void run() {
        /*
        Creamos un booleano a true para que cuando haya una desconexion el do while deje de correr, en ese cliente en concreto.
        Estos bucles estan para poder leer cada mensaje que llegue.
        */
        Boolean des = true;
        try {
            do {
                /*
                mensaje es donde guardamos cada entrada desde el cliente y lo leemos con el inputStream. read
                Esto esta en bytes asique lo guardamos en una variable String haciendo la conversión.
                */
                byte[] mensaje = new byte[100];

                is.read(mensaje);

                String men = new String(mensaje);
                /*
                Desde el cliente cuando se produce una conexión y Desconexión se envía el nick, la direccion ip, el puerto 
                y ademas un codigo que sera /conn para conexion o /desc para desconexión.
                Con estos if comprobamos si el mensaje contiene esos codigos con el .contains.
                */
                if (men.contains("/conn")) {
                    /*
                    En caso de conexion hacemos un split para separar los mensajes, guardamos en una variable el nick
                    y lo mostramos por pantalla al servidor, guardamos en el arraylist de la clase cliente el socket y el id
                    y mostramos por pantalla el nuevo cliente con toda su información.
                    */
                    String[] mensx = men.split("/");
                    String id = mensx[0];
                    System.out.println(id);
                    new Clientes(socket, mensx[0]);
                    System.out.println("Nuevo cliente: " + mensx[0] + " / " + mensx[2] + " / " + mensx[3] + " / " + mensx[4]);
                    /*
                    Este for que recorre todo nuestro arraylist funciona para poder enviar cada mensaje a todos los clientes
                    y que puedan recibir los mensajes desde otros clientes.
                    */
                    for (Clientes cli : Clientes.clientes) {
                        /*
                        Guardamos en una variable el mensaje que se va amostrar en el chat, el id y que se ha conectado.
                        ademas actualizamos los clientes que hay actualmente y mandamos ambos mensajes que se mostraran por pantalla.
                        */
                        String conex = mensx[0] + " se ha conectado";
                        String usu = "Actualmente hay " + Clientes.clientes.size() + " clientes conectados";
                        System.out.println("Actualmente hay " + Clientes.clientes.size() + " clientes conectados");
                        /*
                        getSocket saca todos los sockets de cada cliente y el getOutputstream funciona para enviar con el metodo write.
                        */
                        cli.getSocket().getOutputStream().write(conex.trim().getBytes());

                        cli.getSocket().getOutputStream().write(usu.trim().getBytes());

                    }
                    /*
                    Con contains ahora compramos que se produce una desconexion.
                    */
                } else if (men.contains("/descn")) {
                    /*
                    Realizamos otro split.
                    */
                    String[] mensx = men.split("/");
                    /*
                    Hacemos este for para poder borrar este cliente del arraylist y asi actualizar la lista.
                    */
                    for (Iterator<Clientes> iterator = Clientes.clientes.iterator(); iterator.hasNext();) {
                        Clientes obj = iterator.next();
                        /*
                        Este if es para comprobar que el socket es que queremos eliminar del array.
                        */
                        if (obj.Socket.equals(socket)) {
                            /*
                            Asi lo borramos del arraylist y cambiamos la condicion a false para que no entre el try la proxuima vez.
                            */
                            iterator.remove();

                            des=false;
                        }
                        
                    }
                    /*
                    Este for es para poder informar en el chat de los cambios producidor, cuantos usuarios hay ahora conectador y que
                    este se ha desconectado.
                    */
                    for (Clientes cli : Clientes.clientes) {
                            String conexi = mensx[0] + " se ha desconectado";
                            String usu = "Actualmente hay " + Clientes.clientes.size() + " clientes conectados";
                            System.out.println("Actualmente hay " + Clientes.clientes.size() + " clientes conectados");
                                
                            cli.getSocket().getOutputStream().write(conexi.trim().getBytes());
                            cli.getSocket().getOutputStream().write(usu.trim().getBytes());
                            }
                    /*
                    Despues cerramos el socket definitivamente.
                    */
                    socket.close();

                } else {
                    /*
                    Este ultimo else es para los mensajes normales el cual mostraremos por pantalla y ya lo mandamos preparado desde el cliente
                    para solo tener que reenviarlo a todos los clientes con el mismo for utilizado en los anteriores.
                    */
                    System.out.println(men);

                    for (Clientes cli : Clientes.clientes) {

                        cli.getSocket().getOutputStream().write(men.trim().getBytes());

                    }

                }
                /*
                La condicion que utilizamos con la desconexion se comprueba aqui.
                */
            } while (des);

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
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
