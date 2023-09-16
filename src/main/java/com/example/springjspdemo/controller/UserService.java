package com.example.springjspdemo.controller;

import java.util.ArrayList;

public class UserService {
	public ArrayList<User> users = new ArrayList<User>();
	
	public UserService() {
		User admin = new User("Admin", "root");
		users.add(admin);	
	}
	
	public void addUser(String username, String password) {
		User curr = new User(username, password);
		users.add(curr);
	}
	
	public User findUser(String username) {
		for(int i =0; i < users.size(); i++) {
			if(users.get(i).name.equals(username)) {
				return users.get(i);
			}
		}
		return null;
	}
	public void addToBasket(String username, String item) {
		for(int i =0; i < users.size(); i++) {
			if(users.get(i).name.equals(username)) {
				users.get(i).addToBasket(item);
				break;
			}
		}
	}
	
	public ArrayList<String> getBasketItemsForUser(String user){
		for(int i =0; i < users.size(); i++) {
			if(users.get(i).name.equals(user)) {
				return users.get(i).basket;
			}
		}
		return new ArrayList<String>();
	}

	public void buyItem(String username, String itemName, int price) {
		// TODO Auto-generated method stub
		for(int i =0; i < users.size(); i++) {
			if(users.get(i).name.equals(username)) {
				//get index of item in basket
				int index = -1;
				User s = users.get(i);
				for(int j =0; j < s.basket.size(); j++) {
					if(s.basket.get(j).equals(itemName)) {
						index = j;
						break;
					}
				}
				users.get(i).basket.remove(index);
				//add item to orders
				users.get(i).orders.add(itemName);
				users.get(i).balance -= price;
				break;
			}
		}
		
	}

	public ArrayList<String> getOrdersItemsForUser(String username) {
		// TODO Auto-generated method stub
		for(int i =0; i < users.size(); i++) {
			if(users.get(i).name.equals(username)) {
				return users.get(i).orders;
			}
		}
		return new ArrayList<String>();
		
	}

	
}
