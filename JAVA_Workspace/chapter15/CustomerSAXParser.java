package chapter15;

import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import chapter05.Customer;

public class CustomerSAXParser {
	public static List<Customer> parse(String url) {
		try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser parser = spf.newSAXParser();
			CustomerHandler handler = new CustomerHandler();
			parser.parse(url, handler);
			return handler.getList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
