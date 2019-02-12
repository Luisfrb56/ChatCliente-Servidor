package clientes;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Imagen1 extends JPanel{  
    

public Imagen1(){
    this.setSize(350, 525); 

}
 
//Se crea un método cuyo parámetro debe ser un objeto Graphics
 
public void paint(Graphics grafico) {
Dimension height = getSize();
 
//Se selecciona la imagen que tenemos en el paquete de la //ruta del programa
 
ImageIcon Img = new ImageIcon(getClass().getResource("creed.jpg")); 
 
//se dibuja la imagen que tenemos en el paquete Images //dentro de un panel
 
grafico.drawImage(Img.getImage(), -45, 50, height.width, height.height, null);
 
setOpaque(false);
super.paintComponent(grafico);
}
}



