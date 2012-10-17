package jones.code.scenario;

import jones.code.AppExtender;
import jones.code.GlobalStuff;
import jones.code.InputHandler;
import jones.code.R;

import android.app.Activity;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class QLScenarioInputActivity extends Activity {

	private String currentValue;
	
	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.userinputscenarioresults);
	
		currentValue = "0";
		currentItem = 0;
		
		clearInputValueField();
		
		Button buttonClear = (Button) findViewById(R.id.clearButton);
		buttonClear.setOnClickListener(handleClearListener);
		buttonClear.getBackground().setColorFilter(GlobalStuff.buttonColor, Mode.MULTIPLY);
		
		Button buttonSubmit = (Button) findViewById(R.id.submitButton);
		buttonSubmit.setOnClickListener(handleSubmitListener);
		buttonSubmit.getBackground().setColorFilter(GlobalStuff.buttonColor, Mode.MULTIPLY);
		
		Button buttonOne = (Button) findViewById(R.id.numberOne);
        buttonOne.setOnClickListener(handelButtonOneListener);
        
        Button buttonTwo = (Button) findViewById(R.id.numberTwo);
        buttonTwo.setOnClickListener(handleButtonTwoListener);
        
        Button buttonThree = (Button) findViewById(R.id.numberThree);
        buttonThree.setOnClickListener(handleButtonThreeListener);
        
        Button buttonFour = (Button) findViewById(R.id.numberFour);
        buttonFour.setOnClickListener(handleButtonFourListener);
        
        Button buttonFive = (Button) findViewById(R.id.numberFive);
        buttonFive.setOnClickListener(handleButtonFiveListener);
        
        Button buttonSix = (Button) findViewById(R.id.numberSix);
        buttonSix.setOnClickListener(handleButtonSixListener);
        
        Button buttonSeven = (Button) findViewById(R.id.numberSeven);
        buttonSeven.setOnClickListener(handleButtonSevenListener);
        
        Button buttonEight = (Button) findViewById(R.id.numberEight);
        buttonEight.setOnClickListener(handleButtonEightListener);
        
        Button buttonNine = (Button) findViewById(R.id.numberNine);
        buttonNine.setOnClickListener(handleButtonNineListener);
        
        Button buttonZero = (Button) findViewById(R.id.numberZero);
        buttonZero.setOnClickListener(handleButtonZeroListener);
	}

	private OnClickListener handelButtonOneListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			currentValue += "1";
			updateTextFieldForInput();
		}
	};

	private OnClickListener handleButtonTwoListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			currentValue += "2";
			updateTextFieldForInput();
		}
	};
	
	private OnClickListener handleButtonThreeListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			currentValue += "3";
			updateTextFieldForInput();
		}
	};
	
	private OnClickListener handleButtonFourListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			currentValue += "4";
			updateTextFieldForInput();
		}
	};
	
	private OnClickListener handleButtonFiveListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			currentValue += "5";
			updateTextFieldForInput();
		}
	};
	
	private OnClickListener handleButtonSixListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			currentValue += "6";
			updateTextFieldForInput();
		}
	};
	
	private OnClickListener handleButtonSevenListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			currentValue += "7";
			updateTextFieldForInput();
		}
	};
	
	private OnClickListener handleButtonEightListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			currentValue += "8";
			updateTextFieldForInput();
		}
	};
	
	private OnClickListener handleButtonNineListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			currentValue += "9";
			updateTextFieldForInput();
		}
	};
	
	private OnClickListener handleButtonZeroListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			currentValue += "0";
			updateTextFieldForInput();
		}
	};
	
	private OnClickListener handleClearListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			clearInputValueField();
		}
	};
	
	private static int currentItem = 0;
	
	private OnClickListener handleSubmitListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			AppExtender share = (AppExtender) getApplication();
			PickupItem currentItemToVerify = share.pickupItems.get(currentItem);
			
			int inputValue = Integer.parseInt(currentValue);
			
			ScenarioResult result = new ScenarioResult();
			result.setCorrectTime(Integer.toString(currentItemToVerify.getCorrectAnswer()));
			result.setGuessedTime(currentValue);
			result.setItemType(currentItemToVerify.getItemTypeAsString());
			result.setSpawnTime(Integer.toString(currentItemToVerify.getPickupTime()));
			result.setIsPassed(currentItemToVerify.validate(inputValue));			
			share.resultHolder.getResultsList().add(result);
			
			currentItem++;
			
			clearInputValueField();
			
			if (currentItem == share.scenarioInfo.getNumberOfItems()) {
				setResult(RESULT_OK);
				finish();	
			}
		}
	};
	
	private void updateTextFieldForInput(){
		TextView inputValue = (TextView) findViewById(R.id.inputTextValue);
		currentValue = new InputHandler().formatInputTimerValue(currentValue);
		inputValue.setText(currentValue);
	}
	
	private void clearInputValueField() {
		currentValue = new InputHandler().clearInputValue();
		updateTextFieldForInput();
	}
}