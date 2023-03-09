package org.tukorea.mall;

public class ShoppingMain {
	public static void main(String[] args) {
		Mall mall = new TukoreaMall();
		mall.displayItem();
		mall.buyItem();
		mall.showReceipt();
		System.out.println("\n안녕히 가세요 !!");
	}
}
