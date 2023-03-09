package org.tukorea.atm.bank;
 
import java.util.InputMismatchException;
import java.util.Scanner;

import org.tukorea.atm.helpdesk.CustomerSvc;
import org.tukorea.atm.util.Statistics;
 
public class ATMachine {
	
	Scanner scanner = new Scanner(System.in);
	
	private Account [] accountArray; // 고객계좌배열 참조변수
	private int machineBalance; // ATM 잔고
	private int maxAccountNum; // 고객계좌 참조변수 배열크기
	private int currentAccountNum; // 개설된 고객계좌 수
	private String managerPassword; // 관리자 비밀번호
	
	public static final int BASE_ACCOUNT_ID = 100; // 고객계좌 발급 시 최소 번호
	// 랜덤으로 계좌 번호 발급
	// 범위 : 100 부터 (계좌 발급시 개설가능한 최대 계좌 수 * 2) 번호 까지 부여
	
	public ATMachine(int size, int balance, String password) { 		// 생성자
		maxAccountNum = size;										// 최대 계좌 개수 = size 크기 
		machineBalance = balance;									// 현재 atm 기기 내 잔고 
		managerPassword = password;									// 관리자 비밀번호 
		currentAccountNum = 0;										// 현재 계좌의 수 = 처음엔 0개 
		accountArray = new Account[size];							// 계좌 배열을 받는 참조 변수 
		
	}
	
	
	public void createAccount() { // 계좌 개설 함수 
		
		int accountNum = 0;						// 랜덤 계좌 번호를 저장할 공간 
		
		String name;							// 이름을 저장할 공간 
		String password;						// 비밀 번호 저장 공간 
		
		System.out.println("-------  개설 -------");
		
		System.out.println(" 이름 입력 : ");		// 이름을 입력하라는 메시지 출력 
		name = scanner.next();					// 입력한 이름을 name 공간에 저장 
		
		System.out.println(" 암호 입력 : ");		// 비밀 번호를 입력하라는 메시지 출력 
		password = scanner.next();				// 입력한 비밀번호를 password 공간에 문자열로 저장 
		
		if ( currentAccountNum == 0) {																// 이미 랜덤 계좌 번호가 이미 존재하는지 확인
			accountNum = (int)(Math.random() * 2000 + 1 - BASE_ACCOUNT_ID) + BASE_ACCOUNT_ID;		// 랜덤 계좌 번호 생성
		}
		else {																						// 랜덤 계좌번호가 이미 존재한다면
			for ( int i = 0; i < currentAccountNum; i ++) {											// 반복문을 돌림 (횟수는 크게 중요하지 않음) 
				accountNum = (int)(Math.random() * 2000 + 1 - BASE_ACCOUNT_ID) + BASE_ACCOUNT_ID;	// 랜덤 계좌 번호를 다시 생성
				
				if ( accountArray[i].getAccountId() == accountNum)									// 이 계좌 번호 또한 이미 존재한다면 
					continue;																		// 반복문 계속 실행 
				else																				// 계좌 번호가 존재하지 않는 번호라면 
					break;																			// 반복문 탈출 
			}
		}
		
		if ( accountArray[accountArray.length -1] == null) {										// 만약 계좌 배열이 빈공간이라면 
			accountArray[currentAccountNum] = new Account(accountNum, 0, name, password);			// 계좌 생성 
			currentAccountNum++;																	// 현재 계좌 수 1 증가 
			
			System.out.println(name + "님 " + accountNum + "번 계좌가 정상적으로 개설되었습니다. 감사합니다. ");		// 정상적으로 출력되었음을 알리는 메시지 출력 
			System.out.println(" ");																// 가독성을 위해 삽입한 코드 
		}
		else {																						// 계좌 배열이 모두 찼다면 
			System.out.println(" 더 이상 계좌를 생성할 수 없습니다. 인원이 너무 많습니다. ");					// 계좌를 개설할 수 없다는 메시지 출력 
			System.out.println(" ");																//가독성을 위해 삽입한 코드 
		}
	
	}
	
	
	public void checkMoney() { // 계좌 조회하는 함수 
		
		int accountNum;		// 계좌 번호를 저장할 공간 
		
		System.out.println("-------  조회 ------- ");
		
		while(true) {																			// 오류 발생 시 다시 입력받기 위해 반복문 사용 
			try {																				// 오류 발생으로 프로그램이 종료되는 상황 방지 
				System.out.println(" 계좌 번호 입력 : ");
				accountNum = scanner.nextInt();													// 입력한 계좌 번호를 정수로 읽고 accountNum 공간에 저장 
				break;																			// 반복문 탈출 
				
			} catch (InputMismatchException e) {												// 정수가 아닌 값이 입력되었을 시 실행 
				System.out.println(" 숫자만 입력해주세요. ");	
			} finally {																			// 기본적으로 실행되는 코드 
				scanner.nextLine();																// 입력한 줄을 읽어들임 
			}
		}
		
		System.out.println(" 비밀 번호 입력 : ");													// 비밀 번호를 입력하라는 메시지 출력 
		String password = scanner.nextLine();													// 입력한 줄 읽어들임 
		
		int count = 0;
		
		if (currentAccountNum == 0) {															// 현제 걔좌가 0개라면 
			System.out.println(" 계좌를 찾을 수 없습니다. ");											// 계좌를 찾을 수 없음을 출력 
		}
		else {																					// 현재 계좌 개수가 0개가 아니라면 
			for (int i = 0; i < currentAccountNum; i++) 
//			{										// 현재 계좌 수만큼 반복 
//				try {																			// 오류 발생으로 종료되는 것을 방지하기 위함 
//					if (accountArray[i].authenticate(accountNum, password) == true) {			// 만약 아이디와 비밀 번호가 맞다면 
//						System.out.println(" 계좌 잔액 : " + accountArray[i].getBalance());		// 현재 계좌의 잔액을 출력 
//						System.out.println(" ");												// 가독성을 위해 삽입 
//						break;																	// 반복문 탈출 
//					}
//					else if (accountArray[i].authenticate(accountNum, password) == false && i == currentAccountNum - 1) {	// 아이디와 비밀번호가 맞지 않고, 반복문이 끈났다면 '
//						
//						System.err.println(" 계좌를 조회할 수 없습니다. ");							// 계좌를 찾을 수 없다고 출력 
//						System.err.println(" ");												// 가독성을 위해 삽입 
//						break;																	// 반복문 탈출 
//						
//					}} catch (NullPointerException e) {											// 계좌번호와 비밀 번호가 다른 종류의 문자 형태로 입력된 경우 
//						System.out.println(" 잘못된 계좌 입니다. ");									// 잘못된 계좌임을 알림 	
//						System.out.println(" ");												// 가독성을 위해 삽입한 코
//						break;																	// 반복문 탈출 
//					}
//				}
			{
			 
					if (accountArray[i]. authenticate(accountNum, password)) {
						count++;
						System.out.println(" 계좌 잔액 : " + accountArray[i].getBalance());
						break;
					}
				}
				if (count == 0) {
					System.out.println(" 계좌를 조회할 수 없습니다. ");
				}
			}
		}
 
	
	public void displayMenu() { // 메인 메뉴 표시 함수 
		
		System.out.println("-------------------------");
		System.out.println("-     TUKOREA BANK     -");
		System.out.println("-------------------------");
		
		System.out.println(" 1. 계좌 개설");
		System.out.println(" 2. 계좌 조회");
		System.out.println(" 3. 계좌 입금");
		System.out.println(" 4. 계좌 출금");
		System.out.println(" 5. 계좌 이체");
		
		System.out.println(" 7. 고객 센터");
		System.out.println(" 8. 고객 관리");
		
		System.out.println(" 9. 업무 종료");
		
	}
	
	public void depositMoney() {													// 계좌 이체 함수 
		
		int accountNum;																// 계좌 번호를 저장할 공간 선언 
		
		System.out.println("-------  입금 ------- ");
		
		while(true) {																// 오류 발생 시 다시 입력받기 위해 반복문 사용 
			try {																	// 오류를 잡기 위해 try 문 사용 
				System.out.println(" 계좌 번호 입력");									// 계좌 번호를 입력하라는 메시지 출력 
				accountNum = scanner.nextInt();										// 입력한 값을 accountNum에 정수형 int로 읽어 들임 
				break;																// 정상적으로 입력 받았으면 반복문 탈출 
				
			} catch (InputMismatchException e) {									// 계좌 번호가 숫자가 아닌 다른 것을 입력했을 때 
				System.out.println(" 숫자만 입력해주세요. ");								// 숫자만 입력해달라고 오류 메시지 출력 
			}
			finally {																// 기본적으로는 
				scanner.nextLine();													// 입력한 줄 읽어들임 
			}
		}
		
		System.out.println(" 비밀 번호 입력 : ");										// 비밀 번호를 입력하라는 메시지 출력 
		String password = scanner.nextLine();										// 입력한 값을 읽어 들인 후 문자열 password에 저장함 
		
		if ( currentAccountNum == 0 ) {												// 현재 계좌가 0개인 경우 
			System.out.println(" 잘못된 계좌 입니다. ");									// 입력한 계좌가 잘못되었음을 출력 
		}
		else {																		// 현재 계좌가 0개가 아닌 경우 
			for ( int i = 0; i < currentAccountNum; i++ ) {							// 현재 계좌의 수만큼 반복 
				try {																// 오류 발생 시 프로그램이 종료되는 것을 막기 위해 try문 사용 
					if (accountArray[i].authenticate(accountNum,  password) == true) {			// 입력한 계좌 번호와 비밀 번호가 있다면 
						System.out.println(" 입금액 입력 : ");										// 입금할 금액을 입력받아 
						
						int inmoney = scanner.nextInt();										// 정수형 inmoney 공간에 정수형으로 저장함 
						scanner.nextLine();														// 다음 줄을 읽어 들임 
						
						accountArray[i].deposit(inmoney);										// 입력한 계좌에 deposit() 함수를 실행하여 돈 입금 
						
						System.out.println(" 입금 후 잔액 : " + accountArray[i].getBalance());		// 계좌에 getBalance() 함수를 통해 현재 잔액 출력 
						machineBalance += inmoney;												// 입금한 금액 만큼 atm 기기 내 잔액 증가 
						break;																	// 반복문 탈출 
					}
					else if (accountArray[i].authenticate(accountNum, password) == false && i == currentAccountNum - 1) {		// 반복문 끝까지 일치하는 계좌 번호와 비밀 번호가 없는 경우 
						System.out.println(" 잘못된 계좌 입니다. ");									// 잘못된 계좌 임을 출력 
						break;																	// 반복문 탈출 
					}
					
				} catch ( NullPointerException e) {									// 실제 값을 가진게 아닌 경우 
					System.out.println(" 잘못된 계좌 입니다. ");							// 잘못된 계좌 임을 출력 
					break;															// 반복문 탈출 
					
				} catch ( InputMismatchException e) {								// 계좌 번호를 정수가 아닌 다른 것을 입력한 경우 
					System.out.println(" 다시 입력해주세요. ");							// 다시 입력하라고 출력 
					scanner.nextLine();												// 다음 줄 읽어들인 후 
					break;															// 반복문 탈출 
				}
			}
		}
	}
	
	public void widrawMoney() {														// 계좌 출금 함수 
		
		int accountNum;																// 계좌 번호를 저장할 공간 
		
		System.out.println("-------  출금 ------- ");
		
		while(true) {																// 오류를 처리하기 위해 반복문 사용 
			try {																	// 오류를 처리하기 위해 try문 사용 
				System.out.println(" 계좌 번호 입력 : ");
				accountNum = scanner.nextInt();										// 입력한 계좌 번호를 정수형으로 accountNum 공간에 저장 
				break;																// 반복문 탈출 
				
			} catch ( InputMismatchException e) {									// 숫자가 아닌 것을 입력한 경우 
				System.out.println(" 숫자만 입력해주세요. ");								// 숫자만 입력하라는 메시지 출력 
			} finally {																// 기본값 
				scanner.nextLine();													// 다음줄 읽어들이기 
			}
		}
		
		System.out.println(" 비밀 번호 입력 : ");										// 비밀 번호를 입력 받기 
		String password = scanner.nextLine();										// 문자열 password에 입력한 값을 저장 
		
		if (currentAccountNum == 0 ) {												// 현재 계좌 개수가 0개일 경우, 
			System.out.println(" 잘못된 계좌 입니다. ");									// 출금할 계좌가 없음을 출력 
		}
		else {																		// 현재 계좌 개수가 0개가 아닐 경우 
			for ( int i = 0; i < currentAccountNum; i++) {							// 현재 계좌 개수만큼 반복 
				try {																// 오류를 잡기 위해 try문 사용 
					if ( accountArray[i].authenticate(accountNum, password) == true ) {			// 만약 입력한 계좌와 비밀 번호가 맞다면 
						System.out.println(" 출금액 입력 : ");										// 출금할 금액을 입력받고 
						
						int outmoney = scanner.nextInt();										// 그 금액을 정수로 outmoney에 저장 
						scanner.nextLine();														// 다음 줄을 읽어 들임 
						
						if (accountArray[i].getBalance() > outmoney || accountArray[i].getBalance() == outmoney) {		// 만약 잔액이 출금액보다 많거나 같으면 
							accountArray[i].widraw(outmoney);															// 정상적으로 출금한 후 
							
							System.out.println(" 출금 후 잔액 : " + accountArray[i].getBalance());							// 출금한 후 잔액을 출력 
							machineBalance -= outmoney;																	// 잔액을 출금한 금액만큼 감소 
							break;																						// 반복문 탈출 
						}
						else {																	// 잔액이 출금액보다 적다면 
							System.out.println(" 잔액이 부족합니다. ");								// 잔액이 부적하다고 메시지 출략 
							break;																// 반복문 탈출 
						}
					}
					else if (accountArray[i].authenticate(accountNum, password) == false && i == currentAccountNum - 1) {	// 반복문이 끝날 때까지 계좌 번호와 비밀 번호를 확인할 수 없다면 
						System.out.println(" 잘못된 계좌 입니다. ");						// 잘못된 계좌임을 출력 
						System.out.println(" ");									// 가독성을 위해 삽입한 코드 
						break;														// 반복문 탈출 
					}
				} catch (NullPointerException e) {									// 잘못된 값을 가리키는 오류가 생길 경우 
					System.out.println(" 잘못된 계좌 입니다. ");							// 잘못된 계좌 임을 출력 
					System.out.println(" ");										// 가독성을 위해 삽입한 코드 
					break;															// 반복문 탈출 
					
				} catch (InputMismatchException e) {								// 오류 발생 시 
					System.out.println(" 잘못된 계좌 입니다. ");							// 잘못된 계좌 임을 출력 
					System.out.println(" ");										// 가독성을 위해 삽입한 코드 
					break;															// 반복문 탈출 
				}
			}
		}
	}
	
	public void transfer() {														// 계좌 이체 함수 
		
		int accountNum;																// 계좌 번호를 저장할 공간 
		int transAccountNum;														// 이체할 계좌 번호를 저장할 공간 
		
		System.out.println("-------  이체 ------- ");
		
		while(true) {																// 오류를 잡기위해 반복문으로 실행 
			try {																	// 오류를 잡기 위해 try문 사용 
				System.out.println(" 계좌 번호 입력 : ");								// 계좌 번호를 입력하라는 메시지 출력 
				accountNum = scanner.nextInt();										// 입력한 값을 정수로 accountNum 공간에 저장 
				break;																// 반복문 탈출 
			} catch (InputMismatchException e) {									// 정수가 아닌 값을 입력한 경우 
				System.out.println(" 숫자만 입력해주세요. ");								// 숫자만 입력하라는 메시지 출력 
			} finally {																// 기본적으로 실행되는 줄 
				scanner.nextLine();													// 다음 줄을 읽어 들임 
			}
		}
		
		System.out.println(" 비밀 번호 입력 : ");										// 비밀 번호를 입력하라는 메시지 출력 
		String password = scanner.nextLine();										// 입력한 값을 문자열 password 공간에 저장 
		
		if (currentAccountNum == 0) {												// 만약 현재 계좌의 개수가 0개인 경우 
			System.out.println(" 잘못된 계좌 입니다. ");									// 잘못되었음을 출력 
		}
		else {																		// 현재 계좌의 개수가 0개가 아닌경우 
			// exit:																	// 탈출 지점 설정 
				for ( int i = 0; i < currentAccountNum; i++) {						// 현재 계좌 개수만큼 반복 
					try {															// 오류 발생을 잡기위해 try문 사용 
						if (accountArray[i].authenticate(accountNum, password) == true ) {			// 계좌 번호와 비밀 번호가 확인 된다면 
							System.out.println(" 이체 계좌 번호 입력 : ");								// 이체할 계좌 번호를 입력하라는 메시지 출력 
							transAccountNum = scanner.nextInt();									// 입력한 값을 정수로 transAccountNum 공간에 저장 
							
							for (int i2 = 0; i2 < currentAccountNum; i2 ++) {						// 현재 계좌의 개수만큼 반복문을 또 실행 
								if (accountArray[i2].getAccountId() == transAccountNum) {			// 이체할 계좌가 존재한다면 
									System.out.println(" 이체 금액 입력 : ");							// 이체할 금액을 입력하라는 메시지 출력 
											
									int trmoney = scanner.nextInt();								// 입력한 값을 정수로 trmoney 공간에 저장 
									
									scanner.nextLine();												// 다음 줄을 읽어 들임 
									
									if (accountArray[i].getBalance() > trmoney || accountArray[i].getBalance() == trmoney) {		// 이체할 계좌의 잔액이 이체할 금액보다 크거나 같다면 
										accountArray[i].widraw(trmoney);															// 이체할 계좌에서 이체할 금액만큼 출금한후 
										accountArray[i2].deposit(trmoney);															// 이체 받을 계좌에서 이체할 금액만큼 입금 
										
										System.out.println(" 이체 계좌를 다시 확인하세요. ");												// 혹시 잘못 이체했을 수도 있으니 계좌 번호를 다시 환인하라는 메시지 출력 
										System.out.println(" 현재 잔액 : " + accountArray[i].getBalance());							// getBalance()를 통해 현재 잔액 출력 
										System.out.println(" 계좌 이체를 완료했습니다. ");													// 이체 이체를 성공했다는 메시지 출력 
										return;																						// return을 통해 메소드 종료 
									}
									else {															// 이체할 계좌의 잔액이 이체할 계좌의 금액보다 작다면 
										System.out.println(" 잔액이 부족합니다. ");						// 잔액이 부족하다는 메시치 출력 
										return;														// 메소드 종료 
									}
								}
								else if (accountArray[i2].getAccountId() != transAccountNum && i2 == currentAccountNum - 1) {		// 이체 받을 계좌를 반복문이 끝날 때까지 찾지 못했다면 
									System.out.println(" 이체 계좌가 정확하지 않습니다. ");													// 이체 받을 계좌 번호가 잘못되었다는 메시지 출력 
									// break exit;																					// 탈출 지점으로 이동하여 반복문 탈출 
									return;																							// 메소드 종료 
								}
							}}} catch ( NullPointerException e) {									// 잘못된 값을 입력한 경우 
								System.out.println(" 잘못된 계좌 입니다. ");								// 잘못된 계좌임을 출력 
								break;																// 반복문 탈출 
								// return;																// 메소드 종료 
								
							} catch ( InputMismatchException e) {									// 정수가 아닌 값을 입력한 경우 
								System.out.println(" 숫자만 입력해주세요. ");								// 숫자만 입력해달라고 메시지 출력 
								scanner.nextLine();													// 다음 줄을 읽어들임 
								break;																// 반복문 탈출 
								// return;																// 메소드 종료 
							}
						}
					}
				
		}
	
	public void requestSvc() {													// 비밀 번호를 변경하는 메소드 
		
		int accountNum;															// 계좌 번호를 저장할 공간 
		
		System.out.println("-------암호 변경------- ");
		
		try {																	// try문을 사용하여 오류 발생 최소화 
			System.out.println(" 계좌 번호 입력 : ");
			
			accountNum = scanner.nextInt();										//입력한 값을 정수로 accountNum에 저장 
			scanner.nextLine();
		} catch (InputMismatchException e) {									// 숫자가 아닌 값을 입력한 경우 
			System.out.println(" 숫자만 입력해주세요.");								// 숫자만 입력하라는 메시지 출력 
			
			scanner.nextLine();													// 다음 줄을 읽어 들임 
			return;																// 메소드 종료 
		}
		
		
		if (currentAccountNum == 0) {											// 현재 계좌가 0개 라면 
			
			System.out.println(" 잘못된 계좌입니다. ");								// 잘못된 메소드임을 출력 
		}
		
		else {																	// 현재 계좌가 0개가 아니라면 
			for (int i = 0; i < currentAccountNum; i++) {						// 현재 계좌 개수만큼 반복문 실행 
				boolean bool = (accountArray[i].getAccountId() == accountNum);				// 입력한 계좌가 있는지 없는지 확인하는 코드 (리턴 값이 true, flase) 
				
				if (bool == true) {															// 입력한 계좌 번호가 있는 계좌라면 
					CustomerSvc customer = new CustomerSvc(accountArray, accountNum);		// CustomerSvc.java 파일에 있는 CustomerSvc 메소드 실행 
					customer.updatePasswdReq();												// 비밀 번호를 바꾸는 메소드 실행 
					break;																	// 반복문 탈출 
				}
				else if ( bool == false && i == currentAccountNum - 1) {					// 입력한 계좌 번호가 없는 계좌라면 
					System.out.println(" 잘못된 계좌입니다. ");									// 잘못된 계좌 번호임을 출력 
					
					break;																	// 반복문 탈출 
				}
			}
		}
	}
	
	public void managerMode() {										// 고객 관리 함수 
		
		System.out.println("-------고객 관리------- ");
		
		System.out.println(" 관리자 비밀 번호 입력 : ");
		String AdminPw = scanner.next();							// 입력한 값을 문자열 AdminPw에 저장 
		
		if ( this.managerPassword.equals(AdminPw)) {				// 입력한 비밀 번호가 설정한 비밀 번호와 같다면 
			if (currentAccountNum == 0) {							// 현재 개설된 계좌가 0개라면 
				System.out.println(" 현재 계좌를 만든 고객이 0명 입니다. ");	// 개설된 계좌가 0개라는 메시지 출력 
			}
			else {															// 현재 개설된 계좌의 수가 0개가 아니라면 
				System.out.println(" ATM 현금 잔고 : " + machineBalance + " 원 ");				// 현재 기기내 잔액 출력 
				System.out.println(" 고객 잔고 총액 : " + Statistics.sum(accountArray, currentAccountNum) + "원 " + "( " + currentAccountNum + " ) 명 ");	// 고객들의 잔액만 출력 + 총 몇명인지 출력 
				System.out.println(" 고객 잔고 평균 : " + Statistics.avg(accountArray, currentAccountNum) + "원 " );			// 고객들의 잔액 평균을 출력 
				System.out.println(" 고객 잔고 최고 : " + Statistics.max(accountArray, currentAccountNum) + "원 " );			// 고객들 중 잔액이 가장 높은 고객의 잔액 출력 
				System.out.println(" 고객 계좌 현황 (고객 잔고 내림 차순 정렬) ");
				
				Account[] arrayAccountArray = Statistics.array(accountArray, currentAccountNum);						//고객 잔고 정보 내림차순 정리하는 메소드 실행 
				
				for (int i = 0; i < currentAccountNum; i++) {				// 현재 있는 계좌 수 만큼 반복 
					System.out.println(arrayAccountArray[i].getAccountName() + "\t " + arrayAccountArray[i].getAccountId() + "\t " + arrayAccountArray[i].getBalance()+ "원 ");
				}															// 가독성을 위해 \t 사
				
			}
		}
		else {			// 입력환 비밀 번호가 설정한 비밀 번호와 같지 않다면 
			System.out.println(" 관리자 비밀 번호가 아닙니다. ");					// 비밀 번호가 잘못되었음을 출력 
		}
	}
}