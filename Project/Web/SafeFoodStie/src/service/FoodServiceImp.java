package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import model.dao.FoodMgrImpl;
import model.dao.IFoodMgr;
import model.dto.DuplicateException;
import model.dto.Food;
import model.dto.InfoNotFoundException;
import model.util.DBUtil;

public class FoodServiceImp implements FoodService{
	private IFoodMgr dao;
	public FoodServiceImp() {
		 dao = FoodMgrImpl.getInstance();
	}
	public List<Food> searchAll(String key, String value) {
		try {
			List<Food> find = dao.searchAll(key, value);
			return find;
		} catch (InfoNotFoundException e) {
			throw new InfoNotFoundException();
		} catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	public Food search(int code) {
		try {
			Food find = dao.search(code);
			if(find == null) {
				throw new InfoNotFoundException();
			} else {
				return find;				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public void add(Food food) {
		try {
			dao.add(food);
		} catch(DuplicateException e) {
			throw new DuplicateException();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
