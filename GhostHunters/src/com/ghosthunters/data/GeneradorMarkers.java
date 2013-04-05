package com.ghosthunters.data;

import java.util.ArrayList;
import java.util.List;

import android.app.Application;
import android.os.Handler;
import android.util.Log;

import com.ghosthunters.ui.MarcadorBase;


public class GeneradorMarkers {
	
	private List<MarcadorBase> marcadoresBase = new ArrayList<MarcadorBase>();
	final Handler handle = new Handler();
	Thread t = new Thread();
	
	
	public List<MarcadorBase> getMarcadores() {
		
		if (!t.isAlive()){
			miThread();
		}
		
		calcularPosiciones();
        
		return marcadoresBase;
		
	}

	protected void miThread(){
		
		t = new Thread(){
			public void run(){
				try{
					Thread.sleep(5000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			handle.post(proceso);
			}
		};
		t.start();
	}
	
	final Runnable proceso = new Runnable(){
		public void run(){
			
			calcularPosiciones();
		}
	};
	
	public void calcularPosiciones(){
		
		if (marcadoresBase.size() == 0){
			
			MarcadorBase ghost1 = new MarcadorBase("FUCKER 1", 43.223459, -2.02449, 0);
	        marcadoresBase.add(ghost1);
			
	        MarcadorBase ghost2 = new MarcadorBase("FUCKER 2", 43.2027, -2.0281, 0);
	        marcadoresBase.add(ghost2);
	        Log.v("RUNNABLE", "FANTASMAS 1 Y 2 CREADOS" );
		
		} else {
			
			MarcadorBase ghost3 = new MarcadorBase("FUCKER 3", 43.217382, -2.021683, 0);
	        marcadoresBase.add(ghost3);
			
	        MarcadorBase ghost4 = new MarcadorBase("FUCKER 4", 43.216921, -2.021829, 0);
	        marcadoresBase.add(ghost4);
	        Log.v("RUNNABLE", "FANTASMAS 3 Y 4 CREADOS" );
		}
	}
	
}
