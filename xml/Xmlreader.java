package xml;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.XMLReader;

import main.LocationUrl;

public class Xmlreader {

	private String url;

	public Xmlreader(int selectedindex) {

		try {
			
			LocationUrl stedsurl = new LocationUrl();
             url = stedsurl.getxmlurl(selectedindex);
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			XMLReader reader = parser.getXMLReader();
			XmlParser XMLReaderAgent = new XmlParser();
			reader.setContentHandler(XMLReaderAgent);
			reader.parse(url);
		}

		catch (Exception e1) {

			e1.printStackTrace();
		}

	}
}
