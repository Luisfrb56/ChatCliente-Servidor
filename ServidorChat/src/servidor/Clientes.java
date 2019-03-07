package servidor;

import java.net.Socket;
import java.util.ArrayList;
/*
Clase cliente que guarda en un arraylist los usuarios que se vayan conectando, teniendo su información y 
contando cuantos hay conectados en cada momento.
*/
public class Clientes {
    
     public static  ArrayList<Clientes> clientes = new ArrayList<Clientes>();
      Socket Socket;
      String nick;
    /*
    Constructor  
    */
    public Clientes() {
    }
    /*
    Guarda el socket del cliente y el nick y lo añade en el array.
    */ 
    public Clientes(Socket rSocket, String rNick) {
        Socket=rSocket;
        nick=rNick;
        clientes.add(this);
    }
    /*
    Para acceder al socket.
    */
    public Socket getSocket() {
        return Socket;
    }
    /*
    Por si queremos modificarlo desde otra clase.
    */
    public void setSocket(Socket Socket) {
        this.Socket = Socket;
    }
    /*
    Para acceder al nick.
    */
    public String getNick() {
        return nick;
    }
    /*
    Por si queremos modificar el nick de algun cliente dentro solo del arraylist.
    */
    public void setNick(String nick) {
        this.nick = nick;
    }
}
