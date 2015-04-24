package edu.davenport.cisp340.reaction;

import java.util.*;

public class TargetTimer extends TimerTask 
{

	//public PlayGameView playGameView;
	public static PlayGame playGame;
	
	
	public void run()
	{
		playGame.onMiss();
		//System.out.println("Target Timer, Time Elapsed");
	}
	
}
