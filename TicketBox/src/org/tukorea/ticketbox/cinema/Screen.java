package org.tukorea.ticketbox.cinema;

import org.tukorea.ticketbox.payment.*;

import java.util.*;

public abstract class Screen {
	protected int ticketPrice; // 티켓 가격
	protected int rowMax; // 좌석 행 최대 값
	protected int colMax; // 좌석 열 최대 값
	protected String movieName; // 상영중인 영화 제목
	protected String movieStory; // 상영중인 영화 줄거리
	protected MovieTicket[][] seatArray; // 좌석 2차원 배열
	private HashMap<Integer, Receipt> receiptMap = new HashMap<Integer, Receipt>();

	public abstract void showMovieInfo(); // 영화 정보 보여주기

	Scanner scan = new Scanner(System.in);

	Screen(String name, String story, int price, int row, int col) { // 생성자
		ticketPrice = price;
		movieName = name;
		movieStory = story;
		rowMax = row;
		colMax = col;
		seatArray = new MovieTicket[row][col];
		for (int r = 0; r < rowMax; r++) {
			for (int c = 0; c < colMax; c++) {
				seatArray[r][c] = new MovieTicket();
				seatArray[r][c].setStatus(MovieTicket.SEAT_EMPTY_MARK);
			}
		}
	}

	public void showScreenMenu() { // 상영관 메뉴 보여주기
		System.out.println("---------------------");
		System.out.println("영화 메뉴 - " + this.movieName);
		System.out.println("---------------------");
		System.out.println("1. 상영 영화 정보");
		System.out.println("2. 좌석 예약 현황");
		System.out.println("3. 좌석 예약 하기");
		System.out.println("4. 예약 취소 하기");
		System.out.println("5. 좌석 결제 하기");
		System.out.println("6. 티켓 출력 하기");
		System.out.println("7. 메인 메뉴 이동");
	}

	public void showSeatMap() {
		// 상영관 좌석 예약 현황 보여주기
		System.out.println("\t[ 좌석 예약 현황 ]");
		System.out.print("\t");
		for (int n = 0; n < rowMax; n++)
			System.out.print("[" + (n + 1) + "] ");
		System.out.println();
		for (int i = 0; i < this.rowMax; i++) {
			System.out.print("[" + (i + 1) + "]\t");
			for (int j = 0; j < this.colMax; j++) {
				System.out.print("[" + seatArray[i][j].getStatus() + "] ");
			}
			System.out.println();
		}
	}

	public void reserveTicket() {
		while (true) {
			System.out.println("[ 좌석 예약 ]");
			try {
				System.out.print("좌석 행 번호 입력(1~" + rowMax + "): ");
				int row = scan.nextInt();
				System.out.print("좌석 열 번호 입력(1~" + colMax + "): ");
				int col = scan.nextInt();
				if (seatArray[row - 1][col - 1].getStatus() == MovieTicket.SEAT_EMPTY_MARK) {
					seatArray[row - 1][col - 1].setSeat(row, col);
					seatArray[row - 1][col - 1].setStatus(MovieTicket.SEAT_RESERVED_MARK);
					int rand = (int) (Math.random() * (4 * rowMax * colMax + 1) + 100);
					seatArray[row - 1][col - 1].setReservedId(rand);
					System.out.println("행[" + row + "] 열[" + col + "] " + seatArray[row - 1][col - 1].getReservedId()
							+ "예약 번호로 접수되었습니다.");
				} else
					System.out.println("이미 예약되거나 결제된 좌석입니다.");
				break;
			} catch (InputMismatchException e) {
				System.out.println("\n정수가 아닙니다. 정수(1~" + rowMax + ")만 입력가능합니다.\n");
				scan.next();
				continue;
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("\n좌석 범위를 벗어났습니다. 정수(1~" + rowMax + ")만 입력가능합니다.\n");
				continue;
			}
		}
	}

	private MovieTicket checkReservedId(int id) {
		MovieTicket temp = new MovieTicket();
		for (int i = 0; i < rowMax; i++) {
			for (int j = 0; j < colMax; j++) {
				if (id != seatArray[i][j].getReservedId()) {
					continue;
				} else
					temp = seatArray[i][j];
			}
		}
		return temp;
	}

	public void cancelReservation() {
		while (true) {
			System.out.println("[ 좌석 예약 취소]");
			try {
				System.out.print("좌석 예약 번호 입력: ");
				int id = scan.nextInt();
				MovieTicket temp = checkReservedId(id);
				if (temp.getReservedId() == 0) {
					System.out.println("\n예약번호를 다시 한번 확인해주세요.\n");
				} else {
					if (temp.getStatus() == MovieTicket.SEAT_PAY_COMPLETION_MARK)
						System.out.println("결제가 완료되어 예약 취소가 불가합니다.");
					else {
						temp.setStatus(MovieTicket.SEAT_EMPTY_MARK);
						System.out.println("예약번호 " + id + " 예약 취소 처리되었습니다.");
					}
				}
				break;
			} catch (InputMismatchException e) {
				System.out.println("\n정수가 아닙니다. 정수만 입력가능합니다.\n");
				scan.next();
				continue;
			}
		}
	}

	public void payment() {
		while (true) {
			System.out.println("[ 좌석 예약 결제 ]");
			try {
				System.out.print("예약 번호 입력: ");
				int id = scan.nextInt();
				MovieTicket temp = checkReservedId(id);
				if (temp.getReservedId() == 0) {
					System.out.println("예약번호를 다시 한번 확인해주세요.");
					break;
				} else {
					while (true) {
						System.out.println("-------------");
						System.out.println(" 결재 방식 선택 ");
						System.out.println("-------------");
						System.out.println("1. 은행 이체");
						System.out.println("2. 카드 결제");
						System.out.println("3. 모바일 결제");
						System.out.print("결제 방식 입력(1~3): ");
						int method = scan.nextInt();
						Receipt Retemp;
						switch (method) {
						case Pay.BANK_TRANSFER_PAYMENT:
							System.out.println("[ 은행 이체 ]");
							System.out.print("이름 입력: ");
							String name1 = scan.next();
							System.out.print("은행 번호 입력(8자리수): ");
							String bankNumber = scan.next();
							BankTransfer bt = new BankTransfer();
							Retemp = bt.charge(movieName, (double) ticketPrice, name1, bankNumber);
							getReceiptMap().put(id, Retemp);
							break;

						case Pay.CREDIT_CARD_PAYMENT:
							System.out.println("[ 카드 결제 ]");
							System.out.print("이름 입력: ");
							String name2 = scan.next();
							System.out.print("카드 번호 입력(8자리수): ");
							String cardNumber = scan.next();
							CardPay cp = new CardPay();
							Retemp = cp.charge(movieName, (double) ticketPrice, name2, cardNumber);
							getReceiptMap().put(id, Retemp);
							break;

						case Pay.MOBILE_PHONE_PAYMENT:
							System.out.println("[ 모바일 결제 ]");
							System.out.print("이름 입력: ");
							String name3 = scan.next();
							System.out.print("핸드폰 번호 입력(11자리수): ");
							String phoneNumber = scan.next();
							MobilePay mp = new MobilePay();
							Retemp = mp.charge(movieName, (double) ticketPrice, name3, phoneNumber);
							getReceiptMap().put(id, Retemp);
							break;

						default:
							payment();

						}
						temp.setStatus(MovieTicket.SEAT_PAY_COMPLETION_MARK);
						break;
					}
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("\n정수가 아닙니다. 정수만 입력가능합니다.\n");
				scan.next();
				continue;
			}
		}
	}

	public void printTicket() {
		while (true) {
			System.out.println("[ 좌석 티켓 출력 ]");
			try {
				System.out.print("예약 번호 입력: ");
				int id = scan.nextInt();
				MovieTicket temp = checkReservedId(id);
				if (temp.getReservedId() == 0) {
					System.out.println("예약번호를 다시 한번 확인해주세요.");
					break;
				} else {
					if (getReceiptMap().containsKey(id)) {
						Receipt re = getReceiptMap().get(id);
						System.out.println(re.toString());
					}
				}
				break;
			} catch (InputMismatchException e) {
				System.out.println("\n정수가 아닙니다. 정수만 입력가능합니다.\n");
				scan.next();
				continue;
			}
		}
	}

	public HashMap<Integer, Receipt> getReceiptMap() {
		return receiptMap;
	}

}
