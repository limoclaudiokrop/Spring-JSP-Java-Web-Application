package com.example.springjspdemo.controller;

import java.util.ArrayList;

public class User {
	public int id;
	public String name;
	public String password;
	public ArrayList<String> basket;
	public ArrayList<String> orders;
	public int balance;
	
	public User(String name, String password) {
		this.name = name;
		this.password = password;
		basket = new ArrayList<String>();
		orders = new ArrayList<String>();
		balance = 100;
	}
	
	public void addToBasket(String item) {
		basket.add(item);
	}
}
