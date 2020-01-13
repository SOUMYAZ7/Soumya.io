package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {

	public static final String ADD_MENUITEM_TO_CART = "insert into cart (ct_us_id, ct_me_id) values(?, ?)"; 
	
	public static final String GET_MENUITEM_FROM_CART = "select menu_item.me_id, menu_item.me_name, menu_item.me_free_delivery, menu_item.me_price from cart inner join menu_item on menu_item.me_id = cart.ct_me_id inner join user on user.us_id = cart.ct_us_id where user.us_id = ?";
	
	public static final String GET_TOTAL = "select user.us_id,sum(menu_item.me_price) as Total from cart inner join menu_item on menu_item.me_id = cart.ct_me_id inner join user on user.us_id = cart.ct_us_id where user.us_id = ?";
	
	public static final String REMOVE_CARTITEM = "delete from cart where ct_us_id = ? and ct_me_id = ? limit 1";
	
	@Override
	public void addCartItem(long userId, long menuItemId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(ADD_MENUITEM_TO_CART);
			statement.setLong(1,userId);
			statement.setLong(2,menuItemId);
			int noOfRows = statement.executeUpdate();
			System.out.println("Number of rows affected->"+noOfRows);
		} catch (SQLException e) {
			System.out.println("Data not Inserted");
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				System.out.println("Connection is not closed");
			}
		}
		
	}

	@Override
	public Cart getAllCartItems(long userId) throws CartEmptyException {
		ArrayList<MenuItem> menuItemList = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ResultSet resultSetTotal = null;		
		MenuItem menuItem = null;
		Cart cart = new Cart();
		try {
			statement = connection.prepareStatement(GET_MENUITEM_FROM_CART);			
			statement.setLong(1,userId);			
			resultSet = statement.executeQuery();			
			System.out.println("Number of rows affected->"+resultSet);	
			
			while(resultSet.next()) {				
				menuItem = new MenuItem(); 
				menuItem.setId(resultSet.getLong("me_id"));
				menuItem.setName(resultSet.getString("me_name"));
				menuItem.setFreeDelivery(resultSet.getString("me_free_delivery").equals("Yes"));
				menuItem.setPrice(resultSet.getFloat("me_price"));
				menuItemList.add(menuItem);
			}
			if(menuItemList.size() == 0) {
				throw new CartEmptyException();
			}
			cart.setMenuItemList(menuItemList);
			
			preparedStatement = connection.prepareStatement(GET_TOTAL);
			preparedStatement.setLong(1, userId);
			resultSetTotal = preparedStatement.executeQuery();
			System.out.println("Number of rows affected->"+resultSetTotal);
			while(resultSetTotal.next()) {		
				cart.setTotal(resultSetTotal.getDouble("Total"));
			}			
		} catch (SQLException e) {
			System.out.println("Data not displayed");
		} finally {
			try {
				resultSet.close();
				statement.close();
				resultSetTotal.close();
				preparedStatement.close();
				connection.close();
			} catch (SQLException e) {
				
			}
		}
		return cart;
				
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(REMOVE_CARTITEM);
			statement.setLong(1,userId);
			statement.setLong(2, menuItemId);
			int noOfRows = statement.executeUpdate();
			System.out.println("Number of rows affected ->"+noOfRows);
		} catch (SQLException e) {
			System.out.println("Data is not Deleted");
		} finally {
			try {
				connection.close();
				statement.close();
			} catch (SQLException e) {
				System.out.println("Connection is not closed");
			}
		}
		
	}

}
