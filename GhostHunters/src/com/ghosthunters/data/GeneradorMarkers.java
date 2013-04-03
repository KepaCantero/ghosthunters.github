package com.ghosthunters.data;

import java.util.ArrayList;
import java.util.List;

import com.ghosthunters.ui.MarcadorBase;


public class GeneradorMarkers {
	
	private List<MarcadorBase> marcadoresBase = new ArrayList<MarcadorBase>();
	
	public List<MarcadorBase> getMarcadores() {
		
		MarcadorBase ghost1 = new MarcadorBase("FUCKER 1", 43.2193, -2.016932, 0);
        marcadoresBase.add(ghost1);
		
        MarcadorBase ghost2 = new MarcadorBase("FUCKER 2", 43.2027, -2.0281, 0);
        marcadoresBase.add(ghost2);
        
		return marcadoresBase;
	}
}
