package edu.davenport.cisp340.reaction;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import java.util.Timer;




public class PlayGame extends Activity 
{
	PlayGameView gameView;
	//private Timer timer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_play_game);
	
		gameView = new PlayGameView(this.getApplicationContext());
		setContentView(gameView);
		
		gameView.invalidate();
		//TargetTimer.playGame = this;
		runOnUiThread(new Runnable()
		{
			@Override
			public void run()
			{
				//timer = new Timer();
				//timer.schedule(new TargetTimer(), TIMER_DELAY);
				
				
			}
			
		}
		);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.activity_play_game, menu);
		return true;
	}

	public void onHit() {
	}
	
	
	//This is called only on expired timer
	public void onMiss()
	{
		System.out.println("PlayGame.onMiss");
	}
	
}
//timer = new Timer();
//targetTimer = new TargetTimer();
//targetTimer.playGameView = this;
//timer.schedule(targetTimer, TIMER_DELAY);