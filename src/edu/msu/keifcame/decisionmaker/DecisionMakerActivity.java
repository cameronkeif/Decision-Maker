package edu.msu.keifcame.decisionmaker;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

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
   }
   
   // Handles an add choice click
   public void onClickMakeDecision( View v ) {
      
   }
   
   // Handles an add choice click
   public void onClickReset( View v ) {
      
   }

}
