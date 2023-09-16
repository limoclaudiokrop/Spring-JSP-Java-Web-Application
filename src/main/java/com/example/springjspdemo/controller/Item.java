package com.example.springjspdemo.controller;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {
	@Id
	public String id;
	public String name;
	public String category;
	public int count;
	public String desc;
	public String ingredients;
	public String instruction;
	public String link;
	public Item(String id, String name, String category, int count, String desc, String ingredients,
			String instruction, String link) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.count = count;
		this.desc = desc;
		this.ingredients = ingredients;
		this.instruction = instruction;
		this.link = link;
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	
	public String getCategory() {
		return category;
	}
	
	public String getLink() {
		return link;
	}
	
	public int getCount() {
		return count;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public String getIngredients() {
		return ingredients;
	}
	
	public String getInstruction() {
		return instruction;
	}
}
