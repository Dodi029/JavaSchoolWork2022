package org.tukorea.ticketbox.payment;

public class Receipt {
	String client; // 사용자 이름
	String productName; // 영화 상품 이름
	String payMethod; // 결제 수단
	String payNumber; // 결제 정보(번호)
	double subTotalAmount; // 커미션 제외한 금액
	double totalAmount;
	
	public Receipt(String client, String productName, String payMethod, String payNumber) {
		this.client = client;
		this.productName = productName;
		this.payMethod = payMethod;
		this.payNumber = payNumber;
	}
	
	public String toString() {
		return "-------------------------\n\tReceipt\n-------------------------\n"
				+ "[ Received by: " + client + " ]\n"
		+ "[ Product: " + productName + " ]\n"
		+ "[ PayMethod: " + payMethod + " ]\n"
		+ "[ PayNumber: " + payNumber + " ]\n"
		+ "[ Subtotal: " + subTotalAmount + " ]\n"
		+ "[ Total: " + totalAmount + " ]\n";
	}
	
	public double getTotalAmount() {
		return totalAmount;
	}

	public String toBackupString() {
		return client + ',' + productName + ',' + payMethod + ',' + payNumber + ',' + subTotalAmount + ',' + totalAmount;
	}
}
