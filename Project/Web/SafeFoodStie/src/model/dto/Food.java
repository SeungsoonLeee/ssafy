package model.dto;

public class Food {
	int code;
	String name;
	String maker;
	String material;
	int servingWt;
	double calory;
	double carbo;
	double protein;
	double fat;
	double sugar;
	double natrium;
	double chole;
	double fattyacid;
	double transfat;
	int year;
	String img;
	public Food() {}
	public Food(int code, String name, String maker, String material, int servingWt, double calory,
			double carbo, double protein, double fat, double sugar, double natrium, double chole, double fattyacid,
			double transfat, int year, String img) {
		super();
		this.code = code;
		this.name = name;
		this.maker = maker;
		this.material = material;
		this.servingWt = servingWt;
		this.calory = calory;
		this.carbo = carbo;
		this.protein = protein;
		this.fat = fat;
		this.sugar = sugar;
		this.natrium = natrium;
		this.chole = chole;
		this.fattyacid = fattyacid;
		this.transfat = transfat;
		this.year = year;
		this.img = img;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public int getServingWt() {
		return servingWt;
	}
	public void setServingWt(int servingWt) {
		this.servingWt = servingWt;
	}
	public double getCalory() {
		return calory;
	}
	public void setCalory(double calory) {
		this.calory = calory;
	}
	public double getCarbo() {
		return carbo;
	}
	public void setCarbo(double carbo) {
		this.carbo = carbo;
	}
	public double getProtein() {
		return protein;
	}
	public void setProtein(double protein) {
		this.protein = protein;
	}
	public double getFat() {
		return fat;
	}
	public void setFat(double fat) {
		this.fat = fat;
	}
	public double getSugar() {
		return sugar;
	}
	public void setSugar(double sugar) {
		this.sugar = sugar;
	}
	public double getNatrium() {
		return natrium;
	}
	public void setNatrium(double natrium) {
		this.natrium = natrium;
	}
	public double getChole() {
		return chole;
	}
	public void setChole(double chole) {
		this.chole = chole;
	}
	public double getFattyacid() {
		return fattyacid;
	}
	public void setFattyacid(double fattyacid) {
		this.fattyacid = fattyacid;
	}
	public double getTransfat() {
		return transfat;
	}
	public void setTransfat(double transfat) {
		this.transfat = transfat;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "Food [code=" + code + ", name=" + name + ", maker=" + maker + ", material=" + material + ", servingWt="
				+ servingWt + ", calory=" + calory + ", carbo=" + carbo + ", protein=" + protein + ", fat=" + fat
				+ ", sugar=" + sugar + ", natrium=" + natrium + ", chole=" + chole + ", fattyacid=" + fattyacid
				+ ", transfat=" + transfat + ", year=" + year + ", img=" + img + "]";
	}

	
}
