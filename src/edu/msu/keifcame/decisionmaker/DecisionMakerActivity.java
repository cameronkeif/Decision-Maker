package edu.msu.keifcame.decisionmaker;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.LinearLayout;

public class DecisionMakerActivity extends Activity {

   @Override
   protected void onCreate( Bundle savedInstanceState ) {
      super.onCreate( savedInstanceState );
      setContentView( R.layout.activity_decision_maker );
   }

   @Override
   public boolean onCreateOptionsMenu( Menu menu ) {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate( R.menu.activity_decision_maker, menu );
      return true;
   }
   
   // Handles an add choice click
   public void onClickAddChoice( View v ) {
      LinearLayout choicesContainer = (LinearLayout) findViewById( R.id.choices_container );
      
      EditText choiceBox = new EditText( this );
      choiceBox.setLayoutParams( new LayoutParams( LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT ) );
      choiceBox.setInputType( InputType.TYPE_TEXT_VARIATION_NORMAL );
      choiceBox.requestFocus();
      
      choicesContainer.addView( choiceBox );
   }
   
   // Handles an add choice click
   public void onClickMakeDecision( View v ) {
      
   }
   
   // Handles an add choice click
   public void onClickReset( View v ) {
      
   }

}
