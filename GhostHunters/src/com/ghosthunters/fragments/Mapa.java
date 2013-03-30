package com.ghosthunters.fragments;


import com.ghosthunters.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Toast;


public class Mapa extends Fragment {

	private GoogleMap mMap;
    private SupportMapFragment mMapFragment;
    private Marker marker;
    private Location myLocation;
    private LatLng myLatLng;
	
    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view = inflater.inflate(R.layout.map_fragment, container, false);
	    return view;
	}
	
    @Override
    public void onStart() {
        super.onStart();
        initMap();
    }
	
    @Override
	public void onResume() {
		 super.onResume();
    }
	
	@Override
	public void onPause(){
		super.onPause();
	}
    
	public void initMap(){
		
 	  		
	    mMapFragment = ((SupportMapFragment)getActivity().getSupportFragmentManager().findFragmentById(R.id.mapView));
 		mMap = mMapFragment.getMap();
 		
 		Log.v("traza", "Fragment2:onInitMap" );
 		if (mMap != null)
			mMap.clear();
		 		
 		mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
		mMap.setMyLocationEnabled(true);
 		mMap.getUiSettings().setCompassEnabled(true);
		mMap.getUiSettings().setZoomControlsEnabled(true);
 		mMap.getUiSettings().setZoomGesturesEnabled(true);
		CameraUpdate camUpd1 = CameraUpdateFactory.newLatLng(new LatLng(43.21900, -2.01962));
		//CameraUpdate camUpd1 = CameraUpdateFactory.newLatLng();
		CameraUpdate camUpd2 = CameraUpdateFactory.zoomTo(15);
 			 	
		if ((camUpd1 !=null) && (camUpd2!=null)){
			mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
			mMap.moveCamera(camUpd1);
			mMap.moveCamera(camUpd2);
			
		}
		
		marker = mMap.addMarker(new MarkerOptions()
        	.position(new LatLng(43.221471, -2.018223))
        	.title("I'm a fucking ghost!")
        	.icon(BitmapDescriptorFactory.fromResource(R.drawable.fantasma_icon)));
		
		//Esto sirve para localizar la posición del usuario aunque no tenga GPS
		LocationManager service = (LocationManager) 
				getActivity().getSystemService(Context.LOCATION_SERVICE); 
		Criteria criteria = new Criteria(); 
		String provider = service.getBestProvider(criteria, false); 
		myLocation = service.getLastKnownLocation(provider); 
		myLatLng = new LatLng(myLocation.getLatitude(),myLocation.getLongitude());
		
		//animateMarker(marker, new LatLng(43.21900, -2.01962), false);
		animateMarker(marker, myLatLng, false);
		
    }
	
	public void animateMarker(final Marker marker, final LatLng toPosition, 
			final boolean hideMarker) {
		
		final Handler handler = new Handler(); 
		final long start = SystemClock.uptimeMillis();
		final LatLng startLatLng = marker.getPosition();
		//Cambiando duration se cambia la velocidad. Son inversamente proporcionales
		final long duration = 20000;
		final Interpolator interpolator = new LinearInterpolator(); 
				
		handler.post(new Runnable() { 
			@Override 
			public void run() {
				long elapsed = SystemClock.uptimeMillis() - start; 
				float t = interpolator.getInterpolation((float) elapsed / duration);
				double lng = t * toPosition.longitude + (1 - t) * 
						startLatLng.longitude; 
				double lat = t * toPosition.latitude + (1 - t) * 
						startLatLng.latitude; 
				marker.setPosition(new LatLng(lat, lng));
				if (t < 1.0) { 
					// Post again 16ms later. 
					handler.postDelayed(this, 16); 
				} else { 
					if (hideMarker) { 
						marker.setVisible(false); 
					} else { marker.setVisible(true); 
					} 
				}
			}
		});
	}
	
}