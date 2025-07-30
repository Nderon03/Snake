package classHolder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Random;

/** Called when user clicks Begin button with correct input in StartScreen.
 * @author Nderon Beqiri-modified */
public class Play extends MyFrame
{
	ActionEvent e;
	private ScoreToFile username = new ScoreToFile();
	private static final long serialVersionUID = -3641221053272056036L;
	private int m_counter=0;

	private ScoreToFile highscore = new ScoreToFile();
	/**Determines which gamemode is to be played*/
	public static int choice;

	/**Creation of snake object*/
	public static MySnake mySnake = new MySnake(100, 100);// x , y
	/**Creation of food object*/
	public static Food food = new Food();
	private Image background = ImageUtil.images.get("UI-background");
	private Image background2 = ImageUtil.images.get("UI-background2");
	private Image extraLevel = ImageUtil.images.get("UI-background3");

	private Image fail = ImageUtil.images.get("game-scene-01");

	private Image zero = ImageUtil.images.get("lowscore");

	private Rectangles rec1 = new Rectangles(300,200,25,50);
	private Rectangles rec2 = new Rectangles(500,300,75,150);
	private Rectangles rec3 = new Rectangles(400,100,100,30);
	private Rectangles rec4 = new Rectangles(200,200,15,300);

	private Rectangles rec5 = new Rectangles(400,100,300,350);
	private Rectangles rec6 = new Rectangles(230,80,15,325);
	private Rectangles rec7 = new Rectangles(245,262,400,15);
	private Rectangles rec8 = new Rectangles(100,80,400,15);
	private Rectangles rec9 = new Rectangles(630,277,15,200);
	private Rectangles rec10 = new Rectangles(500,40,15,120);
	private Rectangles rec11 = new Rectangles(500,160,275,15);
	private Rectangles rec12 = new Rectangles(760,170,15,310);
	Random random = new Random();
	private Rectangles addedRec = new Rectangles(random.nextInt(380),random.nextInt(500),random.nextInt(200),random.nextInt(200));
	private Rectangles addedRec2 = new Rectangles(random.nextInt(380),random.nextInt(500),random.nextInt(200),random.nextInt(200));
	private Rectangles addedRec3 = new Rectangles(random.nextInt(380),random.nextInt(500),random.nextInt(200),random.nextInt(200));
	private Rectangles addedRec4 = new Rectangles(random.nextInt(380),random.nextInt(500),random.nextInt(200),random.nextInt(200));

	private float r = random.nextFloat();
	private float gr = random.nextFloat();
	private float b = random.nextFloat();
	private float r2 = random.nextFloat();
	private float gr2 = random.nextFloat();
	private float b2 = random.nextFloat();
	private float r3 = random.nextFloat();
	private float gr3 = random.nextFloat();
	private float b3 = random.nextFloat();
	private float r4 = random.nextFloat();
	private float gr4 = random.nextFloat();
	private float b4 = random.nextFloat();

	/**Returns counter*/

	public int GetCounter(){
		return m_counter;
	}

	/**Action when key pressed*/
	@Override
	public void keyPressed(KeyEvent e)
	{
		super.keyPressed(e);
		mySnake.keyPressed(e);

	}

	/**Draw backgrounds and images*/
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2D = (Graphics2D) g;
		//draw Sky Background
		if(choice==0) {
			g.drawImage(background, 0, 0, null);
			//drawing obstacles for sky background
			g2D.setPaint(Color.blue);
			rec1.paint(g);

			g2D.setPaint(Color.red);
			rec2.paint(g);

			g2D.setPaint(Color.black);
			rec3.paint(g);

			g2D.setPaint(Color.green);
			rec4.paint(g);


		}

		//draw Happy background
		else if(choice==2){
			g.drawImage(background2, 0, 0, null);
			//draw triangle obstacle
			int[] xPoints ={150,250,350};
			int[] yPoints ={300,150,300};
			g2D.setPaint(Color.yellow);
			g2D.drawPolygon(xPoints,yPoints,3);
			g2D.fillPolygon(xPoints,yPoints,3);
			g2D.setPaint(Color.magenta);
			g2D.setFont(new Font("Ink Free",Font.BOLD,15));
			g2D.drawString("You can enter",200,255);
			g2D.drawString("But",230,275);
			g2D.drawString("Do not touch vertices!",170,295);


			//determine boundaries for triangle
			if((mySnake.x>=137&&mySnake.x<=145)&&(mySnake.y>=297&&mySnake.y<=301)){
				mySnake.l=false;
			}
			if((mySnake.x>=237&&mySnake.x<=245)&&(mySnake.y>=147&&mySnake.y<=154)){
				mySnake.l=false;
			}
			if((mySnake.x>=337&&mySnake.x<=345)&&(mySnake.y>=297&&mySnake.y<=301)){
				mySnake.l=false;
			}

			//draw square obstacle
			g2D.setPaint(Color.pink);
			rec5.paint(g);
			g2D.setPaint(new Color(r,gr,b));
			if(mySnake.score>500){
				addedRec.paint(g);
				addedRec.Boundaries();
			}
			g2D.setPaint(new Color(r2,gr2,b2));
			if(mySnake.score>1500){
				addedRec2.paint(g);
				addedRec2.Boundaries();
			}
			g2D.setPaint(new Color(r3,gr3,b3));
			if(mySnake.score>2500){
				addedRec3.paint(g);
				addedRec3.Boundaries();
			}
			g2D.setPaint(new Color(r4,gr4,b4));
			if(mySnake.score>3500){
				addedRec4.paint(g);
				addedRec4.Boundaries();
			}


		}



		//draw Advanced Level Background
		else{

			g.drawImage(extraLevel, 0, 0, null);
			//draw rectangles and interlink them, forming a maze
			g2D.setPaint(Color.white);
			rec6.paint(g);
			rec7.paint(g);
			rec8.paint(g);
			rec9.paint(g);
			rec10.paint(g);
			rec11.paint(g);
			rec12.paint(g);




		}


		//if snake is true
		if (mySnake.l)
		{
			if(choice==0) {
				rec1.Boundaries();
				if(mySnake.score>500) {
					rec1.actionPerformed(e);
				}
				rec2.Boundaries();
				if(mySnake.score>1500){
					rec2.actionPerformed(e);
				}
				rec3.Boundaries();
				if(mySnake.score>2500){
					rec3.actionPerformed(e);
				}
				rec4.Boundaries();
				if(mySnake.score>3500){
					rec4.actionPerformed(e);
				}

			}
			if(choice==2){
				rec5.Boundaries();
			}
			if(choice==3) {
				rec6.Boundaries();
				rec7.Boundaries();
				rec8.Boundaries();
				rec9.Boundaries();
				rec10.Boundaries();
				rec11.Boundaries();
				rec12.Boundaries();
			}
			//draw snake
			mySnake.draw(g);
			//if food is true
			if (food.l)
			{
				//draw food
				food.draw(g);
				//call function that determines snake eats food
				food.Eaten(mySnake);



			} else
			{
				//display new food image
				food = new Food();
			}
			//show score on top left
			drawScore(g);


		}

		//if snake dies, display fail image
		else {
			g.drawImage(fail, 120, 100, null);
			drawFinalScore(g);
			//append result to file AllTimeScores.txt
			while(m_counter<1) {
				try {
					highscore.addToHighScore(mySnake.score);
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
				//highscore.readFile();
				m_counter++;
			}
		}

	}

	/**Displays current score on top left of screen*/
	private void drawScore(Graphics g)
	{
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
		g.setColor(Color.MAGENTA);
		g.drawString("SCORE : " + mySnake.score, 20, 40);
	}

	/**Displays final score in center, above end image*/
	private void drawFinalScore(Graphics g)
	{
		//Sky Background final score
		if(choice==0) {
			g.setFont(new Font("Consolas",Font.PLAIN, 30));
			g.setColor(Color.white);
			g.drawString("Final Score : " + mySnake.score, 275, 80);
			g.setColor(Color.BLUE);
			//condition added to not display well played if user achieves score of 0
			if(mySnake.score!=0) {
				//display username entered in start screen
				g.drawString("Well Played: " + username.getUsername(), 275, 450);
			}
		}


		//Happy Background final score
		else if (choice==2) {
			g.setFont(new Font("Consolas",Font.PLAIN, 30));
			g.setColor(Color.orange);
			g.drawString("Final Score : " + mySnake.score, 275, 80);
			g.setColor(Color.BLACK);
			//condition added to not display well played if user achieves score of 0
			if(mySnake.score!=0) {
				g.drawString("Well Played: " + username.getUsername(), 275, 450);
			}

		}


		//Advanced Level Background final score
		else{
			g.setFont(new Font("Consolas",Font.PLAIN, 30));
			g.setColor(Color.MAGENTA);
			g.drawString("Special Level Score : " + mySnake.score, 275, 80);
			g.setColor(Color.white);
			//condition added to not display well played if user achieves score of 0
			if(mySnake.score!=0) {
				g.drawString("Well Played: " + username.getUsername(), 275, 450);
			}
		}


		//Prank message and image if user achieves score of 0
		if(mySnake.score==0){
			g.setColor(Color.RED);
			g.setFont(new Font("Consolas",Font.PLAIN, 30));
			g.drawImage(zero, 120, 100, null);
			g.drawString("404 ERROR- "+username.getUsername()+" -YOU'RE TERRIBLE",220,445);
			g.drawString("You cannot get a lower score",235,475);

		}

	}


	/**Starts game for Basic Level Sky Background*/
	public static void PlayBegins() throws InterruptedException {
		new Play().LoadFrame();
		//Make music loop until the game ends
		while(mySnake.l!=false) {
			MusicPlayer.GetMusicPlay("src/classHolder/frogger.mp3");
			Thread.sleep(7*1190);
			if(mySnake.l==false){
				MusicPlayer.sleep(10000000);
			}
		}


	}

	/**Starts game for Basic Level Happy Background*/
	public static void PlayBegins2() throws InterruptedException {
		choice = 2;
		new Play().LoadFrame();
		//Make music loop until the game ends
		while(mySnake.l!=false) {
			MusicPlayer.GetMusicPlay("src/classHolder/frogger.mp3");
			Thread.sleep(7*1190);
			if(mySnake.l==false){
				MusicPlayer.sleep(10000000);
			}

		}
	}

	/**Starts game for Advanced Level*/
	public static void PlayBegins3() throws InterruptedException {
		choice = 3;
		new Play().LoadFrame();
		//Make music loop until the game ends
		while(mySnake.l!=false) {
			MusicPlayer.GetMusicPlay("src/classHolder/frogger.mp3");
			Thread.sleep(7*1190);
			if(mySnake.l==false){
				MusicPlayer.sleep(10000000);
			}

		}
	}

}
