package Snake;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.awt.Graphics;
import javax.swing.JOptionPane;

public class Snake {

    LinkedList <Rectangle> snake = new LinkedList();
    int lado=10;
    int x, y;
    int body=3;
    char move;
    boolean grow;
    Comida comida;
    
    Snake(Comida comida){
       this.comida=comida;
        x=150;
        y=150;
        for (int i=0; i<body; i++){
            Rectangle r= new Rectangle (x, y, lado, lado);
            snake.add(r);
            y+=10;
        }
        grow=false;
    }
    
    public void draw(Graphics g){
        g.setColor(Color.black);
        for (int i=0; i<body; i++){
            Rectangle r=snake.get(i);
            g.fillRect(r.x, r.y, r.width, r.height);
        }
        for (int i=1; i<snake.size(); i++)
        if (this.snake.getFirst().intersects(snake.get(i)))
            gameOver();
    }
    
    public void left(){
        Rectangle r= new Rectangle(snake.getFirst());
        r.x-=lado;
        if (r.x<0)
            r.x=300-lado;
        snake.addFirst(r);
        if (!r.intersects(comida.GetBounds()))
            snake.removeLast();
        else
        {
            body++;
            comida.pintar();
        }    
     }
    
    public void right(){
        Rectangle r= new Rectangle(snake.getFirst());
        r.x+=lado;
        if (r.x>=300)
            r.x=0;
        snake.addFirst(r);
        if (!r.intersects(comida.GetBounds()))
            snake.removeLast();
        else
        {
            body++;
            comida.pintar();
        }
    }
    public void up(){
        Rectangle r= new Rectangle(snake.getFirst());
        r.y-=lado;
        if (r.y<0)
            r.y=300-lado;
        snake.addFirst(r);
        if (!r.intersects(comida.GetBounds()))
            snake.removeLast();
        else
        {
            body++;
            comida.pintar();
        }
    }
    public void down(){
        Rectangle r= new Rectangle(snake.getFirst());
        r.y+=lado;
        if (r.y>=300)
            r.y=0;
        snake.addFirst(r);
        if (!r.intersects(comida.GetBounds()))
            snake.removeLast();
        else
        {
            body++;
            comida.pintar();
        }
    }

    public char getMove() {
        return move;
    }

    public void setMove(char move) {
        this.move = move;
    }
    
    public void gameOver(){
        JOptionPane.showMessageDialog(null, "Has perdido");
        System.exit(0);    
    }
    
    public Rectangle getPosicion(){
        return new Rectangle(x, y, lado, lado);
    }
}
