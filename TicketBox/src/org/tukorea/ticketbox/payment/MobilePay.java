package org.tukorea.ticketbox.payment;

public class MobilePay implements Pay {
	public static final double MOBILE_COMMISION = 0.2;

	@Override
	public Receipt charge(String product, double amount, String name, String number) {
		// TODO Auto-generated method stub
		Receipt r = new Receipt(name, product, "MobilePay", number);
		r.subTotalAmount = amount;
		r.totalAmount = amount + amount * MOBILE_COMMISION;
		System.out.println("모바일 결제가 완료되었습니다. : " + r.totalAmount);
		return r;
	}
}