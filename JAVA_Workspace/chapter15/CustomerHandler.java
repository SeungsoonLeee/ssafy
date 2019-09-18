package chapter15;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import chapter05.Customer;

public class CustomerHandler extends DefaultHandler {
	private Customer c;
	private List<Customer> list;
	private String tagData;

	public CustomerHandler() {
		list = new ArrayList<Customer>(10);
	}

	public List<Customer> getList() {
		return list;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equals("customer")) {
			c = new Customer();
			list.add(c);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		tagData = new String(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equals("name")) {
			c.setName(tagData);
		} else if (qName.equals("age")) {
			try {
				c.setAge(Integer.parseInt(tagData));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (qName.equals("address")) {
			c.setAddress(tagData);
		}
	}
}
