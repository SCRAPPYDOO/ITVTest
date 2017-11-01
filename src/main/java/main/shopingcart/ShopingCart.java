package main.shopingcart;

import java.util.ArrayList;
import java.util.List;

public class ShopingCart {
	private List<String> listOfItems = new ArrayList<String>();

	public List<String> getListOfItems() {
		return listOfItems;
	}

	public void setListOfItems(List<String> listOfItems) {
		this.listOfItems = listOfItems;
	}
}
