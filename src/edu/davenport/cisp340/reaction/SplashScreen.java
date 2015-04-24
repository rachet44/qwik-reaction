package edu.davenport.cisp340.reaction;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class SplashScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_splash_screen, menu);
		return true;
	}
	
	public void btnPlay_Click(View view)
	{
		//Toast.makeText(getApplicationContext(), "Play!", Toast.LENGTH_SHORT).show();
		
		Intent playGame = new Intent(this.getApplicationContext(), 
						  PlayGame.class); 
		
		startActivity(playGame);
		
		//startActivity(new Intent(this.getApplicationContext(), PlayGame.class));
	}

}
