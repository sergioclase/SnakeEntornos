package Snake;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MiCanvas extends Canvas implements KeyListener{
    
    Snake snake;
    Comida comida;
    
    MiCanvas(Snake snake, Comida comida){
        this.setBackground(Color.white);
        this.setBounds(50, 50, 300, 300);
        this.snake=snake;
        this.comida=comida;
        this.addKeyListener(this);
    }
    
    public void paint (Graphics g){
        snake.draw(g);
        comida.draw(g);
    }
     @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key=e.getKeyCode();
         if(key==KeyEvent.VK_LEFT)
             if (snake.getMove()=='R'){}
                 else
                    snake.setMove('L');
         if(key==KeyEvent.VK_RIGHT)
             if (snake.getMove()=='L'){}
                else
                    snake.setMove('R');
         if(key==KeyEvent.VK_UP)
             if (snake.getMove()=='D'){}
                else
                 snake.setMove('U');
         if(key==KeyEvent.VK_DOWN)
             if (snake.getMove()=='U'){}
                else
                    snake.setMove('D');
         
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
