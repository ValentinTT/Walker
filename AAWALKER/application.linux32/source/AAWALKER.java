import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class AAWALKER extends PApplet {

Walker w;
int i = 0;
int gr_mov = 35;

public void setup(){
  
  w = new Walker();
  background(250, 100, 50);
}
public void draw(){
  w.step_mouse(gr_mov);
  w.display(gr_mov);
  i++;
  println(i);
}

class Walker{
  int x, y;
  Walker(){//Constructor.
    x = width / 2;  //Inicia x e y a la mitad del ancho y alto de la pantalla
    y = height / 2; //para que las coordenadas permitan dibujar al circulo cerca o en el centro.
  }
  public void step(int mov){
    int choice = (int)random(4);//Numero alazar entre 0 y 4 (0, 1, 2, 3)
    if(choice == 0 && x + mov < width) x += mov;  //Si el n\u00famero corresponde a 0 y al sumarle el corriento queda dentro de la ventana se asigna.
    else if(choice == 1 && x - mov > -1) x -= mov;//Lo mismo para todos los casos.
    else if(choice == 2 && y + mov < height) y += mov;
    else if(choice == 3 && y - mov > -1) y -= mov;
  }
  public void step_mouse(int mov){//Da 50% de que el el punto siga al mouse presionado.
    if(!mousePressed) step(mov);//Si el mouse no se presiona se mueve a la otra funcion
    
    else if((int)random(2) == 0){//Si el n\u00famero random es 0.
      if(mouseX > x && x + mov < width) x += mov; //Mismo mecanismo de asignaci\u00f3n que el de la funci\u00f3n step(int mov)
      else if(x - mov > -1) x -= mov;
      if(mouseY > y && y + mov < height) y += mov;
      else if(y - mov > -1) y -= mov;
    }
    else step(mov); //Si el n\u00famero random es 1
  }
  public void display(int gr){//Imprime el punto(x,y)
    smooth();
    strokeWeight(gr);//Grosor del punto
    stroke(random(255), random(255), random(255));//Relleno del punto o contorno, porque no tiene relleno
    point(x, y);
  }
  
}
  public void settings() {  size(1600, 900); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "AAWALKER" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
