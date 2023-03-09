package org.tukorea.ticketbox.payment;

public class CardPay implements Pay {
	public static final double CARD_COMMISION = 0.15;

	@Override
	public Receipt charge(String product, double amount, String name, String number) {
		// TODO Auto-generated method stub
		Receipt r = new Receipt(name, product, "CardPay", number);
		r.subTotalAmount = amount;
		r.totalAmount = amount + amount * CARD_COMMISION;
		System.out.println("카드 결제가 완료되었습니다. : " + r.totalAmount);
		return r;
	}
}
