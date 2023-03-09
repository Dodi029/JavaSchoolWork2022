package org.tukorea.ticketbox.payment;

public class BankTransfer implements Pay {			// 인터페이스를 구현하는 클래스 
	public static final double BANK_TRANSFER_COMMISION = 0.1;		// 수수료를 10%로 설정 
	
	@Override
	public Receipt charge(String product, double amount, String name, String number) {		// 선언만 한 메소드를 구현 
		Receipt r = new Receipt(name, product, "BankTransfer", number);
		
		r.subTotalAmount = amount;
		r.totalAmount = amount + amount * BANK_TRANSFER_COMMISION;
		
		System.out.println(" 은행 결제가 완료되었습니다. " + r.totalAmount);
		return r;
	}
}
