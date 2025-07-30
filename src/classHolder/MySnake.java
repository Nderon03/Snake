package classHolder;

import GameUtilities.GameUtil;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

/**Sets up snake object and its attributes.
 * @author Nderon Beqiri-modified
 */
public class MySnake extends SnakeObject
{
    private int m_speed_XY;
    private int m_length;
    private int m_num;
    /**Total score achieved that will be diplayed to user during and after game*/
    public int score = 0;
    private static final BufferedImage IMG_SNAKE_HEAD =
            (BufferedImage) ImageUtil.images.get("snake-head-right");
    private static final BufferedImage IMG_SNAKE_HEAD_RED =
            (BufferedImage) ImageUtil.images.get("snake-head-right-red");
    private static List<Point> bodyPoints = new LinkedList<>();

    private static BufferedImage newImgSnakeHead;
    private boolean m_up, m_down, m_left, m_right = true;

    /**Determines if snake is red or green*/
    public static int isRed=0;


    /**Returns value of up*/
    public boolean GetUp(){
        return m_up;
    }

    /**Returns value of down*/
    public boolean GetDown(){
        return m_down;
    }

    /**Returns value of left*/
    public boolean GetLeft(){
        return m_left;
    }

    /**Returns value of right*/
    public boolean GetRight(){
        return m_right;
    }

    /**Return the length of the snake*/
    public int GetLength()
    {
        return m_length;
    }

    /**Change the length of the snake*/
    public void ChangeLength(int length)
    {
        this.m_length = length;
    }
    /**Check which key has been pressed and forms a response*/

    /**Set initial speed of snake*/
    public int SetNormalSpeed(){
        this.m_speed_XY=5;
        return this.m_speed_XY;
    }

    /**Changes speed of snake*/
    public void ChangeSpeed(){
        this.m_speed_XY+=1;
    }



    /**Creation of snake object.*/
    public MySnake(int x, int y)
    {

        this.l = true;
        this.x = x;
        this.y = y;
        //checks if snake is going to be green or red
        if(isRed!=1) {
            this.i = ImageUtil.images.get("snake-body");
        }
        else{
            this.i=ImageUtil.images.get("snake-body-red");
        }
        this.w = i.getWidth(null);
        this.h = i.getHeight(null);

        this.m_speed_XY = 5;
        this.m_length = 1;

        this.m_num = w / m_speed_XY;
        if(isRed!=1) {
            newImgSnakeHead = IMG_SNAKE_HEAD;
        }
        else{
            newImgSnakeHead=IMG_SNAKE_HEAD_RED;
        }

    }


    /**Control scheme*/
    public void keyPressed(KeyEvent e)
    {
        switch (e.getKeyCode())
        {
            case KeyEvent.VK_UP:
                //left hand case
            case KeyEvent.VK_W:
                if (!m_down)
                {
                    m_up = true;
                    m_down = false;
                    m_left = false;
                    m_right = false;

                    if(isRed!=1) {
                        newImgSnakeHead = (BufferedImage)
                                GameUtil.rotateImage(IMG_SNAKE_HEAD, -90);
                    }
                    else {
                        newImgSnakeHead = (BufferedImage)
                                GameUtil.rotateImage(IMG_SNAKE_HEAD_RED, -90);
                    }
                }
                break;

            case KeyEvent.VK_DOWN:
                //left hand case
            case KeyEvent.VK_S:
                if (!m_up)
                {
                    m_up = false;
                    m_down = true;
                    m_left = false;
                    m_right = false;

                    if(isRed!=1) {
                        newImgSnakeHead = (BufferedImage)
                                GameUtil.rotateImage(IMG_SNAKE_HEAD, 90);
                    }
                    else{
                        newImgSnakeHead = (BufferedImage)
                                GameUtil.rotateImage(IMG_SNAKE_HEAD_RED, 90);
                    }
                }
                break;


            case KeyEvent.VK_LEFT:
                //left hand case
            case KeyEvent.VK_A:
                if (!m_right)
                {
                    m_up = false;
                    m_down = false;
                    m_left = true;
                    m_right = false;

                    if(isRed!=1) {
                        newImgSnakeHead = (BufferedImage)
                                GameUtil.rotateImage(IMG_SNAKE_HEAD, -180);
                    }
                    else {
                        newImgSnakeHead = (BufferedImage)
                                GameUtil.rotateImage(IMG_SNAKE_HEAD_RED, -180);
                    }

                }
                break;

            case KeyEvent.VK_RIGHT:
                //left hand case
            case KeyEvent.VK_D:
                if (!m_left)
                {
                    m_up = false;
                    m_down = false;
                    m_left = false;
                    m_right = true;

                    if(isRed!=1) {
                        newImgSnakeHead = IMG_SNAKE_HEAD;
                    }
                    else{
                        newImgSnakeHead = IMG_SNAKE_HEAD_RED;
                    }
                }
                break;

            default:
                break;
        }
    }


    /**Inherited from interface movable, alters the method*/
    private void move()
    {
        if (m_up)
        {
            y -= m_speed_XY;
        } else if (m_down)
        {
            y += m_speed_XY;
        } else if (m_left)
        {
            x -= m_speed_XY;
        } else if (m_right)
        {
            x += m_speed_XY;
        }

    }


    /**Draws snake*/
    @Override
    public void draw(Graphics g)
    {
        outOfBounds();
        eatBody();

        bodyPoints.add(new Point(x, y));

        if (bodyPoints.size() == (this.m_length + 1) * m_num)
        {
            bodyPoints.remove(0);
        }
        g.drawImage(newImgSnakeHead, x, y, null);
        drawBody(g);

        move();
    }

    /**If snake head intersects snake body*/
    private void eatBody()
    {
        for (Point point : bodyPoints)
        {
            for (Point point2 : bodyPoints)
            {
                if (point.equals(point2) && point != point2)
                {
                    this.l = false;
                }
            }
        }
    }

    /**Draw body of snake*/
    private void drawBody(Graphics g)
    {
        int length = bodyPoints.size() - 1 - m_num;

        for (int i = length; i >= m_num; i -= m_num)
        {
            Point point = bodyPoints.get(i);
            g.drawImage(this.i, point.x, point.y, null);
        }
    }

    /**Determine boundaries of frame*/
    private void outOfBounds()
    {
        //fix out of bounds for top, bottom, left and right
        boolean xOut = (x <= 0 || x >= (860 - w));
        boolean yOut = (y <= 0 || y >= (525 - h));
        if (xOut || yOut)
        {
            l = false;
        }
    }
}