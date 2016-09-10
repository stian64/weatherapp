package maps;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.XMLReader;

public class Map {

	private String paramStart = "https://maps.googleapis.com/maps/api/geocode/xml?address=";
	private String apiKey = "&key=AIzaSyCWjjehyJrTF_ADAcnMMhZ9CkMOsMCNzQM";
	private String urlParamS = "http://maps.googleapis.com/maps/api/staticmap?zoom=11&size=500x500&markers=";
	private String urlParamSl = "&sensor=true";
	private String cityName, finalUrl, imageUrl, latitude, longtitude,longLat,data;

	public Map(String city) {

		this.cityName = city;
		data = paramStart + cityName + apiKey;
		this.finalUrl = data;
		getCordinates();

	}

	private void getCordinates() {

		try {

			SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
			XMLReader xmlReader = parser.getXMLReader();
			MapXmlParser xmlAgent = new MapXmlParser();
			xmlReader.setContentHandler(xmlAgent);
			xmlReader.parse(finalUrl);
			//
			this.latitude = xmlAgent.getlongtitude();
			this.longtitude = xmlAgent.getlatitude();

		} catch (Exception e) {

		}
	}

	public String getLong() {
		return longtitude;
	}

	public String getLat() {
		return latitude;
	}

	public void getStaticMapCords() {

          longLat = this.longtitude + "," + this.latitude;
          finalUrl = urlParamS + longLat + urlParamSl;
		  this.imageUrl = finalUrl;

	}

	public String getMapImage() {
		return imageUrl;
	}

}
