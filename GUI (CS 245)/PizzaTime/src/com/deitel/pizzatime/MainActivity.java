package com.deitel.pizzatime;

import java.text.NumberFormat;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;



public class MainActivity extends Activity {
	
	// create variables for the app 
	double pizzaPrice;
	double numberOfPizzas;
	double costPer;
	double finalCost;
	String pizzaChoice;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		// create objects to store user inputs
		final EditText numPizza = (EditText) findViewById(R.id.txtNumOfPizzas);
		
		final Spinner choice = (Spinner) findViewById(R.id.spinChoice);
		
		final TextView totalMessage = ((TextView) findViewById(R.id.txtTotalMessage));
		
		Button total = (Button) findViewById(R.id.btnTotal);
		
		Button reset = (Button) findViewById(R.id.btnStartOver);
		
		
		total.setOnClickListener( new OnClickListener () {

			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				
				Button total = ((Button) v );
				
				String pizzaChoice = total.getText().toString();
				
				String numInput = numPizza.getText().toString();
				
				numberOfPizzas = Double.parseDouble(numInput);
				
				pizzaChoice = choice.getSelectedItem().toString();
				
					if (pizzaChoice.equals("The Monster")) {
						pizzaPrice = 17.99;
					}
					if (pizzaChoice.equals("Large Pepperoni")) {
						pizzaPrice = 15.99;
					}
					if (pizzaChoice.equals("Large Sausage and Olive")) {
						pizzaPrice = 16.99;
					}
					if (pizzaChoice.equals("Vegans Delight")) {
						pizzaPrice = 14.99;
					}
					
					NumberFormat curr = NumberFormat.getCurrencyInstance();
					
					costPer = numberOfPizzas * pizzaPrice;
					finalCost += costPer;
					
					totalMessage.setText("The Total Is: " + curr.format(finalCost));
									
			}		
			
		});
		
		
		reset.setOnClickListener( new OnClickListener () {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
								
				finalCost = 0;
				
				NumberFormat curr = NumberFormat.getCurrencyInstance();

				totalMessage.setText("The Total Is: " + curr.format(finalCost));
				
				}
			});
	
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
