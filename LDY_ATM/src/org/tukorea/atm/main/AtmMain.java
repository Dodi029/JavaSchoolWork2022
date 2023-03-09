package org.tukorea.atm.main;
 
import java.util.InputMismatchException;
import java.util.Scanner;
 
import org.tukorea.atm.bank.ATMachine;
 
public class AtmMain {
	public static void main(String[] args) {
		// 초기 설정 - 개설가능한 최대계좌수 (1000계좌)
		// ATM 잔금(50만원), 관리자 암호
		ATMachine atm = new ATMachine(1000, 500000, "admin");					// 초기 설정 저장 
																				// 최대 계좌 수, 초기 atm기기 잔액, 관리자 비밀 번호 정보 저장 
		Scanner scanner = new Scanner(System.in);
		
		exit:																	// 반복문을 탈출할 지점 
		while(true) {															// 반복문 시작 
			atm.displayMenu();													// 메뉴화면 displayMenu 출력 
			System.out.println("메뉴를 선택하세요 >> ");								// 선택할 메뉴를 입력할 것을 출력 
			try {																// 오류 발생을 최소화 하기 위해 try문 사
				int select = scanner.nextInt();									// 입력한 값을 정수(int)로 받
				switch(select) {												// 입력한 정수에 따라 실행할 함수를 다르게함
				
					case 1:														// 1 입력 시 
						atm.createAccount();									// 계좌 생성 함수 실행 
						break;													// 반복문 처음부터 실행 
						
					case 2:														// 2  입력 시 
						atm.checkMoney();										// 계좌 조회 함수 실행 
						break;													// 반복문 처음부터 실행 
					
					case 3:														// 3 입력 시 
						atm.depositMoney();										// 계좌 입금 함수 실행 
						break;													// 반복문 처음부터 실행 
						
					case 4:														// 4 입력 시 
						atm.widrawMoney();										// 계좌 출금 함수 실행 
						break;													// 반복문 처음부터 실행 
						
					case 5:														// 5 입력 시 
						atm.transfer();											// 계좌 이체 함수 실행 
						break;													// 반복문 처음부터 실행 
						
						
						
					case 7:														// 7 입력 시 
						atm.requestSvc();										// 고객 센터 함수 실행 
						break;													// 반복문 처음부터 실
						
					case 8:														// 8 입력 시 
						atm.managerMode();										// 고객 관리 함수 실행 
						break;													// 반복문 처음부터 실행 
						
						
						
					case 9:														// 9 입력 시 
						System.out.println(" 안녕히 가세요 ");						// 프로그램이 끝남을 알리는 메시지 출력 
						break exit;												// 반복문 탈출 지점 이동 
						// return 0;
						
					default:													// 기본값 = 그 이외의 경우 
						System.out.println(" 다시 선택해주세요 ");					// 다시 입력해달라고 출력 
					
				}
			}
			catch (InputMismatchException e) {									// 정수가 아닌 것을 입력한 경우 실행 되는 코드 
				System.out.println(" 정확하게 입력해주세요.");						// 다시 입력해달라고 출력 
				continue;														// 프로그램을 종료하지 않고 계속 실행 
			}
		}
		// scanner.close();
	}
}