package chapter15;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class WeatherDOMParser {
	public static void main(String[] args) {
		Weather w;
		List<Weather> data = new ArrayList<Weather>();

		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = dbf.newDocumentBuilder();
			// xml을 파싱해서 모든 요소를 객체로 생성 후 tree구조로 반환
			Document doc = parser.parse("http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=108");
			NodeList list = doc.getElementsByTagName("location");

			for (int i = 0, len = list.getLength(); i < len; i++) {
				Node node = list.item(i);
				String city = "";
				if (node.getNodeType() == Node.ELEMENT_NODE) {
					for (Node child = node.getFirstChild(); child != null; child = child.getNextSibling()) {
						if (child.getNodeType() == Node.ELEMENT_NODE) {
							if (child.getNodeName().equals("city")) {
								city = child.getTextContent();
							} else if (child.getNodeName().equals("data")) {
								w = new Weather();
								w.setCity(city);
								for (Node child2 = child.getFirstChild(); child2 != null; child2 = child2.getNextSibling()) {
									if (child2.getNodeType() == Node.ELEMENT_NODE) {
										if (child2.getNodeName().equals("tmEf")) {
											w.setDate(child2.getTextContent());
										} else if (child2.getNodeName().equals("wf")) {
											w.setDesc(child2.getTextContent());
										} else if (child2.getNodeName().equals("tmn")) {
											w.setTmn(child2.getTextContent());
										} else if (child2.getNodeName().equals("tmx")) {
											w.setTmx(child2.getTextContent());
										} else if (child2.getNodeName().equals("reliability")) {
											w.setRealiabiluty(child2.getTextContent());
										}
//										System.out.printf("%s : %s\n", child2.getNodeName(), child2.getTextContent());
									}
								}
								data.add(w);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (Weather weather : data) {
			System.out.println(weather);
		}
	}
}
