package org.kpu.mall;

import java.util.*;

public class KpuMall implements Mall {
	private HashMap<String, Item> shoppingCart = new HashMap<String, Item>();
	Scanner scan = new Scanner(System.in);

	public void displayItem() {
		System.out.println("------------------");
		System.out.println("- KPU FOOD MALL -");
		System.out.println("------------------");
		System.out.println("1. 소고기김밥\t 2000");
		System.out.println("2. 매운신라면\t 3000");
		System.out.println("3. 새우햄버거\t 4000");
		System.out.println("4. 해물볶음밥\t 5000");
		System.out.println("5. 영양갈비탕\t 6000");
	}

	public void buyItem() {
		while (true) {
			System.out.println("------------------");
			System.out.print("주문하세요. 종료(9) >> ");
			int menu = scan.nextInt();
			if (menu == 9)
				break;
			System.out.print("개수는 >> ");
			int quantity = scan.nextInt();
			switch (menu) {
			case 1:
				shoppingCart.put("소고기김밥", new Item("소고기김밥", 2000, quantity));
				System.out.println("소고기김밥 주문 완료. 총 갯수 : " + quantity);
				break;
			case 2:
				shoppingCart.put("매운신라면", new Item("매운신라면", 3000, quantity));
				System.out.println("매운신라면 주문 완료. 총 갯수 : " + quantity);
				break;
			case 3:
				shoppingCart.put("새우햄버거", new Item("새우햄버거", 4000, quantity));
				System.out.println("새우햄버거 주문 완료. 총 갯수 : " + quantity);
				break;
			case 4:
				shoppingCart.put("해물볶음밥", new Item("해물볶음밥", 5000, quantity));
				System.out.println("해물볶음밥 주문 완료. 총 갯수 : " + quantity);
				break;
			case 5:
				shoppingCart.put("영양갈비탕", new Item("영양갈비탕", 6000, quantity));
				System.out.println("영양갈비탕 주문 완료. 총 갯수 : " + quantity);
				break;
			default:
				System.out.println("존재하지 않는 메뉴입니다. 번호 확인 후 다시 입력해주세요.");
			}
		}
	}

	public void showReceipt() {
		System.out.println("-----------");
		System.out.println("- Receipt - ");
		System.out.println("-----------");
		Set<String> Receipts = shoppingCart.keySet();
		Iterator<String> it = Receipts.iterator();
		int total = 0;
		int maxPrice = 0;
		String maxName = null;
		while (it.hasNext()) {
			String name = it.next();
			Item temp = shoppingCart.get(name);
			System.out.println("[ " + temp.getItemName() + ", " + temp.getItemPrice() + "원, " + temp.getItemQuantity() + "개 ]");
			int price = temp.getItemPrice()*temp.getItemQuantity();
			total += price;
			if (temp.getItemQuantity() > maxPrice) {
				maxPrice = price;
				maxName = temp.getItemName();
			}
		}
		System.out.println();
		System.out.println("총 구매 금액은 " + total + "원입니다.");
		System.out.println("최고 구매 상품은 " + maxName + "(" + maxPrice + "원)입니다");
	}
}
