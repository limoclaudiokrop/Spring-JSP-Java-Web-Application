package com.example.springjspdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.awt.List;
@Controller
public class LoginController {
	
	
	
	
	private ItemService itemsService= new ItemService();
	private UserService userService = new UserService();
	
	@RequestMapping(value ="/login", method= RequestMethod.GET)
	public String loginPage(ModelMap model, @RequestParam(value = "errorMsg", required = false) String error) {
		if (error == null) {
			return "login";
		}
		model.put("errorMsg", error);
		return "login";
	}
	
	@RequestMapping(value ="/login", method= RequestMethod.POST)
	public RedirectView welcomePage(ModelMap model, @RequestParam String username, @RequestParam String password) {
		ArrayList<User> users = userService.users;
		for(int i =0; i < users.size(); i++) {
			if (users.get(i).name.equals(username) && users.get(i).password.equals(password)) {
				RedirectView rv = new RedirectView("/welcome", true);
				rv.addStaticAttribute("username", username);
				return rv;
			}
		}
		
		RedirectView rv = new RedirectView("/login", true);
		rv.addStaticAttribute("errorMsg", "Incorrect username or password");
		return rv;
	}
	
	@RequestMapping(value ="/signup", method= RequestMethod.POST)
	public RedirectView signupPage(ModelMap model, @RequestParam String username, @RequestParam String password) {
		ArrayList<User> users = userService.users;
		for(int i =0; i < users.size(); i++) {
			if (users.get(i).name.equals(username)) {
				RedirectView rv = new RedirectView("/login", true);
				rv.addStaticAttribute("errorMsg", "Username is taken");
				//model.put("errorMsg", "Username is taken");
				return rv;
			}
		}
		userService.addUser(username, password);	
		
		//model.put("username", username);
		RedirectView rv = new RedirectView("/welcome", true);
		rv.addStaticAttribute("username", username);
		return rv;
	}
	
//	@RequestMapping(value ="/addBasket", method= RequestMethod.POST)
//	public RedirectView addBasket(ModelMap model, @RequestParam String username, @RequestParam String itemName) {
//		userService.addToBasket(username, itemName);
//		ArrayList<Item> list = itemsService.findItems(userService.getBasketItemsForUser(username));
//		//model.put("username", username);
//		RedirectView rv = new RedirectView("/welcome", true);
//		rv.addStaticAttribute("username", username);
//		return rv;
//	}
//	
//	@RequestMapping(value ="/addItem", method= RequestMethod.POST)
//	public RedirectView addItem(ModelMap model,@RequestParam String username,@RequestParam String category, @RequestParam String name, @RequestParam String count,
//			@RequestParam String price, @RequestParam String link) {
//		Item i = new Item(1,name, category, Integer.parseInt(count), Integer.parseInt(price), link);
//		itemsService.addItem(i);
//		RedirectView rv = new RedirectView("/welcome", true);
//		rv.addStaticAttribute("username", username);
//		return rv;
//	}
//	
//	@RequestMapping(value ="/buyItem", method= RequestMethod.POST)
//	public RedirectView buyItem(ModelMap model, @RequestParam String username, @RequestParam String itemName) {
//		int price = itemsService.findPrice(itemName);
//		userService.buyItem(username, itemName, price);
//		itemsService.buyItem(itemName);
//		RedirectView rv = new RedirectView("/openBasket", true);
//		rv.addStaticAttribute("username", username);
//		return rv;
//	}
	
	@RequestMapping(value ="/new_item", method= RequestMethod.POST)
	public RedirectView newItem(ModelMap model, @RequestParam String name, @RequestParam String count,
			@RequestParam String category, @RequestParam String desc, @RequestParam String instruction,
			@RequestParam String ingredients, @RequestParam String link) {
		//(String id, String name, String category, int count, String desc, String ingredients,
		//	String instruction, String link
		String id = "" + itemsService.ID;
		int servings = Integer.valueOf(count);
		Item item = new Item(id, name, category, servings, desc, ingredients, instruction, link);
		itemsService.addItem(item);
		RedirectView rv = new RedirectView("/", true);
		return rv;
	}
	
	@RequestMapping(value ="/edit_item", method= RequestMethod.POST)
	public RedirectView editItem(ModelMap model, @RequestParam String name, @RequestParam String count,
			@RequestParam String category, @RequestParam String desc, @RequestParam String instruction,
			@RequestParam String ingredients, @RequestParam String link, @RequestParam String id) {
		//(String id, String name, String category, int count, String desc, String ingredients,
		//	String instruction, String link
		
		String mid = "" + itemsService.ID;
		int servings = Integer.valueOf(count);
		Item item = new Item(mid, name, category, servings, desc, ingredients, instruction, link);
		itemsService.addItem(item);
		itemsService.delete(id);
		RedirectView rv = new RedirectView("/", true);
		return rv;
	}
	
	@RequestMapping(value ="/delete", method= RequestMethod.GET)
	public RedirectView delete(ModelMap model, @RequestParam String id) {
		//(String id, String name, String category, int count, String desc, String ingredients,
		//	String instruction, String link
		itemsService.delete(id);
		RedirectView rv = new RedirectView("/", true);
		return rv;
	}
	@RequestMapping(value ="/edit", method= RequestMethod.GET)
	public String edit(ModelMap model, @RequestParam String id) {
		//(String id, String name, String category, int count, String desc, String ingredients,
		//	String instruction, String link
		Item item = itemsService.findItem(id);
		model.put("item", item);
		
		return "edit";
	}
	
	@RequestMapping(value ="/sort", method= RequestMethod.GET)
	public String sort(ModelMap model, @RequestParam String search) {
		//(String id, String name, String category, int count, String desc, String ingredients,
		//	String instruction, String link
		ArrayList<Item> list = (ArrayList<Item>) itemsService.search(search);
		model.put("list", list);
		
		return "welcome";
	}
	
	@RequestMapping(value ="/view", method= RequestMethod.GET)
	public String view(ModelMap model, @RequestParam String id) {
		//(String id, String name, String category, int count, String desc, String ingredients,
		//	String instruction, String link
		Item item = itemsService.findItem(id);
		model.put("item", item);
		
		return "viewMore";
	}
	
	@RequestMapping(value ="/", method= RequestMethod.GET)
	public String welcomePage(ModelMap model) {
		
		ArrayList<Item> list = (ArrayList<Item>) itemsService.findAll();
		
		model.put("list", list);
		
		
		
		return "welcome";
	}
	
	@RequestMapping(value ="/create", method= RequestMethod.GET)
	public String createPage(ModelMap model) {
		
		
		
		
		
		return "create";
	}
//	
//	@RequestMapping(value ="/welcome", method= RequestMethod.GET)
//	public String mainPage(ModelMap model, @RequestParam("username") String username) {
//		model.put("username", username);
//		String admin = "0";
//		if(username.equals("Admin")) {
//			admin = "1";
//		}
//		model.put("admin", admin);
//		ArrayList<Item> list = itemsService.availableItems();
//		User curr = userService.findUser(username);
//		model.put("balance", curr.balance);
//		model.put("list", list);
		
//		
//		return "welcome";
//	}
//	
//	@RequestMapping(value ="/search", method= RequestMethod.GET)
//	public String searchPage(ModelMap model, @RequestParam("username") String username, @RequestParam("item") String item) {
//		model.put("username", username);
//		String admin = "0";
//		if(username.equals("Admin")) {
//			admin = "1";
//		}
//		model.put("admin", admin);
//		ArrayList<Item> list = itemsService.searchItems(item);
//		User curr = userService.findUser(username);
//		model.put("balance", curr.balance);
//		model.put("list", list);
//		
//		
//		return "welcome";
//	}
//	@RequestMapping(value ="/openBasket", method= RequestMethod.GET)
//	public String openBasket(ModelMap model, @RequestParam("username") String username) {
//		ArrayList<Item> list = itemsService.findItems(userService.getBasketItemsForUser(username));
//		model.put("head", "Items in Basket");
//		model.put("list", list);
//		model.put("username", username);
//		model.put("buy", "0");
//		return "basket";
//	}
//	@RequestMapping(value ="/openOrders", method= RequestMethod.GET)
//	public String openOrders(ModelMap model, @RequestParam("username") String username) {
//		ArrayList<Item> list = itemsService.findItems(userService.getOrdersItemsForUser(username));
//		model.put("head", "Past Orders");
//		model.put("list", list);
//		model.put("username", username);
//		model.put("buy", "1");
//		return "basket";
//	}
}
