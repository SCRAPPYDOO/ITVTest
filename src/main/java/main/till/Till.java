package main.till;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import main.item.Item;
import main.shopingcart.ShopingCart;

public class Till {
	private ShopingCart shopingCart = new ShopingCart();
	private List<Item> listOfItemsInStore = new ArrayList<Item>();

	public Till() {
		listOfItemsInStore.add(new Item("A", 50, 3, 130));
		listOfItemsInStore.add(new Item("B", 30, 2, 45));
		listOfItemsInStore.add(new Item("C", 20));
		listOfItemsInStore.add(new Item("D", 15));
	}
	
	public void updateItems(String input) {
		listOfItemsInStore.clear();
		if(input.length() > 0) {
			List<String> newItems = Arrays.asList(input.split(","));
			for(String item : newItems) {
				String[] values = item.trim().split(" ");
				try {
					String name = values[0];
					double price = Double.parseDouble(values[1]);
					int discountValue = 0;
					double discountPrice = 0.0;
					if(values.length > 2) {
						discountValue = Integer.parseInt(values[2]);
						discountPrice = Double.parseDouble(values[3]);
					}
					listOfItemsInStore.add(new Item(name, price, discountValue, discountPrice));
				} catch(Exception e) {}
			}
		}
	}

	public void scanItems(String input) {
		List<String> items = Arrays.asList(input.split(""));
		shopingCart.setListOfItems(items);
	}

	public void checkout() {
		List<String> listOfItems = shopingCart.getListOfItems();
		Map<String, Integer> counting = new HashMap<>();

		listOfItems.stream().forEach((item) -> {
			if (counting.get(item) != null) {
				counting.put(item, counting.get(item).intValue() + 1);
			} else {
				counting.put(item, 1);
			}
		});

		System.out.println("");
		System.out.println("CHECKOUT");
		counting.forEach((item, value) -> {
			Item itemInStore = getItemByName(item);
			if (itemInStore != null) {
				double totalPrice = calculatePriceForItem(itemInStore, value);
				System.out.println(item + " price: " + totalPrice + " pounds");
			}
		});
	}

	public double calculatePriceForItem(Item itemInStore, Integer value) {
		double price = 0.0;
		double promoPrice = 0.0;
		int discountValue = itemInStore.getDiscountValue();
		double itemPrice = itemInStore.getPrice();
		 
		if (discountValue > 0) {
			double itemDiscountPrice = itemInStore.getDiscountPrice();
			promoPrice = value / discountValue * itemDiscountPrice;
			price = value % discountValue * itemPrice;
		} else {
			price = value * itemPrice;
		}

		return (promoPrice + price) / 100;
	}
	
	public Item getItemByName(String itemName) {
		try {
			return listOfItemsInStore.stream().filter((Predicate<? super Item>) item -> item.getName().equals(itemName))
					.findFirst().get();
		} catch (Exception e) {
			return null;
		}
	}

	public ShopingCart getShopingCart() {
		return shopingCart;
	}

	public List<Item> getListOfItemsInStore() {
		return listOfItemsInStore;
	}
}
