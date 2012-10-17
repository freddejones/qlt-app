package jones.code;

import org.donations.DonationsActivity;

import jones.code.scenario.QLScenarioActivity;
import jones.code.timer.QLTimerActivity;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class QLTActivity extends Activity {

	private static final int QL_SCENARIO_ACTIVITY = 0;
	private static final int QL_TIMER_ACTIVITY = 1;
	private static final int QL_HELP_ACTIVITY = 2;
	private static final int QL_DONATIONS = 3;
	private Context ctx;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ctx = this;
		
		Button gotoTimerActivityButton = (Button) findViewById(R.id.gotoTimerActivity);
		gotoTimerActivityButton.setOnClickListener(gotoQLTimerActivity);
		gotoTimerActivityButton.getBackground().setColorFilter(GlobalStuff.buttonColor, Mode.MULTIPLY);
		
		Button gotoScenarioActivityButton = (Button) findViewById(R.id.gotoScenarioActivity);
		gotoScenarioActivityButton.setOnClickListener(gotoQLScenarioActivity);
		gotoScenarioActivityButton.getBackground().setColorFilter(GlobalStuff.buttonColor, Mode.MULTIPLY);
		
		Button gotoHelp = (Button) findViewById(R.id.gotoHelpActivity);
		gotoHelp.setOnClickListener(gotoHelpActivity);
		gotoHelp.getBackground().setColorFilter(GlobalStuff.buttonColor, Mode.MULTIPLY);
		
		Button gotoDonations = (Button) findViewById(R.id.gotoDonationActivity);
		gotoDonations.setOnClickListener(gotoDonationsActivity);
		gotoDonations.getBackground().setColorFilter(GlobalStuff.buttonColor, Mode.MULTIPLY);
		
	}


	private OnClickListener gotoHelpActivity = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent i = new Intent(ctx, QLHelpActivity.class);
			startActivityForResult(i, QL_HELP_ACTIVITY);
		}
		
	};
	
	private OnClickListener gotoDonationsActivity = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent i = new Intent(ctx, DonationsActivity.class);
			startActivityForResult(i, QL_DONATIONS);
		}
		
	};
	
	private OnClickListener gotoQLScenarioActivity = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent i = new Intent(ctx, QLScenarioActivity.class);
			startActivityForResult(i, QL_SCENARIO_ACTIVITY);
		}
		
	};
	
	private OnClickListener gotoQLTimerActivity = new OnClickListener() {

		@Override
		public void onClick(View v) {
			Intent i = new Intent(ctx, QLTimerActivity.class);
			startActivityForResult(i, QL_TIMER_ACTIVITY);
		}
		
	};
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == QL_TIMER_ACTIVITY) {
			if (resultCode == RESULT_OK) {
				
			} else if (resultCode == RESULT_CANCELED) {
				
			}
		} else if (requestCode == QL_SCENARIO_ACTIVITY) {
			if (resultCode == RESULT_OK) {
				
			} else if (resultCode == RESULT_CANCELED) {
				
			}
		}
		
	}
}