package xml;

import main.Data;
import main.DataInstance;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class XmlParser implements ContentHandler {

	private boolean elementCountry = false; // starters and stoppers
	private boolean elementCity = false;
	private boolean elementTimeZone = false;
	private boolean elementTemperature = false;
	private boolean elementTimeStamp = false;
	private boolean elementImageId = false;
	private boolean elementPeriod = false;
	private boolean elementTabular = false;
	private boolean elementMyStopper = false;
	private boolean elementUpdateDate = false;
	private boolean elementLastUpdate = false;
	private String tempdataTimeZone = "";
	private String tempdataImageId = "";
	private String tempdataDate = "";
	private String tempdataPeriod = "";
	private String tempdataTemperature = "";
	private String tempUpdateDate = "";
	private String tempLastUpdate = "";
	private Data datain;

	XmlParser() {

		DataInstance instance = new DataInstance();
		datain = instance.getdata();
	}

	@Override
	public void startElement(String uri, String localName, String element,
			Attributes attributes) throws SAXException {

		if (element.equalsIgnoreCase("name")) {
			elementCity = true;
		}

		if (element.equalsIgnoreCase("country")) {
			elementCountry = true;
		}

		if (element.equalsIgnoreCase("nextupdate")) {
			elementUpdateDate = true;
		}
		
		if (element.equalsIgnoreCase("lastupdate")) {
			elementLastUpdate = true;
		}

		if (element.equalsIgnoreCase("tabular")) {
			elementTabular = true;
		}

		if (element.equalsIgnoreCase("time")) {

			if (elementTabular) {
				tempdataDate = attributes.getValue(0) + ":::"
						+ attributes.getValue(1);

				elementTimeStamp = true;

			}
		}

		if (element.equalsIgnoreCase("symbol")) {
			elementImageId = true;
			tempdataImageId = attributes.getValue(3);
		}
		if (element.equalsIgnoreCase("temperature")) {
			elementTemperature = true;
			tempdataTemperature = attributes.getValue(1);
		}

	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if (elementCity) {
			String data = new String(ch, start, length);
			datain.setCity(data);
			elementCity = false;
		}
		if (elementCountry) {
			String data = new String(ch, start, length);
			datain.setCountry(data);
			elementCountry = false;
		}

		if (elementUpdateDate) {
			tempUpdateDate = (new String(ch, start, length));
			datain.setUpdateTime(tempUpdateDate);
			elementUpdateDate = false;
		}
		
		
		if (elementUpdateDate) {
			tempLastUpdate = (new String(ch, start, length));
			datain.setUpdateTime(tempLastUpdate);
			elementLastUpdate = false;
		}

		if (elementTabular) {

			if (elementTimeStamp) {

				datain.setDate(tempdataDate);

				elementTimeStamp = false;

			}
		}

		if (elementTemperature) {

			datain.setTemperature(tempdataTemperature);
			elementTemperature = false;
		}
		if (elementImageId) {
			datain.setImageId(tempdataImageId);
			elementImageId = false;
		}

	}

	@Override
	public void endElement(String uri, String localName, String element)
			throws SAXException {

	}

	@Override
	public void endPrefixMapping(String arg0) throws SAXException {

	}

	@Override
	public void ignorableWhitespace(char[] arg0, int arg1, int arg2)
			throws SAXException {

	}

	@Override
	public void processingInstruction(String arg0, String arg1)
			throws SAXException {

	}

	@Override
	public void setDocumentLocator(Locator arg0) {

	}

	@Override
	public void skippedEntity(String arg0) throws SAXException {

	}

	@Override
	public void startDocument() throws SAXException {

	}

	@Override
	public void endDocument() throws SAXException {

	}

	@Override
	public void startPrefixMapping(String arg0, String arg1)
			throws SAXException {

	}

}
