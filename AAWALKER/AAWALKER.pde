Walker w;
int i = 0;
int gr_mov = 35;

void setup(){
  size(1600, 900);
  w = new Walker();
  background(250, 100, 50);
}
void draw(){
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
  void step(int mov){
    int choice = (int)random(4);//Numero alazar entre 0 y 4 (0, 1, 2, 3)
    if(choice == 0 && x + mov < width) x += mov;  //Si el número corresponde a 0 y al sumarle el corriento queda dentro de la ventana se asigna.
    else if(choice == 1 && x - mov > -1) x -= mov;//Lo mismo para todos los casos.
    else if(choice == 2 && y + mov < height) y += mov;
    else if(choice == 3 && y - mov > -1) y -= mov;
  }
  void step_mouse(int mov){//Da 50% de que el el punto siga al mouse presionado.
    if(!mousePressed) step(mov);//Si el mouse no se presiona se mueve a la otra funcion
    
    else if((int)random(2) == 0){//Si el número random es 0.
      if(mouseX > x && x + mov < width) x += mov; //Mismo mecanismo de asignación que el de la función step(int mov)
      else if(x - mov > -1) x -= mov;
      if(mouseY > y && y + mov < height) y += mov;
      else if(y - mov > -1) y -= mov;
    }
    else step(mov); //Si el número random es 1
  }
  void display(int gr){//Imprime el punto(x,y)
    smooth();
    strokeWeight(gr);//Grosor del punto
    stroke(random(255), random(255), random(255));//Relleno del punto o contorno, porque no tiene relleno
    point(x, y);
  }
  
}