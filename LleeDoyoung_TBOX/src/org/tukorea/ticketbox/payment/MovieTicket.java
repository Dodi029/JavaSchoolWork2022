package org.tukorea.ticketbox.payment;

public class MovieTicket {
	public static final char SEAT_EMPTY_MARK		= '-';			// 비어있는 좌석 표시 
	public static final char SEAT_RESERVED_MARK		= 'R';			// 예약한 좌석 표시 
	public static final char SEAT_PAY_COMPLETION_MAKR	= '$';		// 결제한 좌석 표시 
	
	private int row; 			// 좌석 행 
	private int col;			// 좌석 열 
	private char status;		// 좌석 상태 - EMPTY, RESERVED, PAY_COMPLRTION 
	private int reservedId;		// 예약 번호 
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public char getStatus() {
		return status;
	}
	
	public void setStatus(char status) {
		this.status = status;
	}
	
	public void setSeat(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public void setReservedId(int id) {
		this.reservedId = id;
	}
	
	public int getReservedId() {
		return reservedId;
	}

}
