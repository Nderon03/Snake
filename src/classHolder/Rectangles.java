package classHolder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import static classHolder.Play.*;

/** Used to instantiate rectangle objects.
 * @author Nderon Beqiri */
public class Rectangles extends JPanel {
    private int m_x, m_y, m_width, m_height;

    private int m_xVelocity=4;//how many pixels rectangles moves x axis
    private int m_yVelocity=2;//how many pixels rectangles move y axis

    /**Sets size of rectangle when called*/
    public Rectangles(int a, int b, int c, int d){
        this.m_x=a;
        this.m_y=b;
        this.m_width=c;
        this.m_height=d;

    }

    /**Returns x_velocity of rectangle*/
    public int GetXVelocity(){
        return m_xVelocity;
    }

    /**Returns y_velocity of rectangle*/
    public int GetYVelocity(){
        return m_yVelocity;
    }

    /**Determines if the snake has touched the obstacle or if food has entered it*/
    public void Boundaries(){
        if(mySnake.x>=this.m_x-25&&mySnake.x<=this.m_x + this.m_width&&
                mySnake.y>=this.m_y-25&&mySnake.y<=this.m_y + this.m_height){
            mySnake.l=false;
        }
        if(choice!=0){
            if(food.x>=this.m_x-25&&food.x<=this.m_x + this.m_width&&
                    food.y>=this.m_y-25&&food.y<=this.m_y + this.m_height) {
                food.l = false;
            }
        }
    }

    /**Draws the rectangle objects*/
    @Override
    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawRect(this.m_x,this.m_y,this.m_width,this.m_height);
        g2D.fillRect(this.m_x,this.m_y,this.m_width,this.m_height);
    }

    /**Determines direction of rectangle based on boundaries*/
    public void actionPerformed(ActionEvent e) {
        if(m_x>=860-this.m_width|| m_x<0){
            m_xVelocity=m_xVelocity*-1;
        }
        m_x=m_x+m_xVelocity;
        repaint();

        if(m_y>=540-this.m_height|| m_y<0){
            m_yVelocity=m_yVelocity*-1;
        }
        m_y=m_y+m_yVelocity;
        repaint();

    }

}
