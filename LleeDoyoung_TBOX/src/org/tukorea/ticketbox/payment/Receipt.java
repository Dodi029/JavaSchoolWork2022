package org.tukorea.ticketbox.payment;

public class Receipt {				// 영수증 내용을 구분자(,)를 사용하여 한줄에 출력 
	String client;				// 사용자 이름 
	String productName;			// 영화 상품 이름 
	String payMethod;			// 결제 수단 
	String payNumber;			// 결제 정보(번호)
	
	double subTotalAmount;		// 커미션 제외한 금액 
	double totalAmount;			// 커미션 포함한 금액 
	
	public Receipt(String client, String productName, String payMethod, String payNumber) {//, double subTotalAmount, double totalAmount) {
		this.client = client;
		this.productName = productName;
		this.payMethod = payMethod;
		this.payNumber = payNumber;
		// this.subTotalAmount = subTotalAmount;
		// this.totalAmount = totalAmount;
	}
	
	public String toString() {			// 티켓 결제 내용 출력 
		return " ---------------------\n\tReceipt \n ---------------------\n" + " [ Received by : " + client + " ] \n" + " [ Product : " + productName + " ]\n" + " [ payMethod : " + payMethod + " ]\n" + " [ payNumber : " + payNumber + " ]\n" + " [ Subtotal : " + subTotalAmount + " ]\n" + " [ Total : " + totalAmount + " ]\n";
	}
	
	public double getTotalAmount() {
		return totalAmount;
	}
	
	public String toBackupString() {		// 영수증 내용을 한줄에 출력 
		return client + ", " + productName + ", " + payMethod + ", " + payNumber + ", " + subTotalAmount + ", " + totalAmount;
	}
}
