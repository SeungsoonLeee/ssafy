package service;

import java.util.List;

import model.dto.Food;


public interface FoodService {
	public List<Food> searchAll(String key, String value);
	public Food search(int code);
	public void add(Food food);
}
