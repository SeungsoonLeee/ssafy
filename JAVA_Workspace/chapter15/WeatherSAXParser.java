package chapter15;

import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class WeatherSAXParser {
	public static class WeatherHandler extends DefaultHandler {
		private Weather w;
		private List<Weather> data;
		private String tagData;
		private String city;

		public WeatherHandler() {
			data = new LinkedList<Weather>();
		}

		public List<Weather> getWeather() {
			return data;
		}

		public void startDocument() throws SAXException {
		}

		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			if (qName.equals("data")) {
				w = new Weather(city);
				data.add(w);
			}
		}

		public void characters(char[] ch, int start, int length) throws SAXException {
			tagData = new String(ch, start, length);
		}

		public void endElement(String uri, String localName, String qName) throws SAXException {
			if (qName.equals("city")) {
				this.city = tagData;
			} else if (qName.equals("tmEf")) {
				w.setDate(tagData);
			} else if (qName.equals("wf")) {
				if (w != null)
					w.setDesc(tagData);
			} else if (qName.equals("tmn")) {
				w.setTmn(tagData);
			} else if (qName.equals("tmx")) {
				w.setTmx(tagData);
			} else if (qName.equals("reliability")) {
				w.setRealiabiluty(tagData);
			}
		}
	}

	public void endDocument() throws SAXException {
	}

	public static List<Weather> getWeathers(String url) {
		try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser parser = spf.newSAXParser();
			WeatherHandler handler = new WeatherHandler();
			parser.parse(url, handler);
			return handler.getWeather();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
