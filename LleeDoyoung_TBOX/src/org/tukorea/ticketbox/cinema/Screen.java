package org.tukorea.ticketbox.cinema;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.HashMap;

import org.tukorea.ticketbox.payment.*;

public abstract class Screen {				// 추상 클래스 선언 
	protected int ticketPrice;					// 티켓 가격 
	protected int rowMax;						// 좌석 행 최대 값 
	protected int colMax;						// 좌석 열 최대 값 
	protected String movieName;					// 상영중인 영화 제목 
	protected String movieStory;				// 상영중인 영화 줄거리 
	protected MovieTicket[][] seatArray;		// 좌석 2차원 배열 
	public abstract void showMovieInfo();			// 영화 정보 보여주기 
	
	private HashMap<Integer, Receipt> receiptMap = new HashMap<Integer, Receipt>();			// HashMap 선언 
	
	Scanner scan = new Scanner(System.in);
	
	Screen(String name, String story, int price, int row, int col){		// 생성자 
		ticketPrice =price;			// 입력한 매개 변수 저장 
		movieName = name;
		movieStory = story;
		rowMax = row;
		colMax = col;
		
		seatArray = new MovieTicket[row][col];			// 좌석 배열 선언 
		
		for (int c = 0; c < colMax; c++) {				// 행 최대값만큼 반복 
			for (int r = 0; r < rowMax; r++) {			// 열 최대값만큼 반복 
				seatArray[r][c] = new MovieTicket();			// 각 좌석마다 영화표 생성 
				seatArray[r][c].setStatus(MovieTicket.SEAT_EMPTY_MARK);			// 각 자리에 비었다는 표시 저장 
			}
		}
	}
	
	public void showScreenMenu() {				// 상영관 메뉴 보여주기 
		
		System.out.println(" ---------------------");
		System.out.println("  영화 메뉴 - " + movieName);
		System.out.println(" ---------------------");
		
		System.out.println(" 1. 상영 영화 정보 ");
		System.out.println(" 2. 좌석 예약 현황 ");
		
		System.out.println(" 3. 좌석 예약 하기 ");
		System.out.println(" 4. 예약 취소 하기 ");
		System.out.println(" 5. 좌석 결제 하기 ");
		System.out.println(" 6. 티켓 출력 하기 ");
		System.out.println(" 7. 메인 메뉴 이동 ");
		
		System.out.println(" ");
	}
	
	public void showSeatMap(){					// 상영관 좌석 예약 현황 보여주기 
		
		System.out.println("\t[ 좌석 예약 현황 ]");
	
		System.out.print("\t");					// 좌석 배열을 맞추기 위한 코드 
		for(int n = 0; n < colMax; n++) {			// 열 개수만큼 반복 
			System.out.print("["+ (n+1) + "] ");
		}
		
		System.out.println();					// 다음줄로 이동 
		
		for(int i = 0; i < this.rowMax; i++) {			// 행 최대값 만큼 반복 
			System.out.print("["+(i+1)+"]\t");		// 행 표시 
			
			for(int j = 0; j < this.colMax; j++) {			// 열 최대값 만큼 반복 
				System.out.print("["+seatArray[i][j].getStatus()+"] ");		// 좌석과 현재 상태 출력 
			}
			System.out.println();			// 가독성을 위해 작성 
		}
	}
	
	public void reserveTicket() {			// 좌석 예약 
		System.out.println(" [ 좌석 예약 ] ");		// 좌석 예약임을 출력 
		
		try {									// 오류를 잡기위해 사용 
			System.out.print(" 좌석 행 번호 입력 : ( 1 - " + rowMax + " ) : ");
			int row = scan.nextInt();		// 입력한 숫자를 row 에 정수형으로 저장 
			
			if ( row >= 1 && row <= rowMax) {		// 입력한 숫자가 영화관 행의 최대값보다 작을 때 다음 줄 실행 
				
				System.out.print(" 좌석 열 번호 입력 : ( 1 - " + colMax + " ) : ");
				int col = scan.nextInt();			// 입력한 숫자를 col에 저장 
				
				if ( col >= 1 && col <= colMax) {			// 입력한 숫자가 영화관 열의 최대값보다 작을 때 다음 줄 실행 
					
					if (seatArray[row - 1][col - 1].getStatus() == MovieTicket.SEAT_RESERVED_MARK) {		// 만약 선택한 좌석의 상태가 예약된 좌석이라면 
						System.out.println(" 이미 예약된 자리입니다, ");			// 예약된 자리임을 출력 
					}
					else if (seatArray[row - 1][col - 1].getStatus() == MovieTicket.SEAT_PAY_COMPLETION_MAKR) {		// 만약 선택한 좌석의 상태가 결제된 좌석이라면 
						System.out.println(" 이미 결제된 자리입니다. ");			// 결제된 좌석임을 출력 
					}
					
					else {			// 난수 중복 제거하고 자리 예약 
						MovieTicket[] seatArray1 = new MovieTicket[rowMax * colMax];			// 예약 번호를 저장할 배열 생성 
						
						for ( int r = 0; r < rowMax; r++) {
							for (int c = 0; c < colMax; c++) {
								seatArray1[(r * colMax) + c] = seatArray[r][c];			// 좌석 예약 번호에 좌석 정보 저장 
							}
						}
						int rdId = (int)(Math.random() + rowMax * colMax * 4 + 100);		// 랜덤으로 예약 번호 발급, 100부터 총 좌석수*4+100 까지 부여 
						
						for (int i = 0; i < rowMax * colMax; i++) {	
							if(seatArray1[i].getReservedId() == rdId) {				// 만약 중복된 아이디가 존재한다면 
								i = 0;												// 반복횟수 초기화 후 
								rdId = (int)(Math.random() * rowMax * colMax * 4 + 100);		// 랜덤 아이디 재발급 
							}
						}
						
						seatArray[row - 1][col - 1].setReservedId(rdId);			// 예약 번호를 저장함 
						seatArray[row - 1][col - 1].setSeat(row, col);				// 좌석 정보를 저장함 
						seatArray[row - 1][col - 1].setStatus(MovieTicket.SEAT_RESERVED_MARK);		// 좌석 표시를 예약 표시로 바꿈 
						
						System.out.println(" 좌석 [ " + row + " ] 행 [ " + col + " ] 열 " + rdId + " 예약 번호로 접수되었습니다. ");		// 예약이 되었음을 출력 
					}
				}
				
				else {				// 만약 열의 숫자가 최대값을 넘어갈 경우, 혹은 1보다 작을 경우 
					System.out.println(" 범위 안의 숫자를 입력해주세요. ");			// 범위가 잘못되었음을 출력 
					return;
				}
			}
			
			else {				// 만약 행의 숫자가 최대값을 넘어가거나 1보다 작을 경우 
				System.out.println( " 밤위 안의 숫자를 입력해주세요. ");			// 범위가 잘못되었음을 출력 
				return;
			}
		} catch (InputMismatchException e) {			// 숫자가 아닌 다른 값을 입력한 경우 
			System.out.println(" 숫자만 입력해주세요. ");			// 숫자만 입력해달라고 출력 
			return;
		}
		
	}
	
	private MovieTicket checkReservedId(int id) {				// 예약 번호로 티켓 확인하기 
		for (int r = 0; r < rowMax; r++) {
			for (int c = 0; c < colMax; c++) {
				if (seatArray[r][c].getReservedId() == id)		// 입력한 번호와 예약 번호가 맞다면 
					return seatArray[r][c];						// 좌석 정보 리턴 
			}
		}
		return null;										// 기본 리텁값 널로 지정 
	}
	
	public void cancelReservation() {							// 예약 취소 (결제된 좌석은 불가) 
		System.out.println(" [ 좌석 예약 취소 ] ");
		
		try {													// 오류를 잡기위해 사용 
			System.out.println(" 좌석 예약 번호 입력 : ");
			int id = scan.nextInt();					// 입력한 예약 번호를 정수형으로 저장 
			
			MovieTicket cancelSeat = checkReservedId(id);			// 입력한 예약번호가 저장되어 있는 정보인지 비교 후, 그 값을 저장 
			
			if(cancelSeat == null) {					// 만약 입력한 정보가 널 값이라면 
				System.out.println(" 예약 번호를 찾을 수 없습니다. ");			// 입력한 번호가 예약 번호에 저장되어 있지 않음을 출력 
			}
			
			else if (cancelSeat.getStatus() == MovieTicket.SEAT_PAY_COMPLETION_MAKR) {		// 입력한 예약번호가 저장되어 있지만, 좌석 상태가 결제된 상태라면 
				System.out.println(" 이미 결제된 좌석은 예약 취소할 수 없습니다. ");			// 결제한 좌석은 취소할 수 없음을 출력 
			}
			
			else {			// 입력한 예약 번호가 저장되어 있는 정보고, 좌석 상태가 결제되지 않은 상태일 경우 실행 
				System.out.println(" 예약 번호 " + cancelSeat.getReservedId() + "번 예약 취소 처리되었습니다. ");		// 예약 취소되었음을 출력 
				cancelSeat.setReservedId(0);			// 예약 정보 초기화 
				cancelSeat.setStatus(MovieTicket.SEAT_EMPTY_MARK);			// 좌석 상태를 비어있는 상태로 저장 
			}
		} catch (InputMismatchException e) {			// 예약 번호를 숫자로 입력하지 않았을 경우 
			System.out.println(" 숫자만 입력해주세요. ");			// 숫자로 입력해달라고 출력 
		}
	}
	
	public void payment() {			// 티켓 결제 
		while (true) {
			System.out.println(" [ 좌석 예약 결제 ] ");
			
			try {					// 오류를 잡기위해 사용 
				System.out.print(" 예약 번호 입력 : ");
				int id = scan.nextInt();			// 입력한 예약 정보를 정수형으로 저장 
				
				MovieTicket temp = checkReservedId(id);			// 입력한 예약 번호가 저장되어 있는 정보인지 비교 후, 그 정보를 저장 
				
				if (temp.getReservedId() == 0) {				// 입력한 예약 번호가 없는 번호일 경우 
					System.out.println(" 예약 번호를 다시 한번 확인해주세요. ");		// 잘못된 예약 번호임을 출력 
					break;
				}
				
				else {
					while (true) {			// 입력한 예약 번호가 저장된 정보일 경우 
						System.out.println(" ---------------------");
						System.out.println(" -    결제 방식 선택    - ");
						System.out.println(" ---------------------");
						
						System.out.println(" 1. 은행 이체 ");
						System.out.println(" 2. 카드 결제 ");
						System.out.println(" 3. 모바일 결제 ");
						
						System.out.print(" 결제 방식 입력 (1 ~ 3) : ");
						
						int method = scan.nextInt();		// 입력한 결제 방식 정보를 정수형으로 저장 
						
						Receipt Retemp;			// 
						
						switch (method) {		// 입력한 결제 방식에 따라 결제 
						
						case Pay.BANK_TRANSFER_PAYMENT:			// 은행 이체를 선택한 경우 
							System.out.println("  [ 은행 이체 ] ");		// 은행 이체임을 출력 
							
							System.out.print(" 이름 입력 : ");
							String name1 = scan.next();			// 입력한 이름을 문자열로 저장 
							
							System.out.print(" 은행 번호 입력 ( 8자리 ) : ");
							String bankNumber = scan.next();		// 입력한 은행 번호를 문자열로 저장 
							
							BankTransfer bt = new BankTransfer();		// 은행 이제 객체 생성 
							Retemp = bt.charge(movieName,  (double) ticketPrice, name1, bankNumber);
							
							getReceiptMap().put(id, Retemp);
							break;
							
						case Pay.CREDIT_CARD_PAYMENT:			// 카드 결제 
							System.out.println(" [ 카드 결제 ] ");		// 카드 결제임을 출력 
							
							System.out.print(" 이름 입력 : ");
							String name2 = scan.next();			// 입력한 이름을 저장 
							
							System.out.print(" 카드 번호 입력 ( 8자리 ) : ");
							String cardNumber = scan.next();		// 입력한 카드 번호를 저장 
							
							CardPay cp = new CardPay();			// 카드 결제 객체 생성 
							Retemp = cp.charge(movieName, (double) ticketPrice, name2, cardNumber);
							
							getReceiptMap().put(id, Retemp);
							break;
							
						case Pay.MOBILE_PHONE_PAYMENT:			// 모바일 결제 
							System.out.println(" [ 모바일 결제 ] ");		// 모바일 결제임을 출력 
							
							System.out.print(" 이름 입력 : ");
							String name3 = scan.next();			// 입력한 이름을 저장 
							
							System.out.print(" 핸드폰 번호 입력 ( 11자리 ) : ");
							String phoneNumber = scan.next();		// 입력한 핸드폰 번호를 저장 
							
							MobilePay mp = new MobilePay();			// 모바일 결제 객체 생성 
							Retemp = mp.charge(movieName, (double) ticketPrice, name3, phoneNumber);
							
							getReceiptMap().put(id, Retemp);
							break;
							
							default:
								payment();			// 기본값 지정 
						}
						temp.setStatus(MovieTicket.SEAT_PAY_COMPLETION_MAKR);		// 결제가 완료되면 해당 좌석 정보를 결제한 좌석으로 저장 
						break;
					}
					break;
				}
			} catch (InputMismatchException e) {				// 숫자가 아닌 값을 입력했을 경우 
				System.out.println(" 정수만 입력해주세요 ");			// 숫자만 입력해 달라고 출력 
				continue;
			}
		}
	}
	
	public void printTicket() {			// 좌석 티켓 출력 
		while (true) {
			System.out.println(" [ 좌석 티켓 출력 ] ");
			
			try {				// 오츄를 잡기 위해 사용 
				System.out.print(" 예약 번호 입력 : ");
				int id = scan.nextInt();			// 입력한 예약 번호를 정수형으로 저장 
				
				MovieTicket temp = checkReservedId(id);		// 입력한 예약 번호가 있는지 비교 후, 그 결과를 저장 
				
				if (temp.getReservedId() == 0) {			// 입력한 예약 번호가 없는 경우 
					System.out.println(" 예약 번호가 틀렸습니다. 다시 확인해 주세요. ");		// 잘못된 에액 번호임을 출력 
					break;
				}
				
				else {
					if (getReceiptMap().containsKey(id)) {			// 입력한 예약 번호가 있을 경우 
						Receipt re = getReceiptMap().get(id);		// 예약 번호 정보를 저장 
						System.out.println(re.toString());			// 저장된 티켓 형식으로 출력 
					}
				}
				break;
			} catch (InputMismatchException e) {					// 숫자가 아닌 다른 값을 입력한 경우 
				System.out.println(" 숫자만 입력해 주세요. ");
				continue;
			}
		}
	}
	
	public HashMap<Integer, Receipt> getReceiptMap(){
		return receiptMap;
	}
}

