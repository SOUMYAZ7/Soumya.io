package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {
	
	public static void testAddCartItem() {
		new CartDaoSqlImpl().addCartItem(2, 3);
	}
	
	public static void testGetAllCartItems() throws CartEmptyException {		
		Cart cart = new CartDaoSqlImpl().getAllCartItems(1);
		List<MenuItem> MenuItemList = cart.getMenuItemList();
		System.out.println("Cart");
		System.out.format("%-20s%-20s%-20s%-20s","ID", "NAME", "FREE DELIVERY", "PRICE");
		System.out.println();
		String freeDelivery;
		for(MenuItem menuItem : MenuItemList) {
			if(menuItem.getFreeDelivery() == true)
				freeDelivery = "Yes";
			else
				freeDelivery = "No";
		System.out.format("%-20s%-20s%-20s%-20s\n",menuItem.getId(), menuItem.getName(), freeDelivery, menuItem.getPrice());
		System.out.println();
		}		
		System.out.format("%-40s","Total     "+cart.getTotal());
	}
	
	public static void testRemoveCartItem() throws CartEmptyException {
		new CartDaoSqlImpl().removeCartItem(1, 1); 
		testGetAllCartItems();
	}

	public static void main(String[] args) throws CartEmptyException {
		testAddCartItem();
		//testGetAllCartItems();
		//testRemoveCartItem();
	}

}
