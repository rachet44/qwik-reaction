package edu.davenport.cisp340.reaction;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;
import android.graphics.*;
import android.view.*;
import java.util.*;
import android.media.AudioManager;
import android.media.SoundPool;

public class PlayGameView extends View 
{
	private Bitmap target;
	private Context context;
	private Display display;
	private Random random;
	//private Timer timer;
	//private TargetTimer targetTimer;
	private double Hits;
	private double Miss;
	//private final long TIMER_DELAY = 10000;
	private double Total;
	private double Hit_Percent;
	private float x_Location;
	private float y_Location;
	private SoundPool soundpool;
	private int soundlasergun1ID;
	private int soundweirdnoiseID;
	private int soundweirdnoise2ID;
	private int soundetphonehomeID;
	private int paultimer;
	private boolean gameDone;
	
	public PlayGameView(Context context) 
	{
		super(context);
		
		target = BitmapFactory.decodeResource(getResources(), R.drawable.du);
		
		this.context = context;
		
		WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
		display = wm.getDefaultDisplay();
		
		random = new Random();
		gameDone = false;
		
		Hits = 0;
		Miss = 0;
		Total = 0;
		Hit_Percent = 0;
		soundpool = new SoundPool(4, AudioManager.STREAM_MUSIC, 0);
		soundlasergun1ID = soundpool.load(this.context, R.raw.lasergun1, 1);
		soundweirdnoiseID = soundpool.load(this.context, R.raw.weirdnoise, 1);
		soundweirdnoise2ID = soundpool.load(this.context, R.raw.weirdnoise2, 1);
		soundetphonehomeID = soundpool.load(this.context, R.raw.etphonehome, 1);
		
		soundpool.play(soundweirdnoise2ID, 1, 1, 1, 0, 1);
		soundpool.release();
	}
	
	public void onDraw(Canvas c)
	{
		super.onDraw(c);
		
		//c.drawBitmap(target, 50, 50, null);

		// Show Graphics Dimensions
		if (gameDone == false)
		{
			
		
		int targetWidth = target.getWidth();
		int targetHeight = target.getHeight();
		
		//Toast.makeText(context, "Height = " + String.valueOf(targetHeight), Toast.LENGTH_SHORT).show();
		//Toast.makeText(context, "Width = " + String.valueOf(targetWidth), Toast.LENGTH_SHORT).show();
		
		int screenWidth = this.getRight();
		int screenHeight = this.getBottom();
		
		//Toast.makeText(context, "Height = " + String.valueOf(screenHeight), Toast.LENGTH_SHORT).show();
		//Toast.makeText(context, "Width = " + String.valueOf(screenWidth), Toast.LENGTH_SHORT).show();
		
		x_Location = random.nextInt(screenWidth);
		y_Location = random.nextInt(screenHeight);

		c.drawBitmap(target, x_Location, y_Location, null);
		}
		else 
		{
		//Toast.makeText(context, "random x = " + String.valueOf(X), Toast.LENGTH_SHORT).show();
		//Toast.makeText(context, "random y = " + String.valueOf(Y), Toast.LENGTH_SHORT).show();
		
		//invalidate();
		Bitmap GameOver = BitmapFactory.decodeResource(getResources(), R.drawable.paultimer); 
		c.drawBitmap(GameOver, 0 , 0, null);
		}
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		float x, y; 
		if( event.getAction() == MotionEvent.ACTION_DOWN )
		{
			x = event.getRawX();
			y = event.getRawY();
			
			if (x > x_Location & x < (x_Location + target.getWidth()))
			{
				if (y > y_Location & x < (y_Location + target.getHeight()))
				{
					onHit();
				}
				else
				{
					onMiss();
				}
			}
			else
			{
				onMiss();
			}
			
			
			
			
			invalidate();
			
		}
		return false;
	}
	
	public void onHit()
	{
		// TO DO:  code for hitting the target goes here...
		//timer.cancel();
		Hits = Hits + 1;
		Total = Hits + Miss;
		if (Total == 10)
		{
			onGameEnd();
			
		}
		soundpool.play(soundlasergun1ID, 1, 1, 1, 0, 1);
		soundpool.release();
		Toast.makeText(context, "Hit", Toast.LENGTH_SHORT).show();
	}
	
	private void onGameEnd() {
		//timer.cancel();
		Hit_Percent = Hits / 10;
		Hit_Percent = Hit_Percent * 100;
		//AlertDialog.Builder dialog = new AlertDialog.Builder(context);
		//dialog.setMessage("Game over" + (Hit_Percent) +"%");
		//AlertDialog message = dialog.create();
		//message.show();
		gameDone = true;
		
		
		soundpool.play(soundetphonehomeID, 1, 1, 1, 0, 1);
		soundpool.release();
		Toast.makeText(context, "Game Over", Toast.LENGTH_SHORT).show();
		Toast.makeText(context, String.valueOf(Hit_Percent) + "%", Toast.LENGTH_LONG).show();
	}

	
	
	
	public void onMiss()
	{
		// TO DO:  code for missing the target goes here...
		//timer.cancel();
		//timer.schedule(targetTimer, TIMER_DELAY);
		Miss = Miss + 1;
		Total = Hits + Miss;
		if (Total == 10)
		{
			onGameEnd();
		}
		soundpool.play(soundweirdnoiseID, 1, 1, 1, 0, 1);
		soundpool.release();
		Toast.makeText(context, "Miss", Toast.LENGTH_SHORT).show();
	}
}
