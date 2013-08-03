package edu.msu.keifcame.decisionmaker;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DecisionMakerActivity extends Activity {
   LinearLayout mChoicesContainer;
   
   @Override
   protected void onCreate( Bundle savedInstanceState ) {
      super.onCreate( savedInstanceState );
      setContentView( R.layout.activity_decision_maker );
      
      mChoicesContainer = (LinearLayout) findViewById( R.id.choices_container );
   }

   @Override
   public boolean onCreateOptionsMenu( Menu menu ) {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate( R.menu.activity_decision_maker, menu );
      return true;
   }
   
   // Handles an add choice click
   public void onClickAddChoice( View v ) {
      addChoiceBox();
   }
   
   // Handles an add choice click
   public void onClickMakeDecision( View v ) {
      int numberOfChoices = mChoicesContainer.getChildCount();
      
      // Select an index in range [0, numberOfChoices)
      Random rand = new Random();
      int selection = rand.nextInt( numberOfChoices );
      
      View choiceBox = mChoicesContainer.getChildAt( selection );
      
      String choice = " ";
      if ( choiceBox instanceof EditText ) {
         choice += ( (EditText) choiceBox ).getText().toString();
      }

      TextView selectionText = (TextView) findViewById( R.id.selectionText );
      selectionText.setText( getString( R.string.you_should ) + choice );
   }
   
   // Handles an add choice click
   public void onClickReset( View v ) {
      mChoicesContainer.removeAllViews();
      addChoiceBox();
      
      TextView selectionText = (TextView) findViewById( R.id.selectionText );
      selectionText.setText( "" );
   }
   
   private void addChoiceBox() {
      EditText choiceBox = new EditText( this );
      choiceBox.setLayoutParams( new LayoutParams( LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT ) );
      choiceBox.setInputType( InputType.TYPE_TEXT_VARIATION_NORMAL );
      choiceBox.requestFocus();
      
      mChoicesContainer.addView( choiceBox );
   }
}
