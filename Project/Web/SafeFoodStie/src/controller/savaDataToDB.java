package controller;

import model.dto.Food;
import model.util.FoodSaxParser;
import service.FoodService;
import service.FoodServiceImp;

public class savaDataToDB {
	public static void main(String[] args) throws Exception {
		FoodSaxParser parser = new FoodSaxParser();
		FoodService service = new FoodServiceImp();
		for(Food food: parser.getFoods()) {
			service.add(food);
		}
	}
}
