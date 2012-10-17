package jones.code.scenario;


import jones.code.AppExtender;
import jones.code.GlobalStuff;
import jones.code.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class QLScenarioActivity extends Activity {

	private static final int QL_SCENARIO_TEST_ACTIVITY = 1;
	private static final int QL_SCENARIO_TEST_VERIFICATION = 2;
	private static final int QL_SCENARIO_END_RESULT = 3;
	private Context ctx;
	
	/* scenario stuff */
	private static int itemsDisplayCounter;
	private PickupItemsHandler items; 
	
	/* scenario spinner values */
	private ScenarioInformationHolder scenarioInfo;
	private int currentScenarioCounter = 0;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scenariomainactivity);

		ctx = this;

		Button gotoScenarioButton = (Button) findViewById(R.id.gotoScenarioButton);
		gotoScenarioButton.setOnClickListener(gotoQlScenarioTestActivity);
		gotoScenarioButton.getBackground().setColorFilter(GlobalStuff.buttonColor, Mode.MULTIPLY);
		
		Button gotoMainButton = (Button) findViewById(R.id.gotoMainActivity);
		gotoMainButton.setOnClickListener(gotoMainActivity);
		gotoMainButton.getBackground().setColorFilter(GlobalStuff.buttonColor, Mode.MULTIPLY);
		
		AppExtender share = (AppExtender) getApplication();
		share.resultHolder = new ScenarioResultHolder();
		
		/* spinner for selecting scenarios */
		Spinner spinnerScenarioItemVisibleTimeout = 
				(Spinner) findViewById(R.id.spinner_scenario_time_visible);
		ArrayAdapter<CharSequence> adapterItemVisible = ArrayAdapter
				.createFromResource(this, R.array.spinner_item_visible_time_array,
						android.R.layout.simple_spinner_item);
		adapterItemVisible.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
		spinnerScenarioItemVisibleTimeout.setAdapter(adapterItemVisible);
		spinnerScenarioItemVisibleTimeout
				.setOnItemSelectedListener(new ScenarioSetItemVisibleTimeoutListner());
		
		Spinner spinnerScenarioTimeoutBetweenItems = 
				(Spinner) findViewById(R.id.spinner_scenario_timeout_between_items);
		ArrayAdapter<CharSequence> adapterBetweenItems = ArrayAdapter
				.createFromResource(this, R.array.spinner_timeout_to_next_spawn,
						android.R.layout.simple_spinner_item);
		adapterBetweenItems.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
		spinnerScenarioTimeoutBetweenItems.setAdapter(adapterBetweenItems);
		spinnerScenarioTimeoutBetweenItems
				.setOnItemSelectedListener(new ScenarioSetTimeoutSpawnListener());
		
		Spinner spinnerScenarioNumberOfItems = 
				(Spinner) findViewById(R.id.spinner_number_of_items_to_spawn);
		ArrayAdapter<CharSequence> adapterNumOfItems = ArrayAdapter
				.createFromResource(this, R.array.spinner_number_of_items_to_spawn,
						android.R.layout.simple_spinner_item);
		adapterNumOfItems.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
		spinnerScenarioNumberOfItems.setAdapter(adapterNumOfItems);
		spinnerScenarioNumberOfItems
				.setOnItemSelectedListener(new ScenarioSetNumberOfItemsListener());
		
		Spinner spinnerScnearioNumberOfScenarios = 
				(Spinner) findViewById(R.id.spinner_number_of_scenarios);
		ArrayAdapter<CharSequence> adapterNumOfScenarios = ArrayAdapter
				.createFromResource(this, R.array.spinner_number_of_scenarios,
						android.R.layout.simple_spinner_item);
		adapterNumOfScenarios.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerScnearioNumberOfScenarios.setAdapter(adapterNumOfScenarios);
		spinnerScnearioNumberOfScenarios
				.setOnItemSelectedListener(new ScenarioSetNumberOfScenariosListener());
		
		/* scenario default values */
		scenarioInfo = new ScenarioInformationHolder();
		scenarioInfo.setNumberOfItems(1);
		scenarioInfo.setTimeoutBetweenSpawns(2000);
		scenarioInfo.setTimeoutItemVisible(1000);
		scenarioInfo.setNumberOfScenarios(1);
	}

	public class ScenarioSetNumberOfScenariosListener implements OnItemSelectedListener {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {
			switch (pos) {
			case 0:
				scenarioInfo.setNumberOfScenarios(1);
				break;
			case 1:
				scenarioInfo.setNumberOfScenarios(5);
				break;
			case 2:
				scenarioInfo.setNumberOfScenarios(10);
				break;
			case 3:
				scenarioInfo.setNumberOfScenarios(20);
				break;
			default:
				scenarioInfo.setNumberOfItems(1);
				break;
			}
			
			AppExtender share = (AppExtender) getApplication();
			share.scenarioInfo = scenarioInfo;
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// Do nothing
		}
	}
	
	public class ScenarioSetItemVisibleTimeoutListner implements OnItemSelectedListener {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {
			switch (pos) {
			case 0:
				scenarioInfo.setTimeoutItemVisible(1000);
				break;
			case 1:
				scenarioInfo.setTimeoutItemVisible(2000);
				break;
			case 2:
				scenarioInfo.setTimeoutItemVisible(3000);
				break;
			default:
				scenarioInfo.setTimeoutItemVisible(1000);
				break;
			}
			
			AppExtender share = (AppExtender) getApplication();
			share.scenarioInfo = scenarioInfo;
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// Do nothing
		}
	}
	
	public class ScenarioSetTimeoutSpawnListener implements OnItemSelectedListener {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {
			switch (pos) {
			case 0:
				scenarioInfo.setTimeoutBetweenSpawns(2000);
				break;
			case 1:
				scenarioInfo.setTimeoutBetweenSpawns(4000);
				break;
			case 2:
				scenarioInfo.setTimeoutBetweenSpawns(6000);
				break;
			case 3:
				scenarioInfo.setTimeoutBetweenSpawns(8000);
				break;
			default:
				scenarioInfo.setTimeoutBetweenSpawns(2000);
				break;
			}
			
			AppExtender share = (AppExtender) getApplication();
			share.scenarioInfo = scenarioInfo;
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// Do nothing
		}
	}
	
	public class ScenarioSetNumberOfItemsListener implements OnItemSelectedListener {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int pos,
				long id) {
			switch (pos) {
			case 0:
				scenarioInfo.setNumberOfItems(1);
				break;
			case 1:
				scenarioInfo.setNumberOfItems(2);
				break;
			case 2:
				scenarioInfo.setNumberOfItems(3);
				break;
			case 3:
				scenarioInfo.setNumberOfItems(4);
				break;
			default:
				scenarioInfo.setNumberOfItems(1);
				break;
			}
			
			AppExtender share = (AppExtender) getApplication();
			share.scenarioInfo = scenarioInfo;
		}

		@Override
		public void onNothingSelected(AdapterView<?> arg0) {
			// Do nothing
		}
	}
	

	private OnClickListener gotoMainActivity = new OnClickListener() {

		@Override
		public void onClick(View v) {
			setResult(RESULT_OK);
			finish();
		}
		
	};


	private OnClickListener gotoQlScenarioTestActivity = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// Clear previous results
			AppExtender share = (AppExtender) getApplication();
			share.resultHolder = new ScenarioResultHolder();
			
			// Generate the next scenario
			genereateNextScenario();
		}
		
	};
	
	protected void genereateNextScenario() {
		itemsDisplayCounter = 0;
		items = new PickupItemsHandler(scenarioInfo.getNumberOfItems());
		items.generateItems();
		
		AppExtender share = (AppExtender) getApplication();
		share.pickupItems = items.getPickupItemsList();
		
		currentScenarioCounter++;
		
		nextScenarioItemTicker();
	}
	
	protected void nextScenarioItemTicker() {
		if (itemsDisplayCounter < scenarioInfo.getNumberOfItems()) {
			AppExtender share = (AppExtender) getApplication();
			share.currentPickupItem = items.getPickupItemsList().get(itemsDisplayCounter);
			Intent i = new Intent(ctx, QLScenarioShowItemsActivity.class);
			startActivityForResult(i, QL_SCENARIO_TEST_ACTIVITY);
			itemsDisplayCounter++;
		}
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == QL_SCENARIO_TEST_ACTIVITY) {
			if (resultCode == RESULT_OK) {
				if (itemsDisplayCounter == scenarioInfo.getNumberOfItems()) 
				{
					Intent i = new Intent(ctx, QLScenarioInputActivity.class);
					startActivityForResult(i, QL_SCENARIO_TEST_VERIFICATION);
				} else {
					nextScenarioItemTicker();
				}
			} else if (resultCode == RESULT_CANCELED) {
				
				currentScenarioCounter = 0;
			}
		} else if (requestCode == QL_SCENARIO_TEST_VERIFICATION) {
			if (currentScenarioCounter < scenarioInfo.getNumberOfScenarios()) {
				
				genereateNextScenario();
			}else if (resultCode == RESULT_OK) {
				
				currentScenarioCounter = 0;
				Intent i = new Intent(ctx, QLScenarioEndResultActivity.class);
				startActivityForResult(i, QL_SCENARIO_END_RESULT);
			}
		} else if (requestCode == QL_SCENARIO_END_RESULT) {
			if (resultCode == RESULT_CANCELED) {
				
			} else if (resultCode == RESULT_OK) {
				
			}
		}
		
	}
}