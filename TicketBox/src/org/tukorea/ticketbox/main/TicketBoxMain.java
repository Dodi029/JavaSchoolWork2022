package org.tukorea.ticketbox.main;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.tukorea.ticketbox.cinema.Screen;

public class TicketBoxMain {
	public static void main(String[] args) {
		TicketBox ticketBox = new TicketBox();
		Scanner scan = new Scanner(System.in);
		Screen screen = null;
		boolean mainMenu = true;
		ticketBox.initScreen();

		while (true) {
			if (mainMenu) {
				screen = ticketBox.selectScreen();
				if (screen == null) {
					System.out.print("안녕히 가세요!");
					scan.close();
					System.exit(0);
				}
				mainMenu = false;
			}
			screen.showScreenMenu();
			System.out.print("메뉴를 선택하세요 >> ");
			try {
				int select = scan.nextInt();
				switch (select) {
				case 1:
					screen.showMovieInfo();
					break;
				case 2:
					screen.showSeatMap();
					break;
				case 3:

					screen.reserveTicket();
					break;
				case 4:
					screen.cancelReservation();
					break;
				case 5:
					screen.payment();
					break;
				case 6:
					screen.printTicket();
					break;
				case 7:
					screen = ticketBox.selectScreen();
					break;
				default:
					System.out.println("\n질못된 수를 입력하셨습니다. 정수(1~7)만 입력가능합니다.");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println();
				System.out.println("정수를 입력하지 않았습니다. 정수(1~7)만 입력가능합니다.");
				scan.next();
				continue;
			}
		}
	}
}
