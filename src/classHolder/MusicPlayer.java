package classHolder;

import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

/** Called when requesting to play audio files
 * @author Nderon Beqiri-modified */
public class MusicPlayer extends Thread
{
	private String m_filename;
	private Player m_player;

	/**Stores the current file which has been called*/
	public MusicPlayer(String filename)
	{
		this.m_filename = filename;
	}

	/**Sets up to play the file audio*/

	public void Play()
	{
		new Thread()
		{
			@Override
			public void run()
			{
				super.run();
				try
				{
					//BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(filename));
					m_player = new Player(new BufferedInputStream(new FileInputStream(m_filename)));
					m_player.play();

				} catch (Exception e)
				{
					System.out.println(e);
				}
			}
		}.start();
	}



	/**Plays the file audio*/
	public static boolean GetMusicPlay(String filename)
	{
		MusicPlayer musicPlayer = new MusicPlayer(filename);
		musicPlayer.Play();
		return true;

	}


}
