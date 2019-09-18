package chapter15;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class SAXTest1 {
	public static void main(String[] args) {
		// 기본 paser가 아닌 다른 parser를 사용할 때 :
		// SAXParserFactory.newInstance(factoryClassName, classLoader)
		// factoryClassName : 패키지명을 포함한 parser의 클래스 이름
		// classLoader : parser를 로딩할 클래스로더

		// 클래스로더 얻는 방법 :
		// ClassLoader cl = new SAXTest1().getClass().getClassLoader();

		SAXParserFactory spf = SAXParserFactory.newInstance();
		try {
			SAXParser parser = spf.newSAXParser();
			// xml을 읽어 지정한 Handler로 parsing
			parser.parse("res/CustomerList.xml", new SAXHandler());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}
}
