package org.tukorea.ticketbox.payment;

public interface Pay {					// 인터페이스로 선언 
	public static final int BANK_TRANSFER_PAYMENT = 1;		// 은행 이체는 1로 저장 
	public static final int CREDIT_CARD_PAYMENT = 2;		// 카드 결제는 2로 저장 
	public static final int MOBILE_PHONE_PAYMENT = 3;		// 모바일 결제는 3으로 저장 
	// 결제하기 (영화 삼품명, 영화 가격, 고객명, 결제 정보 )
	
	public abstract Receipt charge(String product, double amount, String name, String number);		// 추상 메소드 선언 
}
