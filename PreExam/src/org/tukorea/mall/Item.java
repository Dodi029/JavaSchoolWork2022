package org.tukorea.mall;

public class Item {
	private String itemName;
	private int itemPrice;
	private int itemQuantity;
	
	public Item(String itemName, int itemPrice, int itemQuantity) {
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemQuantity = itemQuantity;
	}

	public String getItemName() {
		return itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}
}
