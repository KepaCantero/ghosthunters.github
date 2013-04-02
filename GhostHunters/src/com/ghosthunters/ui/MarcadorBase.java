package com.ghosthunters.ui;

public class MarcadorBase {

	private String nombre;
	private double lat;
	private double lng;
	private double alt;
	
	
	public MarcadorBase(String name, double latitude, 
			double longitude, double altitude) {
        setNombre(name);
        setLat(latitude);
        setLng(longitude);
        setAlt(altitude);
    }
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public double getAlt() {
		return alt;
	}
	public void setAlt(double alt) {
		this.alt = alt;
	}
	
}
