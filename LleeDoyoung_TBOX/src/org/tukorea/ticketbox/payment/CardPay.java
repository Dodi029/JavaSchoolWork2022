package org.tukorea.ticketbox.payment;

public class CardPay implements Pay {				// 인터페이스를 구현하는 클래스 
	public static final double CARD_COMMISION = 0.15;		// 카드 결제의 수수료 15%로 설정 
	
	@Override
	public Receipt charge(String product, double amount, String name, String number) {			// 선언만 한 메소드를 구현 
		Receipt r = new Receipt(name, product, "CradPay", number);
		
		r.subTotalAmount = amount;
		r.totalAmount = amount + amount * CARD_COMMISION;
		
		System.out.println(" 카드 결제가 완료되었습니다. " + r.totalAmount);
		return r;
	}
}
