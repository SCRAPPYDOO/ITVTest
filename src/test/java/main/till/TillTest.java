package main.till;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import main.item.Item;
import main.till.Till;

public class TillTest {
	
	
	@Test
	public void updateItemsTest() {
		Till till = new Till();
		till.updateItems("A 40 2 130, B 2 30 1, C 20");
		assertEquals(3, till.getListOfItemsInStore().size());
		
		till.updateItems("A 40 2 130, B 2 30 1");
		assertEquals(2, till.getListOfItemsInStore().size());
		
		till.updateItems("A402130, B 2 30 1");
		assertNotEquals(2, till.getListOfItemsInStore().size());
	}
	
	@Test
	public void scanItemsTest() {
		Till till = new Till();
		till.scanItems("ABCDABCD");
		assertEquals(8, till.getShopingCart().getListOfItems().size());
	}
	
	@Test
	public void calculatePriceForItemTest() {
		Till till = new Till();
		Item itemB = till.getItemByName("B");
		Item itemA = till.getItemByName("A");
		double priceB = till.calculatePriceForItem(itemB, 2);
		double priceA = till.calculatePriceForItem(itemA, 1);
		
		assertEquals(0.45, priceB, 0);
		assertEquals(0.50, priceA, 0);
		assertNotEquals(1.40, priceB + priceA, 0);
		assertEquals(0.95, priceB + priceA, 0);
	}
	
	@Test
	public void getItemByNameTest() {
		Till till = new Till();
		assertEquals(null, till.getItemByName("F"));
		assertEquals("A", till.getItemByName("A").getName());
	}
	
}
