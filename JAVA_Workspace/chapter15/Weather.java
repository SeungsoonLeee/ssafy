package chapter15;

public class Weather {
	private String city;
	private String date;
	private String desc;
	private String tmx;
	private String tmn;
	private String realiabiluty;

	public Weather() {

	}

	public Weather(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Weather [city=").append(city).append(", date=").append(date).append(", desc=").append(desc)
				.append(", tmx=").append(tmx).append(", tmn=").append(tmn).append(", realiabiluty=")
				.append(realiabiluty).append("]");
		return builder.toString();
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getTmx() {
		return tmx;
	}

	public void setTmx(String tmx) {
		this.tmx = tmx;
	}

	public String getTmn() {
		return tmn;
	}

	public void setTmn(String tmn) {
		this.tmn = tmn;
	}

	public String getRealiabiluty() {
		return realiabiluty;
	}

	public void setRealiabiluty(String realiabiluty) {
		this.realiabiluty = realiabiluty;
	}

}
