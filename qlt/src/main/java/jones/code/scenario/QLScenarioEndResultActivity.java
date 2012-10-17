package jones.code.scenario;

import java.util.ArrayList;

import jones.code.AppExtender;
import jones.code.GlobalStuff;
import jones.code.R;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class QLScenarioEndResultActivity extends Activity {
	
	private ArrayList<ScenarioResult> results;
	
	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.resultactivity);
	
		AppExtender share = (AppExtender) getApplication();
		results = share.resultHolder.getResultsList();		
		createResultReport();
		
		Button confirmButton = (Button) findViewById(R.id.done_result_button);
		confirmButton.getBackground().setColorFilter(GlobalStuff.buttonColor, Mode.MULTIPLY);
		confirmButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				setResult(RESULT_OK);
				finish();
			}
		});
		
		
	}
	
	private void createResultReport() {
		LinearLayout resultLinLay=(LinearLayout) this.findViewById(R.id.resultLinLay);
		LayoutParams lparams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		
		for (int i = 0; i < results.size(); i++) {
			
			TextView tv = new TextView(this);
			tv.setLayoutParams(lparams);
			ScenarioResult currentResult = results.get(i);
			
			String correctResult = "[%s: %s->%s, PASSED]";
			String wrongResult = "[%s: %s->%s, should be: %s->%s, FAILED]";
			
			String text;
			
			/* set color */
		    if (currentResult.getIsPassed())
			{
		    	text = String.format(correctResult, 
		    			currentResult.getItemType(),
		    			currentResult.getSpawnTime(),
		    			currentResult.getGuessedTime());
				tv.setTextColor(Color.GREEN);
			} 
			else 
			{
				text = String.format(wrongResult,
						currentResult.getItemType(),
		    			currentResult.getSpawnTime(),
		    			currentResult.getGuessedTime(),
		    			currentResult.getSpawnTime(),
		    			currentResult.getCorrectTime());
				tv.setTextColor(Color.RED);
			}
		    
		    tv.setText(text);
			resultLinLay.addView(tv);
		}
	}

}