package maps;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class MapXmlParser implements ContentHandler {

	private boolean lng = false;
	private boolean lat = false;
	private boolean loc = true;
	private String[] arr = new String[100];
	private String longtitude, latitude;

	public String getLang() {

		return longtitude;
	}

	public void characters(char[] ch, int start, int length)
			throws SAXException {

		if (loc) {

			if (lng) {
				
				longtitude = new String(ch, start, length);

				lng = false;
			}
			if (lat) {

				latitude = new String(ch, start, length);

				lat = false;

			}
		}

	}
	
	public String getlongtitude(){
		
		return this.longtitude;
	}
	
	public String getlatitude(){
		
		return this.latitude;
	}

	public void endDocument() throws SAXException {

	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (qName.equals("location_type")) {
			loc = false;
		}

	}

	public void endPrefixMapping(String arg0) throws SAXException {

	}

	public void ignorableWhitespace(char[] arg0, int arg1, int arg2)
			throws SAXException {

	}

	public void processingInstruction(String arg0, String arg1)
			throws SAXException {

	}

	public void setDocumentLocator(Locator arg0) {

	}

	public void skippedEntity(String arg0) throws SAXException {

	}

	public void startDocument() throws SAXException {

	}

	public void startElement(String URI, String localName, String element,
			Attributes attributes) throws SAXException {

		if (element.equals("lat")) {

			lat = true;

		}
		if (element.equals("lng")) {

			lng = true;
		}

	}

	public void startPrefixMapping(String arg0, String arg1)
			throws SAXException {

	}

}
