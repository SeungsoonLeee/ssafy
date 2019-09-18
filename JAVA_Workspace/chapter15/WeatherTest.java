package chapter15;

import java.util.List;

public class WeatherTest {
	public static void main(String[] args) {
		List<Weather> ws = WeatherSAXParser.getWeathers("http://www.kma.go.kr/weather/forecast/mid-term-rss3.jsp?stnId=108");
		for (Weather weather : ws) {
			System.out.println(weather);
		}
	}
}
