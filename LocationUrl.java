package main;

public class LocationUrl {

	
	private String[] locationsxmlurl = {"",
			"http://www.yr.no/sted/Ekvatorial-Guinea/Litoral/Bata/varsel.xml",
			"http://www.yr.no/sted/Norge/Oslo/Oslo/Holmenkollen/varsel.xml",
			"http://www.yr.no/sted/Antarktika/Annet/Antarktis/varsel.xml",
			"http://www.yr.no/sted/Sri_Lanka/Western/Colombo/varsel.xml",
			"http://www.yr.no/sted/Norge/Oslo/Oslo/Bygdøy/varsel.xml",
			"http://www.yr.no/sted/Japan/Tokyo/Tokyo/varsel.xml",
			"http://www.yr.no/sted/Norge/Oslo/Oslo/Vestre Aker/varsel.xml",
			"http://www.yr.no/sted/Norge/Akershus/Eidsvoll/Eidsvoll/varsel.xml",
			"http://www.yr.no/sted/Norge/Nordland/Bod%C3%B8/Bod%C3%B8/varsel.xml",
			"http://www.yr.no/sted/Singapore/Annet/Singapore/varsel.xml",
			"http://www.yr.no/sted/Egypt/Kairo/Kairo/varsel.xml",
			"http://www.yr.no/sted/Den_dominikanske_republikk/Distrito_Nacional/Santo_Domingo/varsel.xml"};
	
	public String getxmlurl(int selectedindex){
		
		return locationsxmlurl[selectedindex];
	}
		
}
