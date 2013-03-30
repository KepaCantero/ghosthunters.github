package com.ghosthunters.activity;

import com.ghosthunters.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;


public class MainActivity extends Activity {
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//Log.v(Constants.LOGTAG, " " + FragmentChangeActivity.CLASSTAG + "1");
		
		//Quita la barra de título
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		 
		setContentView(R.layout.main);
					
		if (findViewById(R.id.main_frame) != null) {
		    if (savedInstanceState != null) { 
		    	return; 
		    }
		}
		
		onModoMapa();
	}		
			
    @Override
    public void onPause() {

        super.onPause();
    }

    public void onModoMapa() {
		
    	//Intent intent = MapaUnico.newInstance(this);
    	Intent intent =  MapaActivity.newInstance(this);
		startActivity(intent);
	}    
    
    public void onModoCamara() {
    	
    	Intent intent =  ARactivity.newInstance(this);
		startActivity(intent);
	}    
}
