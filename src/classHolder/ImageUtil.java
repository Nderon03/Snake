package classHolder;

import GameUtilities.GameUtil;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/** Determines how images will be referenced in code for simplicity
 * @author Nderon Beqiri-modified */
public class ImageUtil
{
	/**Maps key (image), to value (name of path)*/
	public static Map<String, Image> images = new HashMap<>();

	static
	{
		// snake
		images.put("snake-head-right", GameUtil.getImage("classHolder/snake-head-right.png"));
		images.put("snake-head-right-red", GameUtil.getImage("classHolder/snake-head-right-red.png"));
		images.put("snake-body", GameUtil.getImage("classHolder/snake-body.png"));
		images.put("snake-body-red", GameUtil.getImage("classHolder/snake-body-red.png"));
		// food
		images.put("0", GameUtil.getImage("GameUtilities/food-kiwi.png"));
		images.put("1", GameUtil.getImage("GameUtilities/food-lemon.png"));
		images.put("2", GameUtil.getImage("GameUtilities/food-litchi.png"));
		images.put("3", GameUtil.getImage("GameUtilities/food-mango.png"));
		images.put("4", GameUtil.getImage("GameUtilities/food-apple.png"));
		images.put("5", GameUtil.getImage("GameUtilities/food-banana.png"));
		images.put("6", GameUtil.getImage("GameUtilities/food-blueberry.png"));
		images.put("7", GameUtil.getImage("GameUtilities/food-cherry.png"));
		images.put("8", GameUtil.getImage("GameUtilities/food-durian.png"));
		images.put("9", GameUtil.getImage("GameUtilities/food-grape.png"));
		images.put("10", GameUtil.getImage("GameUtilities/food-grapefruit.png"));
		images.put("11", GameUtil.getImage("GameUtilities/food-peach.png"));
		images.put("12", GameUtil.getImage("GameUtilities/food-pear.png"));
		images.put("13", GameUtil.getImage("GameUtilities/food-orange.png"));
		images.put("14", GameUtil.getImage("GameUtilities/food-pineapple.png"));
		images.put("15", GameUtil.getImage("GameUtilities/food-strawberry.png"));
		images.put("16", GameUtil.getImage("GameUtilities/food-watermelon.png"));
		//bonus
		images.put("17", GameUtil.getImage("GameUtilities/dollar.png"));
		//backgrounds
		images.put("UI-background", GameUtil.getImage("classHolder/UI-background.png"));
		images.put("UI-background2", GameUtil.getImage("classHolder/UI-background2.png"));
		images.put("UI-background3", GameUtil.getImage("classHolder/UI-background3.png"));
		//if game ends and user gets score above 0
		images.put("game-scene-01", GameUtil.getImage("classHolder/game-scene-01.jpg"));
		//if user achieves score of 0
		images.put("lowscore", GameUtil.getImage("GameUtilities/lowscore.png"));
	}
}


