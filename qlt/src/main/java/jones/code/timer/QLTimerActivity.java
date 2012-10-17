package jones.code.timer;

import java.util.ArrayList;

import jones.code.AppExtender;
import jones.code.GlobalStuff;
import jones.code.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class QLTimerActivity extends Activity {

	public static TypeOfQLTimerTest typeOfQLTimerTest;
	public static int numberOfTests;
	public static int thresholdValue;
	public static boolean countingUpwards;
	
	private ArrayList<String> spawnTimes;

	private static final int QL_TEST_ACTIVITY = 0;
	private Context ctx;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.timermainactivity);

		ctx = this;

		// Set default;
		countingUpwards = true;
		
		spawnTimes = new ArrayList<String>();
		
		Button generateTestButton = (Button) findViewById(R.id.generateTestButton);
		generateTestButton.setOnClickListener(gotoQLTestActivity);
		generateTestButton.getBackground().setColorFilter(GlobalStuff.buttonColor, Mode.MULTIPLY);

		Button gotoMainButton = (Button) findViewById(R.id.gotoMainActivity);
		gotoMainButton.setOnClickListener(gotoMainActivity);
		gotoMainButton.getBackground().setColorFilter(GlobalStuff.buttonColor, Mode.MULTIPLY);

		Button selectCustomNumbers = (Button) findViewById(R.id.select_numbers);
		selectCustomNumbers.setOnClickListener(openCustomDialog);
		selectCustomNumbers.getBackground().setColorFilter(GlobalStuff.buttonColor, Mode.MULTIPLY);

		
		/* spinner for pickup type */
		Spinner spinnerPickup = (Spinner) findViewById(R.id.spinner_pickup_type);
		ArrayAdapter<CharSequence> adapterPickup = ArrayAdapter
				.createFromResource(this, R.array.spinner_pickupitem_array,
						android.R.layout.simple_spinner_item);
		adapterPickup
		.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
		spinnerPickup.setAdapter(adapterPickup);
		spinnerPickup.setOnItemSelectedListener(new SetPickupTypeListener());

		/* spinner for number of tests */
		Spinner spinnerTest = (Spinner) findViewById(R.id.spinner_nr_tests);
		ArrayAdapter<CharSequence> adapterTests = ArrayAdapter
				.createFromResource(this, R.array.spinner_numberoftest_array,
						android.R.layout.simple_spinner_item);
		adapterTests
		.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
		spinnerTest.setAdapter(adapterTests);
		spinnerTest.setOnItemSelectedListener(new SetNumberOfTestsListener());

		/* spinner for selecting threshold */
		Spinner spinnerThreshold = (Spinner) findViewById(R.id.spinner_threshold);
		ArrayAdapter<CharSequence> adapterThreshold = ArrayAdapter
				.createFromResource(this, R.array.spinner_thresholdValue,
						android.R.layout.simple_spinner_item);
		adapterThreshold.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
		spinnerThreshold.setAdapter(adapterThreshold);
		spinnerThreshold.setOnItemSelectedListener(new SetThresholdValueListener());
		
		/* spinner for upwards/downwards */
		Spinner countingUpDownSpinner = (Spinner) findViewById(R.id.spinner_countingUp);
		ArrayAdapter<CharSequence> adapterCountingUpDown = ArrayAdapter
				.createFromResource(this, R.array.spinner_countingup_value,
						android.R.layout.simple_spinner_item);
		adapterCountingUpDown.setDropDownViewResource(
				android.R.layout.select_dialog_singlechoice);
		countingUpDownSpinner.setAdapter(adapterCountingUpDown);
		countingUpDownSpinner.setOnItemSelectedListener(new SetCountingUpDownListener());
	}

	private void showPopUp3() {
		final String[] items = {"ALL", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19",
				"20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
				"30", "31", "32", "33", "34", "35", "36", "37", "38", "39",
				"40", "41", "42", "43", "44", "45", "46", "47", "48", "49",
				"50", "51", "52", "53", "54", "55", "56", "57", "58", "59"};
	    final boolean[] states = new boolean [items.length];
	    for (int i = 0; i < states.length; i++) {
			states[i] = false;
		}
	    AlertDialog.Builder builder = new AlertDialog.Builder(this);
	    builder.setTitle("What would you like to do?");
	    builder.setMultiChoiceItems(items, states, new DialogInterface.OnMultiChoiceClickListener(){
	        public void onClick(DialogInterface dialogInterface, int item, boolean state) {
	        }
	    });
	    builder.setPositiveButton("Done selecting", new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int id) {
	            SparseBooleanArray checkedItems = ((AlertDialog)dialog).getListView().getCheckedItemPositions();
	            
	            spawnTimes = new ArrayList<String>();
	            for (int i = 0; i < items.length; i++) {
					if (checkedItems.get(i)) {
						
						if (i==0)		// If all is selected
						{
							for (int j = 1; j < states.length; j++) {
								spawnTimes.add(items[j]);
							}
							break;
						}
						
						spawnTimes.add(items[i]);
					}
				}
	        }
	    });
	    builder.create().show();
	}
	
	private OnClickListener openCustomDialog = new OnClickListener() {
		@Override
		public void onClick(View v) {
			showPopUp3();
		}
	};
	
	private OnClickListener gotoMainActivity = new OnClickListener() {

		@Override
		public void onClick(View v) {
			setResult(RESULT_OK);
			finish();
		}

	};

	public class SetCountingUpDownListener implements OnItemSelectedListener {
		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {
			switch (pos) {
			case 0:
				countingUpwards = true;
				break;
			case 1:
				countingUpwards = false;
				break;
			default:
				countingUpwards = true;
				break;
			}
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// Do nothing
		}

	}
	
	public class SetThresholdValueListener implements OnItemSelectedListener {
		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {
			switch (pos) {
			case 0:
				thresholdValue = 2;
				break;
			case 1:
				thresholdValue = 3;
				break;
			case 2:
				thresholdValue = 4;
				break;
			case 3:
				thresholdValue = 5;
				break;
			case 4:
				thresholdValue = 6;
				break;
			default:
				thresholdValue = 5;
				break;
			}
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// Do nothing
		}

	}

	public class SetPickupTypeListener implements OnItemSelectedListener {
		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {
			switch (pos) {
			case 0:
				typeOfQLTimerTest = TypeOfQLTimerTest.MH_ONLY;
				break;
			case 1:
				typeOfQLTimerTest = TypeOfQLTimerTest.RA_ONLY;
				break;
			case 2:
				typeOfQLTimerTest = TypeOfQLTimerTest.MH_RA;
				break;
			default:
				typeOfQLTimerTest = TypeOfQLTimerTest.MH_RA;
				break;
			}
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// Do nothing
		}
	};

	public class SetNumberOfTestsListener implements OnItemSelectedListener {

		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {
			switch (pos) {
			case 0:
				numberOfTests = 10;
				break;
			case 1:
				numberOfTests = 20;
				break;
			case 2:
				numberOfTests = 50;
				break;
			case 3:
				numberOfTests = 75;
				break;
			case 4:
				numberOfTests = 100;
				break;
			default:
				numberOfTests = 10;
				break;
			}
		}

		public void onNothingSelected(AdapterView<?> parent) {
			// Do nothing.
		}

	};

	
	private OnClickListener gotoQLTestActivity = new OnClickListener() {

		@Override
		public void onClick(View v) {

			if (spawnTimes.size() == 0) {
				CharSequence text = "Please select spawn times to your test";
				Context context = getApplicationContext();
				Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
				toast.show();
			} else {
				AppExtender share = (AppExtender) getApplication();
				share.timerHandler = new QLTimerTestHandler();

				share.timerHandler.createTestInstances(typeOfQLTimerTest,
						numberOfTests, spawnTimes, thresholdValue, countingUpwards);
				
				Intent i = new Intent(ctx, QLTTestActivity.class);
				startActivityForResult(i, QL_TEST_ACTIVITY);
			}
		}
	};


	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == QL_TEST_ACTIVITY) {
			if (resultCode == RESULT_OK) {
				// DO nothing
			} else if (resultCode == RESULT_CANCELED) {
				
			}
		}

	}
}