package chapter15;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler {
	// XML을 parsing하기 시작할 때 한번 호출되는 메서드
	public void startDocument() throws SAXException {
		System.out.println("----------------------- start Document -----------------------");
	}

	// start tag를 parsing할 때마다 호출되는 메서드
	// uri			네임스페이스로 설정된 uri		parser 종류에 따라 전달X
	// localName	태그 이름만					parser 종류에 따라 전달X
	// qName		prefix를 포함한 태그 이름		
	// attributes	시작태그에 선언된 속성 정보들	
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		System.out.printf("----------------------- %s 시작 -----------------------\n", qName);
		for (int i = 0, len = attributes.getLength(); i < len; i++) {
			System.out.println(attributes.getLocalName(i) + " : " + attributes.getValue(i));
		}
	}

	// 태그 바디 중 문자 데이터를 parsing할 때마다 호출되는 메서드
	// ch			태그 바디의 모든 문자열
	// start		현재 바디의 위치
	// length		현재 문자열의 길이
	public void characters(char ch[], int start, int length) throws SAXException {
		System.out.println(new String(ch, start, length));
	}
	
	// end tag를 parsing할 때마다 호출되는 메서드
	// uri			네임스페이스로 설정된 uri		parser 종류에 따라 전달X
	// localName	태그 이름만					parser 종류에 따라 전달X
	// qName		prefix를 포함한 태그 이름		
	public void endElement(String uri, String localName, String qName) throws SAXException {
		System.out.println("------------------------- end Element -------------------------");
	}
	
	// XML parsing이 끝나면 호출되는 메서드
	public void endDocument() throws SAXException {
		System.out.println("------------------------- end Document -------------------------");
	}
}
