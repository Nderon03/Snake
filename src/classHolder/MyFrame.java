package classHolder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/** Called when game begins.
 * Sets up frame after stage is closed.
 * This is where game is displayed and played.
 * @author Nderon Beqiri-modified */
public class MyFrame extends JPanel implements KeyListener
{
	private static final long serialVersionUID = -3149926831770554380L;


	private JFrame jFrame = new JFrame();

	/**Set icon of frame in top corner and desktop bar*/
	public MyFrame()
	{
		//set icon of frame to snake logo
		jFrame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				MyFrame.class.getResource("snake-logo.png")));
	}

	/**Set frame attributes*/
	public boolean LoadFrame()
	{

		this.setDoubleBuffered(true);
		jFrame.add(this);
		jFrame.addKeyListener(this);

		//set frame properties
		jFrame.setTitle("Snakee Yipee");
		jFrame.setSize(870, 560);
		jFrame.setLocationRelativeTo(null);
		jFrame.addWindowListener(new WindowAdapter()// loka
		{
			/**Closing of program*/
			@Override
			public void windowClosing(WindowEvent e)
			{
				super.windowClosing(e);
				System.exit(0);
			}
		});
		jFrame.setVisible(true);

		new MyThread().start();
		return true;
	}
	class MyThread extends Thread
	{
		@Override
		public void run()
		{
			super.run();
			while (true)
			{
				repaint();
				try
				{
					sleep(30);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	/**Key has been typed*/
	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

	/**Key has been pressed*/
	@Override
	public void keyPressed(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

	/**Key has been let go*/
	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

}



