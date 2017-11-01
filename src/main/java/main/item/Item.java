package main.item;

public class Item {
	private String name;
	private double price = 0;
	private int discountValue = 0;
	private double discountPrice = 0;
	
	public Item(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public Item(String name, double price, int discountValue, double discountPrice) {
		super();
		this.name = name;
		this.price = price;
		this.discountValue = discountValue;
		this.discountPrice = discountPrice;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public int getDiscountValue() {
		return discountValue;
	}

	public double getDiscountPrice() {
		return discountPrice;
	}
}
