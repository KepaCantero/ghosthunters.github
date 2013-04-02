package com.ghosthunters.data;

import java.util.ArrayList;
import java.util.List;

import com.ghosthunters.ui.MarcadorBase;


public class GeneradorMarkers {
	
	private List<MarcadorBase> marcadoresBase = new ArrayList<MarcadorBase>();
	
	public List<MarcadorBase> getMarcadores() {
		
		MarcadorBase ghost1 = new MarcadorBase("GHOST 1", 43.2193, -2.016932, 0);
        marcadoresBase.add(ghost1);
		
		return marcadoresBase;
	}
}
