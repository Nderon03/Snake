package classHolder;

import java.awt.*;
import java.util.Random;

import static classHolder.Play.choice;
import static classHolder.Play.food;

/** Called to display food image in frame when game begins
 * @author Nderon Beqiri-modified */
public class Food extends SnakeObject
{

	/**Selects which image to be shown at random*/
	public int fd;
	/**Sets image of fruit to one of the 17 images stored in ImageUtil class*/
	public Food()	{
		this.l = true;
		//initialises fruits 0-9 to come up but we want 0-16
		this.fd = new Random().nextInt(18);
		this.i = ImageUtil.images.get(String.valueOf(fd));
		this.w = i.getWidth(null);
		this.h = i.getHeight(null);

		//spawn food at random areas
		this.x = (int) (Math.random() * (860 - w));
		this.y = (int) (Math.random() * (550 - h - 40));
	}

	/**Determines if the snake has eaten the food; intersecting coordinates*/
	public void Eaten(MySnake mySnake)	{

		if (mySnake.getRectangle().intersects(this.getRectangle()) && l && mySnake.l)		{
			//if advanced level
			if(choice==3){
				//if fruit is red then go back to normal speed
				if(food.fd==4||food.fd==7||food.fd==15||food.fd==16){
					mySnake.SetNormalSpeed();
				}
				//increase speed if fruit eaten is not red
				else {
					mySnake.ChangeSpeed();
				}

			}

			this.l = false;
			mySnake.ChangeLength(mySnake.GetLength() + 1);
			//when food is consumed by snake, increment score by 500
			if(food.fd!=17) {
				mySnake.score += 500;
			}
			if(food.fd==17){
				mySnake.score += 2000;
			}
		}
	}
	/**Draws the food in the frame*/
	@Override
	public void draw(Graphics g)
	{
		g.drawImage(i, x, y, null);
	}
}
