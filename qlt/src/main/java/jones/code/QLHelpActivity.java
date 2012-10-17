package jones.code;

import android.app.Activity;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class QLHelpActivity extends Activity {
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.helpmenu);
		
		Button gotoMainButton = (Button) findViewById(R.id.gotoMainActivity);
		gotoMainButton.setOnClickListener(gotoMainActivity);
		gotoMainButton.getBackground().setColorFilter(GlobalStuff.buttonColor, Mode.MULTIPLY);
		
		TextView tv = (TextView) findViewById(R.id.helpMenuText);
		String text = "This app is developed for help quake live players to practice item timings. \n\n" +
				"-- Rules: \n" +
				"When items spawn at a specific time just add +35 or +25 depending on item\n" +
				"MH = Mega health is +35 sec (blue icon)\n" +
				"RA = Red armor is +25 sec (red icon) \n" +
				"Example: spawn is xx:45 for MH, write 20 and you are set! \n\n" +
				"-- Modes: \n" +
				"1. Timer test \n" +
				"Customize your test and practice item calculation by heart." + 
				"Select what times you want to practice or just choose <all> to select all." +
				"Select threshold value to practice fast input (instant calculation).\n" +
				"2. Scenario timer test \n" +
				"This mode if for practice to keep more than one item in your memory." +
				"Select how long visibible time you want the item to display spawntime, and select number of items to keep in memory before input." +
				"There is also possible to select delay time before next item is spawned.";
		tv.setText(text);
	}


	private OnClickListener gotoMainActivity = new OnClickListener() {

		@Override
		public void onClick(View v) {
			setResult(RESULT_OK);
			finish();
		}
		
	};
}