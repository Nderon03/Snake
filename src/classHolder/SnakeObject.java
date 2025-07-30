package classHolder;

import java.awt.*;

/** Creates the snake.
 * @author Nderon Beqiri-modified */
public abstract class SnakeObject
{
    int x;
    int y;
    Image i;
    int w;
    int h;

    /**Determines whether object is terminated*/
    public boolean l;


    /**Draws images*/
    public abstract void draw(Graphics g);

    /**Gets rectangle*/
    public Rectangle getRectangle()
    {
        return new Rectangle(x, y, w, h);
    }
}