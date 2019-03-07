/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

import com.sun.glass.events.KeyEvent;
import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Luis Fernando
 */
public class clientes extends javax.swing.JFrame {
    
    /*
    Creamos el socket del cliente y los input y output stream para enviar y leer mensajes, ademas iniciamos la variable nick para
    guardar el id de cada cliente, c=0 es para comprobar si hay que desconectar o conectar como veremos abajo.
    */
    int c = 0;
    Socket clienteSocket;
    static InputStream is;
    static OutputStream os;
    String nick;
    public clientes() throws IOException {
        initComponents();
        /*
        Estas Ima e ima2 son los fondos que tiene cada panel, el del chat y el de la conexión.
        */
        Imagen1 ima=new Imagen1();
        jPanel1.add(ima);
        jPanel1.repaint();
        
        Imagen2 ima2=new Imagen2();
        jPanel2.add(ima2);
        jPanel2.repaint();
        /*
        Ponemos a false los botones del chat hasta que no se producta la conexion.
        */
                jtMensaje.setEnabled(false);
                jbEnviar.setEnabled(false);
                taChat.setEnabled(false);
                
                
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taChat = new javax.swing.JTextArea();
        jtMensaje = new javax.swing.JTextField();
        jbEnviar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtIP = new javax.swing.JTextField();
        jtServer = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtNick = new javax.swing.JTextField();
        jbConectar = new javax.swing.JButton();
        jbCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));

        taChat.setColumns(20);
        taChat.setRows(5);
        taChat.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(taChat);

        jtMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtMensajeActionPerformed(evt);
            }
        });
        jtMensaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtMensajeKeyPressed(evt);
            }
        });

        jbEnviar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jbEnviar.setText("Enviar");
        jbEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEnviarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CONEXIÓN");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Enderezo IP:");

        jtIP.setText("localhost");

        jtServer.setText("1234");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Porto do Servidor:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nickname:");

        jbConectar.setText("Conectar");
        jbConectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbConectarActionPerformed(evt);
            }
        });

        jbCerrar.setText("Cerrar Cliente");
        jbCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtIP, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtServer)
                    .addComponent(jtNick)
                    .addComponent(jbConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jbCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtIP, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtServer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtNick, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbConectar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(933, 933, 933))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1018, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbConectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbConectarActionPerformed
       

        try {
            /*
            En el boton conectar vamos a comprobar si hay que conectar o desconectar porque este ejecutara ambas acciones.
            c=0 en el if para saber si acaba de empezar la aplicacion o si se ha desconectado en algun momento y quiere volver a conectarse.
             */

            if (c == 0) {
                /*
                Aqui comprobamos que se haya introducido el nick, si no es asi, mandamos un aviso por pantalla de que es necesario.
                */
                if(!jtNick.getText().equalsIgnoreCase("")){
                    
                    /*
                    Si hay un nick pero contiene un espacio pedimos que sea sin el.
                    */    
                        if(!jtNick.getText().contains(" ")){
                            /*
                            Una vez dentro activamos los botones del chat y desactivamos el modificar el puerto, ip, o nick a no ser que se desconecte
                            */
                jtMensaje.setEnabled(true);
                jbEnviar.setEnabled(true);
                taChat.setEnabled(true);
                
                jtIP.setEnabled(false);
                jtServer.setEnabled(false);
                jbCerrar.setEnabled(false);
                /*
                Inicializamos el socket cliente y establecemos la conexion con la ip y el puerto introducidos en la interfaz.
                */
                System.out.println("Creando socket cliente");
                clienteSocket = new Socket();
                
                System.out.println("Estableciendo la conexion");
                InetSocketAddress addr = new InetSocketAddress(jtIP.getText(), Integer.parseInt(jtServer.getText()));
                /*
                Lo metemos en un connect para que se produzca la conexion y inicializamos los input y ouput stream.
                */
                clienteSocket.connect(addr);
                System.out.println("conexion hecha");
                is = clienteSocket.getInputStream();
                os= clienteSocket.getOutputStream();
                /*
                metemos en la variable nick el id del cliente y guardamos la ip de nuestro cliente
                y en una variable conectado guardamos el nick, el codigo conn que para tratar la conexion en el servidor
                y mandamos la direccion ip del cliente, la ip del servidor y el puerto.
                */
                nick=jtNick.getText();
                String thisIp=InetAddress.getLocalHost().getHostAddress();
                String conectado=nick+"/conn"+"/"+thisIp+"/"+jtIP.getText()+"/"+jtServer.getText();
                /*
                Mandamos el mensaje y ejecutamos un hilo que leera todos los mensajes de los clientes.
                */
                os.write(conectado.getBytes());
                new hilos(clienteSocket).start();
                
                jtNick.setEnabled(false);
                /*
                Cambiamos c a 1 para que entre la proxima vez en desconexion.
                */
                c += 1;
                jbConectar.setText("Desconectar");
                        }else{
                            /*
                            El aviso del nick sin espacios
                            */
                            System.out.println("El nick no puede tener espacios");
                        }
                        
                    }else{
                    /*
                    El aviso de nick obligatorio
                    */
                    System.out.println("Escribe tu id");
                    
                }
            } else {
                /*
                Si nos desconectamos volvemos activar los botones para la conexion y bloqueamos los del chat.
                */
                jtMensaje.setEnabled(false);
                jbEnviar.setEnabled(false);
                taChat.setEnabled(false);
                jtNick.setEnabled(true);
                jtIP.setEnabled(true);
                jtServer.setEnabled(true);
                jbCerrar.setEnabled(true);
                /*
                Guardamos el nick y el codigo descn que sera tratado en el servidor
                */
                String desconectado=nick+"/descn";
                /*
                Mandamos el mensaje y cerramos el socket, igualamos c a 0 por si queremos volver a conectarnos desde esta maquina.
                */
                os.write(desconectado.getBytes());
                
                clienteSocket.close();
                System.out.println("Terminado");
                jbConectar.setText("Conectar");
                c=0;
            }

        } catch (IOException e) {

            e.printStackTrace();
        }
    }//GEN-LAST:event_jbConectarActionPerformed

    private void jbCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCerrarActionPerformed
        /*
        Un boton cerrar que cierra completamente la aplicacion pero solo si el cliente no esta conectado.
        */
        System.exit(0);
    }//GEN-LAST:event_jbCerrarActionPerformed

    private void jtMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtMensajeActionPerformed
        
    }//GEN-LAST:event_jtMensajeActionPerformed

    private void jbEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEnviarActionPerformed
        try{
            /*
            Boton enviar.
            */
            
            /*
            Primero tenemos un if para identificar el codigo /bye el cual desconecta al cliente del servidor y bloquea los botones del chat
            y activa los del apartado conexion.
            */
            if(jtMensaje.getText().equalsIgnoreCase("/bye")){
                
                jtMensaje.setEnabled(false);
                jbEnviar.setEnabled(false);
                taChat.setEnabled(false);
                jtNick.setEnabled(true);
                jtIP.setEnabled(true);
                jtServer.setEnabled(true);
                jbCerrar.setEnabled(true);
                /*
                Envia el mensaje para tratar la desconexion y cierra el socket, c=0 para poder volver a conectarse.
                */
                String desconectado=nick+"/descn";
                
                os.write(desconectado.getBytes());
                
                clienteSocket.close();
                System.out.println("Terminado");
                jbConectar.setText("Conectar");
                c=0;
            }else{
            /*
            Tratamos un error muy comun para no enviar mensajes vacios. 
            */
            if(!jtMensaje.getText().equalsIgnoreCase("")){
                
            System.out.println(jtMensaje.getText());
            /*
            Desde aqui enviaremos los mensajes que tambien llevaran en todo momento la fecha y la hora del mensaje ademas del nick.
            */
            Date date=new Date();
            String hora=" ["+date.getDay()+"/"+date.getMonth()+"("+date.getHours()+":"+date.getMinutes()+")"+"]";
            String mens=nick+": "+jtMensaje.getText()+ hora;
            
            /*
            Enviamos el mensaje
            */
            os.write(mens.getBytes());
            
            
            jtMensaje.setText("");
                
            }else{
                System.out.println("Escribe algun mensaje");
            }
                
            }
            
            
                
            
            }catch (IOException e) {
                e.printStackTrace();
        }
    }//GEN-LAST:event_jbEnviarActionPerformed

    private void jtMensajeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtMensajeKeyPressed
        /*
        Esto sirve para que se puedan mandar mensajes solo con el enter.
        */
        char cTecla=evt.getKeyChar();
      if(cTecla==KeyEvent.VK_ENTER){
          jbEnviar.doClick();
      }
    }//GEN-LAST:event_jtMensajeKeyPressed
    /*
    clase que extiende de hilos y crea un socket hijo
    */
    class hilos extends Thread{
    private Socket socket;
    public hilos(Socket socket) throws IOException {
        this.socket = socket;
        
        
    }
    public void run(){
        while (true) {
                    try {
                        /*
                        Aqui podemos recibir los mensajes que nos envie el servidor del resto de clientes y msotrarlos en el chat.
                        */
                        byte[] recibido = new byte[500];
                        is.read(recibido);
                        String mensaje = new String(recibido);
                        taChat.setText(taChat.getText()+"\n"+mensaje);
                
                    } catch (IOException ex) {
                        System.out.println("Fallo recibir ");
                
                }
            }
    }
}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(clientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                           
                
                
            
                try {
                    
                    new clientes().setVisible(true);
                    
                    
                } catch (IOException ex) {
                    Logger.getLogger(clientes.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
            }

        }
        );
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCerrar;
    private javax.swing.JButton jbConectar;
    private javax.swing.JButton jbEnviar;
    private javax.swing.JTextField jtIP;
    private javax.swing.JTextField jtMensaje;
    private javax.swing.JTextField jtNick;
    private javax.swing.JTextField jtServer;
    private static javax.swing.JTextArea taChat;
    // End of variables declaration//GEN-END:variables
}
