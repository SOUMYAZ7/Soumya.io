package com.cognizant.truyum.dao;

import java.util.ArrayList;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {
	
	public static void testGetMenuItemListAdmin() {
		ArrayList<MenuItem> menuItemList = new MenuItemDaoSqlImpl().getMenuItemListAdmin();
		System.out.format("%-10s%-20s%-15s%-15s%-20s%-20s%-10s", "ID", "NAME", "PRICE", "ACTIVE", "DATE OF LAUNCH",
				"CATEGORY", "FREE DELIVERY");
		System.out.println();
		String active;
		String freeDelivery;
		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getActive() == true) {
				active = "Yes";
			} else {
				active = "No";
			}
			if (menuItem.getFreeDelivery() == true) {
				freeDelivery = "Yes";
			} else {
				freeDelivery = "No";
			}
			System.out.format("%-10s%-20s%-15s%-15s%-20s%-20s%-10s", menuItem.getId(), menuItem.getName(),
					menuItem.getPrice(), active, menuItem.getDateOfLaunch(), menuItem.getCategory(), freeDelivery);
			System.out.println();
		}
	}

	public static void testGetMenuItemListCustomer() {
		ArrayList<MenuItem> menuItemList = new MenuItemDaoSqlImpl().getMenuItemListCustomer();
		System.out.format("%-10s%-20s%-15s%-15s%-20s%-20s%-10s", "ID", "NAME", "PRICE", "ACTIVE", "DATE OF LAUNCH",
				"CATEGORY", "FREE DELIVERY");
		System.out.println();
		String active;
		String freeDelivery;
		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getActive() == true) {
				active = "Yes";
			} else {
				active = "No";
			}
			if (menuItem.getFreeDelivery() == true) {
				freeDelivery = "Yes";
			} else {
				freeDelivery = "No";
			}
			System.out.format("%-10s%-20s%-15s%-15s%-20s%-20s%-10s", menuItem.getId(), menuItem.getName(),
					menuItem.getPrice(), active, menuItem.getDateOfLaunch(), menuItem.getCategory(), freeDelivery);
			System.out.println();
		}
	}

	public static void testModifyMenuItem() {		
		MenuItem menuItem = new MenuItem(1L, "Biryani", 52.00f, true, new DateUtil().convertToDate("02/11/2020"), "Main Course",
				true);
		new MenuItemDaoSqlImpl().modifyMenuItem(menuItem); 
		ArrayList<MenuItem> menuItemList = new MenuItemDaoSqlImpl().getMenuItemListAdmin();
		System.out.println("After Modification");
		System.out.format("%-10s%-20s%-15s%-15s%-20s%-20s%-10s", "ID", "NAME", "PRICE", "ACTIVE", "DATE OF LAUNCH",
				"CATEGORY", "FREE DELIVERY");
		System.out.println();
		String active;
		String freeDelivery;
		for (MenuItem menuItem1 : menuItemList) {
			if (menuItem1.getActive() == true) {
				active = "Yes";
			} else {
				active = "No";
			}
			if (menuItem1.getFreeDelivery() == true) {
				freeDelivery = "Yes";
			} else {
				freeDelivery = "No";
			}
			System.out.format("%-10s%-20s%-15s%-15s%-20s%-20s%-10s", menuItem1.getId(), menuItem1.getName(),
					menuItem1.getPrice(), active, menuItem1.getDateOfLaunch(), menuItem1.getCategory(), freeDelivery);
			System.out.println();
		}
	}
	public static void testGetMenuItem() {	
		MenuItem menuItem = new MenuItemDaoSqlImpl().getMenuItem(2);		 
		System.out.println("User");
		System.out.format("%-10s%-20s%-15s%-15s%-20s%-20s%-10s", "ID", "NAME", "PRICE", "ACTIVE", "DATE OF LAUNCH",
				"CATEGORY", "FREE DELIVERY");
		System.out.println();
		String active;
		String freeDelivery;
		
			if (menuItem.getActive() == true) {
				active = "Yes";
			} else {
				active = "No";
			}
			if (menuItem.getFreeDelivery() == true) {
				freeDelivery = "Yes";
			} else {
				freeDelivery = "No";
			}
			System.out.format("%-10s%-20s%-15s%-15s%-20s%-20s%-10s", menuItem.getId(), menuItem.getName(),
					menuItem.getPrice(), active, menuItem.getDateOfLaunch(), menuItem.getCategory(), freeDelivery);
			System.out.println();
		}
	

	public static void main(String[] args) {
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
		testGetMenuItem();
	}
}
