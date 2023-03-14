package org.tukorea.ticketbox.payment;

public class BankTransfer implements Pay {
	public static final double BANK_TRANSFER_COMMISION = 0.1;
	
	public Receipt charge(String product, double amount, String name, String number) {
		Receipt r = new Receipt(name, product, "BankTransfer", number);
		r.subTotalAmount = amount;
		r.totalAmount = amount + amount * BANK_TRANSFER_COMMISION;
		System.out.println("은행 결제가 완료되었습니다. : " + r.totalAmount);
		return r;
	}
}
