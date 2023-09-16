package com.example.springjspdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;



public class ItemService {
//	@Autowired
//	private ItemRepository itemRepository;
//	
//	
//	public List<Item> getAll(){
//		List<Item> items = new ArrayList<>();
//		itemRepository.findAll()
//		.forEach(items::add);
//		return items;
//	}
//	
//	public void addItem(Item item) {
//		itemRepository.save(item);
//	}
	
	public ArrayList<Item> items = new ArrayList<Item>();
	public int ID = 0;
	public ItemService() {
		//(String id, String name, String category, int count, String desc, String ingredients,
			//	String instruction, String link
		String desc = "The best eggplant parmesan recipes are extra"
				+ " kind to their namesake vegetable. Start "
				+ "by giving your eggplant an upfront spa treatment:"
				+ " sprinkle the cut pieces with a little salt and let "
				+ "them sit to sweat out the extra moisture and remove "
				+ "any bitter notes. This recipe calls for fresh breadcrumbs"
				+ " but regular dried or Japanese-style panko breadcrumbs â "
				+ "which are coarser â can be used instead. Take your time with "
				+ "frying the eggplant. Be sure to start with hot oil and wait to check "
				+ "on the pieces until they lift easily with a spatula. The homemade tomato"
				+ " sauce is incredibly easy. It only simmers for 10 minutes, so you can check"
				+ " on it while you pan fry the eggplant.";
		String img = "https://food.fnr.sndimg.com/content"
				+ "/dam/images/food/fullset/2018/2/16/0/FNK_"
				+ "Eggplant-Parmesan-H-111_s4x3.jpg.rend.hgtvcom.616.462"
				+ ".suffix/1518807329709.jpeg";
		Item item = new Item("0", "Egg Plant Permasian", "Vegeterian", 2, 
				desc, "", "", img );
		items.add(item);
		
		desc = "Jeera-Aloo is a classic dry Indian dish,"
				+ " which is extremely easy to make and absolutely"
				+ " delicious in taste! This simple stir-fry is made with "
				+ "basic Indian spices, boiled potatoes and cumin, which is the star "
				+ "of the dish! So, whenever you are pressed for time, but in the mood "
				+ "to have something nice with your chapatti, roti or dal, our Jeera-Aloo "
				+ "recipe wonât let you down! To give a Sesame Peanut Twist to your Jeera-Aloo "
				+ "Recipe, add 3 tablespoons of beaten curd, 1 teaspoon roasted sesame seeds and "
				+ "1 tablespoon roasted peanuts, towards the end of your preparation. Heat until the "
				+ "gravy dries up and the potatoes are coated with the Sesame and Peanut mixture.";
		
		img = "https://img-global.cpcdn.com/recipes/314825bf3d2a0c71/680x482cq70/sesame-peanut-spicy-potato-recipe-main-photo.jpg";
		item = new Item("1", "Jeera-Aloo is a classic dry Indian dish", "Vegeterian", 2, 
				desc, "", "", img );
		items.add(item);
		
		desc = "It is an interesting and flavored pulao recipe made ideally with long grain"
				+ " rice and coconut milk. A one pot dish, it can be used as a main meal or even as a tiffin box filler. "
				+ "For a main meal, try serving with a potato based side dish, some raita as well as some crisps. To add a"
				+ " twist, add 1 cup of mixed vegetables, along with the peas and a handful of chopped mint leaves to make a"
				+ " Vegetable Brinji one pot meal.";
		
		img = "https://i.pinimg.com/736x/ec/e9/9c/ece99c8d5593fb58e81bf0bab9576db6.jpg";
		item = new Item("1", "Vegetable Brinji Rice Recipe", "Vegeterian", 2, 
				desc, "", "", img );
		items.add(item);
		
	}
	public ArrayList<Item> findAll() {
		
		return items;
	}
	public void addItem(Item item) {
		items.add(item);
		ID++;
	}
	
	public int size() {
		return items.size();
	}
	
	public void delete(String id) {
		int index = -1;
		for(int i =0; i <items.size(); i++) {
			if(items.get(i).getId().equals(id)) {
				index = i;
				break;
			}
		}
		if(index != -1) {
			items.remove(index);
		}
	}
	
	public Item findItem(String id) {
		for(int i =0; i <items.size(); i++) {
			if(items.get(i).getId().equals(id)) {
				return items.get(i);
			}
		}
		return null;
	}
	
	public List<Item> search(String s){
		List<Item> list = new ArrayList<>();
		for(int i =0; i <items.size(); i++) {
			Item item = items.get(i);
			if(item.name.toLowerCase().contains(s.toLowerCase())) {
				list.add(item);
			}else if(item.desc.toLowerCase().contains(s.toLowerCase())) {
				list.add(item);
			}else if(item.ingredients.toLowerCase().contains(s.toLowerCase())) {
				list.add(item);
			}else if(item.instruction.toLowerCase().contains(s.toLowerCase())) {
				list.add(item);
			}
		}
		
		return list;
	}
//	
//	
//	public ArrayList<Item> findItems(ArrayList<String> itemNames) {
//		ArrayList<Item> result = new ArrayList<Item>();
//		for(int j =0; j < itemNames.size(); j++) {
//			String curr = itemNames.get(j);
//			for(int i =0; i < items.size(); i++) {
//				if(items.get(i).name.equals(curr)) {
//					result.add(items.get(i));
//				}
//			}
//		}
//		return result;
//		
//	}
//
//	public void buyItem(String itemName) {
//		// TODO Auto-generated method stub
//		for(int i =0; i < items.size(); i++) {
//			if(items.get(i).name.equals(itemName)) {
//				items.get(i).count --;
//				break;
//			}
//		}
//		
//	}
//
//	public int findPrice(String itemName) {
//		// TODO Auto-generated method stub
//		for(int i =0; i < items.size(); i++) {
//			if(items.get(i).name.equals(itemName)) {
//				return items.get(i).price;
//			}
//		}
//		return 0;
//	}
//
//	public ArrayList<Item> searchItems(String item) {
//		// TODO Auto-generated method stub
//		ArrayList<Item> list = new ArrayList<Item>();
//		for(int i =0; i < items.size(); i++) {
//			if(items.get(i).category.equals(item) || items.get(i).name.equals(item)) {
//				list.add(items.get(i));
//			}
//		}
//		return list;
//	}

}
