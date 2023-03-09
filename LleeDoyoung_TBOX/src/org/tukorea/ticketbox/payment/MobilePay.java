package org.tukorea.ticketbox.payment;

public class MobilePay implements Pay {				// 인터페이스를 구현하는 클래스 
	public static final double MOBILE_COMMISION = 0.2;		// 모바일 결제 수수료 20%로 설정 
	
	@Override
	public Receipt charge(String product, double amount, String name, String number) {
		Receipt r = new Receipt(name, product, "MobilePay", number);
		
		r.subTotalAmount = amount;
		r.totalAmount = amount + amount * MOBILE_COMMISION;
		
		System.out.println(" 카드 결제가 완료되었습니다. " + r.totalAmount);
		return r;
	}
}
