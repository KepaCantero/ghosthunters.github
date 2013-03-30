package com.ghosthunters.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

import com.ghosthunters.R;
import com.ghosthunters.fragments.Mapa;
import com.ghosthunters.utils.Constants;

public class MapaActivity extends FragmentActivity {
	
	private static final String TAG = "MapaActivity";
    
    
    public static Intent newInstance(Activity activity) {
	    
    	Intent intent = new Intent(activity, MapaActivity.class);
    	Log.v(Constants.LOGTAG, " new Instance: intent creado");
			
		return intent;
    }
    
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
        
		//Crea el fragmento con el mapa
		Fragment newContent = new Mapa();
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.main_frame, newContent);
        transaction.commit();
	    
	}		
			
    @Override
    public void onPause() {

        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_mapa, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.v(TAG, "onOptionsItemSelected() item=" + item);
        switch (item.getItemId()) {
	        case R.id.buttonAR:
	        	onModoCamara();
	            break;
            case R.id.exit:
                finish();
                break;
        }
        return true;
    }
    
    public void onModoCamara() {
		
		Intent i = new Intent(getApplicationContext(), ARactivity.class); 
		startActivity(i);
	}
    
}
