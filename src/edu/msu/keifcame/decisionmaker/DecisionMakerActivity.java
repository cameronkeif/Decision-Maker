package edu.msu.keifcame.decisionmaker;

import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DecisionMakerActivity extends Activity {
   LinearLayout mChoicesContainer;
   
   private static final String CHOICES = "edu.msu.keifcame.decisionmaker.choices";
   
   protected void onCreate( Bundle savedInstanceState ) {
      super.onCreate( savedInstanceState );
      setContentView( R.layout.activity_decision_maker );
      
      mChoicesContainer = (LinearLayout) findViewById( R.id.choices_container );
      
      if ( savedInstanceState != null ) {
         ArrayList<String> choices = savedInstanceState.getStringArrayList( CHOICES );
         
         for ( String choice : choices ) {
            addChoiceBox( choice );
         }
      } else {
         addChoiceBox();
      }
   }
   
   @Override
   public void onSaveInstanceState( Bundle outState ) {
      ArrayList<String> choices = new ArrayList<String>();
      
      int numberOfChoices = mChoicesContainer.getChildCount();
      for ( int i = 0; i < numberOfChoices; i++ ) {
         choices.add( ( (EditText) mChoicesContainer.getChildAt( i ) ).getText().toString() );
      }
      
      outState.putStringArrayList( CHOICES, choices );
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
   
   private EditText addChoiceBox() {
      EditText choiceBox = new EditText( this );
      choiceBox.setLayoutParams( new LayoutParams( LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT ) );
      choiceBox.requestFocus();
      
      mChoicesContainer.addView( choiceBox );
      
      return choiceBox;
   }
   
   // When rotating, we want to keep the text in its box. This method is similar to the above, but adds that text in.
   private EditText addChoiceBox( String choice ) {
      EditText choiceBox = new EditText( this );
      choiceBox.setLayoutParams( new LayoutParams( LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT ) );
      choiceBox.setText( choice );
      choiceBox.requestFocus();
      
      mChoicesContainer.addView( choiceBox );
      
      return choiceBox;
   }
}
