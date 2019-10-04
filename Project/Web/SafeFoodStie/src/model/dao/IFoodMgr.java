package model.dao;

import java.sql.SQLException;
import java.util.List;
import model.dto.DuplicateException;
import model.dto.Food;
import model.dto.InfoNotFoundException;

public interface IFoodMgr {
	public void add(Food food) throws Exception;
	public List<Food> searchAll(String key, String value) throws Exception;
	public Food search(int code) throws Exception;
}
