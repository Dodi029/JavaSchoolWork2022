package org.tukorea.atm.bank;
 
public class Account {
	private int accountId; // 계좌 번호
	private int balance; // 계좌 잔고
	private String accountName; // 고객 명
	private String password; // 계좌 비밀번호
	
	public Account(int id, int money, String name, String pwd) { // 생성자
		this.accountId = id;			// 계좌 번호를 저장할 공간 
		this.balance = money;			// 계좌 잔액을 저장할 공간 
		this.accountName = name;		// 계좌 이름을 저장할 공간 
		this.password = pwd;			// 계좌 비밀 번호를 저장할 공간 
	}
	
//	boolean authenticate(int id, String passwd) { // 계정 확인
//		if (accountId == id) {
//			if (password.equals(passwd)) {
//				return true;
//			}
//			else {
//				System.out.println(" 잘못된 비밀 번호 입니다. ");
//				return false;
//			}
//		}
//		else {
//			System.out.println(" 잘못된 아이디 입니다. ");
//			return false;
//		}
//		
//	}
	boolean authenticate (int id, String passwd) {						// 계좌를 확인하는 함수 
		if (accountId == id) {											// 만약 입력한 숫자와 맞는 계좌가 있을 경우 
			if (password.equals(passwd)) {								// 비밀 번호를 비교 
				return true;											// 비밀 번호까지 있다면 true를 return 
			}
			else {														// 비밀 번호가 틀렸다면 
				System.out.println(" 잘못된 비밀 번호 입니다. ");				// 비밀 번호가 틀렸다는 메시지 출력 
				return false;											// false를 return 
			}
		}
//		System.out.println(" 잘못된 계좌 번호 입니다. ");
		return false;													// 계좌 번호도 틀렸다면 false 리턴 
	}
	
	public String getAccountName() {			// 계좌 이름을 가져옴 
		return accountName;						// 계좌 이름을 리턴 
	}
	
	public int getAccountId() {					// 걔좌 번호를 가져옴 
		return accountId;						// 계좌 번호 리턴 
	}
	
	public int getBalance() {					// 계좌 잔액을 가져옴 
		return balance;							// 계좌 잔액 리턴 
	}
	
	public int deposit(int money) {				// 입금 
		return balance += money;				// 잔액에 입금한 금액만큼 증가 
	}
	
	public int widraw(int money) {				// 출금 
		return balance -= money;				// 잔액에 출금한 금액만큼 감소 
	}
	
	public boolean updatePasswd(String oldPasswd, String newPasswd) {		// 비밀 번호 바꾸기 
		if (this.authenticate(accountId, oldPasswd) == true ) {				// 계좌 번호와 비밀 번호를 잘 입력했다면 
			this.password = newPasswd;										// 기존 비밀 번호를 새로운 비밀 번호로 교체함 
			return true;													// 교체했으므로 true 리턴 
		}
		else																// 계좌 번호와 비밀 번호가 맞지 않다면 
			System.out.println(" 비밀 번호가 틀렸습니다. ");						// 인증에 실패했다는 메시지 출력 
			return false;													// false 리턴 
	}
}