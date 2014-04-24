package Snake;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Color;

public class Comida {

    Rectangle comida= new Rectangle();
    int lado;
    
    Comida(){
        pintar();
    }
    
    public void draw(Graphics g){
        g.setColor(Color.red);
        g.fillOval(comida.x, comida.y, lado, lado);
    }
    
    public void pintar(){
        lado=10;
        comida.height=lado;
        comida.width=lado;
        comida.x=((int)(Math.random()*30))*10;
        comida.y=((int)(Math.random()*30))*10;
    }
    
    public Rectangle GetBounds(){
        return comida;
    }
}
