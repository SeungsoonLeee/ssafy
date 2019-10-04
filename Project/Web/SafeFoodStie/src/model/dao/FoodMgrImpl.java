package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.mysql.cj.protocol.Resultset;
import com.mysql.cj.xdevapi.Statement;

import model.dto.DuplicateException;
import model.dto.Food;
import model.dto.InfoNotFoundException;
import model.util.DBUtil;

public class FoodMgrImpl implements IFoodMgr {
	private static IFoodMgr manager = new FoodMgrImpl();

	private FoodMgrImpl() {};

	public static IFoodMgr getInstance() {
		return manager;
	}

	public List<Food> searchAll(String key, String value) throws Exception{
		List<Food> finds = new LinkedList<Food>();
		ResultSet rs = null;
		PreparedStatement stmt = null;
		Connection con = null;
		if (key.equals("searchName")) {
			key = "name";
		} else if (key.equals("searchMaker")) {
			key = "maker";
		} else {
			key = "material";
		}
		try {
			con = DBUtil.getConnection();
			String sql = " select * from food where " + key + " like \'%" + value + "%\' ";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			boolean isFirst = true;
			while (rs.next()) {
				finds.add(new Food(rs.getInt("code"), rs.getString("name"), rs.getString("maker"),
						rs.getString("material"), rs.getInt("servingWt"), rs.getDouble("calory"), rs.getDouble("carbo"),
						rs.getDouble("protein"), rs.getDouble("fat"), rs.getDouble("sugar"), rs.getDouble("natrium"),
						rs.getDouble("chole"), rs.getDouble("fattyacid"), rs.getDouble("transfat"), rs.getInt("year"),
						rs.getString("img")));
				isFirst = false;
			}
			if (isFirst) {
				throw new InfoNotFoundException();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
		return finds;
	}

	public Food search(int code) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			String sql = " select * from food where code = ? ";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, code);
			rs = stmt.executeQuery();
			while (rs.next()) {
				return new Food(rs.getInt("code"), rs.getString("name"), rs.getString("maker"),
						rs.getString("material"), rs.getInt("servingWt"), rs.getDouble("calory"), rs.getDouble("carbo"),
						rs.getDouble("protein"), rs.getDouble("fat"), rs.getDouble("sugar"), rs.getDouble("natrium"),
						rs.getDouble("chole"), rs.getDouble("fattyacid"), rs.getDouble("transfat"), rs.getInt("year"),
						rs.getString("img"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new SQLException();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
		return null;
	}

	@Override
	public void add(Food food) throws Exception {
		Food find = search(food.getCode());
		if(find != null) {
			throw new DuplicateException();
		} else {
			Connection con = null;
			PreparedStatement stmt = null;
			try {
				con = DBUtil.getConnection();
				String sql = " insert into food(code, name, maker, material"
						+ ", servingWt, calory, carbo, protein, fat"
						+ ", sugar, natrium, chole, fattyacid, transfat, year, img) "
						+ " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
				stmt = con.prepareStatement(sql);
				int idx = 1;
				stmt.setInt(idx++, food.getCode());
				stmt.setString(idx++, food.getName());
				stmt.setString(idx++, food.getMaker());
				stmt.setString(idx++, food.getMaterial());
				stmt.setInt(idx++, food.getServingWt());
				stmt.setDouble(idx++, food.getCalory());
				stmt.setDouble(idx++, food.getCarbo());
				stmt.setDouble(idx++, food.getProtein());
				stmt.setDouble(idx++, food.getFat());
				stmt.setDouble(idx++, food.getSugar());
				stmt.setDouble(idx++, food.getNatrium());
				stmt.setDouble(idx++, food.getChole());
				stmt.setDouble(idx++, food.getFattyacid());
				stmt.setDouble(idx++, food.getTransfat());
				stmt.setInt(idx++, food.getYear());
				stmt.setString(idx++, food.getImg());
				stmt.executeUpdate();
			} catch (Exception e2) {
				e2.printStackTrace();
				throw new SQLException();
			} finally {
				DBUtil.close(stmt);
				DBUtil.close(con);
			}
		}

	}
}
