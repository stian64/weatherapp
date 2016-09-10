package main;

import java.util.ArrayList;

public class Data {

	private String dateUpdate, lastUpdate, city, country;
	private ArrayList<String> date = new ArrayList<String>();
	private ArrayList<String> imageId = new ArrayList<String>();
	private ArrayList<String> temperature = new ArrayList<String>();
	private boolean window = false;
	
	public void Removedata() {
		date.clear();
		imageId.clear();
		temperature.clear();
	}

	// ////////////////////////////////////////////////////////
	// saves data                                           //
	// ///////////////////////////////////////////////////////

	public void setDate(String dates) {
		date.add(dates);
	}

	public void setUpdateTime(String update) {
		dateUpdate = update;
	}

	public void setLastUpdate(String lastupdate) {
		lastUpdate = lastupdate;
	}

	public void setCountry(String cntry) {
		country = cntry;
	}

	public void setCity(String cty) {
		city = cty;
	}

	public void setTemperature(String temp) {
		temperature.add(temp);
	}

	public void setImageId(String imgId) {
		imageId.add(imgId);
	}

	// ///////////////////////////////////////////
	// returns data                            //
	// //////////////////////////////////////////

	public String getUpdateTime() {
		return dateUpdate;
	}

	public String getLastUpdateTime() {
		return lastUpdate;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public ArrayList<String> getDate() {
		return date;
	}

	public ArrayList<String> getTemp() {
		return temperature;
	}

	public ArrayList<String> getImageId() {
		return imageId;
	}

	// //////////////////////////////////////////////////////////////////////////
	//                                                                         //
	// Methods regarding the result window                                     //
	//                                                                         //
	// //////////////////////////////////////////////////////////////////////////

	public void setWindow() {
         window = true;
	}
	
    public void closeWindow() {
		window = false;
	}

	public boolean checkWindow() {
		return window;
	}
	
}
